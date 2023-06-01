package com.example.alltraz;

import com.example.model.Cliente;
import com.example.model.DataBase;
import com.example.model.Empresa;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NotificarProductoView {
    @javafx.fxml.FXML
    private Button enviarNotif;
    @javafx.fxml.FXML
    private Button atras;
    @javafx.fxml.FXML
    private TextArea getNotificacion;

    ArrayList<String> notificaciones = new ArrayList<String>();
    @javafx.fxml.FXML
    public void click_enviarNotif(ActionEvent actionEvent) {
        String notificacion = getNotificacion.getText();
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Notificación.");
        a.setHeaderText("Confirmación de envío.");
        a.setResizable(false);
        a.setContentText("La notificación se ha enviado correctamente.");
        a.showAndWait();


        notificaciones.add(notificacion);
        /*
        Empresa e = new Empresa();

        String userempresa;
        String passwordempresa;

        if (userempresa.equals(e.getUsername_empresa()) || passwordempresa.equals(e.getPassword_empresa())) {
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
*/
        System.out.println(notificaciones);
        }


    @javafx.fxml.FXML
    public void click_atras(ActionEvent actionEvent) {
        try {
            Parent pane = FXMLLoader.load(getClass().getResource("InterfazEmpresas-View.fxml"));

            Scene scene = new Scene(pane);

            Stage stage = (Stage) atras.getScene().getWindow();

            stage.setScene(scene);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
