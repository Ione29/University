public abstract class Flight {
    private long flightID;
    private String departure;
    private String arrival;
    private int time;

    public Flight(long vFlightID, String vDeparture, String vArrival, int vTime){
        this.flightID = vFlightID;
        this.departure = vDeparture;
        this.arrival = vArrival;
        this.time = vTime;
    }

    public long computeCost;
}
