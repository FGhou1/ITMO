package mechanics;

import people.Person;

public class GameLoop {

    private Person hero;
    private LocationList locationList;
    private ScannerChecker scannerChecker;

    Masages masages = new Masages();

    public GameLoop(Person hero, LocationList locationList) {
        this.hero = hero;
        this.locationList = locationList;
        this.scannerChecker = new ScannerChecker();
    }

    public void startGame() {

        masages.greetingsMasage();
        masages.indicatorsMasage(hero);

        while (hero.getEnergy() > 0 && !hero.getVictoryConditionflag()) {
            masages.choiceMasage();

            switch (scannerChecker.getUserChoice(6)) {
                case 1 -> hero.getLocation(locationList);
                case 2 -> hero.goTo(locationList);
                case 3 -> hero.doAction();
                case 4 -> hero.speak();
                case 5 -> hero.skip();
                default -> masages.indicatorsMasage(hero);
            }
        }
        masages.farewellMessage(hero);
        scannerChecker.closeScanner();
    }
}

