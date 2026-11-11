module com.example.proyecto_programadores {
    requires javafx.controls;
    requires javafx.fxml;
    requires db4o;
    requires static lombok;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires com.github.librepdf.openpdf;
    requires java.desktop;


    opens com.example.proyecto_programadores to javafx.fxml;
    opens com.example.proyecto_programadores.entity to db4o, javafx.base;
    exports com.example.proyecto_programadores;
}