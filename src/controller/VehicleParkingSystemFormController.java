package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.Driver;
import models.OnDelivery;
import models.ParkedVehicles;
import models.Vehicle;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import static controller.AddVehicleFormController.vehicles;
import static models.Vehicle.onDeliveryData;
import static models.Vehicle.parkingData;


public class VehicleParkingSystemFormController {


    public Label timeDateClock;
    public Label dateId;
    public Label timeId;
    public AnchorPane mainForm;
    public JFXComboBox cmbDriverDetails;
    public JFXComboBox cmbVehicleDetails;
    public JFXTextField txtSetVehicleType;
    public Label txtParkingSlotNumber;
    public LocalDateTime currentTime;
    public static int selectedVehiclePosition;
    public static ArrayList<Driver> comboDrivers = new ArrayList<Driver>();
    public static ArrayList<Vehicle> comboVehicles = new ArrayList<Vehicle>();
    public static ArrayList<OnDelivery> onDeliveries = new ArrayList();
    public static ArrayList<ParkedVehicles> parkingList = new ArrayList();
    public String driverName;
    public static int index = 0;

    public void initialize() {
        currentDateAndTime();
        for (Driver driver : comboDrivers) {
            cmbDriverDetails.getItems().addAll(driver.getDriverName());
        }

        for (Vehicle vehicle : comboVehicles) {
            cmbVehicleDetails.getItems().addAll(vehicle.getVehicleNo());
        }
    }

    public void currentDateAndTime() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            dateId.setText(LocalDateTime.now().format(dateFormat));
            timeId.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void btnManagementLogin(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("../view/ManagementLoginForm.fxml"));
        Scene scene = new Scene(parent);
        Stage primaryStage = (Stage) mainForm.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Management Login Form");
        primaryStage.show();

    }

    public void cmbDriverDetailsOnAction(ActionEvent actionEvent) {
        driverName = cmbDriverDetails.getValue().toString();
        System.out.println(driverName);
    }

    public void btnParkVehicle(ActionEvent actionEvent) {
        currentTime = LocalDateTime.now();
        String time = currentTime.format(DateTimeFormatter.ofPattern("hh:mm a - dd/MM/yyyy")).toString();

        if (vehicles[selectedVehiclePosition].getVehicleType().equals("Van")) {
            vehicles[selectedVehiclePosition].park(vehicles[selectedVehiclePosition].getVehicleNo(), vehicles[selectedVehiclePosition].getVehicleType(), time, driverName);
            txtParkingSlotNumber.setText(String.valueOf(vehicles[selectedVehiclePosition].getReservedSlots()));
            txtParkingSlotNumber.setVisible(true);
            System.out.println(txtParkingSlotNumber.getText());
        } else if (vehicles[selectedVehiclePosition].getVehicleType().equals("Cargo Lorry")) {
            vehicles[selectedVehiclePosition].park(vehicles[selectedVehiclePosition].getVehicleNo(), vehicles[selectedVehiclePosition].getVehicleType(), time, driverName);
            txtParkingSlotNumber.setText(String.valueOf(vehicles[selectedVehiclePosition].getReservedSlots()));
            txtParkingSlotNumber.setVisible(true);
        } else if (vehicles[selectedVehiclePosition].getVehicleType().equals("Bus")) {
            vehicles[selectedVehiclePosition].park(vehicles[selectedVehiclePosition].getVehicleNo(), vehicles[selectedVehiclePosition].getVehicleType(), time, driverName);
            txtParkingSlotNumber.setText(String.valueOf(vehicles[selectedVehiclePosition].getReservedSlots()));
            txtParkingSlotNumber.setVisible(true);
        }

        System.out.println(Arrays.toString(parkingData[0]));
        System.out.println(Arrays.toString(parkingData[1]));
        System.out.println(Arrays.toString(parkingData[2]));
        System.out.println(Arrays.toString(parkingData[3]));
        System.out.println(Arrays.toString(parkingData[4]));
        System.out.println(Arrays.toString(parkingData[5]));
        System.out.println(Arrays.toString(parkingData[6]));
        System.out.println(Arrays.toString(parkingData[7]));
        System.out.println(Arrays.toString(parkingData[8]));
        System.out.println(Arrays.toString(parkingData[9]));
        System.out.println(Arrays.toString(parkingData[10]));
        System.out.println(Arrays.toString(parkingData[11]));
        System.out.println(Arrays.toString(parkingData[12]));
        System.out.println(Arrays.toString(parkingData[13]));
        System.out.println(vehicles[selectedVehiclePosition].getReservedSlots());

        parkingList.add(new ParkedVehicles(vehicles[selectedVehiclePosition].getVehicleNo(), vehicles[selectedVehiclePosition].getVehicleType(), vehicles[selectedVehiclePosition].getReservedSlots(), vehicles[selectedVehiclePosition].getTimeDate()));
        System.out.println(parkingList.get(0));
    }

    public void btnOnDeliveryShift(ActionEvent actionEvent) {
        currentTime = LocalDateTime.now();
        if (vehicles[selectedVehiclePosition].getVehicleType().equals("Van")) {
            vehicles[selectedVehiclePosition].leavePark(driverName);
            txtParkingSlotNumber.setText(String.valueOf(vehicles[selectedVehiclePosition].getReservedSlots()));
            txtParkingSlotNumber.setVisible(true);
        } else if (vehicles[selectedVehiclePosition].getVehicleType().equals("Cargo Lorry")) {
            vehicles[selectedVehiclePosition].leavePark(driverName);
            txtParkingSlotNumber.setText(String.valueOf(vehicles[selectedVehiclePosition].getReservedSlots()));
            txtParkingSlotNumber.setVisible(true);
        } else if (vehicles[selectedVehiclePosition].getVehicleType().equals("Bus")) {
            vehicles[selectedVehiclePosition].leavePark(driverName);
            txtParkingSlotNumber.setText(String.valueOf(vehicles[selectedVehiclePosition].getReservedSlots()));
            txtParkingSlotNumber.setVisible(true);
        }
        for (int i = 0; i < 14; i++) {
            System.out.println(Arrays.toString(onDeliveryData[i]));
        }

        System.out.println("-------------------------");
        System.out.println(parkingList);
        System.out.println("-------------------------");
        System.out.println("Index of On delivery : "+index);
        onDeliveries.add(new OnDelivery(onDeliveryData[index][0], onDeliveryData[index][1], onDeliveryData[index][4], onDeliveryData[index][3]));
        index++;

        /*if (selectedVehiclePosition==0) {
            parkingList.remove(selectedVehiclePosition);
        }else if (selectedVehiclePosition>=1) {
            parkingList.remove(selectedVehiclePosition - 1);
        }else if (selectedVehiclePosition==2){
            parkingList.remove(selectedVehiclePosition-1);
        }*/
        for(int i=0;i<14;i++){
            if (vehicles[selectedVehiclePosition].getVehicleNo().equals(parkingList.get(i).getVehicleNo())){
                parkingList.remove(i);break;
            }
        }
    }

    public void cmbVehicleDetails(ActionEvent actionEvent) {
         String selectedVehicleNo = cmbVehicleDetails.getValue().toString();
        for (int i = 0; i < 14; i++) {
            if (selectedVehicleNo.equals(vehicles[i].getVehicleNo())) {
                txtSetVehicleType.setText(vehicles[i].getVehicleType());
                selectedVehiclePosition = i;
                System.out.println(vehicles[selectedVehiclePosition].getVehicleNo());
                break;
            }
            txtSetVehicleType.clear();
        }
        //txtParkingSlotNumber.setText(null)
    }
}
