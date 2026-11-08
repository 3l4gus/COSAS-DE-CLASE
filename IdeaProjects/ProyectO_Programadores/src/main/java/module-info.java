module com.example.proyecto_programadores {
    requires javafx.controls;
    requires javafx.fxml;
    requires db4o;
    requires static lombok;
    requires java.desktop;


    opens com.example.proyecto_programadores to javafx.fxml;
    exports com.example.proyecto_programadores;
}