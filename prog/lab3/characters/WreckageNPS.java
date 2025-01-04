package characters;

import interfaces.Cheracters;

public record WreckageNPS(String name, String employment) implements Cheracters{
    public String interact() {
        return "Я — " + name + ", занимаюсь " + employment + ". Походу в коробле произошла NullPointerException";
    }
}
