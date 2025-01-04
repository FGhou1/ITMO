package people;

import java.util.ArrayList;
import java.util.Random;

import locations.Location;
import mechanics.LocationList;
import mechanics.Masages;
import mechanics.ScannerChecker;

public abstract class Person {

    private int energy;           
    private Location<?> location;  
    private boolean visionLocationflag;
    private boolean victoryConditionflag = false;

    Masages masages = new Masages();

    public void setEnergy(int energy) { 
        if((this.energy - energy)>=100){
            this.energy = 100;
        }else{
            this.energy -= energy; }
        }

    public void setLocation(Location<?> location){ this.location = location; }

    public void setVisionLocationflag(boolean visionLocationflag) { this.visionLocationflag = visionLocationflag; }

    public void setVictoryConditionflag(boolean victoryConditionflag) { this.victoryConditionflag = victoryConditionflag; }

    public int getEnergy() { return energy; }

    public Location<?> getLocation() { return location; }

    public boolean getVisionLocationflag() { return visionLocationflag; }

    public boolean getVictoryConditionflag() { return victoryConditionflag;}

    public void getLocation(LocationList locationList){

        setVisionLocationflag(true);

        ArrayList<String> message = new ArrayList<>();
        String pull1 = new String("Вы видите(локации): ");
        for (int i = 0; i < locationList.getList().size(); i++) {
            if (locationList.getList().get(i).equals(getLocation())){
                
            }else{
                pull1 += ((i+1) + ") " + locationList.getList().get(i) + " ");
            }
        }
        message.add(pull1);

        String pull2 = new String("Вы видите(предметы): ");
        for (int i = 0; i < getLocation().getSpawnedItems().size(); i++) {
            pull2 += ((i+1) + ") " + getLocation().getSpawnedItems().get(i) + " ");
        }
        message.add(pull2);

        String pull3 = new String("Вы можете поговорить с: " + getLocation().getspawnedPerson().name());
        message.add(pull3);
        
        masages.messagePackaging(message);
    }

    public void goTo(LocationList locationList){

        if(getVisionLocationflag()){
        
            ScannerChecker scannerChecker2 = new ScannerChecker();
            String pull = new String("Куда пойдем?: ");

            for(int i = 0; i<locationList.getList().size(); i++){
                if (getLocation() != locationList.getList().get(i)) {
                    pull += ((i+1) + ") " + locationList.getList().get(i) + " ");
                }
            }
            masages.messagePackaging(pull);

            switch (scannerChecker2.getUserChoice(locationList.getLocationNamesArray())) {
                case 1 -> {
                    masages.messagePackaging("Вы пошли в " +(locationList.getList().get(0).getName()));
                    this.location = locationList.getList().get(0);
                }
                case 2 -> {
                    masages.messagePackaging("Вы пошли в " +(locationList.getList().get(1).getName()));
                    this.location = locationList.getList().get(1);
                }
                case 3 -> {
                    masages.messagePackaging("Вы пошли в " +(locationList.getList().get(2).getName()));
                    this.location = locationList.getList().get(2);
                }
            }
            setVisionLocationflag(false);

        }else{
            Random random = new Random();
            int randomLocation = random.nextInt(locationList.getList().size()+8);

            switch (randomLocation) {
                case 0 -> {
                    this.setLocation(locationList.getList().get(randomLocation)); 
                    masages.messagePackaging("Вы пришли в " + locationList.getList().get(randomLocation));
                }
                case 1 -> {
                    this.setLocation(locationList.getList().get(randomLocation));
                    masages.messagePackaging("Вы пришли в " + locationList.getList().get(randomLocation));
                }
                case 2 -> {
                    this.setLocation(locationList.getList().get(randomLocation));
                    masages.messagePackaging("Вы пришли в " + locationList.getList().get(randomLocation));
                }
                default -> masages.messagePackaging("Вы ходили кругами и вернулись в тоже самое место");
            }
            setVisionLocationflag(false);
            setEnergy(15);
        }
    }

    public void doAction(){
        if(!this.getVisionLocationflag()){
            masages.messagePackaging(   "Пока объектов для взаимодействия не видно (0-0)");
            return;
        }

        if(getLocation().getSpawnedItems() == null || getLocation().getSpawnedItems().size() == 0){
            masages.messagePackaging(   "Но на лакации нет же ничего.... )");
            return;
        }

        String pull2 = "Предметы для взаимодействия: ";
        for (int i = 0; i < getLocation().getSpawnedItems().size(); i++) {
            pull2 += (i + 1) + ") " + getLocation().getSpawnedItems().get(i) + " ";
        }
        masages.messagePackaging(pull2);
        doAction_part2();
    }

    public abstract void doAction_part2();

    public void speak(){

        if (!getVisionLocationflag()) {
            masages.messagePackaging("Сначала осмотритесь вокруг, чтобы увидеть, что вас окружает.");
            return;
        }
    
        if (getLocation() == null) {
            masages.messagePackaging("Никого нет... не буду же я говорить сам с собой?");
            return;
        }

        
        masages.messagePackaging(location.getspawnedPerson().interact());    
        setEnergy(15);
    }

    public abstract void skip();

}
