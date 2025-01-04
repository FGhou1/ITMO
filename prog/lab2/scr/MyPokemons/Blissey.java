package MyPokemons;

import Moves.BlisseyMove.*;
import ru.ifmo.se.pokemon.Type;
public class  Blissey extends Chansey {
    public Blissey(String name, int level){
        super(name, level);
        super.setType(Type.ELECTRIC, Type.FAIRY);
        super.setStats(255, 10, 10, 75, 135, 55);
        
        Thunder thunder = new Thunder();

        super.setMove(thunder);

    }
}