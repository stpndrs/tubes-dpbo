/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

//import com.mycompany.testdbpkl.Connection;
import DataBase.DBConnection;
import Model.Guru;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GuruController {

    public GuruController() {
    }
    public static void editGuru(Guru guru) {
        String query = "UPDATE guru SET nama = ?, alamat = ?, nip = ?, jenis_kelamin = ? WHERE id = ?";

        try {
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query);
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
        String query = "INSERT INTO guru (nama, alamat, nip, jenis_kelamin) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query);
            stmt.setString(1, guru.getNama());
            stmt.setString(2, guru.getAlamat());
            stmt.setString(3, guru.getNip());
            stmt.setInt(4, guru.getJenis_kelamin());

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
}
