package com.bodyfit.controller.login;

import com.bodyfit.controller.dashboard.DashboardController;
import com.bodyfit.dao.LoginDAO;
import com.bodyfit.model.Instructor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;


public class LoginController{

    private LoginDAO loginDAO;

    public LoginController() {
        loginDAO = new LoginDAO();
    }

    public void start (Stage stage) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/login/login.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        stage.setTitle("BodyFit");
        stage.setScene(new Scene(root, 768, 450));
        stage.setMinHeight(720);
        stage.setMinWidth(450);
        stage.setResizable(true);
        stage.show();
    }

    @FXML
    private TextField login;

    @FXML
    private Button enter;

    @FXML
    public void onClick(ActionEvent event) throws IOException{
        String id = login.getText();
        login.setDisable(true);
        enter.setDisable(true);

        Instructor instructor = loginDAO.login(id);

        if(instructor != null) {
            DashboardController dashboardController = new DashboardController();
            Node source = (Node) event.getSource();
            Window stage = source.getScene().getWindow();
            dashboardController.start((Stage)stage, instructor);
        }

        login.setDisable(false);
        enter.setDisable(false);

    }


}
