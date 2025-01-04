package people;

import java.util.ArrayList;

import characters.NullNPS;
import interfaces.SpecialMove;
import locations.StartingLocation;
import mechanics.EnumParameters;
import mechanics.Masages;
import mechanics.ScannerChecker;

public class Model extends Person implements SpecialMove {

    private boolean flirting = false;
    
    Masages masages = new Masages();

    public Model() {
        setEnergy(100);
        setLocation(new StartingLocation());
        setVisionLocationflag(false);
    }

    @Override
    public void skip() {
        setEnergy(10);
        System.out.println("    Засмотрелась в зеркало");
    }

    @Override
    public void doAction_part2() {
        ScannerChecker scannerChecker = new ScannerChecker();

        if(!getLocation().getspawnedPerson().equals(new NullNPS())){
            ArrayList<String> pull0 = new ArrayList<>();
            String pull1 = new String("У вашего персонажа, есть способность взаимодействовать с людьми");
            String pull2 = new String("Желаете воспользоваться?: 1) Да 2) Нет");
            pull0.add(pull1);
            pull0.add(pull2);
            masages.messagePackaging(pull0);

            int moveChoice = scannerChecker.getUserChoice(2);

            if(moveChoice == 1){
                while (true) {

                    setEnergy(10);

                    System.out.println("Выбирете действие:");
                    System.out.println("    1) Флиртовать");
                    System.out.println("    2) Заняться 18+");
                    System.out.println("    3) Закончить");
        
                     int actionChoice = scannerChecker.getUserChoice(4);

                    switch (actionChoice) {
                        case 1 -> flirting();
                        case 2 -> { if(haveSex()){ setVictoryConditionflag(true);  return;} }
                        default -> { flirting = false; return; }
                    }
                }
            }
        }

        int itemChoice = scannerChecker.getUserChoice(getLocation().getSpawnedItems().size());
        EnumParameters choice = getLocation().getSpawnedItems().get(itemChoice - 1).getApplication();
        String itemName = getLocation().getSpawnedItems().get(itemChoice - 1).name();

        switch (choice) {
            case EAT -> {masages.messagePackaging("Вы съели:" + itemName); setEnergy(-20);}
            case LOOK -> {masages.messagePackaging("Похоже это - " + itemName); setEnergy(10);}
            default -> masages.messagePackaging("Пока непонятно, как этим пользоваться :?");
        }
    }

    @Override
    public void flirting() {
        if (!flirting) {
            flirting = true;
            masages.messagePackaging("Оу, " + getLocation().getspawnedPerson().name() + ", вы так прекрасны! Как зарефокторенный код))))");
        } else {
            masages.messagePackaging("Вроде он уже не равнодушен...");
        }
    }

    @Override
    public boolean haveSex() {
        if (flirting) {
            masages.messagePackaging("Вы собрали jarnic");
            flirting = false;
            return true; 
        } else{
            masages.messagePackaging("Стоит попробовать, как-то сблизиться");
        }
        return false;
    }
}