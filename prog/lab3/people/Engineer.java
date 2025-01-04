package people;

import interfaces.SmartMove;
import locations.StartingLocation;
import mechanics.EnumParameters;
import mechanics.Masages;
import mechanics.ScannerChecker;

public class Engineer extends Person implements SmartMove {

    private boolean think = false;

    Masages masages = new Masages();

    public Engineer() {
        setEnergy(100);
        setLocation(new StartingLocation());
        setVisionLocationflag(false);
        
    }

    @Override
    public void skip() {
        setEnergy(10);
        masages.messagePackaging("    А что это у нас?? (начал код ревью)... спустя 3 часа");
    }

    @Override
    public void doAction_part2() {

        ScannerChecker scannerChecker = new ScannerChecker();

        int itemChoice = scannerChecker.getUserChoice(getLocation().getSpawnedItems().size());
        EnumParameters choice = getLocation().getSpawnedItems().get(itemChoice - 1).getApplication();
        String itemName = getLocation().getSpawnedItems().get(itemChoice - 1).name();

        switch (choice) {
            case EAT -> {masages.messagePackaging("Вы съели:" + itemName); setEnergy(-20);}
            case LOOK -> {masages.messagePackaging("Похоже это - " + itemName); setEnergy(10);}
            case CREATE -> { while (true) {

                                 setEnergy(10);

                                System.out.println("Выбирете действие:");
                                System.out.println("    1) Подумать");
                                System.out.println("    2) Создать");
                                System.out.println("    3) Закончить");
                    
                                 int actionChoice = scannerChecker.getUserChoice(4);
    
                                switch (actionChoice) {
                                    case 1 -> think();
                                    case 2 -> { if(create()){ setVictoryConditionflag(true); return;} }
                                    default -> { think = false; return; }
                                }
                            }
                        }
            default -> masages.messagePackaging("Пока непонятно, как этим пользоваться :?");
        }
    }

    @Override
    public void think() {
        if (!think) {
            think = true;
            masages.messagePackaging("Хм, похоже теперь, я знаю, что делать!");
        } else {
            masages.messagePackaging("Вроде и так все понятно...");
        }
    }

    @Override
    public boolean create() {
        if (think) {
            masages.messagePackaging("Вы собрали jarnic");
            think = false;
            return true; 
        } else{
            masages.messagePackaging("Пока не понятно, что делать...");
        }
        return false;}
}