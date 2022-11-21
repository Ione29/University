import java.util.HashMap;
import java.util.Map;
import java.text.Normalizer.Form;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static Map<Event.TYPE,List<Client>> formMap(List<Client> vClients){
        
        //initialise the HashMap and the List<Client> for each type of event
        Map<Event.TYPE,List<Client>> typeMap = new HashMap<Event.TYPE, List<Client>>();
        ArrayList<Client> anniversaryType = new ArrayList<Client>();
        ArrayList<Client> beachType = new ArrayList<Client>();
        ArrayList<Client> mountainType = new ArrayList<Client>();
        ArrayList<Client> promotionType = new ArrayList<Client>();
        ArrayList<Client> retirementType = new ArrayList<Client>();

        //go through all the clients and their respective events in order to add them to the HashMap
        for(Client client : vClients)
            for(Event event : client.getPurchasedEvents())
                if(event.getType() == Event.TYPE.ANNIVERSARY)
                    anniversaryType.add(client);
                else if(event.getType() == Event.TYPE.BEACH)
                    beachType.add(client);
                else if(event.getType() == Event.TYPE.MOUNTAIN)
                    mountainType.add(client);
                else if(event.getType() == Event.TYPE.PROMOTION)
                    promotionType.add(client);
                else
                    retirementType.add(client);

        typeMap.put(Event.TYPE.ANNIVERSARY, anniversaryType);
        typeMap.put(Event.TYPE.BEACH, beachType);
        typeMap.put(Event.TYPE.MOUNTAIN, mountainType);
        typeMap.put(Event.TYPE.PROMOTION, promotionType);
        typeMap.put(Event.TYPE.RETIREMENT, retirementType);
    
        return typeMap;
    }
    public static void main(String[] args) {
        //list of clients
        Client c1 = new Client("ionita.alexandru@asaff.ro", "Ionita Alexandru-Mihail");
        Client c2 = new Client("john.doe@gmail.com", "John Doe");

        //list of events
        Event e1 = new Event(LocalDate.of(2002, 10, 9), LocalDate.of(2002, 10, 14), 25000, Event.TYPE.ANNIVERSARY, "Breaza");
        Event e2 = new Event(LocalDate.of(2002, 7, 20), LocalDate.of(2002, 7, 21), 5000, Event.TYPE.PROMOTION, "New York City");
        Event e3 = new Event(LocalDate.of(2002, 5, 5), LocalDate.of(2002, 5, 6), 50000, Event.TYPE.BEACH, "Los Angeles");
        Event e4 = new Event(LocalDate.of(2002, 12, 2), LocalDate.of(2002, 12, 4), 10000, Event.TYPE.MOUNTAIN, "Arefu");
        Event e5 = new Event(LocalDate.of(2002, 3, 4), LocalDate.of(2002, 3, 5), 7500, Event.TYPE.RETIREMENT, "Las Vegas");
        
        //duplicate in order to test the buyEvent function
        Event dupe = new Event(LocalDate.of(2002, 12, 2), LocalDate.of(2002, 12, 4), 10000, Event.TYPE.MOUNTAIN, "Arefu");
        
        //2 more for repeating types in order to test the map
        Event e6 = new Event(LocalDate.of(2002, 10, 15), LocalDate.of(2002, 10, 19), 25000, Event.TYPE.ANNIVERSARY, "Breaza");
        Event e7 = new Event(LocalDate.of(2002, 3, 6), LocalDate.of(2002, 3, 7), 7500, Event.TYPE.RETIREMENT, "Las Vegas");
        
        //add events and test buyEvents
        c1.buyEvent(e1);
        c1.buyEvent(e2);
        c2.buyEvent(e3);
        c2.buyEvent(e4);
        c2.buyEvent(e5);
        c2.buyEvent(dupe);  //should give an error
        //add repeating types of events
        c1.buyEvent(e6);
        c2.buyEvent(e7);

        //test display functions
        c1.displaySortedByPrice();
        c1.displaySortedByType();
        c2.displaySortedByPrice();
        c2.displaySortedByType();

        
        //creating list in order to give it as a function variable
        ArrayList<Client> listOfClients = new ArrayList<Client>();
        listOfClients.add(c1);
        listOfClients.add(c2);

        //Map<Event.TYPE,List<Client>> typeMap = formMap(listOfClients);

    }
}
