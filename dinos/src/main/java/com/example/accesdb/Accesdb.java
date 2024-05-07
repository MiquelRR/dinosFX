package com.example.accesdb;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Accesdb {

    private final static String bdcon = "jdbc:mysql://localhost:3306/JurassicPark";
    //private final static String bdcon = "jdbc:mysql://localhost:33006/JurassicPark";
    private final static String us = "root";
    private final static String pw = "root";
   
    public final static String distinctVals = "SELECT DISTINCT %d FROM Dinosaurio;";

    //public final static String addEmployee="INSERT INTO empleados (nombre, apellidos, telefono, cargo) VALUES ('-', '-', '-', '-', '-');";
    public static Scanner sc = new Scanner(System.in);

    public static void modifica(String query){
        try {
            Connection con = DriverManager.getConnection(bdcon, us, pw);
            Statement st = con.createStatement();
            st.executeUpdate(query);
            con.close();
        } catch (SQLException e) {
            System.out.println("Error en la bd -modifica-: \n"+query+ "\n" + e.getErrorCode() + "-" + e.getMessage());
            sc.nextLine();
        }

    }
    public static String lligString(String query){
        return lligReg(query)[0];
    }

    public static String[] lligReg(String query) { // retorna el primer registre d'una consulta
        String[] eixida = null;
        try {
            
            Connection con = DriverManager.getConnection(bdcon, us, pw);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            int cols = rs.getMetaData().getColumnCount();
            eixida = new String[cols];
            if (rs.next()) {
                for (int i = 0; i < eixida.length; i++) {
                    eixida[i] = rs.getString(i + 1);
                }
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(query);
            System.out.println("Error en la bd -lligReg-: " + e.getErrorCode() + "-" + e.getMessage());
            sc.nextLine();
        }
        
        return eixida;
    }

    public static int agrega(String taula, Object[] camp_valor_camp2_valor2_) {
        // agrega a la bbdd en la taula l'objecte {camp,1, valor1, camp2, valor2....}
        boolean clau = true;
        String taules = "";
        String valors = "";
        String sep = "";
        for (Object object : camp_valor_camp2_valor2_) {
            if (clau) {
                taules += object + ",";
            } else {
                sep = (object instanceof String) ? "'" : "";
                valors += sep + object + sep + ",";
            }
            clau = !clau;
        }
        taules = taules.substring(0, taules.length() - 1); // fora última ','
        valors = valors.substring(0, valors.length() - 1);
        String query = "INSERT INTO " + taula + " (" + taules + ") VALUES (" + valors + ");";
        int idInsertat = -1;
        try {
            Connection con = DriverManager.getConnection(bdcon, us, pw);
            Statement st = con.createStatement();
            st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                idInsertat = rs.getInt(1); // Obtener el valor de la clave generada
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(query);
            System.out.println("Error en la bd -agrega-: " + e.getErrorCode() + "-" + e.getMessage());
            return 0;

        }
        return idInsertat;

    }

    public static List<String[]> lligTaula(String taula) { // retorna la taula d'una consulta
        List<String[]> eixida = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(bdcon, us, pw);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + taula);
            int cols = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                String[] registre = new String[cols];
                for (int i = 0; i < registre.length; i++) {
                    registre[i] = rs.getString(i + 1);
                }
                eixida.add(registre);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("SELECT * FROM " + taula);
            System.out.println("Error en la bd -lligTaula- : " + e.getErrorCode() + "-" + e.getMessage());
            sc.nextLine();
        }
        return eixida;
    }
    public static List<Integer> lligQuery2Integers(String query){
        List<Integer> eixida= new ArrayList<>();
        List<String[]> l=lligQuery(query);
        try {
            for (String[] str : l) {
                eixida.add(Integer.parseInt(str[0]));            
            }
        } catch (Exception e) {
            System.out.println(query);
            System.out.println("Error obtenint una lllista de Integer a partir de la query");
        }
        
        return eixida;
    }

    public static List<String[]> lligQuery(String query) { // retorna la taula d'una consulta
        List<String[]> eixida = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(bdcon, us, pw);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            int cols = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                String[] registre = new String[cols];
                for (int i = 0; i < registre.length; i++) {
                    registre[i] = rs.getString(i + 1);
                }
                eixida.add(registre);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(query);
            System.out.println("Error en la bd -lligQuery-: " + e.getErrorCode() + "-" + e.getMessage());
            sc.nextLine();
        }
        return eixida;
    }

    public static Integer toInt(String entrada) { // vull deixar el tractament d'errors agrupat
        Integer eixida = null;
        try {
            eixida = Integer.parseInt(entrada);
        } catch (ClassCastException e) {
            //System.out.println("Error en convertir <" + entrada + "> en tipus Integer -" + e.getMessage());
           //sc.nextLine();
           return null;
        }
        return eixida;
    }

}