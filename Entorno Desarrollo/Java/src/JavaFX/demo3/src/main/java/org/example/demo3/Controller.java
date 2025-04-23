package org.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Controller {

    @FXML
    private TableColumn<Persona, String> ColumnaEdad;

    @FXML
    private TableColumn<Persona, String> ColumnaNombre;

    @FXML
    private TableView<Persona> Tabla;

    @FXML
    private TableColumn<Persona, String> ColumnaApellidos;

    @FXML
    private TextField textFiltro;

    @FXML
    private Button botonEliminar;

    @FXML
    private Button botonAñadir;

    private ObservableList<Persona> personas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        ColumnaNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        ColumnaApellidos.setCellValueFactory(new PropertyValueFactory<>("Apellidos"));
        ColumnaEdad.setCellValueFactory(new PropertyValueFactory<>("Edad"));
        Tabla.setItems(personas);

        botonEliminar.setOnAction(event -> EliminarPersona());
        textFiltro.setOnAction(event -> textFiltro());
    }

    @FXML
    private void Tablero() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Formulario.fxml"));
            Parent root = loader.load();

            Controller2 controller = loader.getController();
            controller.setController(this);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Formulario");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

            Stage nuevaVentana = new Stage();
            nuevaVentana.setTitle("Nueva Ventana");
            nuevaVentana.setScene(new Scene(root));
            nuevaVentana.show();

            nuevaVentana.setOnCloseRequest(e -> {
                abrirVentanaPrincipal();
            } catch (IOException e) {
                e.printStackTrace();
        }
    }

    @FXML
    private void modificarPersona() {
        Persona persona = Tabla.getSelectionModel().getSelectedItem();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Formulario.fxml"));
            Parent root = loader.load();

            Controller2 controller = loader.getController();
            controller.setController(this);
            controller.modificarPersona(persona);

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Formulario");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregar(Persona persona) {
        personas.add(persona);
    }

    public void modificar(ObservableList<Persona> personas, Persona persona) {
        this.personas.set(this.personas.indexOf(persona), persona);
    }

    private void EliminarPersona() {
        int index = Tabla.getSelectionModel().getFocusedIndex();
        Tabla.getItems().remove(index);
    }

    public void textFiltro(){
        String filtro = textFiltro.getText().toLowerCase();
        ObservableList<Persona> personasFiltro = FXCollections.observableArrayList();

        for (Persona persona : personas) {
            if(persona.getNombre().toLowerCase().contains(filtro) || persona.getApellidos().toLowerCase().contains(filtro)){
                personasFiltro.add(persona);
            }
        }
        Tabla.setItems(personasFiltro);
    }


    public void abrirVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Panel.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Panel");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}