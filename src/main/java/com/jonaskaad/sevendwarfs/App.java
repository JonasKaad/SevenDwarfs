package com.jonaskaad.sevendwarfs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("primary.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 650);
        stage.setTitle("PROSA - Seven Dwarfs");
        stage.setScene(scene);
        stage.show();
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream("icon.png")));
    }

    public static void main(String[] args) {
        launch();
    }
}