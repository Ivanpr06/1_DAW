package Utilidades;

import Modelos.Contrato;
import Modelos.Empleado;
import Modelos.TipoContrato;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesContrato {
    public Map<TipoContrato, Integer> getNumContratosPorTipo(List<Contrato> contratos){
        Map<TipoContrato, Integer> numContratosPorTipo = new HashMap<>();

        for (Contrato contrato : contratos){
            if(numContratosPorTipo.containsValue(contrato.getTipoContrato())){
                numContratosPorTipo.put(contrato.getTipoContrato(), numContratosPorTipo.get(contrato.getTipoContrato()) + 1);

            }else{
                numContratosPorTipo.put(contrato.getTipoContrato(), 1);
            }
        }return numContratosPorTipo;
    }

    public Map<TipoContrato, List<Contrato>> getListContratosPorTipo(List<Contrato> contratos){
        Map<TipoContrato, List<Contrato>> listContratosPorTipo = new HashMap<>();

        for (Contrato contrato : contratos){
            if(listContratosPorTipo.containsKey(contrato.getTipoContrato())){
                listContratosPorTipo.get(contrato.getTipoContrato()).add(contrato);
            }else{
                List<Contrato> listContrato = new ArrayList<>();
                listContrato.add(contrato);
                listContratosPorTipo.put(contrato.getTipoContrato(), listContrato);
            }

        }return listContratosPorTipo;
    }

    public Map<TipoContrato, Double> getSalarioMedioTipoContrato(List<Contrato> contratos){
        Map<TipoContrato, Double> salarioMedioTipoContrato = new HashMap<>();
        for (Contrato contrato : contratos){
            if(salarioMedioTipoContrato.containsKey(contrato.getTipoContrato())){
                salarioMedioTipoContrato.put(contrato.getTipoContrato(), salarioMedioTipoContrato.get(contrato.getTipoContrato()) + contrato.getSalarioBase());
            }else{
                salarioMedioTipoContrato.get(contrato.getSalarioBase());
            }
        }

        Map<TipoContrato, Integer> numSalarioMedioTipoContrato = new HashMap<>();
        for (Contrato contrato : contratos){
            if(numSalarioMedioTipoContrato.containsKey(contrato.getTipoContrato())){
                numSalarioMedioTipoContrato.put(contrato.getTipoContrato(), numSalarioMedioTipoContrato.get(contrato.getTipoContrato()) + 1);
            }else{
                numSalarioMedioTipoContrato.put(contrato.getTipoContrato(), 1);
            }
        }

        Map<TipoContrato, Double> mapaSolucion = new HashMap<>();
        // keySet funciona para recorrer el tipo de contratos (PRACTICAS, TEMPORAL, OBRAYSERVICIO , INDEFINIDO)
        for(TipoContrato tipocontrato : salarioMedioTipoContrato.keySet()){
            mapaSolucion.put(tipocontrato, salarioMedioTipoContrato.get(tipocontrato)/numSalarioMedioTipoContrato.get(tipocontrato));
        }

        return mapaSolucion;
    }

}