package com.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    static Connection conexion=null;

    public Connection obtenerConexion(){
        if(conexion==null){
            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/alltraz", "root", "12345");

            }catch (SQLException e){
                e.printStackTrace();
                return null;
            }
        }
        return conexion;
    }

    public void cerrarConexion(){
        if(conexion !=null){
            try {
                conexion.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }
}
