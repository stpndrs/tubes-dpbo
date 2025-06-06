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

public class UpdateStatusSiswa {
    
    // Metode untuk ambil input ID dan ubah status ke PENGAJUAN
    public static void inputDanUpdateStatus() {
        int idMonitoring = Util.inputInt("Masukkan ID Monitoring yang akan dipilih: ");
        int idInstansi = Util.inputInt("Masukkan ID Instansi yang akan dipilih: ");
        updateStatus(idMonitoring, statusPengajuan.Status.PENGAJUAN, idInstansi);
    }

    public static void updateStatus(int idMonitoring, Status statusBaru, int idInstansi) {
        String query = "UPDATE monitoring SET status = ?, instansi_id = ? WHERE id = ?";

        try {
            PreparedStatement stmt = Connection.bukaKoneksi().prepareStatement(query);
            stmt.setString(1, statusBaru.name().toLowerCase());
            stmt.setInt(2, idInstansi);
            stmt.setInt(3, idMonitoring);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Status berhasil diperbarui ke '" + statusBaru.name().toLowerCase() +
                        "' dan instansi_id diubah ke " + idInstansi + " untuk monitoring ID: " + idMonitoring);
            } else {
                System.out.println("Monitoring dengan ID " + idMonitoring + " tidak ditemukan.");
            }

            stmt.close();
        } catch (SQLException e) {
            System.err.println("Gagal memperbarui status dan instansi: " + e.getMessage());
        }
    }
}
