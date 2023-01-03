public class Dispatcher extends Thread{
    private SharedRes shared;

    public Dispatcher(String name, SharedRes vShared){
        super(name);
        this.shared = vShared;
    }

    @Override
    public void run(){
        while(true){
            Sensor.SensorEvent event = shared.consume();
            System.out.println(event.toString());
            try{
                sleep(50);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            
        }
    }
}