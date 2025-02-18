package Interfaz;

import Modelos.Jugador;
import Modelos.Partida;
import Modelos.Personaje;

import java.util.List;

public interface IUtilidadesPartida {

    public void inicializarPartida(Partida partida, List<Jugador> participantes, List<Personaje> personajesDisponibles);

    public void finalizarPartida(Partida partida, Integer equipoVencedor);

}