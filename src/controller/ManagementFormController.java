package controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ManagementFormController {
    public AnchorPane managementFormView;
    public JFXComboBox cmbSelectOption;
    public AnchorPane parkingOrDeliveringView;

    public void initialize() throws IOException {
        cmbSelectOption.getItems().addAll("In parking","On delivery");
    }

    public void btnManagementLogout(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("../view/VehicleParkingSystemForm.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage= (Stage) managementFormView.getScene().getWindow();
        primaryStage.setTitle("Vehicle Parking Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void loadUi(String fileName) throws IOException {
        URL resource = getClass().getResource("../view/"+fileName+".fxml");
        Parent parent=FXMLLoader.load(resource);
        parkingOrDeliveringView.getChildren().clear();
        parkingOrDeliveringView.getChildren().add(parent);
    }

    public void cmbSelectOptionOnAction(ActionEvent actionEvent) throws IOException {
        if (cmbSelectOption.getSelectionModel().getSelectedIndex()==0){
            loadUi("InParkingForm");
        }else if (cmbSelectOption.getSelectionModel().getSelectedIndex()==1){
            loadUi("OnDeliveryForm");
        }
    }

    public void btnAddVehicle(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("../view/AddVehicleForm.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Add Vehicle Form");
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public void btnAddDriver(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("../view/AddDriverForm.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Add Driver Form");
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
