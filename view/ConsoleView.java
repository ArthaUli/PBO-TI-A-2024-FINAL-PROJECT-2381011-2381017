package view;

import entities.Patient;
import service.PatientService;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner;
    private final PatientService patientService;

    public ConsoleView(PatientService patientService) {
        this.scanner = new Scanner(System.in);
        this.patientService = patientService;
    }

    public void showMainMenu() {
        while (true) {
            System.out.println("\n****** PENDAFTARAN PASIEN RUMAH SAKIT ******");
            System.out.println("\nPilih opsi :");
            System.out.println("1. Pendaftaran Pasien Baru");
            System.out.println("2. Lihat Daftar Pasien");
            System.out.println("3. Cari Pasien");
            System.out.println("4. Edit Data Pasien");
            System.out.println("5. Hapus Data Pasien");
            System.out.println("6. Jumlah Pasien Terdaftar");
            System.out.println("7. Jadwal Kunjungan Pasien");
            System.out.println("8. Keluar Dari Program");
            System.out.print("Masukkan opsi ke-: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Input tidak valid, harap masukkan angka.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> registerNewPatient();
                case 2 -> showAllPatients();
                case 3 -> searchPatient();
                case 4 -> editPatient();
                case 5 -> deletePatient();
                case 6 -> showPatientCount();
                case 7 -> showVisitSchedule();
                case 8 -> {
                    System.out.println("Terima kasih telah menggunakan aplikasi. Sampai jumpa!");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
    }

    private void registerNewPatient() {
        System.out.println("\n=== Pendaftaran Pasien Baru ===");
        System.out.print("Masukkan nama pasien: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan umur pasien: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline
        System.out.print("Masukkan alamat pasien: ");
        String address = scanner.nextLine();
        System.out.print("Masukkan keluhan pasien: ");
        String complaint = scanner.nextLine();
        System.out.print("Masukkan tipe kamar (Umum/VIP): ");
        String roomType = scanner.nextLine();

        Patient newPatient = new Patient(name, age, address, complaint, roomType);
        if (patientService.registerNewPatient(newPatient)) {
            System.out.println("Pendaftaran berhasil!");
        } else {
            System.out.println("Kamar penuh. Pendaftaran gagal.");
        }
    }

    private void showAllPatients() {
        System.out.println("\n=== Daftar Semua Pasien ===");
        for (Patient patient : patientService.getAllPatients()) {
            System.out.println(patient);
        }
    }

    private void searchPatient() {
        System.out.print("\nMasukkan nama pasien yang ingin dicari: ");
        String name = scanner.nextLine();
        patientService.findPatient(name)
                .ifPresentOrElse(
                        patient -> System.out.println("\nDetail Pasien:\n" + patient),
                        () -> System.out.println("Pasien tidak ditemukan.")
                );
    }

    private void editPatient() {
        System.out.print("\nMasukkan nama pasien yang ingin diubah: ");
        String name = scanner.nextLine();
        var optionalPatient = patientService.findPatient(name);

        if (optionalPatient.isEmpty()) {
            System.out.println("Pasien tidak ditemukan.");
            return;
        }

        System.out.println("\nMasukkan data baru untuk pasien.");
        System.out.print("Nama: ");
        String newName = scanner.nextLine();
        System.out.print("Umur: ");
        int newAge = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline
        System.out.print("Alamat: ");
        String newAddress = scanner.nextLine();
        System.out.print("Keluhan: ");
        String newComplaint = scanner.nextLine();
        System.out.print("Tipe Kamar (Umum/VIP): ");
        String newRoomType = scanner.nextLine();
        System.out.print("Dokter: ");
        String newDoctor = scanner.nextLine();

        Patient updatedPatient = new Patient(newName, newAge, newAddress, newComplaint, newRoomType);
        if (patientService.updatePatient(name, updatedPatient)) {
            System.out.println("Data pasien berhasil diperbarui.");
        } else {
            System.out.println("Gagal memperbarui data pasien.");
        }
    }

    private void deletePatient() {
        System.out.print("\nMasukkan nama pasien yang ingin dihapus: ");
        String name = scanner.nextLine();
        if (patientService.deletePatient(name)) {
            System.out.println("Data pasien berhasil dihapus.");
        } else {
            System.out.println("Pasien tidak ditemukan.");
        }
    }

    private void showPatientCount() {
        int count = patientService.getPatientCount();
        System.out.println("\nJumlah pasien yang terdaftar: " + count);
    }

    private void showVisitSchedule() {
        System.out.println("\n=== Jadwal Kunjungan Pasien ===");
        System.out.println("Minggu - Kamis: 10:00 - 10:00 (24 Jam)");
        System.out.println("Jumat: 10:00 - 17:00");
        System.out.println("Sabtu: Tutup (Closed)");
    }
}
//ini betul hapus koment ini
