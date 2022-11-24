import java.time.LocalDate;
import java.util.Map;

public class Main {
    
    public static void main(String[] args) {
        Crime c1 = new Crime("shank m8", "Titan", "Paraschivo", LocalDate.of(2002, 02, 11));
        Crime c2 = new Crime("droguri", "Berceni", "Adrian", LocalDate.of(2020, 12, 31));
        Crime c3 = new Crime("airplane crash", "Twin Towers, New York City", "Al-Qaeda", LocalDate.of(2001, 9,11));
        Crime c4 = new Crime("school shooting", "school", "Mihai", LocalDate.of(2007, 11, 2));

        Platform database = new Platform();

        c1.addAtribute(7);
        c1.addAtribute(5);
        c1.addAtribute(2);

        c2.addAtribute(9);
        c2.addAtribute(10);
        c2.addAtribute(6);

        c3.addAtribute(4);
        c3.addAtribute(3);
        c3.addAtribute(8);

        c4.addAtribute(1);
        c4.addAtribute(1);
        c4.addAtribute(1);

        database.addCrime(c1);
        database.addCrime(c2);
        database.addCrime(c3);
        database.addCrime(c4);

        Map<String, Integer> locationMap = database.toMap();

        for(Map.Entry<String,Integer> locationCrimesPair: locationMap.entrySet()){
            System.out.println("Breed " + (String)locationCrimesPair.getKey() + " has an average score of " + (Integer)locationCrimesPair.getValue() + ".");
        }




    }
}
