import java.util.Scanner;
public class PowerOfThor1
{
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTx = in.nextInt(); // Thor's starting X position
        int initialTy = in.nextInt(); // Thor's starting Y position
        int currentX, currentY;
        currentX = initialTx;
        currentY = initialTy;

        // game loop
        while (true)
        {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.

            if(currentY > lightY && currentX == lightX)//move to N
            {
                System.out.println("N");
                currentY--;
            }
            else if(currentY > lightY && currentX < lightX)//move to NE
            {
                System.out.println("NE");
                currentY--;
                currentX++;
            }
            else if(currentY == lightY && currentX < lightX)//move to E
            {
                System.out.println("E");
                currentX++;
            }
            else if(currentY < lightY && currentX < lightX)//move to SE
            {
                System.out.println("SE");
                currentY++;
                currentX++;
            }
            else if(currentY < lightY && currentX == lightX)//move to S
            {
                System.out.println("S");
                currentY++;
            }
            else if(currentY < lightY && currentX > lightX)//move to SW
            {
                System.out.println("SW");
                currentY++;
                currentX--;
            }
            else if(currentY == lightY && currentX > lightX)//move to W
            {
                System.out.println("W");
                currentX--;
            }
            else //move to NW
            {
                System.out.println("NW");
                currentY--;
                currentX--;
            }
        }
    }
}
