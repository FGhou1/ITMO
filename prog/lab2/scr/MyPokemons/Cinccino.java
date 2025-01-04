package MyPokemons;

import Moves.CinccinoMove.*;
import ru.ifmo.se.pokemon.Type;
public class  Cinccino extends Minccino {
    public Cinccino(String name, int level){
        super(name, level);
        super.setType(Type.ELECTRIC, Type.FAIRY);
        super.setStats(75, 95, 60, 65, 60, 115);
        
        Thunder thunder = new Thunder();

        super.setMove(thunder);

    }
}