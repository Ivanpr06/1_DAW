package com.sl.utilidades;

import com.sl.modelos.*;

import java.util.*;
import java.util.stream.Collectors;

public class UtilidadesGeografia {



    public static List<Pais> ejercicio1(List<Pais> paises) {
        ArrayList<Pais> lista_paises = new ArrayList<>();
        for(Pais pais : paises){
            if(!pais.getPaisesVecinos().isEmpty() && pais.getComunidadesAutonomas().size() > 2){
                lista_paises.add(pais);
            }
        }
        return lista_paises;
    }


    public static Map<Continente, Integer> ejercicio2(List<Continente> continentes) {
        Map<Continente, Integer> mapaContinente = new HashMap<>();
        for(Continente continente : continentes){
            for(Pais pais: continente.getPaises()){
                if(continente.getPaises().contains(pais)){
                    mapaContinente.put(continente, continente.getPaises().size());
                }else{
                    mapaContinente.put(continente, 0);
                }
            }
        }
        return mapaContinente;
    }

    public List<Ciudad> ejercicio3(List<Ciudad> ciudades, List<Pais> paises) {
        List<Ciudad> listaCapitales = new ArrayList<>();
        for(Pais pais : paises){
            if(pais.getCapital() != null && listaCapitales.size() < 1){
                listaCapitales.add(pais.getCapital());
            }
        }
        return listaCapitales;
    }


    public static Map<Pais, Long> ejercicio4(List<Pais> paises) {
        Map<Pais, Long> mapaPoblacion = new HashMap<>();
        for(Pais pais : paises){
            long poblacion = 0;
            List<ComunidadAutonoma> comunidades = pais.getComunidadesAutonomas();
            for(ComunidadAutonoma comunidadAutonoma : comunidades){
                poblacion += comunidadAutonoma.getCiudades().get(0).getPoblacion();
            }
            mapaPoblacion.put(pais, poblacion);
        }
        return mapaPoblacion;
    }



    public static boolean ejercicio5(InformePais informePais, Pais pais) {
        int contador = 0;
        if(informePais.getPais().equals(pais)){
            contador += 1;
        }

        long poblacion = 0;
        List<ComunidadAutonoma> comunidades = pais.getComunidadesAutonomas();
        for(ComunidadAutonoma comunidadAutonoma : comunidades){
            poblacion += comunidadAutonoma.getCiudades().get(0).getPoblacion();
        }

        if(informePais.getTotalHabitantesPais() == poblacion){
            contador += 1;
        }

        if(informePais.getTotalComunidadesAutonomasPais() == pais.getComunidadesAutonomas().size()){
            contador += 1;
        }
        int contador2 = 0;
        for(ComunidadAutonoma comunidadAutonoma : comunidades){
            contador2 += comunidadAutonoma.getCiudades().size();
        }
        if(informePais.getTotalCiudadesPais() == contador2){
            contador += 1;
        }

        if(contador == 4){
            return true;
        }else{
            return false;
        }
    }



    public static InformeDetalladoPais ejercicio6(Pais pais) {
        InformeDetalladoPais informeDetalladoPais = new InformeDetalladoPais();
        Map<List<ComunidadAutonoma>, Long> extensionComunidades = new HashMap<>();
        long extension = 0;
        for(ComunidadAutonoma comunidadAutonoma : pais.getComunidadesAutonomas()){
            extension += comunidadAutonoma.getCiudades().get(0).getExtension();
        }
        extensionComunidades.put(pais.getComunidadesAutonomas(),extension);

        Map<List<ComunidadAutonoma>, Long> poblacionComunidades = new HashMap<>();
        long poblacion = 0;
        for(ComunidadAutonoma comunidadAutonoma : pais.getComunidadesAutonomas()){
            poblacion += comunidadAutonoma.getCiudades().get(0).getPoblacion();
        }
        poblacionComunidades.put(pais.getComunidadesAutonomas(),poblacion);

        List<ComunidadAutonoma> comunidadaMasGrande = new ArrayList<>();
        long extensionmax = 0;
        for(ComunidadAutonoma comunidadAutonoma : pais.getComunidadesAutonomas()){
           if(comunidadAutonoma.getCiudades().get(0).getExtension() > extensionmax){
               comunidadaMasGrande.add(comunidadAutonoma);
               extensionmax = comunidadAutonoma.getCiudades().get(0).getExtension();
           }
        }

        List<ComunidadAutonoma> comunidadMasPoblada = new ArrayList<>();
        long poblacionmax = 0;
        for(ComunidadAutonoma comunidadAutonoma : pais.getComunidadesAutonomas()){
            if(comunidadAutonoma.getCiudades().get(0).getExtension() > poblacionmax){
                comunidadMasPoblada.add(comunidadAutonoma);
                poblacionmax = comunidadAutonoma.getCiudades().get(0).getExtension();
            }
        }

        List<ComunidadAutonoma> comunidadCapital = new ArrayList<>();
        for(ComunidadAutonoma comunidadAutonoma : pais.getComunidadesAutonomas()){
            if(comunidadAutonoma.getCapital() != null){
                comunidadCapital.add(comunidadAutonoma);
            }
        }

        return null;
        }
}
