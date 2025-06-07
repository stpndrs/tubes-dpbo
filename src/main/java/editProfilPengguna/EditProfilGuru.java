/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editProfilPengguna;

import com.mycompany.testdbpkl.Connection;
import Pengguna.Guru;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditProfilGuru {
    public static void updateData(Guru guru) {
        String query = "UPDATE guru SET nama = ?, alamat = ?, nip = ?, jenis_kelamin = ? WHERE id = ?";

        try {
            PreparedStatement stmt = Connection.bukaKoneksi().prepareStatement(query);
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
}
