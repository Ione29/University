from signal import signal, SIGTERM, SIGHUP, pause
from rpi_lcd import LCD
import adafruit_dht
import board
import time

dht11Sensor = adafruit_dht.DHT11(board.D17)
lcd = LCD()

def safe_exit(signum, frame):
    exit(1)

signal(SIGTERM, safe_exit)
signal(SIGHUP, safe_exit)

try:
    while True:
        try:
            # Reading the sensors
            temperature = dht11Sensor.temperature
            humidity = dht11Sensor.humidity

            if temperature is not None:
                # Console prints for debugging
                print("Temp: {0:0.1f}\u00b0C".format(temperature))
                print("Humidity: {0:0.1f}%".format(humidity))
                
                # Display the temperature and humidity on the LCD screen
                lcd.text("Temp: {0:0.1f} deg C".format(temperature), 1)
                lcd.text("Humidity: {0:0.1f}%".format(humidity), 2)
            else:
                lcd.text("Failed to retrieve data from sensor", 1)

        except RuntimeError as error:
            # Errors happen fairly often with DHT sensors, 
            # so we wait a bit until we try to read again
            print(error.args[0])
            time.sleep(2.0)
            continue
        except Exception as error:
            dht11Sensor.exit()
            raise error

        time.sleep(3)

except KeyboardInterrupt:
    pass

finally:
    lcd.clear()