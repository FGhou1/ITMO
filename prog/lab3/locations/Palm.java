package locations;

import java.util.List;

import characters.PalmNPS;
import interfaces.EnumItem;
import items.PalmItems;

public class Palm extends Location<PalmItems> {
    
    public Palm() { super("Palm"); this.generatePerson(modelNPS);}

    PalmNPS modelNPS = new PalmNPS("Жана", "облизывает йогурты");

    public List<EnumItem> spawnedItems = generateItems(PalmItems.values(), PalmItems.getAllChances());

    public List<EnumItem> getSpawnedItem() { return spawnedItems; }

    public void printSpawnedItem() { System.out.println(spawnedItems); }

    @Override
    public String toString() { return "Пальма"; }
}