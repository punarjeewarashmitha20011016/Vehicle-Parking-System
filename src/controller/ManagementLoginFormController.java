package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagementLoginFormController {
    public JFXTextField txtUserName;
    public AnchorPane loginFormView;
    public JFXPasswordField txtPasswordField;

    public void btnLogin(ActionEvent actionEvent) throws IOException {
        if ((txtUserName.getText().equals("admin")) && (txtPasswordField.getText().equals("1234"))) {
            Parent parent = FXMLLoader.load(this.getClass().getResource("../view/ManagementForm.fxml"));
            Scene scene = new Scene(parent);
            Stage primaryStage = (Stage) loginFormView.getScene().getWindow();
            primaryStage.setTitle("Vehicle Parking List Form");
            primaryStage.setScene(scene);
            primaryStage.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Check your User Name or Password", ButtonType.CLOSE);alert.show();
        }
    }

    public void btnLoginCancel(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("../view/VehicleParkingSystemForm.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) loginFormView.getScene().getWindow();
        primaryStage.setTitle("Vehicle Parking Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
