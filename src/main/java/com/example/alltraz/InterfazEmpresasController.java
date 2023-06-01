package com.example.alltraz;

import com.example.model.Cliente;
import com.example.model.DataBase;
import com.example.model.Empresa;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InterfazEmpresasController {

    @javafx.fxml.FXML
    private Button notificarProducto;
    @javafx.fxml.FXML
    private Button añadirProducto;

    @javafx.fxml.FXML
    public void click_añadirProducto(ActionEvent actionEvent) {
        try {
            Parent pane = FXMLLoader.load(getClass().getResource("RegistroProducto-View.fxml"));

            Scene scene = new Scene(pane);

            Stage stage = (Stage) añadirProducto.getScene().getWindow();

            stage.setScene(scene);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void click_notificarProducto(ActionEvent actionEvent) {
        try {
            Parent pane = FXMLLoader.load(getClass().getResource("NotificarProducto-View.fxml"));

            Scene scene = new Scene(pane);

            Stage stage = (Stage) notificarProducto.getScene().getWindow();

            stage.setScene(scene);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void recogerLogo(Empresa empresa, File file){
        DataBase db = new DataBase();
        Connection connexion = db.obtenerConexion();

        String consulta = "";
        Empresa e = new Empresa();

        try {
            String Cif = e.getCif();
            PreparedStatement st = connexion.prepareStatement(consulta);
            st.setString(1, Cif);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                /*
                InputStream is = rs.getBinaryStream("ImagenEmpresa");
                Image image = new Image(is);
                ImageView imageView = new ImageView(image);
                image.setImageView(imageView);
                */

                Image logo = null;
                Blob blob = rs.getBlob(12);
                InputStream is = rs.getBinaryStream("ImagenEmpresa");
                logo = new Image(is);
            }

            rs.close();
            st.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }
}
