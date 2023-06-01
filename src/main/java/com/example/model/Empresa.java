package com.example.model;

import java.time.LocalDate;

public class Empresa {
    private Integer ID;
    private String tipo;
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

    public Integer getID() {
        return this.ID;
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

    public static class Producto {

        private int id_producto;
        private String lote;
        private String caracteristicas;
        private LocalDate fsal;
        private LocalDate flleg;
        private LocalDate fcos;
        private LocalDate fplant;

        public Producto(String lote, String caracteristicas, LocalDate fsal, LocalDate flleg, LocalDate fcos, LocalDate fplant) {
            this.id_producto = id_producto;
            this.lote = lote;
            this.caracteristicas = caracteristicas;
            this.fsal = fsal;
            this.flleg = flleg;
            this.fcos = fcos;
            this.fplant = fplant;
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

        public String getCaracteristicas() {
            return caracteristicas;
        }

        public void setCaracteristicas(String caracteristicas) {
            this.caracteristicas = caracteristicas;
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
    }
}
