/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Person;

/**
 * FXML Controller class
 *
 * @author thepu
 */
public class FXMLDocumentController implements Initializable {
    private Person p;
    private ObservableList<Person> myData;
    private ArrayList<Person> misdatos = new ArrayList<Person>();

    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonMod;
    @FXML
    private Button buttonDel;
    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myData = FXCollections.observableArrayList(misdatos);
        myData.add(new Person("John", "Doe"));
        myData.add(new Person("Jane", "Doe"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("LastName"));
//        
        tableView.setItems(myData);

        //Desactivar botones de modificacion y borrado
        this.buttonDel.setDisable(true);
        this.buttonMod.setDisable(true);

        //Oyentes
        tableView.getSelectionModel().selectedIndexProperty().addListener((o, oldval, newval) -> {
            if (newval.intValue() == -1) {
                this.buttonDel.setDisable(true);
                this.buttonMod.setDisable(true);
            } else {
                this.buttonDel.setDisable(false);
                this.buttonMod.setDisable(false);
            }

        });
        

    }

    @FXML
    private void PressedAddMod(ActionEvent event) {
        String text = ((Button)event.getSource()).getText();
        if(text.equals("Modificar")){
            p = this.tableView.getSelectionModel().getSelectedItem();
        try{
            Stage stageActual = new Stage();
            FXMLLoader miCargador = new FXMLLoader(getClass().getResource("/view/FXMLPersona.fxml"));
            Parent root = (Parent)miCargador.load();
            //DatosPersonaControlador controladorPersona =
            miCargador.<FXMLPersonaController>getController().initPersona(p);
            //controladorPersona.initPersona(p);
            Scene scene = new Scene(root);
            stageActual.setScene(scene);
            stageActual.initModality(Modality.APPLICATION_MODAL);
            stageActual.show();
            
        }catch(IOException e){
            e.printStackTrace();
        }
        }

    }

    @FXML
    private void PressedDel(ActionEvent event) {
    }

}
