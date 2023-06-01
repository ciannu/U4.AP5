package sample;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Empresa {
    private Integer ID;
    private String tipo = "Empresa";
    private String cif;
    private String username_empresa;
    private String password_empresa;


    public Empresa(){}

    public Empresa(String cif, String password_empresa) {
        this.cif = cif;
        this.password_empresa = password_empresa;
    }

    public Empresa(Integer ID, String tipo, String cif, String username_empresa, String password_empresa) {
        this.ID = ID;
        this.tipo = tipo;
        this.cif = cif;
        this.username_empresa = username_empresa;
        this.password_empresa = password_empresa;
    }

    public String getUsername_empresa() {
        return username_empresa;
    }

    public void setUsername_empresa(String username_empresa) {
        this.username_empresa = username_empresa;
    }

    public String getPassword_empresa() {
        return password_empresa;
    }

    public void setPassword_empresa(String password_empresa) {
        this.password_empresa = password_empresa;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public int getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
