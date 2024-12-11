package Service;

import Entities.Pasien;
import Repository.PasienRepository;

public class TampilkanDaftarPasien {
    public void tampilkan(PasienRepository repository) {
        if (repository.getDaftarPasien().isEmpty()) {
            System.out.println("Tidak ada pasien yang terdaftar.");
        } else {
            System.out.println("=== Daftar Pasien ===");
            int i = 1;
            for (Pasien pasien : repository.getDaftarPasien()) {
                System.out.println((i++) + ". " + pasien);
            }
        }
    }
}
