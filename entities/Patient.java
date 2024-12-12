package entities;

public class Patient extends Person {
    private String complaint;
    private String roomType;
    private String selectedDoctor;

    public Patient(String name, int age, String address, String complaint, String roomType, String selectedDoctor) {
        super(name, age, address);
        this.complaint = complaint;
        this.roomType = roomType;
        this.selectedDoctor = selectedDoctor;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getSelectedDoctor() {
        return selectedDoctor;
    }

    public void setSelectedDoctor(String selectedDoctor) {
        this.selectedDoctor = selectedDoctor;
    }

    @Override
    public String toString() {
        return "Nama: " + getName() + ", Umur: " + getAge() + ", Alamat: " + getAddress() +
                ", Keluhan: " + complaint + ", Tipe Kamar: " + roomType +
                ", Dokter: " + selectedDoctor;
    }
}