package sample;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Cliente {
    private String nombre;
    private String password;
    private String correo;

    public Cliente() {
    }

    public Cliente(String nombre, String password){
        this.nombre=nombre;
        this.password=password;
    }
    public Cliente(String nombre, String password, String correo){
        this.nombre=nombre;
        this.password=password;
        this.correo=correo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String mostrarUsuario(){
        return nombre;
    }
}
