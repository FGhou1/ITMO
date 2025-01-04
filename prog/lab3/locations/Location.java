package locations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import interfaces.Cheracters;
import interfaces.EnumItem;
import characters.NullNPS;

public abstract class Location <T extends Enum<T>>{

    private String name;
    public List<EnumItem> spawnedItems;
    public Cheracters spawnedPerson; 

    
    public Location(String name) { this.name = name; }

    public String getName() { return name; }

    public List<EnumItem> getSpawnedItems(){ return spawnedItems; }

    public Cheracters getspawnedPerson() { return spawnedPerson; } 

    @SuppressWarnings("unchecked")
    protected List<EnumItem> generateItems(EnumItem[] objects, int[] chances) {

        Random random = new Random();
        List<EnumItem> selectedItems = new ArrayList<>();
        int roll = random.nextInt(100) + 1; 

        for (int count = 0; count < objects.length; count++) { 
            if (roll <= chances[count]){
                selectedItems.add(objects[count]);
            }
        }
        spawnedItems = selectedItems;
        return selectedItems;
    }

    protected void generatePerson(Cheracters person) {
        Random random = new Random();
        int roll = random.nextInt(100) + 1;

        if (roll <= 60) {
            spawnedPerson = person; 
        }
        else{
            NullNPS nullNPS = new NullNPS();
            spawnedPerson = nullNPS;
        }
        
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Location<?> other = (Location<?>) obj;
        return name.equals(other.name); 
    }
}


