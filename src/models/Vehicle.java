package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Vehicle {
    public static int tempData = -1;
    public static String vehicleNo;
    public static String vehicleType;
    public static int reservedSlots;
    public static String timeDate;
    public static String driverName;
    public static int nextIndex = 0;

    public static String[][] parkingData = new String[14][5];
    public static String[][] onDeliveryData = new String[14][5];
    public static boolean[] parkingSlotData = new boolean[14];

    public static String getTimeNow() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        String x = formatter.format(date);
        return x;
    }

    public int findNextFalseIndex() {
        int y = -1;
        for (int i = 0; i < parkingData.length; i++) {
            if (parkingSlotData[i] == false) {
                y = i;
                break;
            }
        }
        return y;
    }

    public int findNextFalseIndexAfter5() {
        int x = -1;
        for (int i = 4; i < parkingSlotData.length - 1; i++) {
            if (parkingSlotData[i] == false) {
                x = i;
                break;
            }
        }
        return x;
    }

    public int findNextFalseIndexAfter13() {
        int x = -1;
        for (int i = 13; i < parkingData.length - 1; i++) {
            if (parkingSlotData[i] == false) {
                x = i;
                break;
            }
        }
        return x;
    }


    public void park(String vehicleNo, String vehicleType, String time, String driverName) {
    }

    public void leavePark(String driverName) {

    }

    public void setVehicleType() {

    }

    public String getVehicleNo() {
        return null;
    }

    public String getVehicleType() {
        return null;
    }

    public int getReservedSlots() {
        return 0;
    }

    public String getTimeDate() {
        return null;
    }

    public String getDriverName() {
        return null;
    }
}
