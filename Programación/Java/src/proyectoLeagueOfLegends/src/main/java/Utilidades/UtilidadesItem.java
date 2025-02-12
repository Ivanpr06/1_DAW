package Utilidades;

import Modelos.Item;
import Modelos.Personaje;

import java.util.List;

public class UtilidadesItem {

    public void equiparItem(Personaje personaje, Item item){
        List<Item> itemsPersonaje = personaje.getEquipamiento();
        itemsPersonaje.add(item);
        personaje.setEquipamiento(itemsPersonaje);

        personaje.setAtaqueBase(personaje.getAtaqueBase() + item.getAumentoDanyo());
        personaje.setDefensaBase(personaje.getDefensaBase() + item.getAumentoDefensa());
        personaje.setVidaBase(personaje.getVidaBase() + item.getAumentoSalud());
        personaje.setMana(personaje.getMana() + item.getAumentoMana());

    }

}
