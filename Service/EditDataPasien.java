package Service;

import Entities.Pasien;
import Repository.PasienRepository;

import java.util.Scanner;

public class EditDataPasien {
    public void edit(Scanner scanner, PasienRepository repository) {
        System.out.print("Masukkan nama pasien yang ingin diedit: ");
        String nama = scanner.nextLine();

        repository.getDaftarPasien().stream()
                .filter(pasien -> pasien.getNama().equalsIgnoreCase(nama))
                .findFirst()
                .ifPresentOrElse(pasien -> {
                    System.out.print("Masukkan nama baru: ");
                    pasien.setNama(scanner.nextLine());
                    System.out.print("Masukkan umur baru: ");
                    pasien.setUmur(scanner.nextInt());
                    scanner.nextLine(); // Bersihkan buffer
                    System.out.print("Masukkan alamat baru: ");
                    pasien.setAlamat(scanner.nextLine());
                    System.out.print("Masukkan keluhan baru: ");
                    pasien.setKeluhan(scanner.nextLine());
                    System.out.println("Data pasien berhasil diperbarui!");
                }, () -> System.out.println("Pasien dengan nama tersebut tidak ditemukan."));
    }
}
