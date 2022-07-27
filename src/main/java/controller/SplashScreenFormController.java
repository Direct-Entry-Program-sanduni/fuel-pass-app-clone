package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import util.Navigation;

import java.io.IOException;
import java.net.URL;

public class SplashScreenFormController {
    public Rectangle fgbContainet;
    public Rectangle fgbFrogressBar;
    public Label lbllabel;

    public void initialize(){
        Timeline t1 = new Timeline();
        var frame1 = new KeyFrame(Duration.millis(250), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lbllabel.setText("Connecting Database...!");
                fgbFrogressBar.setWidth(fgbFrogressBar.getWidth() + 25);
            }
        });
          var frame2 =new KeyFrame(Duration.millis(250), new EventHandler<ActionEvent>() {
              @Override
              public void handle(ActionEvent actionEvent) {
                 lbllabel.setText("Loading data...!");
                 fgbFrogressBar.setWidth(fgbFrogressBar.getWidth() + 30);
              }
          });

        var frame3 = new KeyFrame(Duration.millis(750), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lbllabel.setText("Setting up the UI");
                fgbFrogressBar.setWidth(fgbFrogressBar.getWidth() + 25);
            }
        });

        var frame4 =new KeyFrame(Duration.millis(250), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    fgbFrogressBar.setWidth(fgbContainet.getWidth());
                    URL res = this.getClass().getResource("/view/HomeForm.fxml");
                    //Parent container = FXMLLoader.load(res);
                    Parent homeFormContainer = FXMLLoader.load(res);
                    AnchorPane pneContainer = (AnchorPane) homeFormContainer.lookup("#pneContainer");
                    Navigation.init(pneContainer);
                    Scene scene = new Scene(homeFormContainer);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("National Fuel Pass App");
                    stage.show();
                    stage.centerOnScreen();
                    lbllabel.getScene().getWindow().hide();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        });
        t1.getKeyFrames().addAll(frame1,frame2,frame3,frame4);
        t1.playFromStart();
    }
}
