package Service;

import Entities.Pasien;
import Repository.PasienRepository;

import java.util.Scanner;

public class PendaftaranPasien {
    public void daftarPasien(Scanner scanner, PasienRepository repository) {
        System.out.print("Masukkan nama pasien: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan umur pasien: ");
        int umur = scanner.nextInt();
        scanner.nextLine(); // Bersihkan buffer
        System.out.print("Masukkan alamat pasien: ");
        String alamat = scanner.nextLine();
        System.out.print("Masukkan keluhan pasien: ");
        String keluhan = scanner.nextLine();

        repository.tambahPasien(new Pasien(nama, umur, alamat, keluhan));
        System.out.println("Pasien berhasil didaftarkan!");
    }
}
