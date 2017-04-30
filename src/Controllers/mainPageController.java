package Controllers;

import Initialization.Main;
import User.User;
import Form.Form;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class mainPageController extends UIController {

    @FXML
    private Button logoutButton, loginButton, submitButton, viewSubmittedButton;
    @FXML
    private ImageView imageView; //TODO: find a good image to set as mainPage image
    @FXML
    private Label loggedUsername;

    /**
     * Initialize mainPage.fxml
     */
    public void start(Main main) {
        this.main = main;
        if(main.getUser().getUid() != null) {
            loggedUsername.setText(main.getUser().getUsername());
        } else {
            loggedUsername.setText("Not logged in");
        }
        setActionOnEnter();
        // If not logged in, hide logoutButton, show it otherwise
        if(super.main.getUser().getUid() == null) {
            logoutButton.setVisible(false);
            loginButton.setVisible(true);
            loginButton.setLayoutY(350);
            submitButton.setVisible(false);
            viewSubmittedButton.setVisible(false);
        } else {
            logoutButton.setVisible(true);
            loginButton.setVisible(false);
            submitButton.setVisible(true);
            viewSubmittedButton.setVisible(true);
        }
    }

    /**
     * Allows ENTER key press when focused on password text field to call loginAction.
     * Allows ENTER key press when focused on loginButton to fire loginAction.
     */
    private void setActionOnEnter() {
        loginButton.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if(event.getCode() == KeyCode.ENTER) {
                loginButton.fire();
                event.consume();
            }
        });
    }

    /**
     * Logout user and refresh page
     */
    @FXML
    private void logoutAction() {
        // Logout user
        super.main.setUser(new User());
        // Refresh page
        start(this.main);
    }

    @FXML
    private void submitAction() throws IOException {
        Stage stage;
        stage=(Stage) submitButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/applicationPage1.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
        applicationController controller = loader.getController();
        controller.start(this.main, 0, new Form());
    }

    /**
     * Redirects to loginPage.fxml
     */
    @FXML
    private void displayLoginPage() throws IOException {
        Stage stage;
        stage=(Stage) loginButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/loginPage.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
        loginPageController controller = loader.getController();
        controller.start(this.main);
    }

    @FXML
    private void displaySubmittedApplications() {
    }

}
