package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.example.accesdb.Accesdb;

public class DinoCriterias {
    private static HashMap<String, String> charactheristics = new HashMap<>(); //View name -> bbdd name
    static{
        charactheristics.put("Tamaño", "tamanyo");
        charactheristics.put("Alimentacíon", "alimentacion");
        charactheristics.put("Tipo", "tipo");
       }
    
    
    private String type;
    private String filter;
    public DinoCriterias(String type, String filter) {
        this.type = type;
        this.filter = filter;
    }
    public static Set<String> avlCharactheristics(){
        return charactheristics.keySet();
    }
    public static Set<String> avlOpts(String charac){
        String[] tmpArr = Accesdb.lligQuery(String.format(Accesdb.distinctVals, charactheristics.get(charac))).get(0);
       return new HashSet<>(Arrays.asList(tmpArr));
        
    }
}

