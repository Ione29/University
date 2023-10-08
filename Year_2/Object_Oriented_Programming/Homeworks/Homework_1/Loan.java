public class Loan {
    private int id;
    private double ammount;
    private Person person;

    public Loan(int vId, double vAmmount, Person vPerson)
    {
        this.id = vId;
        this.ammount = vAmmount;
        this.person = vPerson;
    }

    public void increaseAmmount(double added){
        ammount += added;
    }

    public int getId(){
        return this.id;
    }

    public double getAmmount(){
        return this.ammount;
    }

    public Person getPerson(){
        return this.person;
    }

    public String toString(){
        String text = "Loan ID:" + this.id + "; Person: " + this.person.toString() + "; Ammount: " + this.ammount;
        return text;
    }
}
