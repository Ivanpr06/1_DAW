package Utilidades;

import Modelos.Almacen;
import Modelos.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesAlmacen {
    public boolean validarAlmacenes(List<Producto> productos){
        Map<Almacen, Integer> mapa = new HashMap<>();
        for(Producto producto: productos){
            if(mapa.containsKey(producto.getAlmacen())){
                mapa.put(producto.getAlmacen(), mapa.get(producto.getAlmacen()) + 1);
            }else{
                mapa.put(producto.getAlmacen(), 1);
            }
        }
        Boolean validar = false;
        for(Almacen almacen : mapa.keySet()){
        if (almacen.getCapacidad()> mapa.get(almacen)){
            validar = true;
        } else {
            validar = false;
        }
    }return validar;

    }
}
