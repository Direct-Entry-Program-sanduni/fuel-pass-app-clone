package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

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
                lbllabel.setText("Conecting Database...!");
                fgbFrogressBar.setWidth(fgbFrogressBar.getWidth() + 15);
            }
        });
          var frame2 =new KeyFrame(Duration.millis(250), new EventHandler<ActionEvent>() {
              @Override
              public void handle(ActionEvent actionEvent) {
                 lbllabel.setText("Loding data...!");
                 fgbFrogressBar.setWidth(fgbFrogressBar.getWidth() + 30);
              }
          });
        var frame3 =new KeyFrame(Duration.millis(250), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    lbllabel.setText("Loding data 2...!");
                    fgbFrogressBar.setWidth(fgbFrogressBar.getWidth() + 30);
                    URL resource = this.getClass().getResource("/view/HomeForm.fxml");
                    Parent container = FXMLLoader.load(resource);
                    Scene scene =new Scene(container);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle(" Home Form ");
                    stage.show();
                    stage.centerOnScreen();
                    lbllabel.getScene().getWindow().hide();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        });
        t1.getKeyFrames().addAll(frame1,frame2,frame3);
        t1.playFromStart();
    }
}
