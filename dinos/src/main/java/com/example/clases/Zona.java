package com.example.clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.accesdb.Accesdb;

public class Zona {
    public static HashMap<Integer, Zona> all = new HashMap<>();
    static{
        for (String[] reg : Accesdb.lligTaula("Zona")) {
            Zona  z = new Zona(reg[1], reg[2]);
            all.put(Integer.parseInt(reg[0]),z);
        }
    }
    public static void addZona(Zona zona){
        Integer max = Zona.all.keySet().stream()
                                 .mapToInt(Integer::intValue)
                                 .max()
                                 .orElse(0);
        max++;
        Zona.all.put(max,zona);
        Accesdb.agrega("Dinosaurio",new Object[] {
            "id_zona",max,
            "nombre",zona.getNombre(),
            "ubicacion",zona.getUbicacion()});

    }
    
    private String nombre;
    private String ubicacion;
    private List<Atraccion> lista = new ArrayList<>();
    public Zona(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }
    public String toString(){
        return this.nombre;
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
    public Integer getUbicacionId(){
        Integer found=null;
        for (Integer id : Zona.all.keySet()){
            if (Zona.all.get(id)==this){
                found=id;
                break;             
            }
        }
        return found;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public int getNum_atracciones() {
        return this.lista.size();
    }
    public void addAtraccion(Atraccion atr){
        this.lista.add(atr);
    }
}
