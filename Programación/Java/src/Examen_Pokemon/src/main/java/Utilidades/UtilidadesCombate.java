package Utilidades;

import Modelos.Entrenador;
import Modelos.LineaEvolutiva;
import Modelos.Pokemon;
import Modelos.TipoPokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesCombate {

    public Map<Entrenador, Integer> repartirPokemon(List<Entrenador> entrenadores, List<Pokemon> pokemon){

        Map<Entrenador, Integer> puntosEntrenadores = new HashMap<>();

        if(pokemon.size() % entrenadores.size() == 0){
            int pokemonporEntrenador = pokemon.size() / entrenadores.size();

            for(Entrenador entrenador : entrenadores){
                while(entrenador.getEquipoPokemon().size() != 2){
                    entrenador.getEquipoPokemon().add(pokemon.get(0));
                    pokemon.remove(pokemon.get(0));
                }
            }
            for(Entrenador entrenador : entrenadores){
                List<TipoPokemon> favorito = new ArrayList<>(entrenador.getTiposPreferidos());
                int puntos = 0;
                for(Pokemon pok : entrenador.getEquipoPokemon()){
                    List<TipoPokemon> tiposQCoinciden  = new ArrayList<>(pok.getTipos());
                    tiposQCoinciden.retainAll(favorito);
                    puntos += tiposQCoinciden.size();

                }
            puntosEntrenadores.put(entrenador, puntos);
            }


        }return puntosEntrenadores;
    }

    public void subirAlNivel(Pokemon pokemon, Integer nivel){
        Pokemon pokemon_prueba = new Pokemon();

        pokemon_prueba.getStats().setPs(pokemon.getStats().getPs()+(nivel * 2));
        pokemon_prueba.getStats().setAt(pokemon.getStats().getAt()+nivel*2);
        pokemon_prueba.getStats().setDf(pokemon.getStats().getDf()+nivel*2);
        pokemon.getStats().setSpa(pokemon.getStats().getSpa()+nivel*2);
        pokemon_prueba.getStats().setSpdf(pokemon.getStats().getSpdf()+nivel*2);
        pokemon_prueba.getStats().setSpd(pokemon.getStats().getSpd()+nivel*2);

    }

    public boolean puedeEvolucionar(Pokemon pokemon){
        Boolean puede_evolucionar = false;
        Integer nivel = pokemon.getNivel();

        Integer posicion = pokemon.getLineaEvolutiva()
                .stream()
                .filter(pok -> pok.getPokemon().getLineaEvolutiva().equals(pokemon.getLineaEvolutiva()))
                .findFirst().get().getOrden();

        LineaEvolutiva ordenEvolucion = pokemon.getLineaEvolutiva()
                .stream()
                .filter(pok -> pok.getOrden().equals(posicion+1))
                .findFirst().orElse(null);

        if(ordenEvolucion != null){
            if(nivel >= ordenEvolucion.getNivelParaEvolucionar()){
                puede_evolucionar = true;
            }
        }
        return puede_evolucionar;
    }

}
