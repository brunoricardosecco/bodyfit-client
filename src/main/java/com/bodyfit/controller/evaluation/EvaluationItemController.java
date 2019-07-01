package com.bodyfit.controller.evaluation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EvaluationItemController {
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/components/evaluation-item/evaluation-item.fxml"));
        loader.setController(this);
        Parent root = loader.load();

        stage.setTitle("BodyFit");
        stage.setScene(new Scene(root, 768, 100));
        stage.setMinHeight(100);
        stage.setMinWidth(768);
        stage.setResizable(true);

        stage.show();
    }
}
