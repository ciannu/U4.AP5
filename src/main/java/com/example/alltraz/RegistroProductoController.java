package com.example.alltraz;

import com.example.model.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistroProductoController {

    @javafx.fxml.FXML
    private AnchorPane rootPane;
    @javafx.fxml.FXML
    private DatePicker datePlantacion;
    @javafx.fxml.FXML
    private DatePicker dateCosecha;
    @javafx.fxml.FXML
    private DatePicker dateSalidaAlm;
    @javafx.fxml.FXML
    private DatePicker dateLlegadaAlm;
    @javafx.fxml.FXML
    private TextField getLote;
    @javafx.fxml.FXML
    private Button añadirImagen;
    @javafx.fxml.FXML
    private Button registrarProducto;
    @javafx.fxml.FXML
    private Button atras;

    private String cadenaConexion = "jdbc:mysql://localhost:3306/alltraz";
    private String nombreUsuario = "root";
    private String password = "1234";

    @javafx.fxml.FXML
    private Button caracteristicasCosecha;
    @javafx.fxml.FXML
    private Button caracteristicasLlegada;
    @javafx.fxml.FXML
    private Button caracteristicasPlantacion;
    @javafx.fxml.FXML
    private Button caracteristicasSalida;

    private String lote, carPlant, carCos, carLleg, carSal;
    private LocalDate fsal, flleg, fcos, fplant;

    @javafx.fxml.FXML
    public void pick_datePlantacion(ActionEvent actionEvent) {
        fplant = datePlantacion.getValue();
    }

    @javafx.fxml.FXML
    public void pick_dateCosecha(ActionEvent actionEvent) {
        fcos = dateCosecha.getValue();
    }

    @javafx.fxml.FXML
    public void pick_dateSalidaAlm(ActionEvent actionEvent) {
        fsal = dateSalidaAlm.getValue();
    }

    @javafx.fxml.FXML
    public void pick_dateLlegadaAlm(ActionEvent actionEvent) {
        flleg = dateLlegadaAlm.getValue();
    }

    @javafx.fxml.FXML
    public void click_añadirImagen(ActionEvent actionEvent) {
    }
    @javafx.fxml.FXML
    public void click_registrarProducto(ActionEvent actionEvent) {
        lote = getLote.getText();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Datos");
        a.setHeaderText("Confirmación de datos.");
        a.setResizable(false);
        System.out.println(carPlant);
        a.setContentText("Fecha de plantación: " + fplant.toString() + "\nCaracterísticas de la plantación: " + carPlant +
                "\nFecha de cosecha: " + fcos.toString() + "\nCaracterísticas de la cosecha: " + carCos +
                "\nFecha de llegada al almacén: " + flleg.toString() + "\nCaracterísticas de la llegada al almacén: " + carLleg +
                "\nFecha salida almacén: " + fsal.toString() + "\nCaracterísticas de la salida del almacén: " + carSal +
                "Número de lote: " + lote);

        Optional<ButtonType> result = a.showAndWait();

        if (result.get() == ButtonType.OK) {
            Producto prod = new Producto(lote, fplant, carPlant, fcos, carCos, flleg, carLleg, fsal, carSal);

            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                Connection conn = DriverManager.getConnection(this.cadenaConexion, this.nombreUsuario, this.password);
                String insertQuery = "INSERT INTO producto (numero_lote) values (" + lote + ");" +
                        "\nINSERT INTO movimientos (fecha_plantacion, fecha_cosecha, fecha_llegadaAlmacen, fecha_salidaAlmacen, caracteristicas_plantacion," +
                        "caracteristicas_cosecha, caracteristicas_llegadaAlmacen, caracteristicas_salidaAlmacen) values ('" + fplant + "', '" + fcos
                        + "', '" + flleg + "', '" + fsal + "', '" + carPlant + "', '" + carCos + "', '" + carLleg + "', '" + carSal + "');";
                PreparedStatement stmt = conn.prepareStatement(insertQuery);
                ResultSet rs = stmt.executeQuery();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @javafx.fxml.FXML
    public void click_atras(ActionEvent actionEvent) {
        try {
            Parent pane = FXMLLoader.load(getClass().getResource("" +
                    "-View.fxml"));

            Scene scene = new Scene(pane);

            Stage stage = (Stage) atras.getScene().getWindow();

            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void click_caracteristicasPlantacion(ActionEvent actionEvent) {
        try {
            Parent pane = FXMLLoader.load(getClass().getResource("AgregarCaracteristicasPlantacion-View.fxml"));

            Scene scene = new Scene(pane);

            Stage stage = (Stage) caracteristicasPlantacion.getScene().getWindow();

            stage.setScene(scene);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @javafx.fxml.FXML
    public void click_caracteristicasCosecha(ActionEvent actionEvent) {
        try {
            Parent pane = FXMLLoader.load(getClass().getResource("AgregarCaracteristicasCosecha-View.fxml"));

            Scene scene = new Scene(pane);

            Stage stage = (Stage) caracteristicasCosecha.getScene().getWindow();

            stage.setScene(scene);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void click_caracteristicasLlegada(ActionEvent actionEvent) {
        try {
            Parent pane = FXMLLoader.load(getClass().getResource("AgregarCaracteristicasLlegada-View.fxml"));

            Scene scene = new Scene(pane);

            Stage stage = (Stage) caracteristicasLlegada.getScene().getWindow();

            stage.setScene(scene);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void click_caracteristicasSalida(ActionEvent actionEvent) {
        try {
            Parent pane = FXMLLoader.load(getClass().getResource("AgregarCaracteristicasSalida-View.fxml"));

            Scene scene = new Scene(pane);

            Stage stage = (Stage) caracteristicasSalida.getScene().getWindow();

            stage.setScene(scene);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
