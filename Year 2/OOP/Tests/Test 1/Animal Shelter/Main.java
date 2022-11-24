import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Animal(3, "Taffy", "Siamese");
        Animal a2 = new Animal(4, "White", "Siamese");
        Animal a3 = new Animal(7, "Rex", "Bulldog");
        Animal a4 = new Animal(9, "Goldy", "Goldfish");

        a1.addAtribute(7);
        a1.addAtribute(5);
        a1.addAtribute(2);

        a2.addAtribute(9);
        a2.addAtribute(10);
        a2.addAtribute(6);

        a3.addAtribute(4);
        a3.addAtribute(3);
        a3.addAtribute(8);

        a4.addAtribute(1);
        a4.addAtribute(1);
        a4.addAtribute(1);

        Platform database = new Platform();
        database.addPet(a1);
        database.addPet(a2);
        database.addPet(a3);
        database.addPet(a4);

        database.adoptPet(a3);//should work fine
        database.adoptPet(a3);//should give error

        Map<String, Double> gradeMap = database.toMap();

        for(Map.Entry<String,Double> breedGradePair: gradeMap.entrySet()){
            System.out.println("unu");
            System.out.println("Breed " + breedGradePair.getKey() + " has an average score of " + breedGradePair.getValue() + ".");
        }

    }
}
