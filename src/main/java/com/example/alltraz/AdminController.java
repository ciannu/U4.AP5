package com.example.alltraz;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import com.example.model.DataBase;
import com.example.model.Empresa;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminController implements Initializable {
    @javafx.fxml.FXML
    private TextField txFiltrarEmpresa;
    @javafx.fxml.FXML
    private TextField txFiltrarCliente;
    @javafx.fxml.FXML
    private Button modificar;
    @javafx.fxml.FXML
    private Button agregar;
    @javafx.fxml.FXML
    private Button eliminar;
    @javafx.fxml.FXML
    private TableColumn ID;
    @javafx.fxml.FXML
    private TableColumn tipo;
    @javafx.fxml.FXML
    private TableColumn Nombre;
    @javafx.fxml.FXML
    private TableColumn Identificacion;
    @javafx.fxml.FXML
    private TableColumn Password;
    @javafx.fxml.FXML
    private TableView<Empresa> tabla;
    private Empresa empresa;
    @javafx.fxml.FXML
    private AnchorPane rootPane;


    public void initialize(URL url, ResourceBundle rb) {
        llenarTabla();
    }

    public ObservableList<Empresa> getEmpresas() {
        var sql = "Select * From empresa";
        ObservableList<Empresa> empresasList = FXCollections.observableArrayList();

        try {
            DataBase db = new DataBase();
            Connection connexion = db.obtenerConexion();
            PreparedStatement st = db.obtenerConexion().prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Integer id_ = Integer.valueOf(rs.getString("Id_empresa"));
                String tip = rs.getString("Tipo");
                String ne = rs.getString("NombreEmpresa");
                String cif = rs.getString("Cif");
                String pas = rs.getString("Contraseña");
                Empresa e = new Empresa( id_,tip,ne,cif,pas);
                empresasList.add(e);

            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empresasList;
    }

    public void llenarTabla(){
        ObservableList<Empresa>lista = getEmpresas();

        for (Empresa list: lista) {
            System.out.println(list.getUsername_empresa() + list.getTipo() + list.getID() + list.getCif() + list.getPassword_empresa());
        }


        this.ID.setCellValueFactory(new PropertyValueFactory("ID"));
        this.tipo.setCellValueFactory(new PropertyValueFactory("tipo"));
        this.Nombre.setCellValueFactory(new PropertyValueFactory("username_empresa"));
       this.Identificacion.setCellValueFactory(new PropertyValueFactory("cif"));
       this.Password.setCellValueFactory(new PropertyValueFactory("password_empresa"));

       /* this.ID.setCellValueFactory(new PropertyValueFactory("id"));
        this.tipo.setCellValueFactory(new PropertyValueFactory("tipo"));
        this.Nombre.setCellValueFactory(new PropertyValueFactory("username"));
        this.Identificacion.setCellValueFactory(new PropertyValueFactory("cif"));
        this.Password.setCellValueFactory(new PropertyValueFactory("pass"));
*/
        ObservableList<Empresa> p = FXCollections.observableArrayList();

       // p.add(new Empresa2(1,"cif","u","n","p"));

        tabla.setItems(lista);
    }
    @javafx.fxml.FXML
    public void modificar_persona(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("VentanaModificar-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void agregar_persona(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("VentanaAgregar-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @javafx.fxml.FXML
    public void eliminar_persona(ActionEvent actionEvent) {
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("VentanaEliminar-View.fxml"));
            this.rootPane.getChildren().setAll(pane);

        } catch (IOException ex) {
            Logger.getLogger(com.example.alltraz.HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
