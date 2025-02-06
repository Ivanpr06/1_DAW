import Modelos.*;
import Utilidades.UtilidadesFactura;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static Modelos.TipoCliente.PARTICULAR;
import static Modelos.TipoProducto.ALIMENTACION;

public class Main {

    public static void main(String[] args) {

        Almacen almacen = new Almacen(123456, "prueba", 12);
        Cliente cliente = new Cliente(98754,"123456789T","Manolo", "Gutierrez", "Calle Desconocida",PARTICULAR);
        Producto producto = new Producto(135683, "123456Y","Es muy bueno", LocalDate.of(2024, 12, 5),ALIMENTACION,almacen, 12.00);
        List<LineaFactura> lista = new ArrayList<>();
        //lista.add()
        Factura factura = new Factura(123456789, "736467T", 12.75, 2.5, 1.25, 9.00, LocalDate.of(2024,9,8), LocalDate.of(2027, 9, 8), true,lista,cliente);

        System.out.println(almacen);
        System.out.println(cliente);
        System.out.println(producto);
        System.out.println(factura);

        UtilidadesFactura ej_1 = new UtilidadesFactura();
        System.out.println(ej_1.esFacturaVencida(factura));

        UtilidadesFactura ej_2 = new UtilidadesFactura();
        System.out.println(ej_2.esFacturaVencida(factura));

        UtilidadesFactura ej_3 = new UtilidadesFactura();
        System.out.println(ej_3.calcularTotalAPagar(factura));

    }
}
