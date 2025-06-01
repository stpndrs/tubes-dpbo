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
public class Laporan {
    private int id, status;
    private String tanggal, file, komentar;
    private ArrayList<Monitoring> monitoring_id = new ArrayList<>();

    public Laporan(ArrayList<Monitoring> monitoring_id, String tanggal, String file) {
        this.monitoring_id = monitoring_id;
        this.tanggal = tanggal;
        this.file = file;
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

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public String getFile() {
        return file;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
