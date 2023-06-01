package com.example.alltraz;

import com.example.model.Ajustes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import com.example.model.DataBase;
import sample.Empresa;

import java.io.*;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VentanaAgregarController implements Initializable {
    @javafx.fxml.FXML
    private TextField ID;
    @javafx.fxml.FXML
    private TextField CIF;
    @javafx.fxml.FXML
    private TextField PASSWORD;
    @javafx.fxml.FXML
    private Button LISTO;
    @javafx.fxml.FXML
    private Button ATRAS;
    @javafx.fxml.FXML
    private TextField txtRuta;
    @javafx.fxml.FXML
    private Button RUTA;
    @javafx.fxml.FXML
    private AnchorPane rootPane;

    private Empresa empresa = new Empresa();
    private ObservableList<Empresa> empresas = FXCollections.observableArrayList();


    public void initAtributes(ObservableList<Empresa> empresas,Empresa empresa){
        this.empresas=empresas;
        this.empresa=empresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    @javafx.fxml.FXML
    public void btn_LISTO(ActionEvent actionEvent) throws FileNotFoundException {
        Ajustes a = new Ajustes();
        String nombreEmpresa = ID.getText().trim();
        String cif = CIF.getText().trim();
        String pass = PASSWORD.getText().trim();
        String ruta = txtRuta.getText().trim();
        Image image = new Image(ruta);
        ImageView imageView = new ImageView(image);


        if (pass.equals("") || nombreEmpresa.equals("") || cif.equals("") || ruta.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Falta algun campo");
            alert.showAndWait();
        } else {
            DataBase db = new DataBase();
            Connection connexion = db.obtenerConexion();


            String consulta = "INSERT INTO empresa (Cif,Contraseña,ImagenEmpresa,NombreEmpresa) VALUES (?,?,?,?)";
            Empresa empresa = new Empresa();

            try {
                PreparedStatement st = connexion.prepareStatement(consulta);
                st.setString(1,cif);
                st.setString(2,pass);
                st.setString(3,ruta);
                st.setString(4,nombreEmpresa);

                int filasNuevas = st.executeUpdate();

                if(filasNuevas==1){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("¡Ya tienes cuenta!");
                    alert.setContentText("Ahora inicia sesion para entrar en nuestra aplicacion");
                    alert.showAndWait();
                }

                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


    }

}

    @javafx.fxml.FXML
    public void click_ATRAS(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Inicio-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void btn_Ruta(ActionEvent actionEvent) throws FileNotFoundException {
       Ajustes a = new Ajustes();
       a.escogerImagen();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
