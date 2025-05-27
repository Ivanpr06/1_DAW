package org.example.demo4;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextField;

import java.sql.*;
import java.time.LocalDate;

public class Controller {
    public TextField TextDes;
    public DatePicker DataFechalq;
    public DatePicker DataFechaent;
    public TextField TextPrecio;
    public TextField TextDirc;
    public TextField TextNIF;
    public ComboBox<Cliente> ComboClient;
    public ComboBox<Vehiculo> ComboVeh;
    public TextField TextPobl;
    public TextField TextKm;
    public TextField TextTotalServ;
    public TextField TextMarca;
    private TableView<Servicio> tableGrabar;
    @FXML
    private TableColumn<Servicio, String> columnMatricula;
    @FXML
    private TableColumn<Servicio, String> columnMarca;
    @FXML
    private TableColumn<Servicio, Integer> columnPrecio;
    @FXML
    private TableColumn<Servicio, LocalDate> columnFechaAlquiler;
    @FXML
    private TableColumn<Servicio, LocalDate> columnFechaEntrega;
    @FXML
    private TableColumn<Servicio, Integer> columnTotal;


    public void initialize() {
        CogerClientes();
        CogerVehiculo();

        ComboVeh.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                TextDes.setText(newVal.getDescripcion());
                TextMarca.setText(newVal.getMarca());
                TextKm.setText(String.valueOf(newVal.getKilometros()));
                TextPrecio.setText(String.valueOf(newVal.getPrecio()));
            } else {
                TextDes.clear();
                TextMarca.clear();
                TextKm.clear();
                TextPrecio.clear();
            }
            calcularTotalServicio();
        });

        DataFechalq.valueProperty().addListener((obs, oldVal, newVal) -> calcularTotalServicio());
        DataFechaent.valueProperty().addListener((obs, oldVal, newVal) -> calcularTotalServicio());

        ComboClient.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                TextNIF.setText(newVal.getNIF());
                TextDirc.setText(newVal.getDirecion());
                TextPobl.setText(newVal.getPoblacion());
            } else {
                TextNIF.clear();
                TextDirc.clear();
                TextPobl.clear();
            }
        });

        columnMatricula.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMatricula()));
        columnMarca.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMarca()));
        columnPrecio.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getPrecio()).asObject());
        columnFechaAlquiler.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getFechaAlquiler()));
        columnFechaEntrega.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().getFechaEntrega()));
        columnTotal.setCellValueFactory(data -> new SimpleIntegerProperty(data.getValue().getTotal()).asObject());

    }



    public void CogerClientes() {
        ObservableList<Cliente> clientes = FXCollections.observableArrayList();

        try {
            Connection conn = ConexionDB.con();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CLIENTES");

            // Diagnóstico: imprimir columnas
            ResultSetMetaData meta = rs.getMetaData();
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                System.out.println("Columna #" + i + ": " + meta.getColumnName(i));
            }

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setNIF(rs.getString("NIF"));          // Confirmado
                c.setNYA(rs.getString("NYA"));          // Aquí está el posible error
                c.setDireccion(rs.getString("DIRECION"));
                c.setPoblacion(rs.getString("POBLACION"));
                clientes.add(c);
            }

            rs.close();
            stmt.close();
            conn.close();

            ComboClient.setItems(clientes);

            ComboClient.setCellFactory(lv -> new ListCell<Cliente>() {
                @Override
                protected void updateItem(Cliente item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty || item == null ? null : item.getNYA());
                }
            });

            ComboClient.setButtonCell(new ListCell<Cliente>() {
                @Override
                protected void updateItem(Cliente item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty || item == null ? null : item.getNYA());
                }
            });

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void CogerVehiculo() {
        ObservableList<Vehiculo> vehiculos = FXCollections.observableArrayList();

        try {
            Connection conn = ConexionDB.con();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM VEHICULOS");

            // Imprimir columnas para verificar nombres
            ResultSetMetaData meta = rs.getMetaData();
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                System.out.println("Columna #" + i + ": " + meta.getColumnName(i));
            }

            // Leer datos y añadir a la lista
            while (rs.next()) {
                System.out.println("Vehículo encontrado: " + rs.getString("MATRICULA"));

                Vehiculo v = new Vehiculo(
                        rs.getString("MATRICULA"),
                        rs.getString("DESCRIPCION"),
                        rs.getString("MARCA"),
                        rs.getInt("KILOMETROS"),
                        rs.getInt("PRECIO")
                );
                vehiculos.add(v);
            }

            rs.close();
            stmt.close();
            conn.close();

            ComboVeh.setItems(vehiculos);

            // Mostrar matrícula en el desplegable
            ComboVeh.setCellFactory(lv -> new ListCell<Vehiculo>() {
                @Override
                protected void updateItem(Vehiculo item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty || item == null ? null : item.getMatricula());
                }
            });

            // Mostrar matrícula en la parte seleccionada
            ComboVeh.setButtonCell(new ListCell<Vehiculo>() {
                @Override
                protected void updateItem(Vehiculo item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(empty || item == null ? null : item.getMatricula());
                }
            });

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void ButtonGrabar(ActionEvent event) {
        try {
            String totalServText = TextTotalServ.getText();
            int totalServicio = Integer.parseInt(totalServText);

            Cliente cliente = ComboClient.getValue();
            Vehiculo vehiculo = ComboVeh.getValue();
            LocalDate fechaAlquiler = DataFechalq.getValue();
            LocalDate fechaEntrega = DataFechaent.getValue();

            if (cliente == null || vehiculo == null || fechaAlquiler == null || fechaEntrega == null) {
                new Alert(Alert.AlertType.ERROR, "Datos incompletos.").showAndWait();
                return;
            }

            Connection conn = ConexionDB.con();
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO SERVICIOS (ID_SERVICIO, NIF_CLIENTE, MATRICULA_VEHICULO, FECHA_ALQUILER, FECHA_ENTREGA, TOTAL) " +
                            "VALUES (SEQ_SERVICIOS.NEXTVAL, ?, ?, ?, ?, ?)"
            );


            stmt.setString(1, cliente.getNIF());
            stmt.setString(2, vehiculo.getMatricula());
            stmt.setDate(3, Date.valueOf(fechaAlquiler));
            stmt.setDate(4, Date.valueOf(fechaEntrega));
            stmt.setInt(5, totalServicio);

            stmt.executeUpdate();
            conn.close();

            // Agregar a la tabla
            Servicio nuevo = new Servicio(
                    vehiculo.getMatricula(),
                    vehiculo.getMarca(),
                    vehiculo.getPrecio(),
                    fechaAlquiler,
                    fechaEntrega,
                    totalServicio
            );
            tableGrabar.getItems().add(nuevo);

            new Alert(Alert.AlertType.INFORMATION, "Servicio guardado.").showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error: " + e.getMessage()).showAndWait();
        }
    }


    private void calcularTotalServicio() {
        if (DataFechalq.getValue() == null || DataFechaent.getValue() == null) {
            TextTotalServ.setText("");
            return;
        }

        if (ComboVeh.getValue() == null) {
            TextTotalServ.setText("");
            return;
        }

        long dias = java.time.temporal.ChronoUnit.DAYS.between(DataFechalq.getValue(), DataFechaent.getValue());
        if (dias < 0) {
            TextTotalServ.setText("0");
            return;
        }

        int precioVehiculo = ComboVeh.getValue().getPrecio();
        int total = (int) dias * precioVehiculo;

        TextTotalServ.setText(String.valueOf(total));
    }




}