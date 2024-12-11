package Entities;

public class Pasien {
    private String nama;
    private int umur;
    private String alamat;
    private String keluhan;

    public Pasien(String nama, int umur, String alamat, String keluhan) {
        this.nama = nama;
        this.umur = umur;
        this.alamat = alamat;
        this.keluhan = keluhan;
    }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public int getUmur() { return umur; }
    public void setUmur(int umur) { this.umur = umur; }
    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
    public String getKeluhan() { return keluhan; }
    public void setKeluhan(String keluhan) { this.keluhan = keluhan; }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Umur: " + umur + ", Alamat: " + alamat + ", Keluhan: " + keluhan;
    }
}
