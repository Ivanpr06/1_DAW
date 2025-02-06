package Proyecto_5;

import static Proyecto_5.GeneroPokemon.Masculino;

public class Main {
    public static void main(String[] args) {
        Ataque ataque = new AtaqueImpl("Super Tornado", 20);
        Pokemon pokemon = new PokemonImpl(003,"Paco", "Hombre español muy fuerte", 173, 85,Masculino,"Español" );
        Pokedex pokedex = new PokedexImpl(pokemon, ataque);

        System.out.println(pokedex);
    }
}
