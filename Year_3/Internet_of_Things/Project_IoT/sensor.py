import matplotlib.pyplot as plt
from flask import Flask, send_file
from io import BytesIO
import time
import adafruit_dht
from gpiozero import DigitalInputDevice
import board
from threading import Thread
from flask import jsonify

app = Flask(__name__)


try:
    dht11Sensor = adafruit_dht.DHT11(board.D17)
except Exception as e:
    print(f"Error initializing DHT11 sensor: {e}")

try:
    mq2Sensor = DigitalInputDevice(27)
except Exception as e:
    print(f"Error initializing MQ2 sensor: {e}") 

temperatures = []
humidities = []
gasDetection = []
timestamps = []

def update_readings():
    while True:
        try:
            if dht11Sensor is not None:
                temperature = dht11Sensor.temperature
                humidity = dht11Sensor.humidity  # Add this line to read the humidity
                temperatures.append(temperature)
                humidities.append(humidity)  # Add this line to store the humidity
                timestamps.append(time.time())
            else:
                raise Exception("DHT11 sensor is not initialized")

            if mq2Sensor.value != 0:
                gasDetection.append(0)
            else:
                gasDetection.append(1)

            # Remove the oldest reading if there are more than 60 readings
            if len(temperatures) > 60:
                temperatures.pop(0)
                humidities.pop(0)  # Add this line to remove the oldest humidity reading
                timestamps.pop(0)
                gasDetection.pop(0)

            time.sleep(1)
        except Exception as e:
            print(f"Error updating readings: {e}")

@app.route('/gasChart')
def gasChart():
    # Create a figure and plot the gas levels
    fig, ax = plt.subplots()
    ax.plot([t - timestamps[0] for t in timestamps], gasDetection)
    ax.set_xlabel("Time")
    ax.set_ylabel("Gas level")

    # Set the x-axis limits to a fixed range
    ax.set_xlim(0, 60)

    # Save the figure to a BytesIO object
    buf = BytesIO()
    plt.savefig(buf, format='png')

    # Close the figure
    plt.close('all')

    buf.seek(0)

    # Return the figure as a PNG image
    return send_file(buf, mimetype='image/png')



@app.route('/tempsChart')
def tempsChart():
    # Create a figure and plot the temperatures
    fig, ax = plt.subplots()
    ax.plot([t - timestamps[0] for t in timestamps], temperatures)
    ax.set_xlabel('Time')
    ax.set_ylabel('Temperature')

    # Set the x-axis limits to a fixed range
    ax.set_xlim(0, 60)

    # Save the figure to a BytesIO object
    buf = BytesIO()
    plt.savefig(buf, format='png')

    # Close the figure
    plt.close('all')

    buf.seek(0)

    # Return the figure as a PNG image
    return send_file(buf, mimetype='image/png')

@app.route('/data')
def data():
    return jsonify({
        'timestamps': [t - timestamps[0] for t in timestamps],
        'temperatures': temperatures,
        'humidities': humidities,
        'gasDetection': gasDetection
    })

@app.route('/')
def index():
    return '''
    <!DOCTYPE html>
    <html>
    <head>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <style>
        #chart-container {
            display: flex;
            flex-direction: row;
            justify-content: space-around;
            width: 100%;
            height: 100vh;
        }

        .chart {
            width: 75%;  /* Adjust this value as needed */
            height: 100vh;
        }

        #navbar {
            background-color: #f8f9fa;
            padding: 10px 20px;
            text-align: center;
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        #footer {
            position: fixed;
            bottom: 0;
            width: 100%;
            display: flex;
            justify-content: center;
            background-color: #f8f9fa;
            padding: 10px 20px;
            margin-top: 20px;
        }

        #footer-title {
            font-size: 24px;
            font-weight: bold;
            margin-right: 20px;
        }

        #footer-names {
            display: flex;
            flex-direction: column;
            align-items: flex-end;
        }

        #chart-container div {
            text-align: center;
        }
    </style>
    </head>
    <body>
        <div id="navbar">Smart Home Sensor</div>
        <div id="chart-container">
            <div>
                <h2>Temperature Chart</h2>
                <canvas id="tempsChart" class="chart"></canvas>
            </div>
            <div>
                <h2>Gas Level Chart</h2>
                <canvas id="gasChart" class="chart"></canvas>
            </div>
        </div>
        <script>
            var ctx = document.getElementById('tempsChart').getContext('2d');
            var tempsChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: [],
                    datasets: [{
                        label: 'Temperature',
                        data: [],
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 1
                    }, {
                        label: 'Humidity',
                        data: [],
                        borderColor: 'rgba(255, 99, 132, 1)',
                        borderWidth: 1
                    }]
                }
            });

            ctx = document.getElementById('gasChart').getContext('2d');
            var gasChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: [],
                    datasets: [{
                        label: 'Gas Level',
                        data: [],
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 1
                    }]
                }
            });

            setInterval(function() {
                fetch('/data')
                    .then(response => response.json())
                    .then(data => {
                        // Adjust the timestamps to start from 1 and end at 60
                        const minTimestamp = Math.min(...data.timestamps);
                        data.timestamps = data.timestamps.map(t => Math.round(t - minTimestamp + 1)).filter(t => t <= 60);

                        tempsChart.data.labels = data.timestamps;
                        tempsChart.data.datasets[0].data = data.temperatures.slice(-data.timestamps.length);
                        tempsChart.data.datasets[1].data = data.humidities.slice(-data.timestamps.length);
                        tempsChart.update();

                        gasChart.data.labels = data.timestamps;
                        gasChart.data.datasets[0].data = data.gasDetection.slice(-data.timestamps.length);
                        gasChart.update();
                    });
            }, 1000);
        </script>
        <div id="footer">
            <div id="footer-title">IoT Project</div>
            <div id="footer-names">
                <div>Ionita Alexandru-Mihail</div>
                <div>Petre Tiberiu-Adrian</div>
                <div>Macoveiciuc Teodor Mihai</div>
                <div>Rosciuc Vlad Vasile</div>
            </div>
        </div>
    </body>
    </html>
    '''

if __name__ == "__main__":
    # Start the background thread
    Thread(target=update_readings).start()

    # Start the Flask application
    app.run(host='0.0.0.0')