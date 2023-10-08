public class FlightOperator extends Thread{
    private String name;

    public FlightOperator(String vName){
        super(vName);
        this.name = vName;
    }

    
}
