package com.example.serviceappointmentmanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Home {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}