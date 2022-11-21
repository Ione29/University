import java.time.LocalDate;

public class Event implements Comparable{
    
    public enum TYPE{
        MOUNTAIN,
        BEACH,
        ANNIVERSARY,
        PROMOTION,
        RETIREMENT
    }

    private LocalDate startDate;
    private LocalDate endDate;
    private Double price;
    private TYPE type;
    private String location;

    public Event(LocalDate vStartDate, LocalDate vEndDate, double vPrice, TYPE vType, String vLocation){
        this.startDate = vStartDate;
        this.endDate = vEndDate;
        this.price = vPrice;
        this.type = vType;
        this.location = vLocation;
    }

    public LocalDate getStartDate(){
        return this.startDate;
    }

    public LocalDate getEndDate(){
        return this.endDate;
    }

    public TYPE getType(){
        return this.type;
    }

    public double getPrice(){
        return this.price;
    }


    public boolean equals (Object vOther){
        Event other = (Event) vOther;
        return  (
                (startDate == null || startDate.equals(other.startDate)) && 
                (endDate == null || endDate.equals(other.endDate)) &&
                (location == null || location.equals(other.location))
                );
    }

    public int compareTo(Object vOther){
        Event other = (Event) vOther;
        if(this.startDate.compareTo(other.startDate) > 0)
            return 1;
        else if(this.startDate.compareTo(other.startDate) < 0)
            return -1;
        else
            if(this.endDate.compareTo(other.endDate) > 0)
                return 1;
            else if(this.endDate.compareTo(other.endDate) < 0)
                return -1;
            else 
                if(this.location.compareTo(other.location) > 0)
                    return 1;
                else if(this.location.compareTo(other.location) < 0)
                    return -1;
                else return 0;
    }

    @Override
    public String toString(){
        String text = "Start Date: " + this.startDate + " | End Date: " + this.endDate + " | Type: " + this.type + " | Price: " + this.price + " | Location: " + this.location; 
        return text;
    }

    //re-written hashCode for the HashMap implementation
    public int hashCode(){
        return (this.type).hashCode();
    }
}