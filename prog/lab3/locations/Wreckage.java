package locations;

import java.util.List;

import items.WreckageItems;
import characters.WreckageNPS;
import interfaces.EnumItem;

public class Wreckage extends Location<WreckageItems> {
    
    public Wreckage() { super("Wreckage"); this.generatePerson(engineerNPS);}

    WreckageNPS engineerNPS = new WreckageNPS("Данил", "разработкой ПО");

    private List<EnumItem> spawnedItems = generateItems(WreckageItems.values(), WreckageItems.getAllChances());
    
    public List<EnumItem> getSpawnedItem() { return spawnedItems; }

    public void printSpawnedItem() { System.out.println(spawnedItems); }

    @Override
    public String toString() { return "Кораблекрушение"; }
}