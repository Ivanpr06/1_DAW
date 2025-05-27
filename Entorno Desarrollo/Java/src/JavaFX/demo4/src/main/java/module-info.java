module org.example.demo4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens org.example.demo4 to javafx.fxml;
    exports org.example.demo4;
}