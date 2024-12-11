package Service;

import Model.Pasien;

import java.util.ArrayList;
import java.util.Scanner;

public class CariPasien {
    public void cari(Scanner scanner, ArrayList<Pasien> daftarPasien) {
        System.out.print("Masukkan nama pasien yang ingin dicari: ");
        String nama = scanner.nextLine();
        boolean ditemukan = false;

        for (Pasien pasien : daftarPasien) {
            if (pasien.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Data ditemukan: " + pasien);
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Pasien dengan nama tersebut tidak ditemukan.");
        }
    }
}