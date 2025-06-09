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

public class MonitoringController {

    public void tambahMonitoring(Monitoring monitoring) {
        //inputMonitoring input = new inputMonitoring();
        //Monitoring monitoring = input.inputDataMonitoring();

        String query = "INSERT INTO monitoring (siswa_id, guru_id) VALUES (?, ?)";

        try {
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query);
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
    
    public void editMonitoring(int idMonitoring, Monitoring monitoringBaru) {
    String query = "UPDATE monitoring SET siswa_id = ?, guru_id = ? WHERE id = ?";

    try {
        PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query);
        stmt.setInt(1, monitoringBaru.getSiswa_id().getId());
        stmt.setInt(2, monitoringBaru.getGuru_id().getId());
        stmt.setInt(3, idMonitoring);

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
}
