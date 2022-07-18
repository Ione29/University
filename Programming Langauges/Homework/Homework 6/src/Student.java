import java.util.Scanner;

public class Student
{
    private String name;
    private int points;
    private int examsTaken = 0;

    public Student(String name)
    {
        this.name = name;
        this.points = 0;
        this.examsTaken = 0;
    }

    private String getName()
    {
        return this.name;
    }

    private void addExam(int mark)
    {
        this.points += mark;
        examsTaken++;
    }

    private int getTotal()
    {
        return this.points;
    }

    private double getMeanMark()
    {
        return (float)this.points / examsTaken;
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);

        Student student = new Student("Alex");

        student.addExam(input.nextInt());
        student.addExam(input.nextInt());
        student.addExam(input.nextInt());

        System.out.println("The total number of points is " + student.getTotal() + ".");
        System.out.println("The mean of all marks is " + student.getMeanMark() + ".");

    }
}
