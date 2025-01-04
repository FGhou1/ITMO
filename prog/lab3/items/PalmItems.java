package items;

import interfaces.EnumItem;
import mechanics.EnumParameters;

public enum PalmItems implements EnumItem {
    COCONUT(70, EnumParameters.NOTHING), 
    PARROT(30, EnumParameters.LOOK),
    SEEDS(80, EnumParameters.PLANT);

    PalmItems(int chance, EnumParameters application) { 
        this.chance = chance; 
        this.application = application;
    }

    private final int chance;
    private final EnumParameters application;

    public int getChance() { return chance; }
    public EnumParameters getApplication() {return application;}

    public static int[] getAllChances() { 
        PalmItems[] items = PalmItems.values();
        int[] chances = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            chances[i] = items[i].getChance();
        }
        return chances;
    }
    
    public static String[] getAllNames() {
        PalmItems[] items = PalmItems.values();
        String[] names = new String[items.length];
        for (int i = 0; i < items.length; i++) {
            names[i] = items[i].name();
        }
        return names;
    }

    public static void printAllNames() {
        String[] names = getAllNames();
        for (String name : names) {
            System.out.println(name); 
        }
    }
}


