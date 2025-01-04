package mechanics;

import java.util.ArrayList;
import java.util.List;

import locations.Location;

public class LocationList {

    List<Location<?>> locations = new ArrayList<>();
    
    public void addLocation(Location<?> location){ locations.add(location);}

    public List<Location<?>> getList(){ return locations; }
    
    public String[] getLocationNamesArray() {

        List<String> names = new ArrayList<>();

        for (Location<?> location : locations) {
            names.add(location.getName());
        }
        return names.toArray(new String[0]);
        
    }
}
