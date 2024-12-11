package Service;

import Model.Pasien;
import java.util.ArrayList;
import java.util.Scanner;

public class HapusDataPasien {
    public void hapus(Scanner scanner, ArrayList<Pasien> daftarPasien) {
        System.out.print("Masukkan nama pasien yang ingin dihapus: ");
        String nama = scanner.nextLine();
        boolean ditemukan = false;

        for (int i = 0; i < daftarPasien.size(); i++) {
            if (daftarPasien.get(i).getNama().equalsIgnoreCase(nama)) {
                daftarPasien.remove(i);
                System.out.println("Data pasien berhasil dihapus!");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Pasien dengan nama tersebut tidak ditemukan.");
        }
    }
}
