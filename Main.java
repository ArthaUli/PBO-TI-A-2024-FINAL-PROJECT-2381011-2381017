import Service.*;
import Service.CariPasien;
import Service.EditDataPasien;
import Service.HapusDataPasien;
import Service.JumlahPasien;
import Service.PendaftaranPasien;
import Service.TampilkanDaftarPasien;
import views.MainViews;

public class Main {
    public static void main(String[] args) {

        PendaftaranPasien pendaftaranPasien = new PendaftaranPasien();
        CariPasien cariPasien = new CariPasien();
        EditDataPasien editDataPasien = new EditDataPasien();
        HapusDataPasien hapusDataPasien = new HapusDataPasien();
        JumlahPasien jumlahPasien = new JumlahPasien();
        TampilkanDaftarPasien tampilkanDaftarPasien = new TampilkanDaftarPasien();

        MainViews mainViews = new MainViews(
                pendaftaranPasien,
                cariPasien,
                editDataPasien,
                hapusDataPasien,
                jumlahPasien,
                tampilkanDaftarPasien
        );

        mainViews.jalankanMenu();
    }
}