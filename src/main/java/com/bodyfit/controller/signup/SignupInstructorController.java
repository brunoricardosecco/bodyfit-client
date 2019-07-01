package com.bodyfit.controller.signup;

import com.bodyfit.controller.instructor.InstructorListController;
import com.bodyfit.dao.InstructorDAO;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class SignupInstructorController {
    private Instructor user;

    @FXML
    private VBox backButton;
    private InstructorDAO instructorDAO;

    public SignupInstructorController(){ instructorDAO = new InstructorDAO();}

    public void start(Stage stage, Instructor instructor) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("view/signup/instructorSignup.fxml"));
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
                    InstructorListController instructorListController = new InstructorListController();
                    instructorListController.start(stage, instructor);
                } catch (Exception ex) {
                    System.out.println("Erro ao trocar para a dashboard");
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
    private TextField birth_dateInput;

    @FXML
    private TextField cpfInput;

    @FXML
    private TextField crefInput;

    @FXML
    public void onClick(ActionEvent event) throws IOException {
        clearButton.setDisable(true);

        String name  = nameInput.getText();
        String cpf = cpfInput.getText();
        String cref = crefInput.getText();
        String birth_date = birth_dateInput.getText();

        String instructorCode = instructorDAO.register(name, cpf, cref, birth_date);

        if(instructorCode != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registro");
            alert.setHeaderText("Cadastrado!");
            alert.setContentText("O bodybuilder foi cadastrado!");
            alert.showAndWait();
            nameInput.setText("");
            cpfInput.setText("");
            birth_dateInput.setText("");
            crefInput.setText("");
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
        birth_dateInput.setText("");
        crefInput.setText("");
    }
}
