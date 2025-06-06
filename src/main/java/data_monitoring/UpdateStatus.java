/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_monitoring;

import MissionUtil.Util;
import com.mycompany.testdbpkl.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import data_monitoring.statusPengajuan.Status;

public class UpdateStatus {
    
    // Metode untuk ambil input ID dan ubah status ke PENGAJUAN
    public static void inputDanUpdateStatus() {
        int idMonitoring = Util.inputInt("Masukkan ID Monitoring yang akan dipilih: ");
        updateStatus(idMonitoring, statusPengajuan.Status.PENGAJUAN);
    }

    public static void updateStatus(int idMonitoring, Status statusBaru) {
        String query = "UPDATE monitoring SET status = ? WHERE id = ?";

        try {
            PreparedStatement stmt = Connection.bukaKoneksi().prepareStatement(query);
            stmt.setString(1, statusBaru.name().toLowerCase());
            stmt.setInt(2, idMonitoring);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Status berhasil diperbarui ke '" + statusBaru.name().toLowerCase() +
                        "' untuk monitoring ID: " + idMonitoring);
            } else {
                System.out.println("Monitoring dengan ID " + idMonitoring + " tidak ditemukan.");
            }

            stmt.close();
        } catch (SQLException e) {
            System.err.println("Gagal memperbarui status: " + e.getMessage());
        }
    }
}
