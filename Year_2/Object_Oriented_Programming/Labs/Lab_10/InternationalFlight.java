public class InternationalFlight extends Flight{
    private String arrivalCountry;

    public InternationalFlight(long vFlightID, String vDeparture, String vArrival, int vTime, String vArrivalCountry){
        super(vFlightID, vDeparture, vArrival, vTime);
        this.arrivalCountry = vArrivalCountry;
    }
}
