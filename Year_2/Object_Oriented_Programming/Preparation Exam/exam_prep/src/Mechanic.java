import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Mechanic extends Thread{
    private String name;
    private Workshop workshop;
    

    public Mechanic(String vName, String vMechanicName, Workshop vWorkshop){
        super(vName);
        this.name = vName;
        this.workshop = vWorkshop;
    }

    @Override
    public void run(){
        while(true){
            //get car out of queue when available
            Car servicedCar = workshop.remove();
            try {
                wait(5000); //service the car
                //write to file
                try {
                    File outFile = new File("ready_to_deliver.txt");
                    FileWriter fw = new FileWriter(outFile);
                    fw.write(servicedCar.toString());
                    fw.close();
                    servicedCar = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
