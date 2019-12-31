
package atmmanagementsystem;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AtmManagementSystem extends Application {
    Stage stage;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        loginPage();
    }
    void loginPage() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("LoginPage.fxml"));
        Parent root = loader.load();
        LoginPageController controller = loader.getController();
        controller.setAtmManagementSystem(this);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    void createAccountPage() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CreateAccountPage.fxml"));
        Parent root = loader.load();
        CreateAccountPageController controller = loader.getController();
        controller.setAtmManagementSystem(this);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    void confirmPage(String username) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ConfirmationPage.fxml"));
        Parent root = loader.load();
        ConfirmationPageController controller = loader.getController();
        controller.setAtmManagementSystem(this);
        controller.username=username;
        controller.initial(username);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
