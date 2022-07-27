package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class AdminLoginFormController {
    static int attempt=3;
    public PasswordField txtPassword;
    private static final String ADMIN_PASSWORD= "DEP9@admin";
    public AnchorPane pneAdminLoginForm;

    public void initialize(){
        Platform.runLater(txtPassword::requestFocus);
    }

    public void txtPAsswordOnAction(ActionEvent actionEvent) throws IOException {
        if (! txtPassword.getText().equals(ADMIN_PASSWORD)){

            if (attempt==0){
                new Alert(Alert.AlertType.ERROR, "You have reached maximum number of attempt");
                Platform.exit();
                return;
            }

            URL resource = this.getClass().getResource("/audio/security-breach.mp3");
            Media media = new Media(resource.toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();

            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid Admin Password. You have " +attempt+ " more attempts to try again.");
            attempt--;

            InputStream resourceAsStream = this.getClass().getResourceAsStream("/image/alrte.png");
            Image image = new Image(resourceAsStream);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(48);
            imageView.setFitHeight(48);
            alert.setGraphic(imageView);

            alert.setHeaderText("Invalid Login Credential");
            alert.setTitle("Access Denied");

            alert.showAndWait();
            mediaPlayer.dispose();
            txtPassword.requestFocus();
            return;


        }
        URL resource = this.getClass().getResource("/view/ControleCenterForm.fxml");
        AnchorPane contolCenter = FXMLLoader.load(resource);
        AnchorPane pneContainer = (AnchorPane) pneAdminLoginForm.getParent();
        pneContainer.getChildren().clear();
        pneContainer.getChildren().add(contolCenter);
        AnchorPane.setLeftAnchor(contolCenter, 0.0);
        AnchorPane.setRightAnchor(contolCenter, 0.0);
        AnchorPane.setTopAnchor(contolCenter, 0.0);
        AnchorPane.setBottomAnchor(contolCenter, 0.0);


    }
}
