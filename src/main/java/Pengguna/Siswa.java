/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pengguna;
import java.util.ArrayList;
/**
 *
 * @author Pongo
 */
public class Siswa{
    private int id, jenis_kelamin;
    private String nama, alamat, nisn, kelas;
    private User user_id;

    public Siswa(int jenis_kelamin, String nama, String alamat, String nisn, String kelas) {
        this.jenis_kelamin = jenis_kelamin;
        this.nama = nama;
        this.alamat = alamat;
        this.nisn = nisn;
        this.kelas = kelas;
    }
    
    public Siswa(){
        
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(int jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public void setId(int siswaId) {
        this.id = id;
    }
}
