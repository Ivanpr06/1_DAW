package Utilidades;

import Modelos.Empleado;
import Modelos.Empresa;
import Modelos.TipoContrato;
import Modelos.TipoEmpresa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesEmpleado {

    public Map<String, List<Empleado>> getEmpleadosPorLetraDNI(List<Empleado> empleados){
        Map<String, List<Empleado>> empleadosPorLetraDNI = new HashMap<>();

        for (Empleado empleado : empleados){
            if(empleadosPorLetraDNI.containsKey(empleado.getDni().substring(8))){
                empleadosPorLetraDNI.get(empleado.getDni()).add(empleado);
            }else{
                List<Empleado> empleadoList = new ArrayList<>();
                empleadoList.add(empleado);
                empleadosPorLetraDNI.put(empleado.getDni().substring(8),empleadoList);
            }
        }return empleadosPorLetraDNI;
    }

    public Map<Empresa, List<Empleado>> getEmpleadosPorEmpresa(List<Empleado> empleados){
        Map<Empresa, List<Empleado>> empleadosPorEmpresa = new HashMap<>();

        for (Empleado empleado : empleados){
            if(empleadosPorEmpresa.containsKey(empleado.getEmpresa())){
                empleadosPorEmpresa.get(empleado.getEmpresa()).add(empleado);
            }else{
                List<Empleado> empleadoList = new ArrayList<>();
                empleadoList.add(empleado);
                empleadosPorEmpresa.put(empleado.getEmpresa(),empleadoList);
            }
        }return empleadosPorEmpresa;
    }

    public Map<TipoEmpresa, Integer> getNumEmpresasPorTipo(List<Empresa> empresas){
        Map<TipoEmpresa, Integer> numEmpresasPorTipo = new HashMap<>();
        for (Empresa empresa : empresas){
            if(numEmpresasPorTipo.containsKey(empresa.getTipoEmpresa())){
                numEmpresasPorTipo.put(empresa.getTipoEmpresa(), numEmpresasPorTipo.get(empresa.getTipoEmpresa()) + 1);
            }else{
                numEmpresasPorTipo.put(empresa.getTipoEmpresa(),1);
            }
        }return numEmpresasPorTipo;
    }

    public Map<TipoEmpresa,Integer> getNumEmpleadosPorTipoEmpresa(List<Empresa> empresas){
        Map<TipoEmpresa,Integer> numEmpresasPorTipo = new HashMap<>();
        for (Empresa empresa : empresas){
            if(numEmpresasPorTipo.containsKey(empresa.getTipoEmpresa())){
                numEmpresasPorTipo.put(empresa.getTipoEmpresa(), empresa.getEmpleados().size());
            }else{
                numEmpresasPorTipo.put(empresa.getTipoEmpresa(), empresas.size());
            }
        }return numEmpresasPorTipo;
    }

    public Map<TipoContrato, List<Empleado>> getEmpleadosPorTipoContrato(Empresa empresas){
        Map <TipoContrato, List<Empleado>> empleadosPorTipoContrato = new HashMap<>();
        for (Empleado empleado : empresas.getEmpleados()){
            if(empleadosPorTipoContrato.containsKey(empleado.getContrato().getTipoContrato())){
                empleadosPorTipoContrato.get(empleado.getContrato().getTipoContrato()).add(empleado);
            }else{
                List<Empleado> empleadoList = new ArrayList<>();
                empleadoList.add(empleado);
                empleadosPorTipoContrato.put(empleado.getContrato().getTipoContrato(), empleadoList);
            }

        }return empleadosPorTipoContrato;
    }

    public Map<Empresa, Map<TipoContrato, List<Empleado>>> getEmpleadosPorTipoContrato(List<Empresa> empresas){
        Map <Empresa, Map<TipoContrato, List<Empleado>>> empleadosPorTipoContrato = new HashMap<>();
        for (Empresa empresa : empresas){
            empleadosPorTipoContrato.put(empresa, getEmpleadosPorTipoContrato(empresa));
        }return empleadosPorTipoContrato;
    }

}
