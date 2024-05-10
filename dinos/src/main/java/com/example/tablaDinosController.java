package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.clases.Dinosaurio;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class tablaDinosController {
    static ObservableList<Dinosaurio> lista;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> alChoice;

    @FXML
    private ChoiceBox<String> tamChoice;

    @FXML
    private ChoiceBox<String> tipoChoice;

    @FXML
    private Button back_button;

    @FXML
    private Button refresh_button;

    @FXML
    void filterTable() {
        lista=Dinosaurio.getSomeDinos(tamChoice.getValue(),alChoice.getValue(),tipoChoice.getValue());
        dinoTable.setItems(lista);
        refresh_button.setVisible(tamChoice.getValue()!=null || alChoice.getValue()!=null || tipoChoice.getValue()!=null);
        
    }

    @FXML
    private TableView<Dinosaurio> dinoTable;

    @FXML
    private TableColumn<Dinosaurio, String> foodCol;

    @FXML
    private TableColumn<Dinosaurio, String> nameCol;

    @FXML
    private TableColumn<Dinosaurio, String> sizeCol;

    @FXML
    private TableColumn<Dinosaurio, String> typeCol; 

    @FXML
    void back(ActionEvent event) throws IOException {
        Stage stage = (Stage) back_button.getScene().getWindow();
        stage.close();
    }

    @FXML
    void resetFilters(ActionEvent event){
        tamChoice.setValue(null);
        alChoice.setValue(null);
        tipoChoice.setValue(null);
        refresh_button.setVisible(false);
    }

    
    @FXML
    void initialize() {
        tamChoice.getItems().add(null);
        tamChoice.getItems().addAll(Dinosaurio.getSizes());
        alChoice.getItems().add(null);
        alChoice.getItems().addAll(Dinosaurio.getFeeding());
        tipoChoice.getItems().add(null);
        tipoChoice.getItems().addAll(Dinosaurio.getDinoTypes());
        refresh_button.setVisible(false);
        lista= Dinosaurio.getAllDinos();
        dinoTable.setItems(lista);
        nameCol.setCellValueFactory(new PropertyValueFactory<Dinosaurio,String>("nombre"));
        typeCol.setCellValueFactory(new PropertyValueFactory<Dinosaurio,String>("tipo"));
        sizeCol.setCellValueFactory(new PropertyValueFactory<Dinosaurio,String>("tamano"));
        foodCol.setCellValueFactory(new PropertyValueFactory<Dinosaurio,String>("alimentacion"));
        
    }

}
