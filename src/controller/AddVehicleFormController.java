package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import models.Bus;
import models.CargoLorry;
import models.Van;
import models.Vehicle;

import static controller.VehicleParkingSystemFormController.comboVehicles;

public class AddVehicleFormController {
    public JFXTextField txtAddVehicleNumber;
    public JFXTextField txtAddVehicleWeight;
    public JFXTextField txtAddNoOfPassengers;
    public JFXComboBox cmbSelectVehicleType;

    public static Vehicle[] vehicles = new Vehicle[14];
    int index = 0;

    public void initialize() {
        cmbSelectVehicleType.getItems().addAll("Bus", "Van", "Cargo Lorry");
    }

    public void btnAddVehicle(ActionEvent actionEvent) {
        if (cmbSelectVehicleType.getSelectionModel().getSelectedIndex() == 0) {
            vehicles[index] = new Bus(txtAddVehicleNumber.getText(), cmbSelectVehicleType.getSelectionModel().getSelectedItem().toString());
            comboVehicles.add(vehicles[index]);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Vehicle Added Successfully", ButtonType.CLOSE);
            alert.show();
            index++;
        } else if (cmbSelectVehicleType.getSelectionModel().getSelectedIndex() == 1) {
            vehicles[index] = new Van(txtAddVehicleNumber.getText(), cmbSelectVehicleType.getSelectionModel().getSelectedItem().toString());
            comboVehicles.add(vehicles[index]);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Vehicle Added Successfully", ButtonType.CLOSE);
            alert.show();
            index++;
        } else if (cmbSelectVehicleType.getSelectionModel().getSelectedIndex() == 2) {
            vehicles[index] = new CargoLorry(txtAddVehicleNumber.getText(), cmbSelectVehicleType.getSelectionModel().getSelectedItem().toString());
            comboVehicles.add(vehicles[index]);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Vehicle Added Successfully", ButtonType.CLOSE);
            alert.show();
            index++;
        }
    }

    public void cmbVehicleTypeOnAction(ActionEvent actionEvent) {

    }
}
