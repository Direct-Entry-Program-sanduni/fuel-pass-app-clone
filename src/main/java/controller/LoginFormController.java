package controller;

import db.InMemoryDB;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import util.Navigation;
import util.Routes;

public class LoginFormController {
    public TextField txtNic;
    public Button btnLogin;

    public void initialize(){
        Platform.runLater(txtNic::requestFocus);
    }

    public void lblRegisterOnMouseClicked(MouseEvent mouseEvent) {
        //Navigation.navigate(Routes.REGISTRATION);
    }


    public void btnLoginOnAction(ActionEvent actionEvent) {
        String nic = txtNic.getText();
        if (!RegisterFormController.isValidNIC(txtNic.getText()) || InMemoryDB.findUser(txtNic.getText())==null){
            new Alert(Alert.AlertType.ERROR, "Please enter valid NIC").showAndWait();

        }else {
            Navigation.navigate(Routes.DASHBOARD);
        }
    }
}
