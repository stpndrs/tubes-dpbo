/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes_pbo.Pengguna;
import java.util.ArrayList;
/**
 *
 * @author Pongo
 */
public class Guru {
    private int id, jenis_kelamin;
    private String nama, alamat, nip;
    private ArrayList<User> user_id = new ArrayList<>();

    public Guru(int jenis_kelamin, String nama, String alamat, String nip) {
        this.jenis_kelamin = jenis_kelamin;
        this.nama = nama;
        this.alamat = alamat;
        this.nip = nip;
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

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public ArrayList<User> getUser_id() {
        return user_id;
    }

    public void setUser_id(ArrayList<User> user_id) {
        this.user_id = user_id;
    }
    
}
