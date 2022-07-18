import java.util.Scanner;

public class PersonMain{
    public static void main(String []args){
        Scanner s = new Scanner(System.in);
        PersonArray pa=new PersonArray(5);
        pa.insert("Maria","Alexandra",19);
        pa.insert("Alexandra","Julie",24);
        pa.insert("Edward","Andrew",18);
        pa.insert("Black","Johnny",21);
        pa.insert("John","Edward",16);
        pa.displayArray();

        System.out.print("Insert the name you want to search: ");
        String nameF=s.nextLine();
    
        Person search = pa.find(nameF);

        if(search!= null) 
            System.out.println(nameF +  " was found in the members array");
        else 
            System.out.println(nameF + " was not found in the members array");

        System.out.print("Insert the name you want to delete: ");
        String nameD=s.nextLine();

        pa.delete(nameD);
        pa.displayArray();

    }
}