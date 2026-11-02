module com.example.ejerciciosclase2_parte1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ejerciciosclase2_parte1 to javafx.fxml;
    exports com.example.ejerciciosclase2_parte1;
}