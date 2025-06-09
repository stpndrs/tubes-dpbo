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
    private int id, kouta;
    private String nama, alamat, telpon;
    private User user_id;

    public Instansi(int kouta, String nama, String alamat, String telpon ) {
        this.kouta = kouta;
        this.nama = nama;
        this.alamat = alamat;
        this.telpon = telpon;
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
        this.telpon = telpon;
    }

    public String getTelpon() {
        return telpon;
    }

    public int getKouta() {
        return kouta;
    }

    public void setKouta(int kouta) {
        this.kouta = kouta;
    }
    
}
