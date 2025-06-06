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
    String updateQuery = "UPDATE monitoring SET status = ? WHERE id = ?";
    String kuotaQuery = "UPDATE instansi SET kouta = kouta - 1 WHERE id = (" +
                        "SELECT instansi_id FROM monitoring WHERE id = ?) AND kouta > 0";

    try {
        PreparedStatement stmtUpdate = Connection.bukaKoneksi().prepareStatement(updateQuery);
        stmtUpdate.setString(1, statusBaru.name().toLowerCase());
        stmtUpdate.setInt(2, idMonitoring);

        int rowsAffected = stmtUpdate.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Status monitoring ID " + idMonitoring + " berhasil diubah ke '" +
                    statusBaru.name().toLowerCase() + "'");

            // Kurangi kuota hanya jika status adalah DITERIMA
            if (statusBaru == statusPengajuan.Status.DITERIMA) {
                PreparedStatement stmtKuota = Connection.bukaKoneksi().prepareStatement(kuotaQuery);
                stmtKuota.setInt(1, idMonitoring);

                int kuotaAffected = stmtKuota.executeUpdate();
                if (kuotaAffected > 0) {
                    System.out.println("Kuota instansi berhasil dikurangi.");
                } else {
                    System.out.println("Gagal mengurangi kuota: kuota sudah habis atau instansi tidak ditemukan.");
                }

                stmtKuota.close();
            }

        } else {
            System.out.println("Monitoring dengan ID " + idMonitoring + " tidak ditemukan.");
        }

        stmtUpdate.close();
    } catch (SQLException e) {
        System.err.println("Gagal mengubah status: " + e.getMessage());
    }
}
}

