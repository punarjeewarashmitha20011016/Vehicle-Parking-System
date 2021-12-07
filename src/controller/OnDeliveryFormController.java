package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.OnDelivery;

import static controller.VehicleParkingSystemFormController.onDeliveries;

public class OnDeliveryFormController {
    public TableView<OnDelivery> tblOnDeliveryView;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colDriverName;
    public TableColumn colLeftTime;

    public void initialize() {
        ObservableList<OnDelivery> observableList = FXCollections.observableList(onDeliveries);
        for (OnDelivery delivery : onDeliveries) {
            colVehicleNumber.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
            colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
            colDriverName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
            colLeftTime.setCellValueFactory(new PropertyValueFactory<>("timeDate"));
            tblOnDeliveryView.setItems(observableList);
        }
    }
}
