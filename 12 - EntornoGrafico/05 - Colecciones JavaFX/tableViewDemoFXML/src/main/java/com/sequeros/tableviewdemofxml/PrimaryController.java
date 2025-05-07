/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.sequeros.tableviewdemofxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author jabue
 */
public class PrimaryController implements Initializable {

    @FXML
    private TableView<Country> tableView;
    @FXML
    private TableColumn<Country, String> country;
    @FXML
    private TableColumn<Country, String> capital;
    @FXML
    private TableColumn<Country, Double> population;
    @FXML
    private TableColumn<Country, Boolean> democratic;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<Country> data = FXCollections.observableArrayList(
                new Country("USA", "Washington DC", 280, true),
                new Country("Canada", "Ottawa", 32, true),
                new Country("United Kingdom", "London", 60, true),
                new Country("Germany", "Berlin", 83, true),
                new Country("France", "Paris", 60, true));
        tableView.setItems(data);
        country.setCellValueFactory(new PropertyValueFactory<Country,String>("country"));
        capital.setCellValueFactory(cellData -> cellData.getValue().capitalProperty());
        population.setCellValueFactory(new PropertyValueFactory<Country,Double>("population"));
        democratic.setCellValueFactory(cellData -> cellData.getValue().democraticProperty());
    }

}
