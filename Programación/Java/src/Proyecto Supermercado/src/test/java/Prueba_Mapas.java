import Modelos.Almacen;
import Modelos.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Prueba_Mapas {



    public class pruebaMapas {

        public static void main(String[] args) {


            //MAP
            // key -> nombre de ciudad
            // value -> el número de habitantes

            //CREAR MAPA
            Map<String, Integer> poblacionCiudades = new HashMap<>();


            //AÑADIR CLAVES Y VALORES
            poblacionCiudades.put("Sevilla", 600000);
            poblacionCiudades.put("Málaga", 550000);
            poblacionCiudades.put("Córdoba", 400000);
            poblacionCiudades.put("Madrid", 1000000);
            System.out.println(poblacionCiudades);


            //MODIFICAR UNA CLAVE
            poblacionCiudades.put("Cordoba", 420000);
            System.out.println(poblacionCiudades);


            //ELIMINAR UNA CLAVE
            poblacionCiudades.remove("Cordoba");
            System.out.println(poblacionCiudades);

            //CONSULTAR EL VALOR DE UNA CLAVE
            Integer poblacion = poblacionCiudades.get("Sevilla");
            System.out.println("La población de Sevilla es " + poblacion);


            if (poblacionCiudades.containsKey("Santiago")) {
                System.out.println("El mápa contiene la clave buscada");
            }

            if (poblacionCiudades.containsValue(400000)) {
                System.out.println("El mápa contiene el valor buscado");
            }


            Map<Almacen, List<Producto>> productosPorAlmacen = new HashMap<>();


            Almacen almacen1 = new Almacen();
            almacen1.setNombre("Despensa SAFA");

            Producto p1 = new Producto();
            p1.setDescription("Agua 1L");
            p1.setPrecio(0.45);
            p1.setAlmacen(almacen1);
            Producto p2 = new Producto();
            p2.setDescription("Barra de Pan");
            p2.setPrecio(1.40);
            p2.setAlmacen(almacen1);
            Producto p3 = new Producto();
            p3.setDescription("Jamón Serrano");
            p3.setPrecio(60.0);
            p3.setAlmacen(almacen1);

            List<Producto> lista1 = new ArrayList<>();
            lista1.add(p1);
            lista1.add(p2);
            lista1.add(p3);


            Almacen almacen2 = new Almacen();
            almacen2.setNombre("Almacen DAW");

            Producto p4 = new Producto();
            p4.setDescription("Ratones");
            p4.setPrecio(15.0);
            p4.setAlmacen(almacen2);
            Producto p5 = new Producto();
            p5.setDescription("Teclados");
            p5.setPrecio(25.0);
            p5.setAlmacen(almacen2);
            Producto p6 = new Producto();
            p6.setDescription("Pantallas");
            p6.setPrecio(70.0);
            p6.setAlmacen(almacen2);

            List<Producto> lista2 = new ArrayList<>();
            lista2.add(p4);
            lista2.add(p5);
            lista2.add(p6);


            productosPorAlmacen.put(almacen1, lista1);
            productosPorAlmacen.put(almacen2, lista2);
            System.out.println(productosPorAlmacen);


            System.out.println("-----------------------------------------------------");
            System.out.println("");


            //MAPA PRODUCTOS POR ALMACEN y QUIERO QUE ME CUENTES CUANTOS PRODUCTOS HAY EN CADA ALMACEN


            for (Almacen almacen : productosPorAlmacen.keySet()) {


                System.out.println(almacen.toString() + " tiene -> " + productosPorAlmacen.get(almacen).size() + "  productos");

                System.out.println("Y el nombre de los productos es este:");

                for (Producto p : productosPorAlmacen.get(almacen)) {
                    System.out.println(p.getDescription());
                }


            }


            //AVERIGUAR CUAL ES LA MEDIA DE PRODUCTOS POR CADA ALMACEN

            List<Producto> productos = new ArrayList<>();
            productos.add(p1);
            productos.add(p2);
            productos.add(p3);
            productos.add(p4);
            productos.add(p5);
            productos.add(p6);


            Map<Almacen, Double> mediaPrecioAlmacen = new HashMap<>();
            Map<Almacen, Integer> numProductosAlmacen = new HashMap<>();

//        Map<Almacen, List<Producto>>;

            for (Producto p : productos) {

                if (mediaPrecioAlmacen.containsKey(p.getAlmacen())) {
                    mediaPrecioAlmacen.put(p.getAlmacen(), mediaPrecioAlmacen.get(p.getAlmacen()) + p.getPrecio());
                } else {
                    mediaPrecioAlmacen.put(p.getAlmacen(), p.getPrecio());
                }

                if (numProductosAlmacen.containsKey(p.getAlmacen())) {
                    numProductosAlmacen.put(p.getAlmacen(), numProductosAlmacen.get(p.getAlmacen()) + 1);
                } else {
                    numProductosAlmacen.put(p.getAlmacen(), 1);
                }

            }

//        for(Almacen al : mediaPrecioAlmacen.keySet()){
//            mediaPrecioAlmacen.put(al, mediaPrecioAlmacen.get(al) / productosPorAlmacen.get(al));
//
//        }

        }
    }
}
