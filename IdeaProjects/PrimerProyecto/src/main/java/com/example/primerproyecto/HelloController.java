package com.example.primerproyecto;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText, textoNombre;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onHolaMundoBottonClick(){
        textoNombre.setText("Agustín");
    }
}
