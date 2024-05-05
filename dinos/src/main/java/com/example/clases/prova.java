package com.example.clases;

public class prova {
    public static void main(String[] args) {
        Dinosaurio rex= new Dinosaurio("rex", "pno","hervivoro ", "oso");
        System.out.println(Dinosaurio.all.size());
        Dinosaurio.addDino(rex);
        System.out.println(rex.getNombre());
        System.out.println(Dinosaurio.all.size());

    }
    
}


