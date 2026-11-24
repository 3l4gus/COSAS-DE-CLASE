module com.example.proyectopizzeria {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyectopizzeria to javafx.fxml;
    exports com.example.proyectopizzeria;
}