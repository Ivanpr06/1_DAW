package utilidades;

import modelos.*;

import java.util.*;
import java.util.stream.Collectors;

public class UtilidadesF1 {

    public UtilidadesF1() {
    }





    /**
     * Devuelve la lista de pilotos cuya escudería tiene la marca que se pasa como parámetro.
     *
     * @param pilotos
     * @param marca
     * @return
     */
    public static List<Piloto> getPilotosPorMarcaEscuderia(List<Piloto> pilotos, Marca marca){
        List<Piloto> pilotosPorMarca = new ArrayList<>();
            for(Piloto p: pilotos){
                if(p.getEscuderia().getMarca().equals(marca)){
                    pilotosPorMarca.add(p);
                }
            }
            return pilotosPorMarca;
    }


    /**
     * Devuelve los pilotos agrupados por escudería
     *
     * @param pilotos
     * @return
     */
    public static Map<Escuderia, List<Piloto>>  pilotosPorEscuderia(List<Piloto> pilotos){
        Map<Escuderia, List<Piloto>> escuderia = new HashMap<>();
        for(Piloto piloto: pilotos){
            if(escuderia.containsKey(piloto.getEscuderia())){
                escuderia.get(piloto.getEscuderia()).add(piloto);
            }else{
                List<Piloto> listaPilotos = new ArrayList<>();
                listaPilotos.add(piloto);
                escuderia.put(piloto.getEscuderia(), listaPilotos);
            }
        }return escuderia;
    }


    /**
     * Devuelvo los coches cuya suma de puntuacion -> (velocidadPunta + aceleracion - tiempoMedioParadaBoxes - probabilidadAveria )
     * es mayor a la que se pasa , ORDENADOR POR PUNTUACIÓN DE MAYOR A MENOR
     *
     * @param coches
     * @param minimoPuntuacionRequerida
     * @return
     */
    public static List<Coche> topMejoresCoches(List<Coche> coches, Double minimoPuntuacionRequerida){
          List<Coche> topMejoresCoches = new ArrayList<>();
            for(Coche coche: coches){
                if(coche.puntuacionCoche() > minimoPuntuacionRequerida){
                    topMejoresCoches.add(coche);
                }
                // sort ordena de menor a mayor
            topMejoresCoches.sort(Comparator.comparing(Coche::puntuacionCoche).reversed());
            }
          return topMejoresCoches;
    }

    /**
     * Devuelve el porcentaje de victoria de un piloto , que se calcula con la siguiente fórmula:
     *
     * -> puntuación total coche del su escuderia  (velocidadPunta + aceleracion - tiempoMedioParadaBoxes - probabilidadAveria)
     * -> +
     * -> puntosRanking de su escuderia
     * -> +
     * -> puntosRanking piloto
     *
     * @param piloto
     * @return
     */
    public static Double porcentajeVictoriaPiloto(Piloto piloto){
        Double porcentajeVictoriaPiloto = piloto.getEscuderia().getCoche().puntuacionCoche() + piloto.getEscuderia().getPuntosRanking() + piloto.getPuntosRanking();

        return porcentajeVictoriaPiloto;
    }


    /**
     * Devuelve el piloto con mayor porcentaje de victoria de los dos que se pasa,
     * el porcentaje de victoria se calcula del ejercicio anterior.
     *
     */
     public static Piloto getMejorPiloto(Piloto piloto1, Piloto piloto2){
            if(porcentajeVictoriaPiloto(piloto1) > porcentajeVictoriaPiloto(piloto2)){
                return piloto1;
            }else{
                return piloto2;
            }
    }


    /**
     * Devuelve el mapa de las posiciones obtenidas por las escuderías del ranking de la temporada que se pasa como parámetro,
     * teniendo en cuenta que sólo hay un ranking por temporada.
     *
     * Las claves del mapa son el orden obtenido de mayor a menor , tras ordenar las temporadas del ranking por su "posicionEnRanking"
     *
     * @param rankingEscuderias
     * @param temporada
     * @return
     */
    public static Map<Integer,Escuderia> getRankigPorEscuderias(List<RankingEscuderias> rankingEscuderias, Integer temporada){
            Map<Integer,Escuderia> rankigPorEscuderias = new HashMap<>();
            for(RankingEscuderias ranking: rankingEscuderias){
                if(ranking.getTemporada().equals(temporada)){
                    for(Escuderia escuderia: ranking.getEscuderias()){
                        rankigPorEscuderias.put(escuderia.getPosicionEnRanking(), escuderia);
                    }
                }
            } return rankigPorEscuderias;
    }

    /**
     * Devuelve un mapa de los pilotos con la suma de puntos que tengan de las carreras que se pasa como parámetro.
     * Los puntos se obtienen sacando la posición en la que queda el piloto del mapa de "posiciones" y de los puntos
     * que correspondan a esa posición en el mapa "puntosPorPosicion"
     *
     * @param carreras
     * @return
     */
    public static Map<Piloto, Double> totalPuntuacion(List<Carrera> carreras){
        Map<Piloto,Double> puntos = new HashMap<>();
            for(Carrera carrera: carreras){
                for(Integer posicion: carrera.getPosiciones().keySet()){
                    puntos.put(carrera.getPosiciones().get(posicion), carrera.getPuntosPorPosicion().get(posicion));
                }
            }
        return puntos;
        
    }

}
