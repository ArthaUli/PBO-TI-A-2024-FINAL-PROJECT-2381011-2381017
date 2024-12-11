package Repository;

import Entities.Pasien;
import java.util.ArrayList;
import java.util.List;

public class PasienRepository {
    private final List<Pasien> daftarPasien = new ArrayList<>();

    public List<Pasien> getDaftarPasien() {
        return daftarPasien;
    }

    public void tambahPasien(Pasien pasien) {
        daftarPasien.add(pasien);
    }

    public boolean hapusPasien(Pasien pasien) {
        return daftarPasien.remove(pasien);
    }
}
