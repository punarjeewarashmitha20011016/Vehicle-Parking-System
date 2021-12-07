package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import models.ParkedVehicles;
import models.Vehicle;

import static controller.VehicleParkingSystemFormController.parkingList;
import static models.Vehicle.parkingData;

public class InParkingFormController {
    public AnchorPane inParkingFormView;
    public TableView<ParkedVehicles> tblInParkingView;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colVehicleParkingSlot;
    public TableColumn colVehicleParkedTime;

    public int index = 0;

    public void initialize() {
        ObservableList<ParkedVehicles> observableList= FXCollections.observableList(parkingList);
        for (ParkedVehicles vehicles:parkingList) {
            colVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
            colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
            colVehicleParkingSlot.setCellValueFactory(new PropertyValueFactory<>("reservedSlots"));
            colVehicleParkedTime.setCellValueFactory(new PropertyValueFactory<>("timeDate"));
            tblInParkingView.setItems(observableList);
        }

    }
}
