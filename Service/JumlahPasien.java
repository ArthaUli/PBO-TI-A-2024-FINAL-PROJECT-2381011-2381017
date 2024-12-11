package Service;

import Repository.PasienRepository;

public class JumlahPasien {
    public void jumlah(PasienRepository repository) {
        System.out.println("Jumlah pasien saat ini: " + repository.getDaftarPasien().size());
    }
}
