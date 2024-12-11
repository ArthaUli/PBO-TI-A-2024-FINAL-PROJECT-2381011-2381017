
package Service;

import Model.Pasien;

import java.util.ArrayList;

public class JumlahPasien {
    public void jumlah(ArrayList<Pasien> daftarPasien) {
        System.out.println("Jumlah pasien saat ini: " + daftarPasien.size());
    }
}