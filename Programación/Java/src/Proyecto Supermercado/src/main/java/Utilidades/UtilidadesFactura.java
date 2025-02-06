package Utilidades;

import Modelos.Factura;
import Modelos.LineaFactura;

import java.time.LocalDate;

public class UtilidadesFactura {

    public boolean esFacturaVencida(Factura factura){
       if(factura.getFechaVencimiento().equals(LocalDate.now()) || factura.getFechaVencimiento().isAfter(LocalDate.now())){
           return true;
        }else{
           return false;
        }
    }

    public double calcularBaseFactura(Factura factura){
        double base_importe = 0.00;
        for(LineaFactura producto: factura.getLineaFactura()){
            Double precio =  producto.getProducto().getPrecio();
            Integer cantidad = producto.getCantidad();
            base_importe += precio*cantidad;
        }
        return base_importe;
    }

    public double  calcularTotalAPagar(Factura factura){
        double totalAPagar = (factura.getImporteBase() - factura.getDescuento()) * factura.getIva();
        return totalAPagar;
    }
}
