/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.ArrayList;
/**
 *
 * @author Pongo
 */
public class Instansi {
    private int id, kuota;
    private String nama, alamat, telepon, pembimbing;
    private int user_id;

    public Instansi(int kouta, String nama, String alamat, String telepon, String pembimbing) {
        this.kuota = kouta;
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
        this.pembimbing = pembimbing;
    }
    
    public Instansi(){
        
    }

    public void setPembimbing(String pembimbing) {
        this.pembimbing = pembimbing;
    }

    public String getPembimbing() {
        return pembimbing;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        this.telepon = telpon;
    }

    public String getTelpon() {
        return telepon;
    }

    public int getKuota() {
        return kuota;
    }

    public void setKouta(int kouta) {
        this.kuota = kouta;
    }
    
}
