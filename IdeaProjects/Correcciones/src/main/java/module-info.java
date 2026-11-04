module com.example.correcciones {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires com.github.librepdf.openpdf;


    opens com.example.correcciones to javafx.fxml;
    exports com.example.correcciones;
}