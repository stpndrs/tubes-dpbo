/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DataBase.DBConnection;
//import com.mycompany.testdbpkl.Connection;
import Model.Siswa;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SiswaController {
    public static void editSiswa(Siswa siswa) {
        String query = "UPDATE siswa SET nama = ?, alamat = ?, nisn = ?, kelas = ?, jenis_kelamin = ? WHERE id = ?";

        try {
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query);
            stmt.setString(1, siswa.getNama());
            stmt.setString(2, siswa.getAlamat());
            stmt.setString(3, siswa.getNisn());
            stmt.setString(4, siswa.getKelas());
            stmt.setInt(5, siswa.getJenis_kelamin());
            stmt.setInt(6, siswa.getId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Data siswa berhasil diperbarui.");
            } else {
                System.out.println("Data siswa gagal diperbarui atau ID tidak ditemukan.");
            }

            stmt.close();
        } catch (SQLException e) {
            System.err.println("Gagal memperbarui data siswa: " + e.getMessage());
        }
    }
    
    public static void tambahSiswa(Siswa siswa) {
        String query = "INSERT INTO siswa (nama, alamat, nisn, kelas, jenis_kelamin) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query);
            stmt.setString(1, siswa.getNama());
            stmt.setString(2, siswa.getAlamat());
            stmt.setString(3, siswa.getNisn());
            stmt.setString(4, siswa.getKelas());
            stmt.setInt(5, siswa.getJenis_kelamin());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Data siswa berhasil ditambahkan.");
            } else {
                System.out.println("Gagal menambahkan data siswa.");
            }

            stmt.close();
        } catch (Exception e) {
            System.err.println("Error saat menambahkan siswa: " + e.getMessage());
        }
    }
    
    public static String konversiJenisKelamin(int jk){
        if(jk == 1){
            return "Laki-Laki";
        }
        return "Prempuan";
    }
}
