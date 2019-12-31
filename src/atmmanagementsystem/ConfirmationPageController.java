/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmmanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class ConfirmationPageController implements Initializable {

    @FXML
    private Label currentAmount;
    @FXML
    private TextField givenAmount;
    
    public String username;

    AtmManagementSystem atmManagementSystem;
    
    public void setAtmManagementSystem(AtmManagementSystem atmManagementSystem) {
        this.atmManagementSystem = atmManagementSystem;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void initial(String username){
        DataBase database = new DataBase();
        currentAmount.setText(Integer.toString(database.getAmount(username)));
    }
    @FXML
    private void confirmAction(ActionEvent event) throws IOException {
        if(Integer.parseInt(givenAmount.getText())>Integer.parseInt(currentAmount.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Insufficient Amount!");
            alert.setHeaderText("");
            alert.showAndWait();
        }else{
            DataBase database = new DataBase();
            database.setAmount(username,Integer.parseInt(currentAmount.getText())-Integer.parseInt(givenAmount.getText()));
            atmManagementSystem.loginPage();
        }
    }

    @FXML
    private void cancelAction(ActionEvent event) throws IOException {
        atmManagementSystem.loginPage();
    }
    
}
