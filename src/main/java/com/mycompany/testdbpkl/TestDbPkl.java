/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.testdbpkl;
import Login.UpdatePasswordKeHashPassword;
import Pengguna.Instansi;
import Pengguna.Siswa;
import data_monitoring.UpdateStatusSiswa;
import data_monitoring.UpdateStatusAdmin;
import data_presensi.TambahPresensi;
import tambahData.InputInstansi;
import tambahData.InputSiswa;
import tambahData.TambahSiswa;
import tambahData.tambahInstansi;

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
            //UpdatePasswordKeHashPassword.hashSemuaPassword();
            /*
            String username = MissionUtil.Util.inputString("masukkan username: ");
            String password = MissionUtil.Util.inputString("masukkan password: ");
            
            if(Login.AuthService.login(username, username)){
                System.out.println("login berhasil");
            }
            else{
                System.out.println("Login gagal");
            }
            */
            
        } else {
            System.out.println("Gagal membuka koneksi database.");
        }
    }
}
