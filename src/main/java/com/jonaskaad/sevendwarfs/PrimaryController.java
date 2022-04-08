package com.jonaskaad.sevendwarfs;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Random;

public class PrimaryController {
    @FXML
    private Label welcomeText;


    @FXML
    public void initialize() {
        Random random = new Random();
        int rand1 = random.nextInt(1, 8);
        int rand2 = random.nextInt(1, 8);
        while(rand1 == rand2){
            System.out.println("oh no   " + rand2);
            rand2 = random.nextInt(1, 8);
        }

        System.out.println("rand1: " + rand1 + "  rand2: " + rand2);
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to Seven Dwarfs Application!");
    }
}