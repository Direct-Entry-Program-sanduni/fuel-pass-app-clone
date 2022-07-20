package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class WelcomeFormController {
    public Button btnRegister;
    public Button btnLogin;
    public AnchorPane pneWelcome;

    public void initialize(){

    }


    public void btn_RegisterOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/RegisterForm.fxml");
        AnchorPane registerform = FXMLLoader.load(resource);
        AnchorPane penContainer = (AnchorPane) pneWelcome.getParent();


    }

    public void btn_LoginOnAction(ActionEvent actionEvent) {
    }
}
