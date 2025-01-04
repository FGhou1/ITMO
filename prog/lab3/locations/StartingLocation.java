package locations;

import java.util.List;

import characters.StaringNPS;
import interfaces.EnumItem;
import items.StartingLocationItems;

public class StartingLocation extends Location<StartingLocationItems> {
    
    public StartingLocation() { super("Starting location"); this.spawnedPerson = new StaringNPS("Мерцающий дух");}

    public List<EnumItem> spawnedItem = generateItems(StartingLocationItems.values(), StartingLocationItems.getAllChances());
    
    public List<EnumItem> getSpawnedItem() { return spawnedItem; }

    public void printSpawnedItem() { System.out.println(spawnedItems);}

    @Override
    public String toString() { return "Начальная локация"; }

}