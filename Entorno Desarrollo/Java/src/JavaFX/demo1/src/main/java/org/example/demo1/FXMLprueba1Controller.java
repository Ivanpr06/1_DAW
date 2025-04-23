package org.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class FXMLprueba1Controller{

    @FXML
    private TextField txtop1; // Campo de texto para el primer operando

    @FXML
    private TextField txtop2; // Campo de texto para el segundo operando

    @FXML
    private RadioButton botonSuma;

    @FXML
    private RadioButton botonResta;

    @FXML
    private RadioButton BotonMulti;

    @FXML
    private RadioButton botonDivision;
    @FXML
    private TextField txtresult; // Campo de texto para mostrar el resultado

    @FXML
    private Button result; // Botón para calcular

    // Método que se ejecuta al inicializar el controlador
    @FXML
    private void initialize() {
        // Configurar el evento del botón
        result.setOnAction(event -> calcularResultado());
    }

    // Método para realizar el cálculo
    private void calcularResultado() {
        try {
            // Obtener los valores de los campos de texto
            double operador1 = Double.parseDouble(txtop1.getText());
            double operador2 = Double.parseDouble(txtop2.getText());

            // Realizar la suma (puedes cambiar la operación según necesites)
            double resultado = 0;
            if(botonSuma.isSelected()) {
                resultado = operador1 + operador2;
            }else if(botonResta.isSelected()) {
                resultado = operador1 - operador2;
            }else if(BotonMulti.isSelected()) {
                resultado = operador1 * operador2;
            }else if(botonDivision.isSelected()) {
                resultado = operador1 / operador2;
            }

            // Mostrar el resultado
            txtresult.setText(String.valueOf(resultado));
        } catch (NumberFormatException e) {
            // Manejar error si los valores no son números válidos

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("Formato Incorrecto");
            alerta.showAndWait();
        }
    }
}