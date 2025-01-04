package characters;

import interfaces.Cheracters;

public record NullNPS() implements Cheracters{

    public String name(){
        return " -";
    }
    public String interact(){
        return "пока не с кем говорить...";
    }
}
