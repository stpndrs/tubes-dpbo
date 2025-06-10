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
    private String nama, alamat, telepon;
    private User user_id;

    public Instansi(int kouta, String nama, String alamat, String telepon ) {
        this.kuota = kouta;
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
    }
    
    public Instansi(){
        
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
