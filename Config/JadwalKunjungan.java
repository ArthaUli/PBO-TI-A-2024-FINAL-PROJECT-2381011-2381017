package config;

import java.util.ArrayList;
import entities.Patient;

public class DatabaseConfig {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static final int TOTAL_ROOMS = 10;
    private static int occupiedRooms = 0;

    public static ArrayList<Patient> getPatients() {
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

    public static final String[] DOCTORS = {
            "Dr. Siburian (Poli Gigi)",
            "Dr. Lupita (Poli Gigi)",
            "Dr. Oji (Radiologi)",
            "Dr. Yohanes (Poli Mata)",
            "Dr. Artha (Jantung)",
            "Dr. Delon (THT)",
            "Dr. Arthur (Penyakit Dalam)",
            "Dr. Samuel (Dokter Umum)"
    };
}