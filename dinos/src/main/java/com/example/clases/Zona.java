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
    public static List<String> getZonasNames(){
        List<String> lista = new ArrayList<>();
        for (Zona z : Zona.all.values()) {
            lista.add(z.nombre);
        }
        return lista;
    }
    public static Zona getZonaFromName(String name){
        for (Zona z : Zona.all.values()) {
            if(z.getNombre().equals(name)) return z;
        }
        return null;

    }
   

    public static void addZona(Zona zona){
        Integer max = Zona.all.keySet().stream()
                                 .mapToInt(Integer::intValue)
                                 .max()
                                 .orElse(0);
        max++;
        Zona.all.put(max,zona);
        Accesdb.agrega("Zona",new Object[] {
            "id_zona",max,
            "nombre",zona.getNombre(),
            "ubicacion",zona.getUbicacion()});

    }

    public static Integer getIdByCardinalName(String zonaString){
        for( Integer id : Zona.all.keySet()) {
            /* System.out.println(">".repeat(50)+zonaString+"/"+Zona.all.get(id).getUbicacion()); */
            if (Zona.all.get(id).getUbicacion().equals(zonaString)) return id;

        }
        return 1;
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
