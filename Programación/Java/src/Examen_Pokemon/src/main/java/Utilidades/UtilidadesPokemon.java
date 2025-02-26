package Utilidades;

import Modelos.Pokemon;
import Modelos.TipoPokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UtilidadesPokemon {

    public List<Pokemon> obtenerPokemonConTipos(List<Pokemon> pokemons, List<TipoPokemon> tipos){
        List<Pokemon> pokemonConTipos = new ArrayList<>();
        for (TipoPokemon tipo : tipos) {
            for (Pokemon pokemon : pokemons) {
                if(pokemon.getTipos().contains(tipo)){
                    pokemonConTipos.add(pokemon);
                }
            }
        }return pokemonConTipos;
    }

    public List<Pokemon> obtenerPokemonConTiposStream(List<Pokemon> pokemons,List<TipoPokemon> tipos){
        return pokemons.stream().filter(pok -> pok.getTipos().equals(tipos)).collect(Collectors.toList());
    }

    public Map<TipoPokemon, List<Pokemon>> obtenerPokemonPurosPorTipo(List<Pokemon> pokemons){
        Map<TipoPokemon, List<Pokemon>> pokemonPorTipo = new HashMap<>();
        for (Pokemon pokemon : pokemons) {

            if(pokemon.getTipos().size() ==1){

                if(pokemonPorTipo.containsKey(pokemon.getTipos().get(0))){
                    pokemonPorTipo.get(pokemon.getTipos().get(0)).add(pokemon);
                }else{
                    List<Pokemon> ListaPokemon = new ArrayList<>();
                    ListaPokemon.add(pokemon);
                    pokemonPorTipo.put(pokemon.getTipos().get(0), ListaPokemon);
                }

            }


        }return pokemonPorTipo;
    }


}
