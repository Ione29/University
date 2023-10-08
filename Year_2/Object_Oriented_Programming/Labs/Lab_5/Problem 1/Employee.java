import java.time.LocalDate;

public class Employee implements Comparable{
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
    
    public String toString(){
        String text = "Name: " + this.name + " | CNP: " + this.CNP + " | Hiring Date: " + this.hiringDate + " | Specialization: " + this.specialization + " | Salary: " + this.salary;
        return text;
    }

    public int hashCode(){
        return (this.name + this.CNP).hashCode();
    }

    public boolean equals (Object vOther){
        Employee other = (Employee) vOther;
        return (
                (name == null || name.equals(other.name)) && 
                (CNP == null || CNP.equals(other.CNP)));
    }

    public int compareTo(Object vOther){
        Employee other = (Employee) vOther;
        if(this.name.compareTo(other.name) > 0)
            return 1;
        else if(this.name.compareTo(other.name) < 0)
            return -1;
        else
            if(this.CNP.compareTo(other.CNP) > 0)
                return 1;
            else if(this.CNP.compareTo(other.CNP) < 0)
                return -1;
            else return 0;

    }
}
