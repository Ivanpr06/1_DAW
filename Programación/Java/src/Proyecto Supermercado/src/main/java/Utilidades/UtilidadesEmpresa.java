package Utilidades;

import Modelos.Empleado;
import Modelos.Empresa;
import Modelos.TipoContrato;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


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

}
