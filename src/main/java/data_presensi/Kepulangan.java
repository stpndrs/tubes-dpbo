/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_presensi;

import com.mycompany.testdbpkl.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Kepulangan {

    public boolean setJamKeluar(int monitoringId) {
        String tanggal = Waktu.getTanggalHariIni();
        String jamKeluar = Waktu.getJamSekarang();

        String query = "UPDATE presensi SET jam_keluar = ? WHERE monitoring_id = ? AND tanggal = ?";

        try {
            PreparedStatement stmt = Connection.bukaKoneksi().prepareStatement(query);
            stmt.setString(1, jamKeluar);
            stmt.setInt(2, monitoringId);
            stmt.setString(3, tanggal);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}