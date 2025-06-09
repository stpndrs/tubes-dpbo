/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Pongo
 */
public class User {
    private int id, role;
    private String nama, usename, password;

    public User(String nama, String usename, String password, int role) {
        this.role = role;
        this.nama = nama;
        this.usename = usename;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getUsername() {
        return usename;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }
}
