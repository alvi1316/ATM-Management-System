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
import javafx.scene.control.TextField;


public class CreateAccountPageController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField password;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField age;
    @FXML
    private TextField nid;
    @FXML
    private TextField address;

    AtmManagementSystem atmManagementSystem;
    
    public void setAtmManagementSystem(AtmManagementSystem atmManagementSystem) {
        this.atmManagementSystem = atmManagementSystem;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void confirmAction(ActionEvent event) throws IOException {
        Users user = new Users(name.getText(),password.getText(),Integer.parseInt(phoneNumber.getText()),Integer.parseInt(nid.getText()),address.getText(),Integer.parseInt(age.getText()));
        DataBase database = new DataBase();
        database.saveToDataBase(user);
        database.createTable(user);
        database.writeDataBase(user);
        atmManagementSystem.loginPage();
    
    }

    @FXML
    private void cancelAction(ActionEvent event) throws IOException {
        atmManagementSystem.loginPage();
    }
    
}
