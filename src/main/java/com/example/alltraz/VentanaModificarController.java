package com.example.alltraz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import com.example.model.DataBase;
import sample.Empresa;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VentanaModificarController {
    @javafx.fxml.FXML
    private TextField NombreEmpresa;
    @javafx.fxml.FXML
    private TextField CIF;
    @javafx.fxml.FXML
    private TextField PASSWORD;
    @javafx.fxml.FXML
    private Button LISTO;
    @javafx.fxml.FXML
    private Button ATRAS;
    @javafx.fxml.FXML
    private TextField ID;
    @javafx.fxml.FXML
    private Button BuscarId;

    @Deprecated
    public void btn_Ruta(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecciona archivo");

        // Set initial directory (optional)
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        // Add file extension filters (optional)
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif");
        fileChooser.getExtensionFilters().addAll(imageFilter);

        // Show the file chooser dialog
        Window primaryStage = null;
        File selectedFile = fileChooser.showOpenDialog(primaryStage);

        if (selectedFile != null) {
            // Process the selected file
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        } else {
            System.out.println("No file selected.");
        }

    }



    @javafx.fxml.FXML
    public void click_ATRAS(ActionEvent actionEvent) {
    }

    @FXML
    public void btn_BuscarID(ActionEvent actionEvent) {
        String nombreEmpresa = NombreEmpresa.getText().trim();
        String cif = CIF.getText().trim();
        String pass = PASSWORD.getText().trim();

        DataBase db = new DataBase();
        Connection connexion = db.obtenerConexion();


        String consulta = "Select * FROM empresa where Id_empresa= ?";
        Empresa empresa = new Empresa();

        try {
            PreparedStatement st = connexion.prepareStatement(consulta);
            String id=ID.getText().trim();
            st.setString(1, id);

            ResultSet rs = st.executeQuery();

            while(rs.next()){
                String nombreempresa1 = rs.getString("NombreEmpresa");
                String cif1 = rs.getString("Cif");
                String pass1 = rs.getString("Contraseña");

                NombreEmpresa.setText(nombreempresa1);
                CIF.setText(cif1);
                PASSWORD.setText(pass1);
            }


            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    @javafx.fxml.FXML
    public void btn_LISTO(ActionEvent actionEvent) {
        String nombreEmpresa1 = NombreEmpresa.getText();
        String cif1 = CIF.getText();
        String pass1 = PASSWORD.getText();
        String id1 = ID.getText();


        if (pass1.equals("") || nombreEmpresa1.equals("") || cif1.equals("")) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText(null);
            a.setTitle("Error");
            a.setContentText("Falta algun campo");
            a.showAndWait();
        } else {
            DataBase db = new DataBase();
            Connection connexion = db.obtenerConexion();


            String consulta = "UPDATE empresa SET Cif=?,Contraseña=?,NombreEmpresa=? where Id_empresa=?";
            Empresa empresa = new Empresa();

            try {
                PreparedStatement st = connexion.prepareStatement(consulta);
                st.setString(1, cif1);
                st.setString(2, pass1);
                st.setString(3, nombreEmpresa1);
                st.setString(4, id1);

                int filasNuevas = st.executeUpdate();

                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

}
