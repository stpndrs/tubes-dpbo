/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

//import com.mycompany.testdbpkl.Connection;
import DataBase.DBConnection;
import Model.Guru;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GuruController {

    public GuruController() {
    }
    public static void editGuru(Guru guru) {
        String query = "UPDATE guru SET nama = ?, alamat = ?, nip = ?, jenis_kelamin = ? WHERE id = ?";

        try {
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query);  // koneksi 
            stmt.setString(1, guru.getNama());
            stmt.setString(2, guru.getAlamat());
            stmt.setString(3, guru.getNip());
            stmt.setInt(4, guru.getJenis_kelamin());
            stmt.setInt(5, guru.getId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Data guru berhasil diperbarui.");
            } else {
                System.out.println("Data guru gagal diperbarui atau ID tidak ditemukan.");
            }

            stmt.close();
        } catch (SQLException e) {
            System.err.println("Gagal memperbarui data guru: " + e.getMessage());
        }
    }
    
    public static void tambahGuru(Guru guru) {
        String query = "INSERT INTO guru (nama, alamat, nip, jenis_kelamin, user_id) VALUES (?, ?, ?, ?, ?)";
        guru.setUser_id(getUserIdByUsername(guru.getNip()));
        try {
            //BUAT USER DULU
            User user = new User(guru.getNama(), guru.getNip(), guru.getNip(), 3);
            UserController.tambahUser(user);
            
            //AMBIL USER ID  
            int user_id_guru = getUserIdByUsername(user.getUsername());
            
            //MASUKKAN USER ID NYA
            guru.setUser_id(user_id_guru);
            
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query);
            stmt.setString(1, guru.getNama());
            stmt.setString(2, guru.getAlamat());
            stmt.setString(3, guru.getNip());
            stmt.setInt(4, guru.getJenis_kelamin());
            stmt.setInt(5, guru.getUser_id());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Data guru berhasil ditambahkan.");
            } else {
                System.out.println("Gagal menambahkan data guru.");
            }

            stmt.close();
        } catch (Exception e) {
            System.err.println("Error saat menambahkan guru: " + e.getMessage());
        }
    }
    
    public String konversiJenisKelamin(int jk){
        if(jk == 1){
            return "Laki-Laki";
        }
        return "Prempuan";
    }
    
    public static int getUserIdByUsername(String username){
        int IdUser = 0;
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT id FROM user WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                IdUser = rs.getInt("id");
            }
            rs.close();
            stmt.close();
            System.out.println("User id  : " + IdUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return IdUser;
    }
}
