import java.util.ArrayList;

public class Animal {
    private Integer age;
    private String name;
    private final String breed;
    private ArrayList<Integer> attributes; 
    private ArrayList<String> diseases; 

    public Animal(int vAge, String vName, String vBreed){
        this.age = vAge;
        this.name = vName;
        this.breed = vBreed;
        attributes = new ArrayList<Integer>();
        diseases = new ArrayList<String>();
    }

    public String getBreed(){
        return this.breed;
    }

    public String getName(){
        return this.name;
    }

    public void addAtribute(Integer vAttribute){
        this.attributes.add(vAttribute);
    }

    public void addDisease(String vDisease){
        this.diseases.add(vDisease);
    }

    public double getAverageGrade(){
        double averageGrade = 0;

        for(Integer attribute : attributes)
            averageGrade += attribute;

        averageGrade /= attributes.size();

        return averageGrade;
    }

    public int compareTo(Object vOther){
        Animal other = (Animal) vOther;
        if(this.age.compareTo(other.age) > 0)
            return 1;
        else if(this.age.compareTo(other.age) < 0)
            return -1;
        else
            if(this.breed.compareTo(other.breed) > 0)
                return 1;
            else if(this.breed.compareTo(other.breed) < 0)
                return -1;
            else return 0;
    }

    @Override
    public String toString(){
        String text = "Name: " + this.name + " | Age: " + this.age + " | Breed: " + this.breed;
        return text;
    }

}
