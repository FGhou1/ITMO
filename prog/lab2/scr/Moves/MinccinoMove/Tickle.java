package Moves.MinccinoMove;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class Tickle extends StatusMove{
    public Tickle(){
        super(Type.NORMAL, 0, 100);
    }
    
    @Override
    protected void applyOppEffects(Pokemon p){
        super.applyOppEffects(p);
        Effect e = new Effect().stat(Stat.DEFENSE, -1).stat(Stat.ATTACK, -1);
        p.addEffect(e);

    }

    @Override
    protected String describe(){
        String[] part = this.getClass().toString().split("\\.");
        return "делает " + part[part.length-1];
    }
}
