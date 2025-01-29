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

}
