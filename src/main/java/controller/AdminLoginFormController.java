package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;

import javax.print.attribute.standard.Media;
import java.io.IOException;
import java.net.URL;

public class AdminLoginFormController {
    static int attempt=3;
    public PasswordField txtPassword;
    private static final String ADMIN_PASSWORD = "DEP9@admin";

    public void txtPAsswordOnAction(ActionEvent actionEvent) throws IOException {
        if (txtPassword.getText().equals(ADMIN_PASSWORD)){

            if (attempt==0){
                new Alert(Alert.AlertType.ERROR, "You have reached maximum number of attempt");
                Platform.exit();
                return;
            }
            attempt--;
            URL resource = this.getClass().getResource("/audio/security-breach.mp3");
            Media media = new Media("/audio/security-breach.mp3");
            new MediaPlayer(media).play();
            new Alert(Alert.AlertType.ERROR, "Invalid Password");
            txtPassword.requestFocus();
            return;
        }
        URL resource = this.getClass().getResource("/view/ControleCenterForm.fxml");
        AnchorPane contolCenter = FXMLLoader.load(resource);
        AnchorPane pneContainer = (AnchorPane) pneAdminLoginForm.getParent();
        pneContainer.getChildren().clear();
        pneContainer.getChildren().add(contolCenter)''


    }
}
