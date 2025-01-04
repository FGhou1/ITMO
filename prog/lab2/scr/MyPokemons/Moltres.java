package MyPokemons;

import Moves.MoltresMove.*;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
public class Moltres extends Pokemon {
    public Moltres(String name, int level){
        super(name, level);
        super.setType(Type.ELECTRIC, Type.FAIRY);
        super.setStats(90, 100, 90, 125, 85, 90);
        
        Confide confide = new Confide();
        Flamethrower flamethrower = new Flamethrower();
        Hurricane hurricane = new Hurricane();
        AerialAce aerialAce = new AerialAce();

        super.setMove(confide, hurricane, aerialAce, flamethrower);

    }
}
