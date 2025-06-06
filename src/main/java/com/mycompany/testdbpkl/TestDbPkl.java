/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.testdbpkl;
import Pengguna.Instansi;
import Pengguna.Siswa;
import data_monitoring.UpdateStatusSiswa;
import data_monitoring.UpdateStatusAdmin;
import data_presensi.TambahPresensi;
import tambahData.InputInstansi;
import tambahData.InputSiswa;
import tambahData.TambahSiswa;
import tambahData.TambahInstansi;

public class TestDbPkl {

    public static void main(String[] args) {
        // Coba buka koneksi
        if (Connection.bukaKoneksi() != null) {
            System.out.println("CONNECT");
            
            // Jalankan proses tambah presensi
            //TambahPresensi tambahPresensi = new TambahPresensi();
            //tambahPresensi.tambah();
            
            //UpdateStatus.inputDanUpdateStatus();
            
            //UpdateStatusAdmin.inputDanUpdateStatus();
            
            //Siswa siswaBaru = InputSiswa.inputDataSiswa();
            //TambahSiswa.simpanSiswa(siswaBaru);
            
            //Instansi instansiBaru = InputInstansi.inputDataInstansi();
            //TambahInstansi.simpanInstansi(instansiBaru);
            
        } else {
            System.out.println("Gagal membuka koneksi database.");
        }
    }
}
