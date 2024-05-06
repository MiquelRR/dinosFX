package com.example.clases;

import java.util.HashMap;

import com.example.accesdb.Accesdb;

public class Atraccion {
    public static HashMap<Integer,Atraccion> all = new HashMap<>();
    static {
        for (String[] reg : Accesdb.lligTaula("Atraccion")) {
            Atraccion atr = new Atraccion(
                reg[3],
            Dinosaurio.all.get((Integer.parseInt(reg[2]))),
            Integer.parseInt(reg[4]),
            Integer.parseInt(reg[5]),
            Zona.all.get(Integer.parseInt(reg[1]))
            );
            all.put(Integer.parseInt(reg[0]),atr);
        }
    }

    //sobrecàrrega del metod
    public static void addAtraccion(String nombre, String zona, int capacidad, int edad_min) {
        Atraccion atr;
        atr=new Atraccion(nombre, capacidad, edad_min, Zona.getZonaFromName(zona));
        addAtraccion(atr);
    };

    //sobrecàrrega del metod
    public static void addAtraccion(String nombre, String dino, String zona, int capacidad, int edad_min) {
        Atraccion atr;
        if (dino!=null)
        atr=new Atraccion(nombre, Dinosaurio.getDinoFromName(dino), capacidad, edad_min, Zona.getZonaFromName(zona));
        else atr=new Atraccion(nombre, capacidad, edad_min, Zona.getZonaFromName(zona));
        addAtraccion(atr);
    };

    public static void addAtraccion(Atraccion atr){
        Integer max = Atraccion.all.keySet().stream()
                                 .mapToInt(Integer::intValue)
                                 .max()
                                 .orElse(0);
        max++;
        Atraccion.all.put(max,atr);
        /* int dinoId;
        if (atr.dino==null){
            dinoId=0;
        } else {
            dinoId=atr.getDino().getDinoId();
        } */
        int dinoId=(atr.dino==null)?0:atr.getDino().getDinoId();
        Accesdb.agrega("Atraccion",new Object[] {
            "id_atraccion",max,
            "id_zona",atr.getZona().getUbicacionId(),
            "id_dino",dinoId,
            "nombre",atr.getNombre(),
            "capacidad",atr.getCapacidad(),
            "edad_minima",atr.getEdad()});
        
    }
    private String nombre;
    private Dinosaurio dino;
    private int capacidad;
    private int edad;
    private Zona zona;
    public Atraccion(String nombre, Dinosaurio dino, int capacidad, int edad, Zona zona) {
        this.nombre = nombre;
        this.dino = dino;
        this.capacidad = capacidad;
        this.edad = edad;
        this.zona = zona;
    }
    public Atraccion(String nombre, int capacidad, int edad, Zona zona) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.edad = edad;
        this.zona = zona;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Dinosaurio getDino() {
        return dino;
    }
    public void setDino(Dinosaurio dino) {
        this.dino = dino;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public Zona getZona() {
        return zona;
    }
    public void setZona(Zona zona) {
        this.zona = zona;
    }
    public static void asignarDino(Dinosaurio dino, Atraccion atrac) {
        atrac.setDino(dino);
    }
    
    public static void asignarZona(Zona zona, Atraccion atrac){
        zona.addAtraccion(atrac);
    }
    
}
