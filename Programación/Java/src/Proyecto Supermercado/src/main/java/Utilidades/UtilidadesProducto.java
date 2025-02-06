package Utilidades;

import Modelos.Almacen;
import Modelos.LineaFactura;
import Modelos.Producto;
import Modelos.TipoProducto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UtilidadesProducto {

    public List<Producto> getPorTipo(List<Producto> productos, TipoProducto tipo) {
        List<Producto> lista = new ArrayList<>();
        for(Producto producto: productos){
            if(producto.getTipoProducto() == tipo){
                lista.add(producto);
            }
        }return lista;
    }

    public List<Producto> getPorAlmacen(List<Producto> productos, Almacen almacen){
        List<Producto> lista = new ArrayList<>();
        for(Producto producto: productos){
            if(producto.getAlmacen() == almacen){
                lista.add(producto);
            }
        }return lista;
    }
}

