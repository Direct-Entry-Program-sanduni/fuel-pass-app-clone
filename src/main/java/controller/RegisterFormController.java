package controller;

import db.InMemoryDB;
import db.User;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;

public class RegisterFormController {
    public TextField txtNIC;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtAddress;
    public Button btvRegister;
    public AnchorPane pneRegisterForm;
    public Label lblNICStatus;

    private void setDisableCmp(boolean disable){
        txtFirstName.setDisable(disable);
        txtLastName.setDisable(disable);
        txtAddress.setDisable(disable);
        btvRegister.setDisable(disable);
    }

    public void initialize(){
        Platform.runLater(txtNIC::requestFocus);

        txtNIC.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldText, String currentText) {

                setDisableCmp(true);
              if (currentText.isBlank()) {
                  lblNICStatus.setText("Please enter valid NIC");
                  lblNICStatus.setTextFill(Color.BLACK);
              }else {
                  if (isValidNIC(currentText)){
                      lblNICStatus.setText("Valid NIC");
                      lblNICStatus.setTextFill(Color.GREEN);
                      setDisableCmp(false);
                  }else {
                      lblNICStatus.setText("Invalid NIC");
                      lblNICStatus.setTextFill(Color.RED);
                  }
              }
            }
        });
    }
    public static boolean isValidNIC(String input){
        if (input.length() != 10) return false;
        if (!(input.endsWith("v")|| input.endsWith("V"))) return false;
        if(!input.substring(0,9).matches("\\d+")) return false;
        return true;
    }

    public void lblLoginOnMouseClick(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/LoginForm.fxml");
        AnchorPane loginForm = FXMLLoader.load(resource);
        AnchorPane pneContainer = (AnchorPane) pneRegisterForm.getParent();
        pneContainer.getChildren().clear();
        pneContainer.getChildren().add(loginForm);
        AnchorPane.setTopAnchor(loginForm,0.0);
        AnchorPane.setRightAnchor(loginForm,0.0);
        AnchorPane.setBottomAnchor(loginForm,0.0);
        AnchorPane.setLeftAnchor(loginForm,0.0);

    }

    public void btnRegistorOnAction(ActionEvent actionEvent) {
        String firstName = txtFirstName.getText();
        if (firstName.isBlank()) {
            new Alert(Alert.AlertType.ERROR, "Please Enter your first name").showAndWait();
            txtFirstName.requestFocus();
            return;
        } else if (!isName(firstName)) {
            new Alert(Alert.AlertType.ERROR, "First").showAndWait();
            txtFirstName.requestFocus();
            return;
        } else if (!isName(txtLastName.getText())) {
            new Alert(Alert.AlertType.ERROR, "Last name is invalid").showAndWait();
            txtLastName.requestFocus();
            return;
        } else if (txtAddress.getText().trim().length()<3) {
            new Alert(Alert.AlertType.ERROR, "Address is Invalid").showAndWait();
            txtLastName.requestFocus();
            return;
        }

       boolean result =InMemoryDB.registerUser(new User(txtNIC.getText(), txtFirstName.getText(), txtLastName.getText(),txtAddress.getText()));
        if (result){
            new Alert(Alert.AlertType.CONFIRMATION, "Registretion is success");
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "Nic already registed");
            txtNIC.requestFocus();
        }

    }

    public boolean isName(String input){
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            if (!Character.isLetter(aChar) && aChar != ' ') return false;
        }
        return true;
    }
}
