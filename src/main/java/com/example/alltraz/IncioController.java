package com.example.alltraz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IncioController {
    private AnchorPane rootPane;
    @FXML
    private Button InicioEmpresa;
    @FXML
    private Button InicioCliente;
    @FXML
    private Button ADMIN;

    @FXML
    public void InicioEmpresa(ActionEvent actionEvent) {
        try {
            Parent pane = FXMLLoader.load(getClass().getResource("InicioSesionEmpresa-View.fxml"));

            Scene scene = new Scene(pane);

            Stage stage = (Stage) InicioEmpresa.getScene().getWindow();

            stage.setScene(scene);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void InicioCliente(ActionEvent actionEvent) {
        try {
            Parent pane = FXMLLoader.load(getClass().getResource("InicioSesionCliente-View.fxml"));

            Scene scene = new Scene(pane);

            Stage stage = (Stage) InicioCliente.getScene().getWindow();

            stage.setScene(scene);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void btn_ADMIN(ActionEvent actionEvent) {
        try {
            Parent pane = FXMLLoader.load(getClass().getResource("Admin-View.fxml"));

            Scene scene = new Scene(pane);

            Stage stage = (Stage) ADMIN.getScene().getWindow();

            stage.setScene(scene);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
