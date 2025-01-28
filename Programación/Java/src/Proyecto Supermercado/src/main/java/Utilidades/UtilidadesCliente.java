package Utilidades;

import Modelos.Cliente;

public class UtilidadesCliente {

    public boolean  esDniValido(Cliente cliente){
        if (cliente.getDni().length() == 9){
            int contador = 1;
            for (char caracter : cliente.getDni().toCharArray()){
                if (!Character.isDigit(caracter) && contador <= 8){
                    return false;
                }
                if (Character.isDigit(caracter) && contador == 9){
                    return false;

                }
                contador++;
            }return true;
        }else{
            return false;
        }
    }
}
