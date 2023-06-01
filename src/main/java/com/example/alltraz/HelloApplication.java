package com.example.alltraz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Inicio-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),875,598);
        Parent root = fxmlLoader.load(getClass().getResource("Inicio-View.fxml"));
        Scene scene1 = new Scene(root);
        stage.setTitle("ALLTRAZ");
        stage.getIcons().add(new Image("C:\\Users\\DAM1.XA19D2\\Desktop\\Alltraz-main\\Programa Java\\ALLTRAZ\\src\\main\\resources\\com\\example\\Images\\Miproyecto.png"));
        stage.setScene(scene);
        stage.show();
    }

        public static void main(String[] args) {
        launch();
    }
}