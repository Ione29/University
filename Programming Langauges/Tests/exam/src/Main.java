import com.sun.security.jgss.GSSUtil;

import javax.swing.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("C:\\Users\\Ione\\Desktop\\Java Programs\\PLa Lab\\Tests\\exam\\src\\inputFile.txt"));
        FileWriter output = new FileWriter("C:\\Users\\Ione\\Desktop\\Java Programs\\PLa Lab\\Tests\\exam\\src\\outputFile.txt");
        int years = 0;
        float days = 0;
        boolean flag;
        int[] cases = {90, 100, 180, 200, 350, 400, 500, 600, 700, 800, 1000, 1200};

        for(int i = 0; i < cases.length; i += 2)
        {
            flag = false;
            for(int j = 2 * i; j < 2 * i + 2; j++)
            {
                System.out.println();
                if(flag == false) {
                    output.write("For level ");
                    flag = true;
                }
                switch (j)
                {
                    case 0: {
                        output.write("A1 ");
                        break;
                    }
                    case 4: {
                        output.write("A2 ");
                        break;
                    }
                    case 8: {
                        output.write("B1 ");
                        break;
                    }
                    case 12: {
                       output.write("B2 ");
                        break;
                    }
                    case 16: {
                        output.write("C1 ");
                        break;
                    }
                    case 20: {
                        output.write("C2 ");
                        break;
                    }
                }
            }
            for(int k = 0; k < 2; k++)
            {
                days = 0;
                years = 0;
                if (k == 0) {
                    output.write(" the best case scenario is ");
                    days = (float) cases[i] / 24;
                } else {
                    output.write(" and the worst case scenario is ");
                    days = (float) cases[i + 1] / 24;
                }
                while (days >= 365) {
                    days -= 365;
                    years++;
                }
                if (days != 0)
                    output.write(days + " days");
                if (days != 0 && years != 0)
                    output.write(" and ");
                if (years != 0)
                    output.write(years + " years");
            }
            }
        }
    }

