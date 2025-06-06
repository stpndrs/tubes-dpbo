/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.testdbpkl;
import data_monitoring.UpdateStatus;
import data_monitoring.UpdateStatusAdmin;
import data_presensi.TambahPresensi;

public class TestDbPkl {

    public static void main(String[] args) {
        // Coba buka koneksi
        if (Connection.bukaKoneksi() != null) {
            System.out.println("CONNECT");
            
            // Jalankan proses tambah presensi
            //TambahPresensi tambahPresensi = new TambahPresensi();
            //tambahPresensi.tambah();
            //UpdateStatus.inputDanUpdateStatus();
            UpdateStatusAdmin.inputDanUpdateStatus();
            
        } else {
            System.out.println("Gagal membuka koneksi database.");
        }
    }
}
