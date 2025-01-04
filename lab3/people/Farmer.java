package people;

import interfaces.GardenMove;
import locations.StartingLocation;
import mechanics.ScannerChecker;
import mechanics.EnumParameters;
import mechanics.Masages;

public class Farmer extends Person implements GardenMove {

    private boolean seedsPlanted = false;
    private boolean plantCaredFor = false;

    Masages masages = new Masages();

    public Farmer() {
        setEnergy(-100);
        setLocation(new StartingLocation());
        setVisionLocationflag(false);
    }

    @Override
    public void skip() {
        setEnergy(10);
        masages.messagePackaging("    -Хмммм, эта трава такая красивая");
    }

    @Override
    public void doAction_part2 () {
        
        ScannerChecker scannerChecker = new ScannerChecker();

        int itemChoice = scannerChecker.getUserChoice(getLocation().getSpawnedItems().size());
        EnumParameters choice = getLocation().getSpawnedItems().get(itemChoice - 1).getApplication();
        String itemName = getLocation().getSpawnedItems().get(itemChoice - 1).name();

        switch (choice) {
            case EAT -> {masages.messagePackaging("Вы съели:" + itemName); setEnergy(-20);}
            case LOOK -> {masages.messagePackaging("Похоже это - " + itemName); setEnergy(10);}
            case PLANT -> { while (true) {

                                setEnergy(10);

                                System.out.println("Выбирете действие:");
                                System.out.println("    1) Посадить семена");
                                System.out.println("    2) Позаботиться о семочке");
                                System.out.println("    3) Собрать урожай");                
                                System.out.println("    4) Закончить");
                    
                                int actionChoice = scannerChecker.getUserChoice(4);
    
                                switch (actionChoice) {
                                    case 1 -> plantSeeds();
                                    case 2 -> takeCareOfThePlant();
                                    case 3 -> { if (harvest()) {  setVictoryConditionflag(true); return; } }
                                    default -> { seedsPlanted = false; plantCaredFor = false; return; }
                                }
                            }
                        }
            default -> masages.messagePackaging("Пока непонятно, как этим пользоваться :?");
        }
    
    }

    @Override
    public void plantSeeds() {
        if (!seedsPlanted) {
            seedsPlanted = true;
            masages.messagePackaging("Семена посажены");
        } else {
            masages.messagePackaging("Вы делаете что-то не так /(^-^)\\");
        }
    }

    @Override
    public void takeCareOfThePlant() {
        if (seedsPlanted) {
            plantCaredFor = true;
            masages.messagePackaging("Вы заботились о растении");
        } else if (!seedsPlanted) {
            masages.messagePackaging("Сначала нужно посадить семена.");
        } else {
            masages.messagePackaging("Вы делаете что-то не так /(^-^)\\");
        }
    }

    @Override
    public boolean harvest() {
        if (plantCaredFor) {
            masages.messagePackaging("Вы собрали урожай");
            resetPlantingCycle();
            return true; 
        } else if (!seedsPlanted) {
            masages.messagePackaging("Сначала нужно посадить семена.");
        } else if (!plantCaredFor) {
            masages.messagePackaging("Сначала нужно позаботиться о семочке.");
        } else {
            masages.messagePackaging("Вы делаете что-то не так /(^-^)\\");
        }
        return false; 
}


    private void resetPlantingCycle() {
        seedsPlanted = false;
        plantCaredFor = false;
    }
}

