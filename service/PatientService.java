package service;

import repository.PatientRepository;
import entities.Patient;
import java.util.ArrayList;
import java.util.Optional;

public class PatientService {
    private final PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public boolean registerNewPatient(Patient patient) {
        if (!repository.hasAvailableRooms()) {
            return false;
        }
        repository.save(patient);
        return true;
    }

    public ArrayList<Patient> getAllPatients() {
        return repository.findAll();
    }

    public Optional<Patient> findPatient(String name) {
        return repository.findByName(name);
    }

    public boolean updatePatient(String name, Patient updatedInfo) {
        Optional<Patient> patient = repository.findByName(name);
        if (patient.isPresent()) {
            Patient existingPatient = patient.get();
            existingPatient.setName(updatedInfo.getName());
            existingPatient.setAge(updatedInfo.getAge());
            existingPatient.setAddress(updatedInfo.getAddress());
            existingPatient.setComplaint(updatedInfo.getComplaint());
            existingPatient.setRoomType(updatedInfo.getRoomType());
            existingPatient.setSelectedDoctor(updatedInfo.getSelectedDoctor());
            return true;
        }
        return false;
    }

    public boolean deletePatient(String name) {
        return repository.delete(name);
    }

    public int getPatientCount() {
        return repository.count();
    }
}