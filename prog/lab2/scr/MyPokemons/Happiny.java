package MyPokemons;

import Moves.HappinyMove.*;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
public class Happiny extends Pokemon {
    public Happiny(String name, int level){
        super(name, level);
        super.setType(Type.ELECTRIC, Type.FAIRY);
        super.setStats(100, 5, 5, 15, 65, 30);
        
        DoubleTeam doubleTeam = new DoubleTeam();
        Psychic psychic = new Psychic();

        super.setMove(doubleTeam, psychic);

    }
}