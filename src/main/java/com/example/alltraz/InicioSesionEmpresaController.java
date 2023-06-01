package com.example.alltraz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import com.example.model.Cliente;
import com.example.model.DataBase;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InicioSesionEmpresaController {
    @javafx.fxml.FXML
    private AnchorPane rootPane;
    @javafx.fxml.FXML
    private TextField getUser;
    @javafx.fxml.FXML
    private TextField getPassword;
    @javafx.fxml.FXML
    private Button atras;
    @FXML
    private Button atras1;
    @FXML
    private Button inicioSesion;

    @FXML
    public void click_InicioSesionEmpresa(ActionEvent actionEvent) {
        String cif = getUser.getText().trim();
        String pass = getPassword.getText().trim();

        if (cif.equals("") || pass.equals("")) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setTitle("Error");
            a.setContentText("Falta algun campo");
            a.showAndWait();
        } else {
            DataBase db = new DataBase();
            Connection connexion = db.obtenerConexion();


            String consulta = "Select * FROM empresa where Cif='" + cif + "'AND Contraseña='" + pass + "'";
            Cliente cliente;

            try {
                Statement st = connexion.createStatement();
                ResultSet rs = st.executeQuery(consulta);

                if (!rs.next()) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setHeaderText(null);
                    a.setTitle("Error");
                    a.setContentText("No hay registro con estos datos");
                    a.showAndWait();
                } else {
                    do {
                        cliente = new Cliente(
                                rs.getString("Cif"),
                                rs.getString("Contraseña")
                        );
                    } while (rs.next());
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                    a.setHeaderText(null);
                    a.setTitle("Aviso");
                    a.setContentText("Login existoso ");
                    a.showAndWait();
                    ventanaInterfazEmpresas();

                }
                rs.close();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }

    @FXML
    public void click_atras(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Inicio-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ventanaInterfazEmpresas(){
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("InterfazEmpresas-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}
