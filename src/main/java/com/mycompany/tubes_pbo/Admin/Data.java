package com.mycompany.tubes_pbo.Admin;

import java.util.ArrayList;

/**
 * Data Siswa PKL
 * @author Axio
 */
public class Data {
    private String nama;
    private String NISN;
    private String Kelas;
    private String mulai;
    private String instansi;

    // Jika kamu ingin menyimpan list data monitoring
    private static ArrayList<Data> monitoring = new ArrayList<>();

    public Data(String nama, String NISN, String Kelas, String mulai, String instansi) {
        this.nama = nama;
        this.NISN = NISN;
        this.Kelas = Kelas;
        this.mulai = mulai;
        this.instansi = instansi;
    }

    // Getter & Setter
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getNISN() { return NISN; }
    public void setNISN(String NISN) { this.NISN = NISN; }

    public String getKelas() { return Kelas; }
    public void setKelas(String Kelas) { this.Kelas = Kelas; }

    public String getMulai() { return mulai; }
    public void setMulai(String mulai) { this.mulai = mulai; }

    public String getInstansi() { return instansi; }
    public void setInstansi(String instansi) { this.instansi = instansi; }

    // Method static untuk menambahkan data
    public static void inputan() {
        monitoring.add(new Data("Kipli", "312323", "XI RPL", "2024-06-01", "PT Maju Jaya"));
        monitoring.add(new Data("Budi", "324534", "XI TKJ", "2024-06-01", "PT Suka Coding"));
        monitoring.add(new Data("Ayu", "234234", "XII MM", "2024-06-01", "PT Kreatif Media"));
        monitoring.add(new Data("Sari", "645345", "XI DKV", "2024-06-01", "PT Desain Hebat"));
    }

    public static ArrayList<Data> getMonitoring() {
        return monitoring;
    }
}
