package locations;

import java.util.List;

import items.BushesItems;
import characters.BushesNPS;
import interfaces.EnumItem;

public class Bushes extends Location<BushesItems> {

    public Bushes() { super("Bushes"); this.generatePerson(farmerNPS);}

    BushesNPS farmerNPS = new BushesNPS("Федя", "выращиванием канабиса");

    public List<EnumItem> spawnedItem = generateItems(BushesItems.values(), BushesItems.getAllChances());

    public List<EnumItem> getSpawnedItem() { return spawnedItem; }

    public void printSpawnedItem() { System.out.println(spawnedItems); }

    public String toString() { return "Кусты"; }
}