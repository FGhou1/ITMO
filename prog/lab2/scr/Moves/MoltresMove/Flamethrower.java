package Moves.MoltresMove;

import MainClass.Main;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class Flamethrower extends SpecialMove{
    public Flamethrower(){
        super(Type.FIRE, 90, 100);
    }
    
    @Override
    protected void applyOppEffects(Pokemon p){
        super.applyOppEffects(p);
        
        if(Main.chance(0.1)){
            Effect.burn(p);
        }
    }

    @Override
    protected String describe(){
        String[] part = this.getClass().toString().split("\\.");
        return "делает " + part[part.length-1];
    }
}