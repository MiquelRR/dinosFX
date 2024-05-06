package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class zonasController {

    /// home/miquel/prog_exercices/dinosFX/dinos/src/main/java/com/example/images/mapa_bn.png
    private Image nord = new Image(getClass().getResourceAsStream("images/mapa_norte.png"));
    private Image sur = new Image(getClass().getResourceAsStream("images/mapa_sur.png"));
    private Image este = new Image(getClass().getResourceAsStream("images/mapa_este.png"));
    private Image oeste = new Image(getClass().getResourceAsStream("images/mapa_oeste.png"));
    private Image grey = new Image(getClass().getResourceAsStream("images/mapa_bn.png"));

    @FXML
    private Button back_button;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView map;

    @FXML
    private Hyperlink east;

    @FXML
    private Hyperlink north;

    @FXML
    private Hyperlink south;

    @FXML
    private Hyperlink west;

    @FXML
    void selectZone(ActionEvent event) {
       if(event.equals(east)) System.out.println("+".repeat(300));;

    }

    @FXML
    void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) back_button.getScene().getWindow();
        stage.close();
    }


    @FXML
    void showEast(MouseEvent event) {
        map.setImage(este);
    }

   

    @FXML
    void showGrey(MouseEvent event) {
        // map.setImage(grey);
    }

    @FXML
    void showNord(MouseEvent event) {
        map.setImage(nord);
    }

    @FXML
    void showSouth(MouseEvent event) {
        map.setImage(sur);

    }

    @FXML
    void showWest(MouseEvent event) {
        map.setImage(oeste);
    }

    @FXML
    void initialize() {
        // showGrey(null);

    }

}
