package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import models.Driver;

import java.util.Arrays;

import static controller.VehicleParkingSystemFormController.comboDrivers;

public class AddDriverFormController {
    public JFXTextField txtAddDriverName;
    public JFXTextField txtAddDriverNic;
    public JFXTextField txtAddDriverLicenceNo;
    public JFXTextField txtAddDriverAddress;
    public JFXTextField txtAddDriverContactNo;
    public Driver[] drivers = new Driver[16];
    int index = 0;

    public void btnAddDriver(ActionEvent actionEvent) {
        drivers[index] = new Driver(txtAddDriverName.getText(), txtAddDriverNic.getText(), txtAddDriverLicenceNo.getText(), txtAddDriverAddress.getText(), Integer.parseInt(txtAddDriverContactNo.getText()));
        System.out.println(Arrays.toString(drivers));
        comboDrivers.add(drivers[index]);
        index++;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Driver added successfuly", ButtonType.CLOSE);
        alert.show();
    }
}
