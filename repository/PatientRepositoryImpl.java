package repository;

import config.DatabaseConfig;
import entities.Patient;
import java.util.ArrayList;
import java.util.Optional;

public class PatientRepositoryImpl implements PatientRepository {

    @Override
    public void save(Patient patient) {
        DatabaseConfig.getPatients().add(patient);
        DatabaseConfig.incrementOccupiedRooms();
    }

    @Override
    public ArrayList<Patient> findAll() {
        return new ArrayList<>(DatabaseConfig.getPatients()); // Mengembalikan salinan untuk mencegah modifikasi langsung
    }

    @Override
    public Optional<Patient> findByName(String name) {
        return DatabaseConfig.getPatients().stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    @Override
    public boolean delete(String name) {
        for (int i = 0; i < DatabaseConfig.getPatients().size(); i++) {
            if (DatabaseConfig.getPatients().get(i).getName().equalsIgnoreCase(name)) {
                DatabaseConfig.getPatients().remove(i);
                DatabaseConfig.decrementOccupiedRooms();
                return true;
            }
        }
        return false;
    }

    @Override
    public int count() {
        return DatabaseConfig.getPatients().size();
    }

    @Override
    public boolean hasAvailableRooms() {
        return DatabaseConfig.getOccupiedRooms() < DatabaseConfig.getTotalRooms();
    }
}
// ini juga push tapi pake nama ku
