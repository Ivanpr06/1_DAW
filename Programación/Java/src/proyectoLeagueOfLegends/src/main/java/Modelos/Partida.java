package Modelos;

import com.sun.jdi.IntegerType;
import com.sun.jdi.IntegerValue;
import com.sun.jdi.connect.Connector;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Partida {

    private Integer id;
    private String codigo;
    private Double server;
    private Map<Jugador,Personaje> eleccciones;
    private Map<Integer, Set<Jugador>> jugadoresPorEquipo;
    private LocalDateTime inicioPartida;
    private LocalDateTime finPartida;
    private Integer duracionPartida;
    private Integer equipoVencedor;

    public Partida() {
    }

    public Partida(Integer id, String codigo, Double server, Map<Jugador, Personaje> eleccciones, Map<Integer, Set<Jugador>> jugadoresPorEquipo, LocalDateTime inicioPartida, LocalDateTime finPartida, Integer duracionPartida, Integer equipoVencedor) {
        this.id = id;
        this.codigo = codigo;
        this.server = server;
        this.eleccciones = eleccciones;
        this.jugadoresPorEquipo = jugadoresPorEquipo;
        this.inicioPartida = inicioPartida;
        this.finPartida = finPartida;
        this.duracionPartida = duracionPartida;
        this.equipoVencedor = equipoVencedor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getServer() {
        return server;
    }

    public void setServer(Double server) {
        this.server = server;
    }

    public Map<Jugador, Personaje> getEleccciones() {
        return eleccciones;
    }

    public void setEleccciones(Map<Jugador, Personaje> eleccciones) {
        this.eleccciones = eleccciones;
    }

    public Map<Integer, Set<Jugador>> getJugadoresPorEquipo() {
        return jugadoresPorEquipo;
    }

    public void setJugadoresPorEquipo(Map<Integer, Set<Jugador>> jugadoresPorEquipo) {
        this.jugadoresPorEquipo = jugadoresPorEquipo;
    }

    public LocalDateTime getInicioPartida() {
        return inicioPartida;
    }

    public void setInicioPartida(LocalDateTime inicioPartida) {
        this.inicioPartida = inicioPartida;
    }

    public LocalDateTime getFinPartida() {
        return finPartida;
    }

    public void setFinPartida(LocalDateTime finPartida) {
        this.finPartida = finPartida;
    }

    public Integer getDuracionPartida() {
        return duracionPartida;
    }

    public void setDuracionPartida(Integer duracionPartida) {
        this.duracionPartida = duracionPartida;
    }

    public Integer getEquipoVencedor() {
        return equipoVencedor;
    }

    public void setEquipoVencedor(Integer equipoVencedor) {
        this.equipoVencedor = equipoVencedor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Partida partida = (Partida) o;
        return Objects.equals(id, partida.id) && Objects.equals(codigo, partida.codigo) && Objects.equals(server, partida.server) && Objects.equals(eleccciones, partida.eleccciones) && Objects.equals(jugadoresPorEquipo, partida.jugadoresPorEquipo) && Objects.equals(inicioPartida, partida.inicioPartida) && Objects.equals(finPartida, partida.finPartida) && Objects.equals(duracionPartida, partida.duracionPartida) && Objects.equals(equipoVencedor, partida.equipoVencedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, server, eleccciones, jugadoresPorEquipo, inicioPartida, finPartida, duracionPartida, equipoVencedor);
    }

    @Override
    public String toString() {
        return "Partida{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", server=" + server +
                ", eleccciones=" + eleccciones +
                ", jugadoresPorEquipo=" + jugadoresPorEquipo +
                ", inicioPartida=" + inicioPartida +
                ", finPartida=" + finPartida +
                ", duracionPartida=" + duracionPartida +
                ", equipoVencedor=" + equipoVencedor +
                '}';
    }
}
