module org.example.tienda_de_pesca {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.tienda_de_pesca to javafx.fxml;
    exports org.example.tienda_de_pesca;
}