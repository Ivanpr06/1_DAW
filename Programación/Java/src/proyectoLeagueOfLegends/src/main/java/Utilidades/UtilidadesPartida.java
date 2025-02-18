package Utilidades;

import Modelos.Jugador;
import Modelos.Partida;
import Modelos.Personaje;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
       Map<Equipo,Jugador> jugadoresPorEquipo = new HashMap<>();
    }

    public void finalizarPartida(Partida partida, Integer equipoVencedor){

    }

}

