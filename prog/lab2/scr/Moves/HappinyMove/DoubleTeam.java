package Moves.HappinyMove;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class DoubleTeam extends StatusMove{
    public DoubleTeam(){
        super(Type.PSYCHIC, 0, 100);
    }
    
    @Override
    protected void applySelfEffects(Pokemon p){
        super.applySelfEffects(p);
            Effect e = new Effect().stat(Stat.SPEED, +1); 
            p.addEffect(e);
        }

    @Override
    protected String describe(){
        String[] part = this.getClass().toString().split("\\.");
        return "делает " + part[part.length-1];
    }
}