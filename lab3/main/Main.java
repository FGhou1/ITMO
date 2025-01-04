package main;

import locations.*;
import people.Person;
import people.Model;
import people.Farmer;
import people.Engineer;
import mechanics.*;

public class Main {
    public static void main(String[] args) {  

        LocationList locationList = new LocationList();
        
        Person hero;

        Bushes bushes = new Bushes();
        Palm palm = new Palm();
        Wreckage wreckage = new Wreckage();

        locationList.addLocation(bushes);
        locationList.addLocation(palm);
        locationList.addLocation(wreckage);

        System.out.println("");
        System.out.println("Добро пожаловать! Выберите класс персонажа:");
        System.out.println("    1) Фермер  2) Модель  3) Инженер");
        System.out.println("");
        System.out.println("Задачи классов (условия победы):");
        System.out.println("    Фермер - вырастить урожай.");
        System.out.println("    Модель - заняться 18+.");
        System.out.println("    Инженер - создать шедевр.");


        ScannerChecker scannerChecker = new ScannerChecker();
        int choice = scannerChecker.getUserChoice(3);

        switch (choice) {
            case 1 -> {hero = new Farmer();}
            case 2 -> {hero = new Model();}
            default -> {hero = new Engineer();}
        }

        GameLoop gameLoop = new GameLoop(hero, locationList);
        
        gameLoop.startGame();
    }
}
