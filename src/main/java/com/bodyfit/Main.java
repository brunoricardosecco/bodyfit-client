package com.bodyfit;

import com.bodyfit.controller.login.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage stage) throws Exception{
        Font.loadFont(getClass().getResourceAsStream("fonts/Khand-Regular.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("fonts/Khand-Bold.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("fonts/Khand-Light.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("fonts/Raleway-Bold.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("fonts/Raleway-Regular.ttf"), 14);
        Font.loadFont(getClass().getResourceAsStream("fonts/Raleway-Thin.ttf"), 14);

        LoginController loginController = new LoginController();
        loginController.start(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
