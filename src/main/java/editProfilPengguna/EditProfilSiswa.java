/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editProfilPengguna;

import com.mycompany.testdbpkl.Connection;
import Pengguna.Siswa;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditProfilSiswa {
    public static void updateData(Siswa siswa) {
        String query = "UPDATE siswa SET nama = ?, alamat = ?, nisn = ?, kelas = ?, jenis_kelamin = ? WHERE id = ?";

        try {
            PreparedStatement stmt = Connection.bukaKoneksi().prepareStatement(query);
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
}
