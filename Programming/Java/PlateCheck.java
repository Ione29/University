import java.util.Scanner;

class PlateCheck
{
    public static void main(String args[])
    {
        boolean valid = true;
        System.out.println("Enter the plate number: ");
        Scanner sc = new Scanner(System.in);
        String plate = sc.nextLine();
        
        //plate has 6 characters: L-NN-LLL
        if(plate.length() == 6)
        {
            if(!('A' <= plate.charAt(0) && plate.charAt(0) <= 'Z'))
                valid = false;
            
            for(int i = 1; i < 3; i++)
                if(!('0' <= plate.charAt(i) && plate.charAt(i) <= '9'))
                    valid = false;

            for(int i = 3; i < 6; i++)
                if(!('A' <= plate.charAt(i) && plate.charAt(i) <= 'Z'))
                    valid = false;
            
            
        }
        //plate has 7 characters: LL-NN-LLL or L-NNN-LLL
        else if (plate.length() == 7)
        {
            if(!('A' <= plate.charAt(0) && plate.charAt(0) <= 'Z'))
                valid = false;
            
            //                  first case: LL-NN-LLL                               second case: L-NNN-LLL
            if(!(('A' <= plate.charAt(1) && plate.charAt(1) <= 'Z') || ('0' <= plate.charAt(1) && plate.charAt(1) <= '9')))
                valid = false;
        
            for(int i = 2; i < 4; i++)
                if(!('0' <= plate.charAt(i) && plate.charAt(i) <= '9'))
                    valid = false;
            
            for(int i = 4; i < 7; i++)
                if(!('A' <= plate.charAt(i) && plate.charAt(i) <= 'Z'))
                    valid = false;
        }
        //plate has 8 characters: LL-NNN-LLL
        else if(plate.length() == 8)
        {
            for(int i = 0; i < 2; i++)
                if(!('A' <= plate.charAt(i) && plate.charAt(i) <= 'Z'))
                    valid = false;
            
            for(int i = 2; i < 5; i++)
                if(!('0' <= plate.charAt(i) && plate.charAt(i) <= '9'))
                    valid = false;
            
            for(int i = 5; i < 8; i++)
                if(!('A' <= plate.charAt(i) && plate.charAt(i) <= 'Z'))
                    valid = false;
        }
        else 
            valid = false;

        System.out.println("The plate number is " + (valid ? "valid" : "invalid"));
    }
}