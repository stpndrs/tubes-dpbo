/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.tubes_pbo;
import java.util.Scanner;
import java.util.ArrayList;
import Pengguna.User;
/**
 *
 * @author Pongo
 */
public class main {
    Scanner input = new Scanner(System.in);
    ArrayList<User> users = new ArrayList<>();
    int noRole;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        main p = new main();
        int noRole;
        p.runThis();
    }
    
    public void runThis(){
        users.add(new User("Fadhil", "fadhil123", "pass1", 1));
        users.add(new User("Rani", "rani789", "pass3", 2));
        users.add(new User("Budi", "budi321", "pass4", 3));
        users.add(new User("Sinta", "sinta654", "pass5", 4));
        
        /*
            rolo 1 = admin
            role 2 = siswa
            role 3 = guru
            role 4 = instansi
        */
        
        if(!Login()){
            runThis();
        }
        
        if(this.noRole == 1){
            menuAdmin();
        } else if(this.noRole == 2){
            menuSiswa();
        } else if (this.noRole == 3){
            menuGuru();
        } else{
            menuInstansi();
        }
    }
    
    public boolean validisai(String username, String password){
        for (User i : users) {
            if (i.getUsename().equals(username) && i.getPassword().equals(password)) {
                System.out.println("Login berhasil! Selamat datang, " + i.getNama());
                noRole = i.getRole();
                return true;
            }
        }
        System.out.println("Login gagal! Username atau password salah.");
        return false;
    }
    
    public boolean Login(){
        System.out.println("Masukkan username anda: ");
        String username = input.nextLine();
        System.out.println("Masukkan password anda: ");
        String pass = input.nextLine();
        return validisai(username, pass);
    }
    
    public void menuAdmin(){
        
    }
    
    public void menuSiswa(){
        
    }
    
    public void menuGuru(){
        
    }
    
    public void menuInstansi(){
        
    }
}
