import java.time.LocalDate;

public class Employee {
    private String name;
    private String CNP;
    private LocalDate hiringDate;
    private String specialization;
    private Double salary; 

    public Employee(String vName, String vCNP, LocalDate vHiringDate, String vSpecalization, Double vSalary){
        this.name = vName;
        this.CNP = vCNP;
        this.hiringDate = vHiringDate;
        this.specialization = vSpecalization;
        this.salary = vSalary;
    }

    public String getName(){
        return this.name;
    }
}
