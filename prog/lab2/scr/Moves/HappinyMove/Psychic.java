package Moves.HappinyMove;

import MainClass.Main;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class Psychic extends SpecialMove{
    public Psychic(){
        super(Type.PSYCHIC, 90, 100);
    }
    
    @Override
    protected void applyOppEffects(Pokemon p){
        super.applyOppEffects(p);
        
        if(Main.chance(0.1)){
            Effect e = new Effect().stat(Stat.SPECIAL_DEFENSE, -1); 
            p.addEffect(e);
        }
    }

    @Override
    protected String describe(){
        String[] part = this.getClass().toString().split("\\.");
        return "делает " + part[part.length-1];
    }
}