package com.example.clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.accesdb.Accesdb;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Dinosaurio {
    public static HashMap<Integer, Dinosaurio> all = new HashMap<>();
    static {
        for (String[] reg : Accesdb.lligTaula("Dinosaurio")) {
            Dinosaurio dino = new Dinosaurio(reg[1], reg[2], reg[3], reg[4]);
            all.put(Integer.parseInt(reg[0]), dino);
        }
    }

    public static List<String> getDinosNames() {
        List<String> nameList = new ArrayList<String>();
        for (Dinosaurio dino : Dinosaurio.all.values()) {
            nameList.add(dino.getNombre());
        }
        return nameList;
    }
    
    public static Set<String> getSizes() {
        Set<String> retSet = new HashSet<String>();
        for (Dinosaurio dino : Dinosaurio.all.values()) {
            retSet.add(dino.getTamano());
        }
        return retSet;
    }

    public static Set<String> getFeeding() {
        Set<String> retSet = new HashSet<String>();
        for (Dinosaurio dino : Dinosaurio.all.values()) {
            retSet.add(dino.getAlimentacion());
        }
        return retSet;
    }
    public static Set<String> getDinoTypes() {
        Set<String> retSet = new HashSet<String>();
        for (Dinosaurio dino : Dinosaurio.all.values()) {
            retSet.add(dino.getTipo());
        }
        return retSet;
    }

    public static Dinosaurio getDinoFromName(String dinoname) {
        for (Dinosaurio dino : Dinosaurio.all.values()) {
            if (dino.nombre.getValue().equals(dinoname))
                return dino;
        }
        return null;
    }
    

    public static Integer getIdFromName(String name) {
        for (Integer id : Dinosaurio.all.keySet()) {
            if (Dinosaurio.all.get(id).nombre.getValue().equals(name))
                return id;
        }
        return null;
    }

    public Dinosaurio(String nombre, String tamano, String alimentacion, String tipo) {
        this.setNombre(nombre);
        this.setTamano(tamano);
        this.setAlimentacion(alimentacion);
        this.setTipo(tipo);
    }

    public static void addDino(Dinosaurio dino) {
        Integer max = Dinosaurio.all.keySet().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        max++;
        Dinosaurio.all.put(max, dino);
        Accesdb.agrega("Dinosaurio", new Object[] {
                "id_dino", max,
                "nombre", dino.getNombre(),
                "tamanyo", dino.getTamano(),
                "alimentacion", dino.getAlimentacion(),
                "tipo", dino.getTipo() });

    }

    public Integer getDinoId() {
        Integer found = null;
        for (Integer id : Zona.all.keySet()) {
            if (Dinosaurio.all.get(id) == this) {
                found = id;
                break;
            }
        }
        return found;
    }

    private StringProperty nombre;

    public void setNombre(String value) {
        nombreProperty().set(value);
    }

    public String getNombre() {
        return nombreProperty().get();
    };

    public StringProperty nombreProperty() {
        if (nombre == null)
            nombre = new SimpleStringProperty(this, "nombre");
        return nombre;
    }

    private StringProperty tamano;

    public void setTamano(String value) {
        tamanoProperty().set(value);
    }

    public String getTamano() {
        return tamanoProperty().get();
    };

    public StringProperty tamanoProperty() {
        if (tamano == null)
            tamano = new SimpleStringProperty(this, "tamano");
        return tamano;
    }

    private StringProperty alimentacion;

    public void setAlimentacion(String value) {
        alimentacionProperty().set(value);
    }

    public String getAlimentacion() {
        return alimentacionProperty().get();
    };

    public StringProperty alimentacionProperty() {
        if (alimentacion == null)
            alimentacion = new SimpleStringProperty(this, "alimentacion");
        return alimentacion;
    }

    private StringProperty tipo;

    public void setTipo(String value) {
        tipoProperty().set(value);
    }

    public String getTipo() {
        return tipoProperty().get();
    };

    public StringProperty tipoProperty() {
        if (tipo == null)
            tipo = new SimpleStringProperty(this, "tipo");
        return tipo;
    }

   
  /*   public static ObservableList<Dinosaurio> getAllDinos(){
        ObservableList<Dinosaurio> dinoList = FXCollections.observableArrayList();
        for (Dinosaurio dino : Dinosaurio.all.values()) {
            dinoList.add(new Dinosaurio(dino.getNombre(), dino.getTipo(), dino.getTamano(), dino.getAlimentacion())); 
            System.out.println(dino.getNombre()+dino.getTipo()+ dino.getTamano()+ dino.getAlimentacion());           
        }
        return dinoList;
    } */

    public static ObservableList<Dinosaurio> getAllDinos(){
        ObservableList<Dinosaurio> dinoList = FXCollections.observableArrayList();
        for (Dinosaurio dino : Dinosaurio.all.values()) {
            dinoList.add(dino);           
        }
        return dinoList;
    }

    public static ObservableList<Dinosaurio> getSomeDinos(String size, String feed, String type){
        ObservableList<Dinosaurio> dinoList = FXCollections.observableArrayList();
        for (Dinosaurio dino : Dinosaurio.all.values()) {
            boolean cond =
                (size == null || size.equals(dino.getTamano())) &&
                (feed == null || feed.equals(dino.getAlimentacion())) &&
                (type == null || type.equals(dino.getTipo()));

            if(cond) dinoList.add(dino);           
        }
        return dinoList;
    }





}