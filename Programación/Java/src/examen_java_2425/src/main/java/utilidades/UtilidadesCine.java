package utilidades;


import modelos.*;

import java.time.Duration;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesCine {



    public static List<Cine> ejercicio1(List<Cine> cines){
        List<Cine> cine20 = new ArrayList<>();
        for(Cine c : cines) {
            if(c.getSalas().getFirst().getAsientos().size() > 20){
                cine20.add(c);
            }
        }return cine20;
    }

    public static Map<Sala, Integer> ejercicio2(Cine cine){
        Map<Sala, Integer> salasYasientos = new HashMap<>();
        for(Sala sala : cine.getSalas()) {
            salasYasientos.put(sala, sala.getAsientos().size());
        }
        return salasYasientos;
    }


    public static Pelicula ejercicio3(Cine cine){
       double mayorrating = 0.0;
       Pelicula pelicula = new Pelicula();
       for(Proyeccion proy : cine.getSalas().getFirst().getFunciones()){
           if(proy.getPelicula().getRating() > mayorrating){
               mayorrating = proy.getPelicula().getRating();
               pelicula = proy.getPelicula();
           }

       }return pelicula;
    }



    public static Map<Proyeccion,Long> ejercicio4(Sala sala){
        Map<Proyeccion,Long> proyDuracion = new HashMap<>();
        for(Proyeccion proy : sala.getFunciones()) {
            proyDuracion.put(proy, Duration.between(proy.getFechaInicio(), proy.getFechaFin()).toSeconds());
        }

        return proyDuracion;
    }

    public static Double ejercicio5(Cine cine){
        Double ventaEntradas = 0.0;
        for(Sala sala : cine.getSalas()) {
            for(Proyeccion proy : sala.getFunciones()) {
                for(Entrada entrada : proy.getEntradas()) {
                    ventaEntradas += entrada.getPrecio();
                }
            }
        }
        return ventaEntradas;
    }

    public static InformeProyeccion ejercicio6(Proyeccion proyeccion){
        InformeProyeccion informe = new InformeProyeccion();
        informe.setPelicula(proyeccion.getPelicula());

        informe.setAsientosOcupados(proyeccion.getEntradas().size());

        informe.setAsientosDisponibles(proyeccion.getSala().getAsientos().size() - proyeccion.getEntradas().size());

        double ventaEntradas = 0.0;
        for(Entrada entrada : proyeccion.getEntradas()) {
            ventaEntradas += entrada.getPrecio();
        }
        informe.setRecaudacionSala(ventaEntradas);

        informe.setPorcentajeOcupacionSala(informe.getAsientosOcupados().doubleValue() / proyeccion.getSala().getAsientos().size());

        List<Entrada> entradasFrau = new ArrayList<>();
            for(Entrada entrada : proyeccion.getEntradas()) {
                if(!entrada.getAsiento().isDisponible()){
                    entradasFrau.add(entrada);
                }
            }
        informe.setEntradasFraudulentas(entradasFrau);

        Map<Asiento, Boolean> disponible = new HashMap<>();
        for(Asiento as : proyeccion.getSala().getAsientos()){
            for(Entrada entrada : proyeccion.getEntradas()){
                if(!entrada.getAsiento().isDisponible()){
                    disponible.put(as, true);
                }else{
                    disponible.put(as, false);
                }
            }
        }
        informe.setDisponibilidadAsientos(disponible);

        return informe;
    }
}