package views;

import Model.Pasien;
import Service.*;
import Util.JadwalKunjungan;

import java.util.ArrayList;
import java.util.Scanner;

public class MainViews {
    private final PendaftaranPasien pendaftaran;
    private final CariPasien cari;
    private final EditDataPasien edit;
    private final HapusDataPasien hapus;
    private final JumlahPasien jumlah;
    private final TampilkanDaftarPasien tampilkan;
    private final JadwalKunjungan jadwal;

    public MainViews(
            PendaftaranPasien pendaftaran,
            CariPasien cari,
            EditDataPasien edit,
            HapusDataPasien hapus,
            JumlahPasien jumlah,
            TampilkanDaftarPasien tampilkan) {
        this.pendaftaran = pendaftaran;
        this.cari = cari;
        this.edit = edit;
        this.hapus = hapus;
        this.jumlah = jumlah;
        this.tampilkan = tampilkan;
        this.jadwal = new JadwalKunjungan();
    }

    public void jalankanMenu() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pasien> daftarPasien = new ArrayList<>();
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
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    pendaftaran.daftarPasien(scanner, daftarPasien);
                    break;
                case 2:
                    tampilkan.tampilkan(daftarPasien);
                    break;
                case 3:
                    cari.cari(scanner, daftarPasien);
                    break;
                case 4:
                    edit.edit(scanner, daftarPasien);
                    break;
                case 5:
                    hapus.hapus(scanner, daftarPasien);
                    break;
                case 6:
                    jumlah.jumlah(daftarPasien);
                    break;
                case 7:
                    jadwal.tampilkanJadwal();
                    break;
                case 8:
                    System.out.println("Terima kasih telah menggunakan sistem ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 8);

        scanner.close();
    }
}