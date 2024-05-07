package com.example.clases;

import java.util.HashMap;

import com.example.accesdb.Accesdb;

public class Atraccion {
    public static HashMap<Integer, Atraccion> all = new HashMap<>();
    static {
        for (String[] reg : Accesdb.lligTaula("Atraccion")) {
            Dinosaurio dino = (reg[2] == null) ? null : Dinosaurio.all.getOrDefault((Integer.parseInt(reg[2])), null);
            Atraccion atr = new Atraccion(
                    reg[3],
                    dino,
                    Integer.parseInt(reg[4]),
                    Integer.parseInt(reg[5]),
                    Zona.all.get(Integer.parseInt(reg[1])));
            all.put(Integer.parseInt(reg[0]), atr);
        }
    }

    // sobrecàrrega del metod
    public static void addAtraccion(String nombre, String zona, int capacidad, int edad_min) {
        Atraccion atr;
        atr = new Atraccion(nombre, capacidad, edad_min, Zona.getZonaFromName(zona));
        addAtraccion(atr);
    };

    // sobrecàrrega del metod
    public static void addAtraccion(String nombre, String dino, String zona, int capacidad, int edad_min) {
        Atraccion atr;
        if (dino != null)
            atr = new Atraccion(nombre, Dinosaurio.getDinoFromName(dino), capacidad, edad_min,
                    Zona.getZonaFromName(zona));
        else
            atr = new Atraccion(nombre, capacidad, edad_min, Zona.getZonaFromName(zona));
        addAtraccion(atr);
    };

    public static String getReportAtractionsOfZone(String zoneCardinalName) {
        int idZona = Zona.getIdByCardinalName(zoneCardinalName);
        Zona zone = Zona.all.get(idZona);
        String nameZona = Zona.all.get(idZona).getNombre();
        String report="";
        /* report = "Zona '" + nameZona + "' situada al " + zoneCardinalName + "\n";
        report += "-".repeat(report.length()) + "\n"; */
        for (Atraccion atr : Atraccion.all.values()) {
            if (atr.zona.equals(zone)) {
                report += "'" + atr.nombre + "' capac.: " + atr.capacidad + " edad >" + atr.edad;
                if (atr.dino != null)
                    report += " dino : " + atr.dino.getNombre() + "\n";
                else
                    report += "\n";
            }
        }
        return report;
    }

    public static void addAtraccion(Atraccion atr) {
        Integer max = Atraccion.all.keySet().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        max++;
        Atraccion.all.put(max, atr);

        if (atr.dino == null) {
            Accesdb.agrega("Atraccion", new Object[] {
                    "id_atraccion", max,
                    "id_zona", atr.getZona().getUbicacionId(),
                    "nombre", atr.getNombre(),
                    "capacidad", atr.getCapacidad(),
                    "edad_minima", atr.getEdad() });
        } else {
            Accesdb.agrega("Atraccion", new Object[] {
                    "id_atraccion", max,
                    "id_zona", atr.getZona().getUbicacionId(),
                    "id_dino", atr.getDino().getDinoId(),
                    "nombre", atr.getNombre(),
                    "capacidad", atr.getCapacidad(),
                    "edad_minima", atr.getEdad() });
        }

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
        this.dino = null;
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

    public static void asignarZona(Zona zona, Atraccion atrac) {
        zona.addAtraccion(atrac);
    }

}
