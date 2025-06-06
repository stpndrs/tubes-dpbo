/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tambahData;

import com.mycompany.testdbpkl.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import data_monitoring.Monitoring;

public class TambahMonitoring {

    public void tambahMonitoring() {
        inputMonitoring input = new inputMonitoring();
        Monitoring monitoring = input.inputDataMonitoring();

        String query = "INSERT INTO monitoring (siswa_id, guru_id) VALUES (?, ?)";

        try {
            PreparedStatement stmt = Connection.bukaKoneksi().prepareStatement(query);
            stmt.setInt(1, monitoring.getSiswa_id().getId());
            stmt.setInt(2, monitoring.getGuru_id().getId());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Monitoring berhasil ditambahkan.");
            } else {
                System.out.println("Gagal menambahkan monitoring.");
            }

            stmt.close();
        } catch (SQLException e) {
            System.err.println("Gagal menyimpan monitoring: " + e.getMessage());
        }
    }
}
