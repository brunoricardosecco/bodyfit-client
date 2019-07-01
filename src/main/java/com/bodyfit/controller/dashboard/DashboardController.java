package com.bodyfit.controller.dashboard;

import com.bodyfit.controller.login.LoginController;
import com.bodyfit.model.Bodybuilder;
import com.bodyfit.model.Instructor;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

import javafx.stage.Window;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class DashboardController {
    private Bodybuilder user;

    @FXML
    private VBox signoutButton;


    public void start(Stage stage, Bodybuilder bodybuilder) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                getClass().getClassLoader().getResource("view/dashboard/dashboard_instructor.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        stage.setTitle("BodyFit");
        stage.setScene(new Scene(root, 768, 450));
        stage.setMinHeight(720);
        stage.setMinWidth(450);
        stage.setResizable(true);
        stage.show();

        this.user = bodybuilder;

        signoutButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    LoginController loginController = new LoginController();
                    loginController.start(stage);
                } catch (Exception ex) {
                    System.out.println("Erro ao voltar para Login");
                }
            }
        });
    }

}
