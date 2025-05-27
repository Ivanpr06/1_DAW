package org.example.tienda_de_pesca;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Controller {

    @FXML
    private TextField textpvp;

    @FXML
    private TextField textmodelo;

    @FXML
    private Button botonguardar;

    @FXML
    private Button botonmodificar;

    @FXML
    private TextField textpeso;

    @FXML
    private TextField textnavegavilidad;

    @FXML
    private TextField textcolor;

    @FXML
    private DatePicker datefecha;

    @FXML
    private TextField textojos;

    @FXML
    private TextField textreferencia;

    @FXML
    private TextField textdisponibilidad;

    @FXML
    private ComboBox<String> combotamano;


    public void initialize() {
        cargarTamanos();
        botonguardar.setOnAction(event -> cargarDatos());
//        botonmodificar.setOnAction(event -> modificarDatos());
    }

    private void cargarTamanos() {
        combotamano.getItems().addAll("Pequeño", "Mediano", "Grande");
    }

    private void cargarDatos() {
        try{
            String modelo = textmodelo.getText();
            String tamano = combotamano.getValue();
            String color = textcolor.getText();
            String navegavilidad = textnavegavilidad.getText();
            String ojos = textojos.getText();
            String referencia = textreferencia.getText();
            int peso = Integer.parseInt(textpeso.getText());
            String disponibilidad = textdisponibilidad.getText();
            int pvp = Integer.parseInt(textpvp.getText());
            LocalDate fecha = datefecha.getValue();

            Connection conn = ConexionDB.conexion();
            String sql = "INSERT INTO señuelos (modelo, tamano, color, navegavilidad, ojos, referencia, peso, disponibilidad, pvp, fecha_recepcion) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, modelo);
            stmt.setString(2, tamano);
            stmt.setString(3, color);
            stmt.setString(4, navegavilidad);
            stmt.setString(5, ojos);
            stmt.setString(6, referencia);
            stmt.setInt(7, peso);
            stmt.setString(8, disponibilidad);
            stmt.setInt(9, pvp);
            stmt.setDate(10, Date.valueOf(fecha));

            stmt.executeUpdate();
            conn.close();

            mostrarAlerta("Guardado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            mostrarAlerta("No se puede guardar los datos.");
        }

    }

//    public void modificarDatos() {
//        this.tiendapesca.set(this.tiendapesca.indexOf(pesca), pesca);
//    }


    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}