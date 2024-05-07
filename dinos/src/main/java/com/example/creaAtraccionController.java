package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.example.clases.Atraccion;
import com.example.clases.Dinosaurio;
import com.example.clases.Zona;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class creaAtraccionController {
    Boolean valid;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField cap;

    @FXML
    private Label capLabel;

    @FXML
    private Label minLabel;

    @FXML
    private TextField min;

    @FXML
    private TextField name;

    @FXML
    private ChoiceBox<String> zonaChoice;

    @FXML
    private ChoiceBox<String> dinoChoice;

    @FXML
    void guarda(ActionEvent event) throws IOException {
        int capacidad = 0, minima = 0;
        if (valid) {
            capacidad = Integer.parseInt(cap.getText());
            minima = Integer.parseInt(min.getText());
        }

        String nombre = name.getText();
        valid = valid && nombre.length() > 0;

        String zona = zonaChoice.getValue();
        valid = valid && zona.length() > 0;

        String dino = dinoChoice.getValue();
        // en requisitos, se puede hacer una atraccion sin dino
        if (valid) {
            if (dino != null) {
                Atraccion.addAtraccion(nombre, dino, zona, capacidad, minima);
            } else {
                Atraccion.addAtraccion(nombre, zona, capacidad, minima);
            }
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("DinoDAM Alert System");
            alert.setHeaderText("Atraccion '"+nombre+"' agregada correctamente");
            String dinoname= (dino==null)?"ninguno":dino;
            alert.setContentText("Zona "+zona+" dino : "+dinoname);
            alert.showAndWait();
            App.setRoot("menuDinos");
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("DinoDAM Alert System");
            alert.setContentText("Es necesario asignar zona y/o comprueba cantidades");
            alert.setHeaderText("Faltan datos o no son correctos");
            ButtonType revisar = new ButtonType("Revisar Datos");
            ButtonType cancelar = new ButtonType("Cancelar Alta");
            alert.getButtonTypes().setAll(revisar, cancelar);
            Optional<ButtonType> choosed = alert.showAndWait();
            if (choosed.isPresent()) {
                // if(choosed.get()== revisar){}
                if (choosed.get() == cancelar) {
                    alert = new Alert(AlertType.WARNING);
                    alert.setTitle("DinoDAM Alert System");
                    alert.setHeaderText("No se ha agregado ninguna atracción");
                    alert.setContentText("No se que has hecho todo este rato");
                    alert.showAndWait();
                    App.setRoot("menuDinos");
                }
            }

        }
    }

    @FXML
    void testFields(KeyEvent event) {
        String capT = cap.getText();
        String minT = min.getText();
        boolean v1 = false;
        if (capT != null) {
            // parse no da error pues se hace despues de la regex
            if (capT.matches("^[0-9]+$") && Integer.parseInt(capT) < 101) {
                capLabel.setVisible(false);
                v1 = true;
            } else {
                capLabel.setVisible(true);
                v1 = false;
            }
        } else {
            v1 = false;
            capLabel.setVisible(false);
        }

        boolean v2 = false;
        if (minT != null) {
            if (minT.matches("^[0-9]+$") && Integer.parseInt(minT) < 19) {
                minLabel.setVisible(false);
                v2 = true;
            } else {
                minLabel.setVisible(true);
                v2 = false;
            }
        } else {
            capLabel.setVisible(false);
            v2 = false;
            ;
        }
        valid = v1 && v2;

    }

    @FXML
    void initialize() {
        valid = false;
        capLabel.setVisible(false);
        minLabel.setVisible(false);
        dinoChoice.getItems().addAll(Dinosaurio.getDinosNames());
        zonaChoice.getItems().addAll(Zona.getZonasNames());

    }

}