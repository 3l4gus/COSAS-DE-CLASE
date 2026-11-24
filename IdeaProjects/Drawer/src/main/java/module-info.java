module com.example.drawer {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.fontawesome5;


    opens com.example.drawer to javafx.fxml;
    exports com.example.drawer;
}