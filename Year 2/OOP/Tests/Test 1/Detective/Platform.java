import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Platform {
    private ArrayList<Crime> crimes;

    public Platform(){
        crimes = new ArrayList<Crime>();
    }

    public void addCrime(Crime vCrime){
        crimes.add(vCrime);
    }

    public Map<String, Integer> toMap(){
        Map<String, Integer> locationMap = new HashMap<String, Integer>();

        ArrayList<String> locations = new ArrayList<String>();

        for(Crime crime : crimes)
            if(locations.contains(crime.getLocation()))
                locations.add(crime.getLocation());

        for(String location : locations){
            int noOfEncounters = 0;

            for(Crime crime : crimes)
                if(location.equals(crime.getLocation()))
                    noOfEncounters++;

            locationMap.put(location, noOfEncounters);
        }
        return locationMap;
    }
}
