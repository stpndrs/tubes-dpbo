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
public class Instansi {
    private int id, kouta;
    private String nama, alamat, telpon;
    private ArrayList<User> user_id = new ArrayList<>();

    public Instansi(int kouta, String nama, String alamat, String telpon, ArrayList<User> user_id ) {
        this.kouta = kouta;
        this.nama = nama;
        this.alamat = alamat;
        this.telpon = telpon;
        this.user_id = user_id;
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

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }

    public int getKouta() {
        return kouta;
    }

    public void setKouta(int kouta) {
        this.kouta = kouta;
    }
    
}
