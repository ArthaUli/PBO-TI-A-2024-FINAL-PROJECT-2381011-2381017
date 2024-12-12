package entities;

public class Patient {
        private String name;
        private int age;
        private String address;
        private String complaint;
        private String roomType;
        private String selectedDoctor;

        public Patient(String name, int age, String address, String complaint, String roomType, String selectedDoctor) {
            this.name = name;
            this.age = age;
            this.address = address;
            this.complaint = complaint;
            this.roomType = roomType;
            this.selectedDoctor = selectedDoctor;
        }

        // Getters and Setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }

        public String getAddress() { return address; }
        public void setAddress(String address) { this.address = address; }

        public String getComplaint() { return complaint; }
        public void setComplaint(String complaint) { this.complaint = complaint; }

        public String getRoomType() { return roomType; }
        public void setRoomType(String roomType) { this.roomType = roomType; }

        public String getSelectedDoctor() { return selectedDoctor; }
        public void setSelectedDoctor(String selectedDoctor) { this.selectedDoctor = selectedDoctor; }

        @Override
        public String toString() {
            return "Nama: " + name + ", Umur: " + age + ", Alamat: " + address +
                    ", Keluhan: " + complaint + ", Tipe Kamar: " + roomType +
                    ", Dokter: " + selectedDoctor;
        }
    }

