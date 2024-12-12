package config;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import entities.Patient;

public class DatabaseConfig {
    private static List<Patient> patients = Collections.synchronizedList(new ArrayList<>());
    private static final int TOTAL_ROOMS = 10;
    private static int occupiedRooms = 0;

    public static List<Patient> getPatients() {
        return patients;
    }

    public static int getTotalRooms() {
        return TOTAL_ROOMS;
    }

    public static int getOccupiedRooms() {
        return occupiedRooms;
    }

    public static void incrementOccupiedRooms() {
        occupiedRooms++;
    }

    public static void decrementOccupiedRooms() {
        occupiedRooms--;
    }
}
//yg ini jugaaa hapuss koment ku baru push pake nama - Artha
