/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Person;

/**
 * FXML Controller class
 *
 * @author thepu
 */
public class FXMLPersonaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Stage primaryStage;
    @FXML
    private TextField textfieldFirstName;
    @FXML
    private TextField textfieldLastName;
    @FXML
    private Button buttonAcept;
    @FXML
    private Button buttonCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initStage(Stage stage) {
        primaryStage = stage;
        primaryStage.setTitle("Ventana persona");

    }

    @FXML
    private void PressedAcept(ActionEvent event) {
    }

    @FXML
    private void PressedCancel(ActionEvent event) {
        Node n = (Node) event.getSource();
        n.getScene().getWindow().hide();

    }

    public void initPersona(Person p) {
        if (p != null) {
            this.textfieldFirstName.setText(p.getFirstName());
            this.textfieldLastName.setText(p.getLastName());
        }
    }

}
