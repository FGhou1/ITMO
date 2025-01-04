package characters;

import interfaces.Cheracters;

public record BushesNPS(String name, String employment) implements Cheracters{

    public String interact() {
        return "Я — " + name + ", занимаюсь " + employment + ". Здесь помнит шаги тех, кто был на ней...";
    }    
}