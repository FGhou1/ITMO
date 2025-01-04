package MainClass;

import MyPokemons.Chansey;
import MyPokemons.Cinccino;
import MyPokemons.Happiny;
import MyPokemons.Minccino;
import MyPokemons.Moltres;
import MyPokemons.Blissey;
import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;

public class Main{
	public static void main(String[] args){
		Battle b = new Battle();
		Pokemon minccino = new Minccino("Просто парень", 1);
		Pokemon moltres = new Moltres("Чиловый перень", 1);
        Pokemon happiny = new Happiny("Чиловая девушка", 1);
		Pokemon cinccino = new Cinccino("Чиловый препод", 2);
        Pokemon chansey = new Chansey("Чиловый дед", 2);
        Pokemon blissey = new Blissey("Просто чиловая ВТ утка", 3);

		b.addAlly(minccino);
		b.addAlly(chansey);
		b.addAlly(blissey);

		b.addFoe(moltres);
		b.addFoe(happiny);
		b.addFoe(cinccino);

		b.go();
	}

	public static boolean chance(double d){
		return d > Math.random();
	} 
}
