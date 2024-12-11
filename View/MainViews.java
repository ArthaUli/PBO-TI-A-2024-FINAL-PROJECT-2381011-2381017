package View;

import Config.JadwalKunjungan;
import Repository.PasienRepository;
import Service.*;

import java.util.Scanner;

public class MainViews {
    private final PendaftaranPasien pendaftaran = new PendaftaranPasien();
    private final CariPasien cari = new CariPasien();
    private final EditDataPasien edit = new EditDataPasien();
    private final HapusDataPasien hapus = new HapusDataPasien();
    private final JumlahPasien jumlah = new JumlahPasien();
    private final TampilkanDaftarPasien tampilkan = new TampilkanDaftarPasien();
    private final JadwalKunjungan jadwal = new JadwalKunjungan();
    private final PasienRepository repository = new PasienRepository();
    private final Scanner scanner = new Scanner(System.in);

    public void jalankanMenu() {
        int pilihan;
        do {
            System.out.println("\n=== Sistem Pendaftaran Pasien ===");
            System.out.println("1. Pendaftaran Pasien Baru");
            System.out.println("2. Tampilkan Daftar Pasien");
            System.out.println("3. Cari Pasien");
            System.out.println("4. Edit Data Pasien");
            System.out.println("5. Hapus Data Pasien");
            System.out.println("6. Jumlah Pasien");
            System.out.println("7. Jadwal Kunjungan");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Bersihkan buffer

            switch (pilihan) {
                case 1 -> pendaftaran.daftarPasien(scanner, repository);
                case 2 -> tampilkan.tampilkan(repository);
                case 3 -> cari.cari(scanner, repository);
                case 4 -> edit.edit(scanner, repository);
                case 5 -> hapus.hapus(scanner, repository);
                case 6 -> jumlah.jumlah(repository);
                case 7 -> jadwal.tampilkanJadwal();
                case 8 -> System.out.println("Terima kasih telah menggunakan sistem ini!");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 8);
        scanner.close();
    }
}
