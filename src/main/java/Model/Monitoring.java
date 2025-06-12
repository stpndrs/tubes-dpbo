/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Pongo
 */
public class Monitoring {
    private int id, status, siswa_id, guru_id, isntansi_id;
    private String mulai, selesai;

    public Monitoring(int siswa_id, int instansi_id, int guru_id) {
        this.siswa_id = siswa_id;
        this.isntansi_id = instansi_id;
        this.guru_id = guru_id;
    }
    
    public Monitoring(){
    }

    public void setMulai(String mulai) {
        this.mulai = mulai;
    }

    public void setSelesai(String selesai) {
        this.selesai = selesai;
    }

    public String getMulai() {
        return mulai;
    }

    public String getSelesai() {
        return selesai;
    }

    public int getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public int getSiswa_id() {
        return siswa_id;
    }

    public int getGuru_id() {
        return guru_id;
    }

    public int getIsntansi_id() {
        return isntansi_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setSiswa_id(int siswa_id) {
        this.siswa_id = siswa_id;
    }

    public void setGuru_id(int guru_id) {
        this.guru_id = guru_id;
    }

    public void setIsntansi_id(int isntansi_id) {
        this.isntansi_id = isntansi_id;
    }
}
