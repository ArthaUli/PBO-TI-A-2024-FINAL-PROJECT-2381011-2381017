package Service;

import Model.Pasien;

import java.util.ArrayList;

public class TampilkanDaftarPasien {
    public void tampilkan(ArrayList<Pasien> daftarPasien) {
        if (daftarPasien.isEmpty()) {
            System.out.println("Tidak ada pasien yang terdaftar.");
        } else {
            System.out.println("=== Daftar Pasien ===");
            for (int i = 0; i < daftarPasien.size(); i++) {
                System.out.println((i + 1) + ". " + daftarPasien.get(i));
            }
        }
    }
}