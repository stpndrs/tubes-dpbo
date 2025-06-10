/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Model.Monitoring;
import java.util.ArrayList;
/**
 *
 * @author Pongo
 */
public class Presensi {
    private int id, status, monitoring_id;
    private String tanggal, jam_masuk, jam_keluar, keterangan, lokasi;

    public Presensi(int monitoring_id ,String tanggal, String jam_masuk, String keterangan, int status) {
        this.monitoring_id = monitoring_id;
        this.tanggal = tanggal;
        this.jam_masuk = jam_masuk;
        this.keterangan = keterangan;
        this.status = status;
    }
    
    public Presensi(){
        
    }

    public int getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public int getMonitoring_id() {
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

    public String getKeterangan() {
        return keterangan;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMonitoring_id(int monitoring_id) {
        this.monitoring_id = monitoring_id;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setJam_masuk(String jam_masuk) {
        this.jam_masuk = jam_masuk;
    }

    public void setJam_keluar(String jam_keluar) {
        this.jam_keluar = jam_keluar;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

}
