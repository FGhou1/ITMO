package mechanics;

import java.util.ArrayList;
import java.util.List;

import locations.*;
import people.Person;

public class Masages {

    public void greetingsMasage(){
        System.out.println("");
        System.out.println(">>>>>>>>>@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@<<<<<<<<<<<<<");
        System.out.println("");
        System.out.println("                      Вы появились на острове...");
        System.out.println("");
        System.out.println(">>>>>>>>>@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@<<<<<<<<<<<<<");
        System.out.println("");
    }

    public void indicatorsMasage(Person hero){
        System.out.print("   Вы находитесь: в " + hero.getLocation().getName() + " | ");
        System.out.println("энергия: " + hero.getEnergy() + " | Ваш персонаж: " + hero.getClass().getSimpleName());
        System.out.println("  ___________________________________________________________________________");
        System.out.println("");
    }

    public void choiceMasage(){
        System.out.println("Выберите действие: ");
        System.out.println("    1) Осмотреться ");
        System.out.println("    2) Пойти");
        System.out.println("    3) Использовать ");
        System.out.println("    4) Поговорить ");
        System.out.println("    5) Пропустить");
        System.out.println("    6) Показать индикаторы");
    }

    public void spawnItems(List<Location<?>> locationList) {

        System.out.println("");
        for (Location<?> location : locationList) {
            if (location.getSpawnedItems().size() != 0) {
                System.out.println("В " + location.getName() + " появились: " + location.getSpawnedItems() + ", " + location.spawnedPerson.name());
            } else {
                System.out.println("В " + location.getName() + " ничего не появилось");
            }
        }
    }
    
    public void messagePackaging(ArrayList<String> massage){

        System.out.println("-----------------------------------------------------------------");
        for (int i = 0; i < massage.size(); i++){
            System.out.println(">>> " + massage.get(i));
        }       
        System.out.println("-----------------------------------------------------------------");
    }

    public void messagePackaging(String massage){

        System.out.println("-----------------------------------------------------------------");
        System.out.println(">>> " + massage);
        System.out.println("-----------------------------------------------------------------");

    }

    public void farewellMessage(Person hero){
        if(hero.getVictoryConditionflag()){
            System.out.println("");
            System.out.println(">>>>>>>>>@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@<<<<<<<<<<<<<");
            System.out.println("");
            System.out.println("                    Поздравляю с прохождением игры!");
            System.out.println("");
            System.out.println("                          /// GAME OVER ///");
            System.out.println("");
            System.out.println(">>>>>>>>>@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@<<<<<<<<<<<<<");
        }else{
            System.out.println("");
            System.out.println(">>>>>>>>>@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@<<<<<<<<<<<<<");
            System.out.println("");
            System.out.println("               Вы проиграли, у вас закончилась энергия");
            System.out.println("");
            System.out.println("                          /// GAME OVER ///");
            System.out.println("");
            System.out.println(">>>>>>>>>@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@<<<<<<<<<<<<<");
        }
    }
}
