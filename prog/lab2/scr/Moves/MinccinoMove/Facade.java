package Moves.MinccinoMove;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Facade extends PhysicalMove{
    public Facade(){
        super(Type.NORMAL, 70, 100);
    }
    
    @Override
    protected void applyOppEffects(Pokemon p){
        super.applyOppEffects(p);
        
        if(p.getCondition().toString() == "PARALYZE" || p.getCondition().toString() == "POISON" || p.getCondition().toString() == "BURN"){
            super.applyOppDamage(p, accuracy);        }

    }

    @Override
    protected String describe(){
        String[] part = this.getClass().toString().split("\\.");
        return "делает " + part[part.length-1];
    }
}

