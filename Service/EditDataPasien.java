package Service;

import Model.Pasien;

import java.util.ArrayList;
import java.util.Scanner;

public class EditDataPasien {
    public void edit(Scanner scanner, ArrayList<Pasien> daftarPasien) {
        System.out.print("Masukkan nama pasien yang ingin diedit: ");
        String nama = scanner.nextLine();
        boolean ditemukan = false;

        for (Pasien pasien : daftarPasien) {
            if (pasien.getNama().equalsIgnoreCase(nama)) {
                System.out.print("Masukkan nama baru: ");
                pasien.setNama(scanner.nextLine());
                System.out.print("Masukkan umur baru: ");
                pasien.setUmur(scanner.nextInt());
                scanner.nextLine(); // Membersihkan buffer
                System.out.print("Masukkan alamat baru: ");
                pasien.setAlamat(scanner.nextLine());
                System.out.println("Data pasien berhasil diperbarui!");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Pasien dengan nama tersebut tidak ditemukan.");
        }
    }
}