package org.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller2 {
    @FXML
    private TextField TextNombre;


    @FXML
    private Button BotonSalir;

    @FXML
    private TextField TextEdad;

    @FXML
    private TextField TextApellidos;

    @FXML
    private Button BotonGuardar;

    private Controller controller;

    private ObservableList<Persona> personas = FXCollections.observableArrayList();


    public void setController(Controller controller) {
        this.controller = controller;
    }

    @FXML
    private void guardarPersona() {
        String Nombre = TextNombre.getText().trim();
        String Apellidos = TextApellidos.getText().trim();
        String Edad = TextEdad.getText().trim();

        if (Nombre.isEmpty() || Apellidos.isEmpty() || Edad.isEmpty()) {
            System.err.println("Los campos no pueden estar vacios");
            return;
        }

        if(personaSeleccionado != null) {
            personaSeleccionado.setNombre(Nombre);
            personaSeleccionado.setApellidos(Apellidos);
            personaSeleccionado.setEdad(Edad);

            controller.modificar(personas ,personaSeleccionado);
            Stage stage = (Stage) BotonSalir.getScene().getWindow();
            stage.close();
        }else{
            Persona persona = new Persona(Nombre, Apellidos, Edad);
            controller.agregar(persona);
        }

        TextNombre.clear();
        TextApellidos.clear();
        TextEdad.clear();

        Stage actual = (Stage) BotonGuardar.getScene().getWindow();
        actual.close();
    }

    @FXML
    private void botonSalir() {
        Stage stage = (Stage) BotonSalir.getScene().getWindow();
        stage.close();
    }

    private Persona personaSeleccionado = null;

    public void modificarPersona(Persona persona) {
        this.personaSeleccionado = persona;

        this.TextNombre.setText(persona.getNombre());
        this.TextApellidos.setText(persona.getApellidos());
        this.TextEdad.setText(persona.getEdad());
    }
}
