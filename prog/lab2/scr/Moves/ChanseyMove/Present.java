package Moves.ChanseyMove;

import MainClass.Main;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class Present extends PhysicalMove{
    public Present(){
        super(Type.FIRE, 0, 90);
    }
    
    @Override
    protected void applyOppEffects(Pokemon p){
        super.applyOppEffects(p);
        
        if(Main.chance(0.5)){
            super.applyOppDamage(p, 10);
        }
        else{
            Effect e = new Effect().stat(Stat.HP, +1); 
            p.addEffect(e);
        }
    }

    @Override
    protected String describe(){
        String[] part = this.getClass().toString().split("\\.");
        return "делает " + part[part.length-1];
    }
}