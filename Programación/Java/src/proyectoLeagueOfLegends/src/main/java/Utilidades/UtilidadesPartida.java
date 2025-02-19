package Utilidades;

import Modelos.Jugador;
import Modelos.Partida;
import Modelos.Personaje;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class UtilidadesPartida {

    public void inicializarPartida(Partida partida, List<Jugador> participantes, List<Personaje> personajesDisponibles){
        Collections.shuffle(personajesDisponibles);

       Map<Jugador, Personaje> elecciones = new HashMap<>();
       for (Jugador jugador : participantes) {
           for (Personaje personaje : personajesDisponibles) {
               if(jugador.getPersonajesFavoritos().contains(personaje)){
                   elecciones.put(jugador, personaje);
                   personajesDisponibles.remove(personaje);
               }else{
                    elecciones.put(jugador, personajesDisponibles.get(0));
                    personajesDisponibles.remove(0);
               }
           }
       }
       Map<Integer, Set<Jugador>> jugadoresPorEquipo = new HashMap<>();
       Integer contador = 0;
       Set<Jugador> equipo1 = new HashSet<>();
       Set<Jugador> equipo2 = new HashSet<>();
        if(participantes.size() % 2 == 0) {
           for (Jugador jugador : participantes) {
                if(contador % 2 == 0){
                    equipo1.add(jugador);
                    contador++;
                }else{
                    equipo2.add(jugador);
                    contador++;
                }
           }
       }
        jugadoresPorEquipo.put(1, equipo1);
        jugadoresPorEquipo.put(2, equipo2);

        partida.setInicioPartida(LocalDateTime.now());
    }

    public void finalizarPartida(Partida partida, Integer equipoVencedor){
        partida.setFinPartida(LocalDateTime.now());
        partida.setDuracionPartida((int)Duration.between(partida.getFinPartida(), partida.getInicioPartida()).getSeconds());
        partida.setEquipoVencedor(equipoVencedor);

        Set<Jugador>jugadoresGanadores = partida.getJugadoresPorEquipo().get(equipoVencedor);
        for(Jugador jugador : jugadoresGanadores){
                Personaje vencedor = partida.getEleccciones().get(jugador);
                if(jugador.getPartidasGanadas().containsKey(vencedor)){
                    jugador.getPartidasGanadas().put(vencedor, jugador.getPartidasGanadas().get(vencedor) + 1);
                }else{
                    jugador.getPartidasGanadas().put(vencedor, 1);
                }
        }
    }

}

