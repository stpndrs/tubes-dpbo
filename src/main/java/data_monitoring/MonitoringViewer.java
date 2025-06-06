/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_monitoring;

import com.mycompany.testdbpkl.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MonitoringViewer {
    public static void tampilkanDaftarMonitoring() {
        String query = "SELECT id, siswa_id, instansi_id, guru_id FROM monitoring";

        try {
            PreparedStatement stmt = Connection.bukaKoneksi().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            System.out.println("===== Daftar Monitoring =====");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        "\t | Siswa ID: " + rs.getInt("siswa_id") +
                        "\t | Instansi ID: " + rs.getInt("instansi_id") +
                        "\t | Guru ID: " + rs.getInt("guru_id"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Gagal menampilkan data monitoring: " + e.getMessage());
        }
    }
}

