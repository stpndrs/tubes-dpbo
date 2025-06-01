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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        main p = new main();
        p.runThis();
    }
    
    public void runThis(){
        users.add(new User("Fadhil", "fadhil123", "pass1", 1));
        users.add(new User("Ahnaf", "ahnaf456", "pass2", 1);
        users.add(new User("Rani", "rani789", "pass3", 2));
        users.add(new User("Budi", "budi321", "pass4", 1));
        users.add(new User("Sinta", "sinta654", "pass5", 2));
        
        Login();
        if(!Login()){
            runThis();
        }
        
        
    }
    
    public boolean validisai(String username, String password){
        for (User i : users) {
            if (i.getUsename().equals(username) && i.getPassword().equals(password)) {
                System.out.println("Login berhasil! Selamat datang, " + i.getNama());
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
}
