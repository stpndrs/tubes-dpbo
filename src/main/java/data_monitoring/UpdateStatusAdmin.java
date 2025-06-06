/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_monitoring;

import MissionUtil.Util;
import com.mycompany.testdbpkl.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateStatusAdmin {

    public static void inputDanUpdateStatus() {
        int idMonitoring = Util.inputInt("Masukkan ID Monitoring yang ingin diubah statusnya: ");

        // Tampilkan pilihan status
        System.out.println("Pilih status baru:");
        int i = 1;
        for (statusPengajuan.Status status : statusPengajuan.Status.values()) {
            System.out.println(i + ". " + status.name());
            i++;
        }

        int pilihan = Util.inputInt("Masukkan nomor status: ");
        if (pilihan < 1 || pilihan > statusPengajuan.Status.values().length) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        statusPengajuan.Status statusBaru = statusPengajuan.Status.values()[pilihan - 1];
        updateStatus(idMonitoring, statusBaru);
    }

    public static void updateStatus(int idMonitoring, statusPengajuan.Status statusBaru) {
        String query = "UPDATE monitoring SET status = ? WHERE id = ?";

        try {
            PreparedStatement stmt = Connection.bukaKoneksi().prepareStatement(query);
            stmt.setString(1, statusBaru.name().toLowerCase());
            stmt.setInt(2, idMonitoring);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Status monitoring ID " + idMonitoring + " berhasil diubah ke '" +
                        statusBaru.name().toLowerCase() + "'");
            } else {
                System.out.println("Monitoring dengan ID " + idMonitoring + " tidak ditemukan.");
            }

            stmt.close();
        } catch (SQLException e) {
            System.err.println("Gagal mengubah status: " + e.getMessage());
        }
    }
}

