import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyFrame extends Frame {
    
    ExecutorService executor = Executors.newFixedThreadPool(5);
    SharedRes shared = new SharedRes(2);
    
    Sensor s1 = new Sensor("Sensor_1", Sensor.Type.FRONT_DOOR, shared);
    Sensor s2 = new Sensor("Sensor_2", Sensor.Type.BACK_DOOR, shared);
    Sensor s3 = new Sensor("Sensor_3", Sensor.Type.NURSERY, shared);
    Sensor s4 = new Sensor("Sensor_4", Sensor.Type.BEDROOM, shared);
    Dispatcher dispatcher = new Dispatcher("dispatcher", shared);
    
    private final int DEFAULT_HEIGHT = 600;
    private final int DEFAULT_WIDTH = 600;
    
    private Panel sensors = new Panel();
    
    private Panel frontDoorPanel = new Panel();
    private Label l1 = new Label("Front Door");
    private Button start1 = new Button("Start");
    
    private Panel backDoorPanel = new Panel();
    private Label l2 = new Label("Back Door");
    private Button start2 = new Button("Start");
    
    private Panel bedroomPanel = new Panel();
    private Label l4 = new Label("Bedroom");
    private Button start4 = new Button("Start");
    
    private Panel nurseryPanel = new Panel();
    private Label l3 = new Label("Nursery");
    private Button start3 = new Button("Start");
    
    private TextArea notificationsArea = new TextArea(30, 25);
    private Panel notifications = new Panel();
    
    public SensorStartStop sController1 = new SensorStartStop(s1);
    public SensorStartStop sController2 = new SensorStartStop(s2);
    public SensorStartStop sController3 = new SensorStartStop(s3);
    public SensorStartStop sController4 = new SensorStartStop(s4);
    
    public class SensorStartStop implements ActionListener{
        boolean flag;
        Sensor sensor;
        
        public SensorStartStop(Sensor vSensor){
            this.flag = false;
            this.sensor = vSensor;
        }

        public void actionPerformed(ActionEvent e){
            if(this.flag == false){
                executor.execute(this.sensor);
                this.flag = true;
            }
            else{
                executor.shutdown();
                this.flag = false;
            }
        }
    }

    public MyFrame() {
        setTitle("Sensors");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLayout(new GridLayout(1, 2));
        
        l1.setAlignment(Label.CENTER);
        frontDoorPanel.add(l1);
        frontDoorPanel.add(start1);
        
        l2.setAlignment(Label.CENTER);
        backDoorPanel.add(l2);
        backDoorPanel.add(start2);

        l3.setAlignment(Label.CENTER);
        bedroomPanel.add(l3);
        bedroomPanel.add(start3);

        l4.setAlignment(Label.CENTER);
        nurseryPanel.add(l4);
        nurseryPanel.add(start4);

        sensors.add(frontDoorPanel);
        sensors.add(backDoorPanel);
        sensors.add(bedroomPanel);
        sensors.add(nurseryPanel);
        
        add(sensors);

        notifications.add(notificationsArea);

        sensors.setLayout(new GridLayout(4, 1));
        
        
        add(notifications);
        
    }
}