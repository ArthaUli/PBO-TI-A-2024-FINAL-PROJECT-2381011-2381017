package Repository;

import entities.Patient;
import java.util.ArrayList;
import java.util.Optional;

public interface PatientRepository {
    void save(Patient patient);
    ArrayList<Patient> findAll();
    Optional<Patient> findByName(String name);
    boolean delete(String name);
    int count();
    boolean hasAvailableRooms();
}