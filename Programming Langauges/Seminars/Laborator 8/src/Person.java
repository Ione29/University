class Person{
    private String lname;
    private String fname;
    private int age;

    public Person(String fname, String lname, int age){
        this.lname=lname;
        this.fname=fname;
        this.age=age;
    }

    public void displayPerson(){
        System.out.println(this.fname + " " + this.lname + " is " + this.age); 
    }

    public String getLast(){
        return this.lname;
    }
}