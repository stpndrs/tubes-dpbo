/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes_pbo;
import java.util.ArrayList;
/**
 *
 * @author Pongo
 */
public class Presensi {
    private int id, status;
    private ArrayList<Monitoring> monitoring_id = new ArrayList<>();
    private String tanggal, jam_masuk, jam_keluar, keterangan, lokasi;

    public Presensi(ArrayList<Monitoring> monitoring_id ,String tanggal, String jam_masuk, String keterangan) {
        this.monitoring_id = monitoring_id;
        this.tanggal = tanggal;
        this.jam_masuk = jam_masuk;
        this.keterangan = keterangan;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Monitoring> getMonitoring_id() {
        return monitoring_id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getJam_masuk() {
        return jam_masuk;
    }

    public String getJam_keluar() {
        return jam_keluar;
    }

    public void setJam_keluar(String jam_keluar) {
        this.jam_keluar = jam_keluar;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getLokasi() {
        return lokasi;
    }
}
