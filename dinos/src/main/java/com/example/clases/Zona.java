package com.example.clases;

public class Zona {
    private String nombre;
    private String ubicacion;
    private int num_atracciones;
    public Zona(String nombre, String ubicacion, int num_atracciones) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.num_atracciones = num_atracciones;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public int getNum_atracciones() {
        return num_atracciones;
    }
    public void setNum_atracciones(int num_atracciones) {
        this.num_atracciones = num_atracciones;
    }
    
}
