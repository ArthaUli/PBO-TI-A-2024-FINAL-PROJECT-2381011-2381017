package Service;

import Model.Pasien;

import java.util.ArrayList;
import java.util.Scanner;

public class PendaftaranPasien {
    public void daftarPasien(Scanner scanner, ArrayList<Pasien> daftarPasien) {
        System.out.print("Masukkan nama pasien: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan umur pasien: ");
        int umur = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer
        System.out.print("Masukkan alamat pasien: ");
        String alamat = scanner.nextLine();
        System.out.print("Masukkan Keluhan Pasien: ");
        String keluhan = scanner.nextLine();

        daftarPasien.add(new Pasien(nama, umur, alamat, keluhan));
        System.out.println("Pasien berhasil didaftarkan!");
    }
}