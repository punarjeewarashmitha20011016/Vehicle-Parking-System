package models;

import static controller.AddVehicleFormController.vehicles;
import static controller.VehicleParkingSystemFormController.parkingList;
import static controller.VehicleParkingSystemFormController.selectedVehiclePosition;

public class CargoLorry extends Vehicle {
    private String vehicleNo;
    private String vehicleType;
    private int reservedSlots;
    private String timeDate;
    private String driverName;

    public CargoLorry() {
    }

    public CargoLorry(String vehicleNo, String getVehicleType) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = getVehicleType;
    }

    public void setVehicleNo(String vehicleCargoLorryNo) {
        this.vehicleNo = vehicleCargoLorryNo;
    }

    public void setVehicleType(String vehicleCargoLorryType) {
        this.vehicleType = vehicleCargoLorryType;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public int getReservedSlots() {
        return reservedSlots;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getDriverName() {
        return this.driverName;
    }

    public String getTimeDate() {
        return this.timeDate;
    }

    @Override
    public void park(String vehicleNo, String vehicleType, String time, String driverName) {

        int index = findNextFalseIndexAfter5();
        if (index == 4 | index == 5 | index == 6 | index == 7 | index == 8 | index == 9 | index == 10) {
            parkingSlotData[index] = true;
            reservedSlots = index + 1;
            tempData = index + 1;
            parkingData[index][0] = vehicles[selectedVehiclePosition].getVehicleNo();
            parkingData[index][1] = vehicles[selectedVehiclePosition].getVehicleType();
            parkingData[index][2] = Integer.toString(index + 1);
            parkingData[index][3] = getTimeNow();
            parkingData[index][4] = driverName;
            System.out.println(vehicles[selectedVehiclePosition].getVehicleNo() + " " + driverName);
            timeDate = parkingData[index][3];
        }
    }

    @Override
    public void leavePark(String driverName) {
        System.out.println(nextIndex);
        onDeliveryData[nextIndex][0] = vehicles[selectedVehiclePosition].getVehicleNo();
        onDeliveryData[nextIndex][1] = vehicles[selectedVehiclePosition].getVehicleType();
        onDeliveryData[nextIndex][2] = String.valueOf(vehicles[selectedVehiclePosition].getReservedSlots());
        onDeliveryData[nextIndex][3] = getTimeNow();
        onDeliveryData[nextIndex][4] = driverName;
        timeDate = getTimeNow();
        System.out.println(vehicles[selectedVehiclePosition].getVehicleNo()+" - "+vehicles[selectedVehiclePosition].getVehicleType());
        System.out.println("Selected Vehicle Position of the Vehicle"+selectedVehiclePosition);
        nextIndex++;
    }

    @Override
    public String toString() {
        return "CargoLorry{" +
                "vehicleNo='" + vehicleNo + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }
}
