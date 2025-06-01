/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes_pbo;
import Pengguna.Siswa;
import Pengguna.Instansi;
import Pengguna.Guru;
import java.util.ArrayList;
/**
 *
 * @author Pongo
 */
public class Monitoring {
    private int id;
    private ArrayList<Siswa> siswa_id = new ArrayList<>();
    private ArrayList<Instansi> instansi_id = new ArrayList<>();
    private ArrayList<Guru> guru_id = new ArrayList<>();
    private String tanggal_mulai, tanggal_selesai;

    public Monitoring(ArrayList<Siswa> siswa_id, ArrayList<Instansi> instansi_id, ArrayList<Guru> guru_id) {
        this.siswa_id = siswa_id;
        this.instansi_id = instansi_id;
        this.guru_id = guru_id;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Siswa> getSiswa_id() {
        return siswa_id;
    }

    public ArrayList<Instansi> getInstansi_id() {
        return instansi_id;
    }

    public void setInstansi_id(ArrayList<Instansi> instansi_id) {
        this.instansi_id = instansi_id;
    }

    public ArrayList<Guru> getGuru_id() {
        return guru_id;
    }

    public void setGuru_id(ArrayList<Guru> guru_id) {
        this.guru_id = guru_id;
    }

    public String getTanggal_mulai() {
        return tanggal_mulai;
    }

    public void setTanggal_mulai(String tanggal_mulai) {
        this.tanggal_mulai = tanggal_mulai;
    }

    public String getTanggal_selesai() {
        return tanggal_selesai;
    }

    public void setTanggal_selesai(String tanggal_selesai) {
        this.tanggal_selesai = tanggal_selesai;
    }
}
