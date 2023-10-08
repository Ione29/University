public class InsuranceTest
{
    public static void main(String[] args)
    {
        Insurance life = new LifeInsurance("Eduard-Nicolae", "Bazaria", "Undeva in Balkani");
        Insurance accident = new AccidentInsurance("Alexandru-Mihail", "Ionita", "Popesti-Leordeni", "half-early");

        System.out.println("Life Insurance paid amount per period: " + life.computeAmountPerPeriod());
        life.computeSum();
        System.out.println("Life Insurance total sum: " + life.getSum());

        System.out.println("Accident Insurance paid amount per period: " + accident.computeAmountPerPeriod());
        accident.computeSum();
        System.out.println("Accident Insurance total sum: " + accident.getSum());

        life.toString();
        accident.toString();
    }
}
