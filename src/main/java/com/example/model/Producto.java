package com.example.model;

import java.time.LocalDate;

public class Producto{

    private int id_producto;
    private String lote, carCos, carPlant, carLleg, carSal;
    private LocalDate fsal;
    private LocalDate flleg;
    private LocalDate fcos;
    private LocalDate fplant;

    public Producto(String lote, LocalDate fplant, String carPlant, LocalDate fcos, String carCos, LocalDate flleg, String carLleg, LocalDate fsal, String carSal) {
        this.id_producto = id_producto;
        this.lote = lote;
        this.fplant = fplant;
        this.carPlant = carPlant;
        this.fcos = fcos;
        this.carCos = carCos;
        this.flleg = flleg;
        this.carLleg = carLleg;
        this.fsal = fsal;
        this.carSal = carSal;
    }

    public Producto(){

    }
    public static Producto carCos(String carCos) {
        Producto producto = new Producto();
        producto.carCos = carCos;
        return producto;
    }

    public static Producto carPlant(String carPlant) {
        Producto producto = new Producto();
        producto.carPlant = carPlant;
        return producto;
    }

    public static Producto carLleg(String carLleg) {
        Producto producto = new Producto();
        producto.carPlant = carLleg;
        return producto;
    }

    public static Producto carSal(String carSal) {
        Producto producto = new Producto();
        producto.carPlant = carSal;
        return producto;
    }
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }


    public LocalDate getFsal() {
        return fsal;
    }

    public void setFsal(LocalDate fsal) {
        this.fsal = fsal;
    }

    public LocalDate getFlleg() {
        return flleg;
    }

    public void setFlleg(LocalDate flleg) {
        this.flleg = flleg;
    }

    public LocalDate getFcos() {
        return fcos;
    }

    public void setFcos(LocalDate fcos) {
        this.fcos = fcos;
    }

    public LocalDate getFplant() {
        return fplant;
    }

    public void setFplant(LocalDate fplant) {
        this.fplant = fplant;
    }
    public String getCarCos() {
        return carCos;
    }

    public void setCarCos(String carCos) {
        this.carCos = carCos;
    }

    public String getCarPlant() {
        return carPlant;
    }

    public void setCarPlant(String carPlant) {
        this.carPlant = carPlant;
    }

    public String getCarLleg() {
        return carLleg;
    }

    public void setCarLleg(String carLleg) {
        this.carLleg = carLleg;
    }

    public String getCarSal() {
        return carSal;
    }

    public void setCarSal(String carSal) {
        this.carSal = carSal;
    }
}