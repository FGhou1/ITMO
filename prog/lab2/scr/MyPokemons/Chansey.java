package MyPokemons;

import Moves.ChanseyMove.*;
import ru.ifmo.se.pokemon.Type;
public class  Chansey extends Happiny {
    public Chansey(String name, int level){
        super(name, level);
        super.setType(Type.ELECTRIC, Type.FAIRY);
        super.setStats(250, 5, 5, 35, 105, 50);
        
        Present present = new Present();

        super.setMove(present);

    }
}
