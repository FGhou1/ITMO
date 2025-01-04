package items;

import interfaces.EnumItem;
import mechanics.EnumParameters;

public enum StartingLocationItems implements EnumItem{
    BOX(50, EnumParameters.NOTHING);

    private final int chance;
    private final EnumParameters application;

    StartingLocationItems(int chance, EnumParameters application) {
        this.chance = chance;
        this.application = application;
    }

    public int getChance() {return chance;}
    public EnumParameters getApplication() {return application;}

    public static int[] getAllChances() { 
        StartingLocationItems[] items = StartingLocationItems.values();
        int[] chances = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            chances[i] = items[i].getChance();
        }
        return chances;
    }

    public static String[] getAllNames() {
        StartingLocationItems[] items = StartingLocationItems.values();
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
