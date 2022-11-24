import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Platform {
    private ArrayList<Animal> animalsAvailable;
    private ArrayList<Animal> animalsAdopted;

    public Platform(){
        animalsAvailable = new ArrayList<Animal>();
        animalsAdopted = new ArrayList<Animal>();
    }

    public void addPet(Animal vPet){
        animalsAvailable.add(vPet);
    }

    public boolean adoptPet(Animal vPet){
        if(animalsAvailable.contains(vPet)){
            animalsAdopted.add(animalsAvailable.get(animalsAvailable.indexOf(vPet)));
            animalsAvailable.remove(vPet);
            System.out.println(vPet.getName() + " was adopted succesfully!");
            return true;
        }
        else{
            System.out.println("The animal you are trying to adopt is not available.");
            return false;
        }
    }

    public Map<String, Double> toMap(){
        Map<String, Double> averageGradeByBreed = new HashMap<String, Double>();

        ArrayList<String> breeds = new ArrayList<String>();
        for(Animal animal : animalsAvailable)
            if(animalsAvailable.contains(animal.getBreed()))
                breeds.add(animal.getBreed());

        for(String breed : breeds){
            Double averageGrade = 0.0;
            int noOfEncounters = 0;

            for(Animal animal : animalsAvailable)
                if(animal.getBreed().equals(breed)){
                    averageGrade += animal.getAverageGrade();
                    noOfEncounters++;
                }

            averageGrade /= noOfEncounters;

            averageGradeByBreed.put(breed, averageGrade);
        }

        return averageGradeByBreed;
    }
}
