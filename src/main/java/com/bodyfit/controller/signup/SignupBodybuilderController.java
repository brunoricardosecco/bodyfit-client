package com.bodyfit.controller.signup;

import com.bodyfit.controller.bodybuillder.BodybuilderListController;
import com.bodyfit.controller.dashboard.DashboardController;
import com.bodyfit.controller.signup.SignupBodybuilderController;
import com.bodyfit.dao.BodybuilderDAO;
import com.bodyfit.model.Bodybuilder;
import com.bodyfit.model.Instructor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;

public class SignupBodybuilderController {

    private Instructor user;

    @FXML
    private VBox backButton;

    private BodybuilderDAO bodybuilderDAO;


    public SignupBodybuilderController() { bodybuilderDAO = new BodybuilderDAO(); }

    public void start(Stage stage, Instructor instructor) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/signup/bodybuilderSignup.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        stage.setTitle("Bodyfit");
        stage.setScene(new Scene(root, 768, 450));
        stage.setMinHeight(720);
        stage.setMinWidth(450);
        stage.setResizable(true);
        stage.show();
        this.user = instructor;

        backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    BodybuilderListController bodybuilderListController = new BodybuilderListController();
                    bodybuilderListController.start(stage, instructor);
                } catch (Exception exception) {
                    System.out.println("Erro ao trocar de tela");
                }
            }
        });
    }


        @FXML
        private Button signupButton;

        @FXML
        private Button clearButton;



        @FXML
        private TextField nameInput;

        @FXML
        private TextField cpfInput;

        @FXML
        private TextField birthdayInput;

        @FXML
        private TextField telInput;

        @FXML
        private TextField monthlyChargeInput;

        @FXML
        public void onClicky(ActionEvent event) throws IOException {
            clearButton.setDisable(true);


            String name = nameInput.getText();
            String cpf = cpfInput.getText();
            String birthday = birthdayInput.getText();
            String tel = telInput.getText();
            Boolean status = true;
            String last_paid = null;
            Double value = 0.0;
            try {
                value = Double.parseDouble(monthlyChargeInput.getText());
            } catch (Exception ex) {
                System.out.println(ex);
            }
            String bodybuilderCode = bodybuilderDAO.register(name, cpf, birthday, tel, status, last_paid, value);

            if(bodybuilderCode != null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registro");
                alert.setHeaderText("Cadastrado!");
                alert.setContentText("O bodybuilder foi cadastrado!");
                alert.showAndWait();
                nameInput.setText("");
                cpfInput.setText("");
                birthdayInput.setText("");
                telInput.setText("");
                monthlyChargeInput.setText("");
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registro");
                alert.setHeaderText("Erro!");
                alert.setContentText("Campos errados ou usuário já cadastrado!");
                alert.showAndWait();
            }
            clearButton.setDisable(false);
        }

        @FXML
        public void clearForm(ActionEvent event) throws IOException {
            nameInput.setText("");
            cpfInput.setText("");
            birthdayInput.setText("");
            telInput.setText("");
            monthlyChargeInput.setText("");
        }


}
