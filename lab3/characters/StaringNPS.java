package characters;

import interfaces.Cheracters;

public record StaringNPS(String name) implements Cheracters{
    public String interact(){
        return "?#&#&#&&##&&#&&#&&??";
    }
}
