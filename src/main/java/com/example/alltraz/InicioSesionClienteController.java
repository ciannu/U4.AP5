package com.example.alltraz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import com.example.model.Cliente;
import com.example.model.DataBase;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InicioSesionClienteController implements Initializable {
    @javafx.fxml.FXML
    private AnchorPane rootPane;
    @FXML
    private Button atras;
    @FXML
    private Button Registrarse;
    @FXML
    private TextField txtUsuername;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button registrarse;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void click_InicioSesion(ActionEvent actionEvent) {
        String user = txtUsuername.getText().trim();
        String pass = txtPassword.getText().trim();

        if (user.equals("") || pass.equals("")) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setTitle("Error");
            a.setContentText("Falta algun campo");
            a.showAndWait();
        } else {
            DataBase db = new DataBase();
            Connection connexion = db.obtenerConexion();


            String consulta = "Select * FROM usuario where Username='" + user + "'AND Contraseña='" + pass + "'";
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
                                rs.getString("Username"),
                                rs.getString("Contraseña")
                        );
                    } while (rs.next());
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                    a.setHeaderText(null);
                    a.setTitle("Aviso");
                    a.setContentText("Login existoso \n" + cliente.mostrarUsuario());
                    a.showAndWait();

                    ventanaInformacionProducto();

                }
                rs.close();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void ventanaInformacionProducto() {
        try {
            Parent pane = FXMLLoader.load(getClass().getResource("InformacionProducto-View.fxml"));

            Scene scene = new Scene(pane);

            Stage stage = (Stage) Registrarse.getScene().getWindow();

            stage.setScene(scene);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void click_Registrarse(ActionEvent actionEvent) {
        try {
            Parent pane = FXMLLoader.load(getClass().getResource("RegistroCliente-View.fxml"));

            Scene scene = new Scene(pane);

            Stage stage = (Stage) Registrarse.getScene().getWindow();

            stage.setScene(scene);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz.HelloController.class.getName()).log(Level.SEVERE, null, ex);
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

    @FXML
    public void eventkey(KeyEvent event) {

        //NO DEJAR ESPACIOS EN LOS CAMPOS

        Object evt = event.getSource();

        if (evt.equals(txtUsuername)) {
            if (event.getCharacter().equals(" ")) {
                event.consume();
            }
        } else if (evt.equals(txtPassword)) {
            if (event.getCharacter().equals(" ")) {
                event.consume();
            }
        }
    }

}
