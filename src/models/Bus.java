package models;

import static controller.AddVehicleFormController.vehicles;
import static controller.VehicleParkingSystemFormController.parkingList;
import static controller.VehicleParkingSystemFormController.selectedVehiclePosition;

public class Bus extends Vehicle {
    private String vehicleNo;
    private String vehicleType;
    private int reservedSlots;
    private String timeDate;
    private String driverName;

    public Bus() {
    }

    public Bus(String vehicleNo, String vehicleType) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
    }

    public void setVehicleNo(String vehicleBusNo) {
        this.vehicleNo = vehicleBusNo;
    }

    public void setVehicleType(String vehicleBusType) {
        this.vehicleType = vehicleBusType;
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
        //int index = findNextFalseIndexAfter13();
        if (parkingSlotData[13] == false) {
            parkingSlotData[13] = true;
            reservedSlots = 13 + 1;
            tempData = 13 + 1;
            parkingData[13][0] = vehicles[selectedVehiclePosition].getVehicleNo();
            parkingData[13][1] = vehicles[selectedVehiclePosition].getVehicleType();
            parkingData[13][2] = Integer.toString(14);
            parkingData[13][3] = getTimeNow();
            parkingData[13][4] = driverName;
            System.out.println(vehicles[selectedVehiclePosition].getVehicleNo() + " " + driverName);
            timeDate = parkingData[13][3];
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
        nextIndex++;;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "vehicleNo='" + vehicleNo + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }
}
