/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editProfilPengguna;

import com.mycompany.testdbpkl.Connection;
import Pengguna.Instansi;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditProfilInstansi {
    public static void updateData(Instansi instansi) {
        String query = "UPDATE instansi SET nama = ?, alamat = ?, telpon = ?, kouta = ? WHERE id = ?";

        try {
            PreparedStatement stmt = Connection.bukaKoneksi().prepareStatement(query);
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
}
