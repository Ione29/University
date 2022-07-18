import java.util.ArrayList;
import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main
{
    public static ArrayList<dailyStats> Read() throws IOException
    {
        FileInputStream fin = new FileInputStream("C:\\Users\\Ione\\Desktop\\Java Programs\\PLa Lab\\Homework\\Homework 14\\src\\weather.txt");
        InputStreamReader reader = new InputStreamReader(fin);
        BufferedReader br = new BufferedReader(reader);
        String input = "";
        ArrayList<dailyStats> row = new ArrayList<>();
        while((input = br.readLine()) != null)
        {

            String[] temp = input.split("\\s+");
            String month = temp[0];
            String day = temp[1];
            String year = temp[2];
            if(Integer.parseInt(day) <= 9)
                day = "0" + day;
            if(Integer.parseInt(month) <= 9)
                month = "0" + month;
            if(Integer.parseInt(temp[3]) == -999)
                continue;
            LocalDate date = LocalDate.parse(year + "-" + month + "-" +day);
            row.add(new dailyStats(date, Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), Integer.parseInt(temp[6])));
        }
        br.close();
        reader.close();
        fin.close();
        return row;
    }

    public static double avgPrecipitations(ArrayList<dailyStats> weather, int year)
    {
        int sum = 0, days = 0;
        for(var i : weather)
            if(i.getDate().getYear() == year)
            {
                days++;
                sum += i.getPrecipitations();
            }

        return sum / days;
    }

    public static double avgSnow(ArrayList<dailyStats> weather, int year)
    {
        int sum = 0, days = 0;
        for(var i : weather)
            if(i.getDate().getYear() == year)
            {
                days++;
                sum += i.getSnow();
            }

        return sum / days;
    }

    public static double maxTemp(ArrayList<dailyStats> weather, int year, int month)
    {
        double max = Double.MIN_VALUE;
        for(var i : weather)
            if(i.getDate().getYear() == year && i.getDate().getMonth().getValue() == month)
                if(i.getHighTemp() > max)
                    max = i.getHighTemp();
        return max;
    }

    public static double lowTemp(ArrayList<dailyStats> weather, int year, int month)
    {
        double min = Double.MAX_VALUE;
        for(var i : weather)
            if(i.getDate().getYear() == year && i.getDate().getMonth().getValue() == month)
                if(i.getLowTemp() < min)
                    min = i.getLowTemp();
        return min;
    }

    public static void main(String[] args) throws IOException
    {
        ArrayList<dailyStats> weather = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        weather = Read();

        for(var i : weather)
        {
            System.out.print(avgPrecipitations(weather, i.getDate().getYear()) + " ");
            System.out.print(avgSnow(weather, i.getDate().getYear()));
            System.out.println();
        }

        System.out.println("Type in the year and the month:");
        int year = input.nextInt();
        int month = input.nextInt();
        System.out.println(maxTemp(weather, year, month));
        System.out.println(lowTemp(weather, year, month));
    }
}