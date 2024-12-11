package Service;

import Entities.Pasien;
import Repository.PasienRepository;

import java.util.Scanner;

public class HapusDataPasien {
    public void hapus(Scanner scanner, PasienRepository repository) {
        System.out.print("Masukkan nama pasien yang ingin dihapus: ");
        String nama = scanner.nextLine();

        repository.getDaftarPasien().stream()
                .filter(pasien -> pasien.getNama().equalsIgnoreCase(nama))
                .findFirst()
                .ifPresentOrElse(pasien -> {
                    repository.hapusPasien(pasien);
                    System.out.println("Data pasien berhasil dihapus!");
                }, () -> System.out.println("Pasien dengan nama tersebut tidak ditemukan."));
    }
}
