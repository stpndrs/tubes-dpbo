/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

//import com.mycompany.testdbpkl.Connection;
import static Controller.GuruController.getUserIdByUsername;
import DataBase.DBConnection;
import Model.Instansi;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InstansiController {
    public static void editInstansi(Instansi instansi) {
        String query = "UPDATE instansi SET nama = ?, alamat = ?, telepon = ?, kuota = ? WHERE id = ?";

        try {
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query);
            stmt.setString(1, instansi.getNama());
            stmt.setString(2, instansi.getAlamat());
            stmt.setString(3, instansi.getTelpon());
            stmt.setInt(4, instansi.getKuota());
            stmt.setInt(5, instansi.getId());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Data instansi berhasil diperbarui.");
            } else {
                System.out.println("Data instansi gagal diperbarui atau ID tidak ditemukan.");
            }

            stmt.close();
        } catch (SQLException e) {
            System.err.println("Gagal memperbarui data instansi: " + e.getMessage());
        }
    }
    
    public static void tambahInstansi(Instansi instansi) {
        String query = "INSERT INTO instansi (nama, alamat, telepon, kuota, user_id, pembimbing_instansi) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            //BUAT USER DULU
            User user = new User(instansi.getNama(), instansi.getPembimbing(), instansi.getPembimbing(), 4);
            UserController.tambahUser(user);
            
            //AMBIL USER ID  
            int user_id_instansi = getUserIdByUsername(user.getUsername());
            
            //MASUKKAN USER ID NYA
            instansi.setUser_id(user_id_instansi);
            
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query);
            stmt.setString(1, instansi.getNama());
            stmt.setString(2, instansi.getAlamat());
            stmt.setString(3, instansi.getTelpon());
            stmt.setInt(4, instansi.getKuota());
            stmt.setInt(5, instansi.getUser_id());
            stmt.setString(6, instansi.getPembimbing());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Data instansi berhasil ditambahkan. ");
            } else {
                System.out.println("Gagal menambahkan data instansi.");
            }

            stmt.close();
        } catch (Exception e) {
            System.err.println("Error saat menambahkan instansi: " + e.getMessage());
        }
    }
    
    public static int getUserIdByUsername(String username){
        int IdUser = 0;
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT id FROM user WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                IdUser = rs.getInt("id");
            }
            rs.close();
            stmt.close();
            System.out.println("User id  : " + IdUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return IdUser;
    }
}
