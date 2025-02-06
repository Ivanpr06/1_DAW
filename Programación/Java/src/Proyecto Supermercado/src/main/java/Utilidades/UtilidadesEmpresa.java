package Utilidades;

import Modelos.*;

import java.time.LocalDate;
import java.util.*;


public class UtilidadesEmpresa {

    public List<Empleado> getEmpleadosPorContrato(Empresa empresa, TipoContrato tipoContrato) {

        List <Empleado> empleados_lista = new ArrayList<>();

        for (Empleado empleado : empresa.getEmpleados()) {
            if (empleado.getContrato().getTipoContrato().equals(tipoContrato)){
                empleados_lista.add(empleado);
            }
        }
        return empleados_lista;
    }

    public List<Empleado> getMileuristasOrdenadosPorSalario(Empresa empresa){
        List <Empleado> empleados_lista  = new ArrayList<Empleado>();
        for (Empleado empleado: empresa.getEmpleados()){
            if (empleado.getContrato().getSalarioBase() >= 1000){
                empleados_lista.add(empleado);
            }
        }
        // Ordena una lista
        empleados_lista.sort(Comparator.comparing(lista->lista.getContrato().getSalarioBase()));
        // Mayor a menor
        empleados_lista.reversed();
        return empleados_lista;
    }

    public double fondoSalarialEmpresa(Empresa empresa){
        Double totalSalario = 0.0;
        for (Empleado empleado : empresa.getEmpleados()){
            Double suma = empleado.getContrato().getSalarioBase();
            totalSalario += suma;
        }return totalSalario;
    }

    public Empleado getMejorPagado(List<Empresa> empresas){
        Empleado elqueMasCobra = null;
        Double salarioDelQueMasCobra = 0.0;
        for (Empresa empresa: empresas){
            for (Empleado empleado: empresa.getEmpleados()){
                if (empleado.getContrato().getSalarioBase() > salarioDelQueMasCobra){
                    salarioDelQueMasCobra = empleado.getContrato().getSalarioBase();
                    elqueMasCobra = empleado;
                }
            }
        }
        return elqueMasCobra;
    }

    public List<Empleado> getEmpleadosPymePracticas(List<Empresa> empresas){
        List <Empleado> empleados_lista = new ArrayList<>();
        for (Empresa empresa: empresas){
            if(empresa.getTipoEmpresa().equals(TipoEmpresa.PYME)){
                for (Empleado empleado: empresa.getEmpleados()){
                    if(empleado.getContrato().getTipoContrato().equals(TipoContrato.PRACTICAS)){
                        empleados_lista.add(empleado);
                    }
                }

            }
        }return empleados_lista;
    }

    public Map<Empresa,Empleado> getLosMejorPagadosPorEmpresa(List<Empresa> empresas){
        Map<Empresa,Empleado> losMejorPagados = new HashMap<>();
        for (Empresa empresa: empresas){
            losMejorPagados.put(empresa, getMileuristasOrdenadosPorSalario(empresa).getFirst());

        }return losMejorPagados;
    }

    public Double gastoTotalCliente(List<Factura> facturas, Cliente cliente){
            double importe = 0.0;
            for (Factura factura: facturas){
                if(factura.getCliente().equals(cliente)){
                    importe = importe + factura.getImporteBase();
                }

            }return importe;
    }

    public Double totalFacturadoPeriodo(List<Factura> facturas, LocalDate fechaInicio, LocalDate fechaFin){
        double importe = 0.0;
        for (Factura factura: facturas){
            if(factura.getFechaEmision().isAfter(fechaInicio) && factura.getFechaEmision().isBefore(fechaFin)){
                importe = importe + factura.getImporteBase();
            }
        }return importe;

    }

    public Empleado contratarTrabajador(Empresa e, String dni, String nombre, String apellidos, String direccion, String telefono, TipoContrato tipo, Double salario){
        Cliente cliente = new Cliente();
        cliente.setDni(dni);
        cliente.setNombre(nombre);
        cliente.setApellidos(apellidos);
        cliente.setDireccion(direccion);

        Empleado empleado = new Empleado();
        empleado.setNumTelefono(telefono);

    }



}
