/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

//import com.mycompany.testdbpkl.Connection;
import DataBase.DBConnection;
import Model.Instansi;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InstansiController {
    public static void editInstansi(Instansi instansi) {
        String query = "UPDATE instansi SET nama = ?, alamat = ?, telpon = ?, kouta = ? WHERE id = ?";

        try {
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query);
            stmt.setString(1, instansi.getNama());
            stmt.setString(2, instansi.getAlamat());
            stmt.setString(3, instansi.getTelpon());
            stmt.setInt(4, instansi.getKouta());
            stmt.setInt(5, instansi.getId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Data instansi berhasil diperbarui.");
            } else {
                System.out.println("Data instansi gagal diperbarui atau ID tidak ditemukan.");
            }

            stmt.close();
        } catch (SQLException e) {
            System.err.println("Gagal memperbarui data instansi: " + e.getMessage());
        }
    }
    
    public static void tambahInstansi(Instansi instansi) {
        String query = "INSERT INTO instansi (nama, alamat, telpon, kouta) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query);
            stmt.setString(1, instansi.getNama());
            stmt.setString(2, instansi.getAlamat());
            stmt.setString(3, instansi.getTelpon());
            stmt.setInt(4, instansi.getKouta());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Data instansi berhasil ditambahkan. ");
            } else {
                System.out.println("Gagal menambahkan data instansi.");
            }

            stmt.close();
        } catch (Exception e) {
            System.err.println("Error saat menambahkan instansi: " + e.getMessage());
        }
    }
}
