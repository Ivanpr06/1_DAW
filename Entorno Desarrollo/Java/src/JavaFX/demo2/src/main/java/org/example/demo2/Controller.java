package org.example.demo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private Button BotonAgregar;

    @FXML
    private TableColumn ColumnaEdad;

    @FXML
    private TableColumn ColumnaNombre;

    @FXML
    private TextField TextNombre;

    @FXML
    private TableView<Persona> Tabla;

    @FXML
    private TableColumn ColumnaApellidos;

    @FXML
    private TextField TextEdad;

    @FXML
    private TextField TextApellidos;

    @FXML
    private Button BotonEliminar;

    @FXML
    private Button BotonModificar;

    private ObservableList<Persona> personas;


    @FXML
    private void initialize() {
        personas = FXCollections.observableArrayList();
        ColumnaNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        ColumnaApellidos.setCellValueFactory(new PropertyValueFactory<>("Apellidos"));
        ColumnaEdad.setCellValueFactory(new PropertyValueFactory<>("Edad"));

        // Configurar el evento del botón
        BotonAgregar.setOnAction(event -> AnyadirPersona());
        BotonModificar.setOnAction(event -> ModificarPersona());
        BotonEliminar.setOnAction(event -> EliminarPersona());
    }

    private void AnyadirPersona() {
        try {
            String Nombre = String.valueOf(TextNombre.getText());
            String Apellidos = String.valueOf(TextApellidos.getText());
            Integer Edad = Integer.parseInt(TextEdad.getText());

            Persona p = new Persona(Nombre, Apellidos, Edad);

            if(!personas.contains(p)) {
                personas.add(p);
                Tabla.getItems().add(p);
            }
        }
        catch (NumberFormatException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("Introduzca un numero valido");
            alerta.showAndWait();
        }
        catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("Formato Incorrecto");
            alerta.showAndWait();
        }
    }

    private void ModificarPersona() {
        Persona personaSeleccionada = Tabla.getSelectionModel().getSelectedItem();
        if (personaSeleccionada != null) {
            String nuevoNombre = TextNombre.getText();
            String nuevoApellidos = TextApellidos.getText();
            String nuevaEdadTexto = TextEdad.getText();
            int nuevaEdad = Integer.parseInt(nuevaEdadTexto);

            personaSeleccionada.setNombre(nuevoNombre);
            personaSeleccionada.setApellidos(nuevoApellidos);
            personaSeleccionada.setEdad(nuevaEdad);

            Tabla.refresh();
        }
    }


    private void EliminarPersona() {
        int index = Tabla.getSelectionModel().getFocusedIndex();
        Tabla.getItems().remove(index);

    }


}

