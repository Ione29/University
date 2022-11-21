import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Client{

    private String email;
    private String name;
    private ArrayList<Event> purchasedEvents = new ArrayList<Event>();
    public Client(String vEmail, String vName){
        this.email = vEmail;
        this.name = vName;
    }

    //getter needed in order to put the events in the map
    public ArrayList<Event> getPurchasedEvents(){
        return this.purchasedEvents;
    }

    public boolean buyEvent(Event vEvent){
    for(Event event : purchasedEvents)
        //start date of desired event is between the startDate or endDate of another event in the purchased list
        if(event.getStartDate().compareTo(vEvent.getStartDate()) <= 0 && vEvent.getStartDate().compareTo(event.getEndDate()) <= 0) 
        {
            System.out.println(name + ", the event you are trying to buy is overlaping with another event that you have already bought");
            return false;
        }
            //end date of desired event is between the startDate or endDate of another event in the purchased list
            else if(event.getStartDate().compareTo(vEvent.getEndDate()) <= 0 && vEvent.getEndDate().compareTo(event.getEndDate()) <= 0) 
        {
            System.out.println(name + ", the event you are trying to buy is overlaping with another event that you have already bought.");
            return false;
        }    

    //if there is no interlaping, the purchase is succesful
    purchasedEvents.add(vEvent);
    return true;
    }

    public void displaySortedByPrice(){

        ArrayList<Event> dupeEvents = purchasedEvents;

        Collections.sort(dupeEvents,
                new Comparator<Event>(){
                    public int compare(Event e1, Event e2){
                        if(e1.getPrice() > e2.getPrice())
                            return 1;
                        else if(e1.getPrice() < e2.getPrice())
                            return -1;
                        else
                            return 0;
                    }
                });

        System.out.println();
        System.out.println(this.name + ", these are your purchased events, sorted by price: ");
        for(Event event : dupeEvents)
            System.out.println(event.toString());

        
    }

    public void displaySortedByType(){

        ArrayList<Event> dupeEvents = purchasedEvents;

        Collections.sort(dupeEvents,
            new Comparator<Event>(){
                public int compare(Event e1, Event e2){
                    return e1.getType().compareTo(e2.getType());
                }
            });
        
        System.out.println();
        System.out.println(this.name + ", these are your purchased events, sorted by type: ");
        for(Event event : dupeEvents)
            System.out.println(event.toString());

        
    }
}