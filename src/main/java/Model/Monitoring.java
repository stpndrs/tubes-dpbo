/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Model.Siswa;
import Model.Instansi;
import Model.Guru;
import java.util.ArrayList;
/**
 *
 * @author Pongo
 */
public class Monitoring {
    private int id, status;
    private Siswa siswa_id;
    private Instansi instansi_id;
    private Guru guru_id;
    private String tanggal_mulai, tanggal_selesai;

    public Monitoring(Siswa siswa_id, Instansi instansi_id, Guru guru_id) {
        this.siswa_id = siswa_id;
        this.instansi_id = instansi_id;
        this.guru_id = guru_id;
    }
    
    public Monitoring(){
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Siswa getSiswa_id() {
        return siswa_id;
    }

    public void setSiswa_id(Siswa siswa_id) {
        this.siswa_id = siswa_id;
    }

    public Instansi getInstansi_id() {
        return instansi_id;
    }

    public void setInstansi_id(Instansi instansi_id) {
        this.instansi_id = instansi_id;
    }

    public Guru getGuru_id() {
        return guru_id;
    }

    public void setGuru_id(Guru guru_id) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
