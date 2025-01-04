package MyPokemons;

import Moves.MinccinoMove.*;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
public class Minccino extends Pokemon {
    public Minccino(String name, int level){
        super(name, level);
        super.setType(Type.ELECTRIC, Type.FAIRY);
        super.setStats(55, 50, 40, 40, 40, 75);
        
        Facade facade = new Facade();
        Swagger swagger = new Swagger();
        Tickle tickle = new Tickle();

        super.setMove(facade, swagger, tickle);

    }
}

