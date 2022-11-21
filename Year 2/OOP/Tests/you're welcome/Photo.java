import java.time.LocalDate;

public class Photo{
    private String name;
    private LocalDate date;
    private Integer score;

    public Photo(String vName, LocalDate vDate, int vScore){
        this.name = vName;
        this.date = vDate;
        this.score = vScore;
    }

    public Integer getScore(){
        return this.score;
    }

    public String toString(){
        String text = "Name: " + this.name + " | Date: " + this.date + " | Score: " + this.score;
        return text;
    }

    public boolean equals(Object vOther){
        Photo other = (Photo) vOther;
        return  (
                (name == null || name.equals(other.name)) && 
                (date == null || date.equals(other.date)) &&
                (score == null || score.equals(other.score))
                );
    }

    public int compareTo(Object vOther){
        Photo other = (Photo) vOther;
        if(this.name.compareTo(other.name) > 0)
            return 1;
        else if(this.name.compareTo(other.name) < 0)
            return -1;
        else
            if(this.date.compareTo(other.date) > 0)
                return 1;
            else if(this.date.compareTo(other.date) < 0)
                return -1;
            else 
                if(this.score.compareTo(other.score) > 0)
                    return 1;
                else if(this.score.compareTo(other.score) < 0)
                    return -1;
                else return 0;
    }

    public int hashCode(){
        return (this.name + this.date + this.score).hashCode();
    }
}