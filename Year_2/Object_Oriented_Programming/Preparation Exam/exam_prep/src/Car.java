import java.util.List;
import java.util.Random;
import java.util.LinkedList;

public class Car {
    private List<CarPart> brokenParts;
    private String serviceID, carMake, plateNumber;

    public Car(String vServiceID, String vCarMake, String vPlateNumber){
        brokenParts = new LinkedList<CarPart>();
        Random random = new Random();


        for(int i = 0; i < 3; i++){
            CarPart newPart = CarPart.values()[random.nextInt(0, CarPart.values().length)];
            while(brokenParts.contains(newPart))
                newPart = CarPart.values()[random.nextInt(0, CarPart.values().length)];

            brokenParts.add(CarPart.values()[random.nextInt(0, CarPart.values().length)]);
        }
            
        this.serviceID = vServiceID;
        this.carMake = vCarMake;
        this.plateNumber = vPlateNumber;
    }

    @Override
    public String toString(){
        String text = serviceID + "," + carMake + "," + plateNumber;
        return text;
    }
}
