package characters;

import interfaces.Cheracters;

public record PalmNPS(String name, String employment) implements Cheracters{
    public String interact() {
        return "Я — " + name + ". Люди знают меня только с одной стороны, но правда в том, что я " + employment + ".";
    }    
}