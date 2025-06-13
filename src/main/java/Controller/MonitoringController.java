/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

//import com.mycompany.testdbpkl.Connection;
import DataBase.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Model.Monitoring;
import java.sql.Connection;
import java.sql.ResultSet;

public class MonitoringController {

    public void tambahMonitoring(Monitoring monitoring) {

        String query = "INSERT INTO monitoring (siswa_id, guru_id, instansi_id) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, monitoring.getSiswa_id());
            stmt.setInt(2, monitoring.getGuru_id());
            stmt.setInt(3, monitoring.getIsntansi_id());

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

    public void editMonitoring(Monitoring monitoringBaru) {
        String query = "UPDATE monitoring SET siswa_id = ?, guru_id = ?, instansi_id = ? WHERE id = ?";

        try {
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, monitoringBaru.getSiswa_id());
            stmt.setInt(2, monitoringBaru.getGuru_id());
            stmt.setInt(3, monitoringBaru.getIsntansi_id());
            stmt.setInt(4, monitoringBaru.getId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Data monitoring berhasil diperbarui.");
            } else {
                System.out.println("Monitoring dengan ID tersebut tidak ditemukan.");
            }

            stmt.close();
        } catch (SQLException e) {
            System.err.println("Gagal memperbarui monitoring: " + e.getMessage());
        }
    }

    public void setTanggalMonitoring(Monitoring monitoringBaru) {
        String query = "UPDATE monitoring SET tanggal_mulai = ?, tanggal_selesai = ? WHERE id = ?";
        
        try {
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query);
            stmt.setString(1, monitoringBaru.getMulai());
            stmt.setString(2, monitoringBaru.getSelesai());
            stmt.setInt(3, monitoringBaru.getId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Data monitoring berhasil diperbarui.");
            } else {
                System.out.println("Monitoring dengan ID tersebut tidak ditemukan.");
            }

            stmt.close();
        } catch (SQLException e) {
            System.err.println("Gagal memperbarui monitoring: " + e.getMessage());
        }
    }

    public String getNamaSiswaById(int id) {
        String nama = null;
        try {
            Connection conn = DBConnection.getConnection(); // gunakan koneksi yang kamu pakai
            String query = "SELECT nama FROM siswa WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                nama = rs.getString("nama");
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nama;
    }

    public String getNamaGuruById(int id) {
        String nama = null;
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT nama FROM guru WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                nama = rs.getString("nama");
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nama;
    }

    public String getNamaInstansiById(int id) {
        String nama = null;
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT nama FROM instansi WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                nama = rs.getString("nama");
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nama;
    }

    public Integer getIdSiswaByMonitoringId(int idMonitoring) {
        Integer idSiswa = null;
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT siswa_id FROM monitoring WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idMonitoring);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                idSiswa = rs.getInt("siswa_id");
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idSiswa;
    }

    public Integer getIdGuruByMonitoringId(int idMonitoring) {
        Integer idGuru = null;
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT guru_id FROM monitoring WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idMonitoring);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                idGuru = rs.getInt("guru_id");
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idGuru;
    }

    public Integer getIdInstansiByMonitoringId(int idMonitoring) {
        Integer idInstansi = null;
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT instansi_id FROM monitoring WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idMonitoring);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                idInstansi = rs.getInt("instansi_id");
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idInstansi;
    }

    //ADMIN
    public static void updateStatusAdmin(int idMonitoring, int statusBaru) {
        String updateQuery = "UPDATE monitoring SET status = ? WHERE id = ?";
        String kuotaQuery = "UPDATE instansi SET kuota = kuota - 1 WHERE id = ("
                + "SELECT instansi_id FROM monitoring WHERE id = ?) AND kuota > 0";

        try {
            PreparedStatement stmtUpdate = DBConnection.getConnection().prepareStatement(updateQuery);
            stmtUpdate.setInt(1, statusBaru);
            stmtUpdate.setInt(2, idMonitoring);

            int rowsAffected = stmtUpdate.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Status monitoring ID " + idMonitoring + " berhasil diubah ke status " + statusBaru);

                // Kurangi kuota hanya jika status adalah 2 (DITERIMA)
                if (statusBaru == 2) {
                    PreparedStatement stmtKuota = DBConnection.getConnection().prepareStatement(kuotaQuery);
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

    public static int getInstansiIdByMonitoringId(int monitoringId) {
        String query = "SELECT instansi_id FROM monitoring WHERE id = ?";
        try (var conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, monitoringId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("instansi_id");
            }

        } catch (SQLException e) {
            System.err.println("Gagal mengambil instansi_id: " + e.getMessage());
        }
        return -1;
    }

    public static Integer getIdSiswaByNisn(String nisn) {
        String sql = "SELECT id FROM siswa WHERE nisn = ?";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nisn);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            } else {
                System.out.println("Siswa dengan NISN tersebut tidak ditemukan.");
                return null;
            }

        } catch (SQLException e) {
            System.err.println("Gagal mengambil ID siswa: " + e.getMessage());
            return null;
        }
    }
    
    public static String converStatus(int status){
        if(status == 1){
            return "pengajuan";
        }
        else if(status == 2){
            return "diterima";
        } else if(status == 3){
            return "pelaksanaan";
        } else if(status == 4){
            return "selesai";
        }
        return "di tolak";
    }
}
