package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.accesdb.Accesdb;

/**
 * JavaFX App
 */
public class App extends Application {

    @SuppressWarnings("exports")
    public static Scene scene;

    @SuppressWarnings("exports") //per a poder modificar el titol
    public static Stage st;
   
    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws IOException {
        st=stage;
        Accesdb.setLogOn(); //activem el log de queries
        scene = new Scene(loadFXML("menuDinos"), 600, 340);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}