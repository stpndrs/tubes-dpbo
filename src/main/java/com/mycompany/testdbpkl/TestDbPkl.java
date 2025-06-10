/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.testdbpkl;
//import Login.UpdatePasswordKeHashPassword;
//import Model.Instansi;

import Login.AuthService;
import ViewLogin.LoginView;
import Login.UpdatePasswordKeHashPassword;

//import Model.Siswa;
//import Controller.UpdateStatusSiswa;
//import Controller.UpdateStatusAdmin;
//import Controller.TambahPresensi;
//import View.InputInstansi;
//import View.InputSiswa;
//import Controller.TambahSiswa;
//import Controller.tambahInstansi;

public class TestDbPkl {

    public static void main(String[] args) {
        // Coba buka koneksi
        if (DataBase.DBConnection.getConnection()!= null) {
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
            //UpdatePasswordKeHashPassword.hashSemuaPassword();
            
            new LoginView().setVisible(true);
           
        } else {
            System.out.println("Gagal membuka koneksi database.");
        }
    }
}
