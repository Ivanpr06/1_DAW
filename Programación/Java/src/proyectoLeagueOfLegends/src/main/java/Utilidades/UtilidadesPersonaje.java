package Utilidades;

import Modelos.Personaje;
import Modelos.RegionPersonaje;

import javax.swing.plaf.synth.Region;
import java.util.*;

public class UtilidadesPersonaje {

    public Personaje levelUp(Personaje personaje){
        Personaje personajeActual = new Personaje();
        int nivel = personaje.getNivel();


        personajeActual.setNivel(personaje.getNivel()+1);
        personajeActual.setAtaqueBase(personaje.getAtaqueBase() + personaje.getEscalabilidad().getIncrementodaDanyoNivel() * nivel);
        personajeActual.setDefensaBase(personaje.getDefensaBase() + personaje.getEscalabilidad().getIncrementoDefensaNivel() * nivel);
        personajeActual.setVidaBase(personaje.getVidaBase() + personaje.getEscalabilidad().getIncrementoSaludNivel() * nivel);
        personajeActual.setMana(personaje.getMana() + personaje.getEscalabilidad().getIncrementoManaNivel() * nivel);
        return personajeActual;
    }

    public Personaje levelUp18(Personaje personaje){
        Personaje personajeActual = new Personaje();

        personajeActual.setNivel(personaje.getNivel()+18);
        personajeActual.setAtaqueBase(personaje.getAtaqueBase() + personaje.getEscalabilidad().getIncrementodaDanyoNivel() * 18);
        personajeActual.setDefensaBase(personaje.getDefensaBase() + personaje.getEscalabilidad().getIncrementoDefensaNivel() * 18);
        personajeActual.setVidaBase(personaje.getVidaBase() + personaje.getEscalabilidad().getIncrementoSaludNivel() * 18);
        personajeActual.setMana(personaje.getMana() + personaje.getEscalabilidad().getIncrementoManaNivel() * 18);
        return personajeActual;
    }

    public Map<RegionPersonaje, List<Personaje>> getPersonajesPorRegion(List<Personaje> personajes){
        Map<RegionPersonaje, List<Personaje>> personajesPorRegion = new HashMap<>();
        for(Personaje personaje : personajes) {
            if(personajesPorRegion.containsValue(personaje.getRegionPersonaje())){
                personajesPorRegion.get(personaje.getRegionPersonaje()).add(personaje);
            }else{
                List<Personaje> lista = new ArrayList<>();
                lista.add(personaje);
                personajesPorRegion.put(personaje.getRegionPersonaje(), lista);
            }
        }return personajesPorRegion;
    }

    public Personaje getMasPoderoso(List<Personaje> personaje){
        List<Personaje> list = new ArrayList<>();
        for(Personaje per: personaje){
            per.setAtaqueBase(per.getAtaqueBase() + per.getEscalabilidad().getIncrementodaDanyoNivel() * 18);
            per.setDefensaBase(per.getDefensaBase() + per.getEscalabilidad().getIncrementoDefensaNivel() * 18);
            per.setVidaBase(per.getVidaBase() + per.getEscalabilidad().getIncrementoSaludNivel() * 18);
            per.setMana(per.getMana() + per.getEscalabilidad().getIncrementoManaNivel() * 18);
            list.add(per);
            }
        list.sort(Comparator.comparing(p -> p.getAtaqueBase() + p.getDefensaBase() + p.getVidaBase() + p.getMana()));
        return list.getFirst();
    }

    public Map<RegionPersonaje, Personaje> getMasPoderosoPorRegion(List<Personaje> personajes){
        Map<RegionPersonaje, List<Personaje>> personajesPorRegion = getPersonajesPorRegion(personajes);
        Map<RegionPersonaje, Personaje> regionPersonajesMasPoderoso = new HashMap<>();
        for(RegionPersonaje regionPersonaje : personajesPorRegion.keySet()) {
            regionPersonajesMasPoderoso.put(regionPersonaje, getMasPoderoso(personajesPorRegion.get(regionPersonaje)));
        }

        return regionPersonajesMasPoderoso;
    }

}
