/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

/**
 *
 * @author Pongo
 */
public class Session {
    int id_user, id_penguna, id_monitoring, kuota;
    String nama, kode, jenis_kelamin, kelas, alamat, telepon, password;

    public void SessionSiswa(int id_user, int id_penguna, int id_monitoring, String nama, String jenis_kelamin, String kelas, String alamat) {
        this.id_user = id_user;
        this.id_penguna = id_penguna;
        this.id_monitoring = id_monitoring;
        this.nama = nama;
        this.jenis_kelamin = jenis_kelamin;
        this.kelas = kelas;
        this.alamat = alamat;
    }
    
    
}
