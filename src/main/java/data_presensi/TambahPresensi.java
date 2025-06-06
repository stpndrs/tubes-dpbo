/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_presensi;

import MissionUtil.Util;
import com.mycompany.testdbpkl.Connection;
import data_monitoring.Monitoring;
import Pengguna.Guru;
import Pengguna.Siswa;
import Pengguna.Instansi;
import data_monitoring.MonitoringViewer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TambahPresensi {

    public void tambah() {
        MonitoringViewer.tampilkanDaftarMonitoring();
        int monitoringId = Util.inputInt("Masukkan ID Monitoring: ");

        Monitoring monitoring = getMonitoringById(monitoringId);
        if (monitoring == null) {
            System.out.println("Monitoring tidak ditemukan.");
            return;
        }

        String tanggal = Waktu.getTanggalHariIni();
        String jamMasuk = Waktu.getJamSekarang();
        int status = Util.inputInt("1. Hadir \n 2. Sakit \n 3. izin \n Masukkan status: ");
        String keterangan = Util.inputString("Masukkan keterangan: ");

        masukkanData(monitoring, tanggal, jamMasuk, keterangan, status);
    }

    private Monitoring getMonitoringById(int id) {
        Monitoring monitoring = null;
        String query = "SELECT * FROM monitoring WHERE id = ?";

        try {
            PreparedStatement stmt = Connection.bukaKoneksi().prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Siswa siswa = new Siswa();
                siswa.setId(rs.getInt("siswa_id"));

                Instansi instansi = new Instansi();
                instansi.setId(rs.getInt("instansi_id"));

                Guru guru = new Guru();
                guru.setId(rs.getInt("guru_id"));

                monitoring = new Monitoring(siswa, instansi, guru);
                monitoring.setId(id);
                monitoring.setTanggal_mulai(rs.getString("tanggal_mulai"));
                monitoring.setTanggal_selesai(rs.getString("tanggal_selesai"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Gagal mengambil monitoring: " + e.getMessage());
        }

        return monitoring;
    }

    private void masukkanData(Monitoring monitoring, String tanggal, String jamMasuk, String keterangan, int status) {
        String query = "INSERT INTO presensi (monitring_id, tanggal, jam_masuk, keterangan, status) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = Connection.bukaKoneksi().prepareStatement(query);
            stmt.setInt(1, monitoring.getId());
            stmt.setString(2, tanggal);
            stmt.setString(3, jamMasuk);
            stmt.setString(4, keterangan);
            stmt.setInt(5, status);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Presensi berhasil disimpan ke database.");
            }

            stmt.close();
        } catch (SQLException e) {
            System.err.println("Gagal menyimpan presensi: " + e.getMessage());
        }
    }
}

