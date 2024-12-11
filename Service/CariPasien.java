package Service;

import Entities.Pasien;
import Repository.PasienRepository;

import java.util.Scanner;

public class CariPasien {
    public void cari(Scanner scanner, PasienRepository repository) {
        System.out.print("Masukkan nama pasien yang ingin dicari: ");
        String nama = scanner.nextLine();

        repository.getDaftarPasien().stream()
                .filter(pasien -> pasien.getNama().equalsIgnoreCase(nama))
                .findFirst()
                .ifPresentOrElse(
                        pasien -> System.out.println("Data ditemukan: " + pasien),
                        () -> System.out.println("Pasien dengan nama tersebut tidak ditemukan.")
                );
    }
}
