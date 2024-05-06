package com.example;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
    void exit(MouseEvent event) {
        
    }

    @FXML
    void listaDinos(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("tablaDinos.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850 , 505);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void listaZonas(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("selectorZonas.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850 , 505);
        stage.setScene(scene);
        stage.show();
        //App.setRoot("selectorZonas");
    }

    @FXML
    void nuevaAtraccion(ActionEvent event) throws IOException {
        App.setRoot("nuevaAtracc");

    }

    @FXML
    void initialize() {

    }

}
