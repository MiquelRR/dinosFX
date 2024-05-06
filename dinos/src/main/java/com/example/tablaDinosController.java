package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

public class tablaDinosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<?> alChoice;

    @FXML
    private Button back_button;

    @FXML
    private TableColumn<?, ?> foodCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> sizeCol;

    @FXML
    private ChoiceBox<?> tamChoice;

    @FXML
    private ChoiceBox<?> tipoChoice;

    @FXML
    private TableColumn<?, ?> typeCol;

    @FXML
    void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) back_button.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert alChoice != null : "fx:id=\"alChoice\" was not injected: check your FXML file 'tablaDinos.fxml'.";
        assert back_button != null : "fx:id=\"back_button\" was not injected: check your FXML file 'tablaDinos.fxml'.";
        assert foodCol != null : "fx:id=\"foodCol\" was not injected: check your FXML file 'tablaDinos.fxml'.";
        assert nameCol != null : "fx:id=\"nameCol\" was not injected: check your FXML file 'tablaDinos.fxml'.";
        assert sizeCol != null : "fx:id=\"sizeCol\" was not injected: check your FXML file 'tablaDinos.fxml'.";
        assert tamChoice != null : "fx:id=\"tamChoice\" was not injected: check your FXML file 'tablaDinos.fxml'.";
        assert tipoChoice != null : "fx:id=\"tipoChoice\" was not injected: check your FXML file 'tablaDinos.fxml'.";
        assert typeCol != null : "fx:id=\"typeCol\" was not injected: check your FXML file 'tablaDinos.fxml'.";

    }

}
