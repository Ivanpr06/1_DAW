package Proyecto_5;

public class PokedexImpl implements Pokedex {

    // Atributos
    private Pokemon pokemon;
    private Ataque ataque;

    // Constructor

    public PokedexImpl(Pokemon pokemon, Ataque ataque) {
        this.pokemon = pokemon;
        this.ataque = ataque;
    }

    // Get && Set

    public Pokemon getPokemon() {
        return pokemon;
    }

    public Ataque getAtaque() {
        return ataque;
    }
    public Pokemon getCompradorPokemon() {return pokemon;}

    // ToString

    @Override
    public String toString() {
        return pokemon + "\n" + ataque;
    }
}
