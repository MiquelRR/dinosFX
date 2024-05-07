package com.example;

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
    private Image nord = new Image(getClass().getResourceAsStream("images/mapa_norte.png"));
    private Image sur = new Image(getClass().getResourceAsStream("images/mapa_sur.png"));
    private Image este = new Image(getClass().getResourceAsStream("images/mapa_este.png"));
    private Image oeste = new Image(getClass().getResourceAsStream("images/mapa_oeste.png"));
    private Image grey = new Image(getClass().getResourceAsStream("images/mapa_bn.png"));

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_button;

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
    void back(ActionEvent event) {
        Stage stage = (Stage) back_button.getScene().getWindow();
        stage.close();
    }

    @FXML
    void selectZone(ActionEvent event) {
        Hyperlink zone = (Hyperlink) event.getSource();;
        String z=zone.getId();
        
        switch (z) {
            case "east":
                System.out.println("este".repeat(30));
                break;
            case "west":
                System.out.println("oeste".repeat(30));
                break;
            case "north":
                System.out.println("norte".repeat(30));
                break;
            case "south":
                System.out.println("sur".repeat(30));
                break;
            default:
                System.out.println(event.getSource().toString());
                break;
        }

    }

    @FXML
    void show(MouseEvent event) {
        Hyperlink zone = (Hyperlink) event.getSource();;
        String z=zone.getId();
        switch (z) {
            case "east":
                map.setImage(este);
                break;
            case "west":
                map.setImage(oeste);
                break;
            case "north":
                map.setImage(nord);
                break;
            case "south":
                map.setImage(sur);
                break;
            default:
                map.setImage(grey);
                break;
        }
    }

    @FXML
    void showGrey(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert back_button != null
                : "fx:id=\"back_button\" was not injected: check your FXML file 'selectorZonas.fxml'.";
        assert east != null : "fx:id=\"east\" was not injected: check your FXML file 'selectorZonas.fxml'.";
        assert map != null : "fx:id=\"map\" was not injected: check your FXML file 'selectorZonas.fxml'.";
        assert north != null : "fx:id=\"north\" was not injected: check your FXML file 'selectorZonas.fxml'.";
        assert south != null : "fx:id=\"south\" was not injected: check your FXML file 'selectorZonas.fxml'.";
        assert west != null : "fx:id=\"west\" was not injected: check your FXML file 'selectorZonas.fxml'.";

    }

}
