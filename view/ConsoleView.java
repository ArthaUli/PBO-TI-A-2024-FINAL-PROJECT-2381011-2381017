package view;

import config.DatabaseConfig;
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
            System.out.println("7. Lihat Jadwal Kunjungan");
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
                case 7 -> showVisitingHours();
                case 8 -> {
                    System.out.println("Terima kasih telah menggunakan aplikasi. Sampai jumpa!");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
    }

    private void registerNewPatient() {
        System.out.print("Masukkan nama pasien: ");
        String name = scanner.nextLine().trim();
        System.out.print("Masukkan umur pasien: ");

        int age;
        try {
            age = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Input tidak valid, umur harus berupa angka.");
            scanner.nextLine(); // Bersihkan buffer
            return;
        }

        System.out.print("Masukkan alamat pasien: ");
        String address = scanner.nextLine().trim();
        System.out.print("Masukkan keluhan pasien: ");
        String complaint = scanner.nextLine().trim();

        String roomType = selectRoomType();
        String doctor = selectDoctor();

        Patient newPatient = new Patient(name, age, address, complaint, roomType, doctor);
        if (patientService.registerNewPatient(newPatient)) {
            System.out.println("Pasien berhasil didaftarkan.");
        } else {
            System.out.println("Maaf, semua ruangan sudah penuh.");
        }
    }

    private String selectRoomType() {
        while (true) {
            System.out.println("\nTipe Kamar yang Tersedia:");
            System.out.println("1. Sederhana");
            System.out.println("2. Standar");
            System.out.println("3. VIP");
            System.out.print("Masukkan pilihan tipe kamar: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Input tidak valid, harap masukkan angka.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            return switch (choice) {
                case 1 -> "Sederhana";
                case 2 -> "Standar";
                case 3 -> "VIP";
                default -> {
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
                    yield null;
                }
            };
        }
    }

    private String selectDoctor() {
        while (true) {
            System.out.println("\nDaftar Dokter yang Tersedia:");
            for (int i = 0; i < DatabaseConfig.DOCTORS.length; i++) {
                System.out.println((i + 1) + ". " + DatabaseConfig.DOCTORS[i]);
            }
            System.out.print("Masukkan nomor dokter yang ingin dipilih: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Input tidak valid, harap masukkan angka.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice >= 1 && choice <= DatabaseConfig.DOCTORS.length) {
                return DatabaseConfig.DOCTORS[choice - 1];
            }
            System.out.println("Pilihan tidak valid, silakan coba lagi.");
        }
    }

    private void showAllPatients() {
        var patients = patientService.getAllPatients();
        if (patients.isEmpty()) {
            System.out.println("Belum ada pasien yang terdaftar.");
        } else {
            System.out.println("Daftar Pasien:");
            patients.forEach(System.out::println);
        }
    }

    private void searchPatient() {
        System.out.print("Masukkan nama pasien yang dicari: ");
        String name = scanner.nextLine().trim();
        patientService.findPatient(name)
                .ifPresentOrElse(
                        patient -> System.out.println("Data Pasien Ditemukan: " + patient),
                        () -> System.out.println("Pasien dengan nama tersebut tidak ditemukan.")
                );
    }

    private void editPatient() {
        System.out.print("Masukkan nama pasien yang ingin diedit: ");
        String name = scanner.nextLine().trim();

        var patientOpt = patientService.findPatient(name);
        if (patientOpt.isPresent()) {
            Patient patient = patientOpt.get();

            System.out.print("Masukkan nama baru (tekan Enter untuk melewati): ");
            String newName = scanner.nextLine().trim();
            if (!newName.isEmpty()) {
                patient.setName(newName);
            }

            System.out.print("Masukkan umur baru (0 jika tidak ingin mengubah): ");
            int newAge = scanner.nextInt();
            scanner.nextLine();
            if (newAge > 0) {
                patient.setAge(newAge);
            }

            System.out.print("Masukkan alamat baru (tekan Enter untuk melewati): ");
            String newAddress = scanner.nextLine().trim();
            if (!newAddress.isEmpty()) {
                patient.setAddress(newAddress);
            }

            System.out.print("Masukkan keluhan baru (tekan Enter untuk melewati): ");
            String newComplaint = scanner.nextLine().trim();
            if (!newComplaint.isEmpty()) {
                patient.setComplaint(newComplaint);
            }

            if (patientService.updatePatient(name, patient)) {
                System.out.println("Data pasien berhasil diubah.");
            }
        } else {
            System.out.println("Pasien dengan nama " + name + " tidak ditemukan.");
        }
    }

    private void deletePatient() {
        System.out.print("Masukkan nama pasien yang ingin dihapus: ");
        String name = scanner.nextLine().trim();

        if (patientService.deletePatient(name)) {
            System.out.println("Pasien dengan nama " + name + " berhasil dihapus.");
        } else {
            System.out.println("Pasien dengan nama tersebut tidak ditemukan.");
        }
    }

    private void showPatientCount() {
        System.out.println("Jumlah pasien terdaftar: " + patientService.getPatientCount());
    }

    private void showVisitingHours() {
        System.out.println("Jadwal kunjungan rumah sakit:");
        System.out.println("Senin - Minggu: 10:00 - 18:00");
    }
}