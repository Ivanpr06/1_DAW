package Utilidades;

import Modelos.Habilidad;
import Modelos.Item;
import Modelos.Personaje;
import Utilidades.UtilidadesPersonaje;
import Utilidades.UtilidadesItem;

public class UtilidadesHabilidad {

    public void golpearConHabilidad(Personaje emisor, Personaje receptor, Habilidad habilidadEmisor){
        UtilidadesPersonaje uP = new UtilidadesPersonaje();
        UtilidadesItem uI = new UtilidadesItem();

        uP.levelUp18(emisor);
        uP.levelUp18(receptor);

        if(!emisor.getEquipamiento().isEmpty() && emisor.getEquipamiento() != null){
            for(Item item : emisor.getEquipamiento()){
                uI.equiparItem(emisor, item);
            }
        }

        if(!receptor.getEquipamiento().isEmpty() && receptor.getEquipamiento() != null){
            for(Item item : receptor.getEquipamiento()){
                uI.equiparItem(receptor, item);
            }
        }

        Double danyo_habilidad_total = habilidadEmisor.getDanyoBase() + ( 0.2 * emisor.getAtaque()) - (0.1 - receptor.getDefensa());
        emisor.setMana(emisor.getMana() - habilidadEmisor.getCosteMana());
        receptor.setVida(receptor.getVida() - danyo_habilidad_total);
    }
}
