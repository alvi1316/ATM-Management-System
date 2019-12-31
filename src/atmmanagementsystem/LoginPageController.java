
package atmmanagementsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


public class LoginPageController implements Initializable {
    
    AtmManagementSystem atmManagementSystem;

    @FXML
    private TextField username;
    @FXML
    private TextField password;

    public void setAtmManagementSystem(AtmManagementSystem atmManagementSystem) {
        this.atmManagementSystem = atmManagementSystem;
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void loginAction(ActionEvent event) throws IOException {
        DataBase database = new DataBase();
        if(database.checkUsernamePassword(username.getText(), password.getText())){
            atmManagementSystem.confirmPage(username.getText());
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText("Please give the username and password properly.");
            alert.showAndWait();
        }
        
    }

    @FXML
    private void createAccountAction(ActionEvent event) throws IOException {
        atmManagementSystem.createAccountPage();
        
    }
    
}
