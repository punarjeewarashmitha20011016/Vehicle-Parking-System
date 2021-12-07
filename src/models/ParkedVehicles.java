package models;

public class ParkedVehicles {
    private String vehicleNo;
    private String vehicleType;
    private int reservedSlots;
    private String timeDate;

    public ParkedVehicles(String vehicleNo, String vehicleType, int reservedSlots, String timeDate) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.reservedSlots = reservedSlots;
        this.timeDate = timeDate;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getReservedSlots() {
        return reservedSlots;
    }

    public void setReservedSlots(int reservedSlots) {
        this.reservedSlots = reservedSlots;
    }

    public String getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }

    @Override
    public String toString() {
        return "ParkedVehicles{" +
                "vehicleNo='" + vehicleNo + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", reservedSlots='" + reservedSlots + '\'' +
                ", timeDate='" + timeDate + '\'' +
                '}';
    }
}
