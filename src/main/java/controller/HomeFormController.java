package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.Navigation;
import util.Routes;

import java.io.IOException;
import java.net.URL;

public class HomeFormController {


    public AnchorPane pneContainer;
    public ImageView pneLogin;

    public void initialize() throws IOException {

        Navigation.navigate(Routes.WELCOME);

    }

    public void OnMouseClicked_img(MouseEvent mouseEvent) throws IOException {
        pneContainer.getChildren().clear();
        initialize();
    }

    public void pneLoginOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        pneContainer.getChildren().clear();
        URL resource = this.getClass().getResource("/view/AdminLoginForm.fxml");
        AnchorPane adminLoginForm = FXMLLoader.load(resource);
        pneContainer.getChildren().add(adminLoginForm);
        AnchorPane.setLeftAnchor(adminLoginForm, 0.0);
        AnchorPane.setRightAnchor(adminLoginForm, 0.0);
        AnchorPane.setTopAnchor(adminLoginForm, 0.0);
        AnchorPane.setBottomAnchor(adminLoginForm, 0.0);

    }

    public void pneLoginKeyReleased(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode()== KeyCode.ENTER || keyEvent.getCode()==  KeyCode.SPACE){
            pneLoginOnMouseClicked(null);
        }
    }
}
