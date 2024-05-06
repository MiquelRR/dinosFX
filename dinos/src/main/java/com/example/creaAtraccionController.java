package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.clases.Atraccion;
import com.example.clases.Dinosaurio;
import com.example.clases.Zona;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class creaAtraccionController {
    Boolean valid = true;

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
            App.setRoot("menuDinos");
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("DinoDAM Alert System");
            alert.setContentText(
                    String.format("cap %d min %d nom %s zona %s dino %s", capacidad, minima, nombre, zona, dino));
            // alert.setContentText("Es necesario asignar zona y/o comprueba cantidades");
            alert.setHeaderText("Faltan datos o no son correctos");
            alert.showAndWait();
        }
    }

    @FXML
    void testFields(KeyEvent event) {
        String capT = cap.getText();
        String minT = min.getText();
        boolean v1 = false;
        if (capT != null) {
            // parse no da error pues se hace despues de la regex
            if (capT.matches("[0-9]+") && Integer.parseInt(capT) < 101) {
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
            if (minT.matches("[0-9]+") && Integer.parseInt(minT) < 19) {
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
        capLabel.setVisible(false);
        minLabel.setVisible(false);
        dinoChoice.getItems().addAll(Dinosaurio.getDinosNames());
        zonaChoice.getItems().addAll(Zona.getZonasNames());

    }

}