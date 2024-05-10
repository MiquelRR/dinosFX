package com.example;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class menuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void exit(ActionEvent event) {
        System.out.println("¡Hasta luego, lukas!");
        Platform.exit();
    }

    @FXML
    void listaDinos(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("tablaDinos.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850 , 505);
        stage.setScene(scene);
        stage.setTitle("DinoDAM : Listado de Dinosaurios");
        stage.show();

    }

    @FXML
    void listaZonas(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("selectorZonas.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850 , 505);
        stage.setScene(scene);
        stage.setTitle("DinoDAM : Consulta de atracciones por zona");
        stage.show();
        //App.setRoot("selectorZonas");
    }

    @FXML
    void nuevaAtraccion(ActionEvent event) throws IOException {
        App.st.setTitle("DinoDAM : Alta atracción");
        App.setRoot("nuevaAtracc");

    }

    @FXML
    void initialize() {
     App.st.setTitle("DinoDAM MiquelRR");
 
    }

}
