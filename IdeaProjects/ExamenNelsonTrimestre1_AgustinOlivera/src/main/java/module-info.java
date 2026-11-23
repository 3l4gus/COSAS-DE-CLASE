module com.example.examennelsontrimestre1_agustinolivera {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires static lombok;
    requires db4o;


    opens com.example.examennelsontrimestre1_agustinolivera to javafx.fxml;
    opens com.example.examennelsontrimestre1_agustinolivera.entity to db4o, javafx.base;
    exports com.example.examennelsontrimestre1_agustinolivera;
}