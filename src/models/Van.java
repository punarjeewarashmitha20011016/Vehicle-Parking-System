package models;

import static controller.AddVehicleFormController.vehicles;
import static controller.VehicleParkingSystemFormController.parkingList;
import static controller.VehicleParkingSystemFormController.selectedVehiclePosition;

public class Van extends Vehicle {
    private String vehicleNo;
    private String vehicleType;
    private int reservedSlots;
    private String timeDate;
    private String driverName;

    public Van() {
    }

    public Van(String vehicleNo, String vehicleType) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
    }

    public void setVehicleNo(String vehicleVanNo) {
        this.vehicleNo = vehicleVanNo;
    }

    public void setVehicleType(String vehicleVanType) {
        this.vehicleType = vehicleVanType;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getDriverName() {
        return this.driverName;
    }

    public int getReservedSlots() {
        return reservedSlots;
    }

    public String getTimeDate() {
        return this.timeDate;
    }

    public int getSlotNumber() {
        return reservedSlots;
    }

    @Override
    public void park(String vehicleNo, String vehicleType, String time, String driverName) {
        int index = findNextFalseIndex();
        if (index == 0 | index == 1 | index == 2 | index == 3) {
            parkingSlotData[index] = true;
            tempData = index + 1;
            reservedSlots = index + 1;
            parkingData[index][0] = vehicleNo;
            parkingData[index][1] = vehicles[selectedVehiclePosition].getVehicleType();
            parkingData[index][2] = Integer.toString(index + 1);
            parkingData[index][3] = getTimeNow();
            parkingData[index][4] = driverName;
            System.out.println(vehicles[selectedVehiclePosition].getVehicleNo() + " " + driverName);
            timeDate = parkingData[index][3];
        } else if (parkingSlotData[11] == false) {
            parkingSlotData[11] = true;
            tempData = 12;
            reservedSlots = 12;
            parkingData[11][0] = vehicles[selectedVehiclePosition].getVehicleNo();
            parkingData[11][1] = vehicles[selectedVehiclePosition].getVehicleType();
            parkingData[11][2] = Integer.toString(12);
            parkingData[11][3] = getTimeNow();
            parkingData[11][4] = driverName;
            timeDate = parkingData[11][3];
        } else if (parkingSlotData[12] == false) {
            parkingSlotData[12] = true;
            tempData = 13;
            reservedSlots = 13;
            parkingData[12][0] = vehicles[selectedVehiclePosition].getVehicleNo();
            parkingData[12][1] = vehicles[selectedVehiclePosition].getVehicleType();
            parkingData[12][2] = Integer.toString(13);
            parkingData[12][3] = getTimeNow();
            parkingData[12][4] = driverName;
            timeDate = parkingData[11][3];
        } else {
            System.out.println("Van slots are Full");
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
            System.out.println("Selected Vehicle Position of the Vehicle : "+selectedVehiclePosition);
            nextIndex++;
    }

    @Override
    public String toString() {
        return "Van{" +
                "vehicleNo='" + vehicleNo + '\'' +
                ", vehicleType='" + vehicleType + '\'' + '}';
    }
}
