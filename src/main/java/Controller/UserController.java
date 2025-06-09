/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DataBase.DBConnection;
import Model.User;
//import com.mycompany.testdbpkl.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class UserController {
    public static void tambahUser(User user) {
        String query = "INSERT INTO User (nama, username, password, role) VALUES (?, ?, ?, ?)";
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

        try {
            PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query);
            stmt.setString(1, user.getNama());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, hashedPassword);
            stmt.setInt(4, user.getRole());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Data siswa berhasil ditambahkan.");
            } else {
                System.out.println("Gagal menambahkan data siswa.");
            }

            stmt.close();
        } catch (Exception e) {
            System.err.println("Error saat menambahkan siswa: " + e.getMessage());
        }
    }
    
    public static boolean gantiPassword(int userId, String passwordLama, String passwordBaru) {
        String querySelect = "SELECT password FROM user WHERE id = ?";
        String queryUpdate = "UPDATE user SET password = ? WHERE id = ?";

        try (var conn = DBConnection.getConnection();
             PreparedStatement stmtSelect = conn.prepareStatement(querySelect)) {

            stmtSelect.setInt(1, userId);
            ResultSet rs = stmtSelect.executeQuery();

            if (rs.next()) {
                String passwordTersimpan = rs.getString("password");

                // Verifikasi password lama
                if (BCrypt.checkpw(passwordLama, passwordTersimpan)) {
                    String hashedBaru = BCrypt.hashpw(passwordBaru, BCrypt.gensalt());

                    try (PreparedStatement stmtUpdate = conn.prepareStatement(queryUpdate)) {
                        stmtUpdate.setString(1, hashedBaru);
                        stmtUpdate.setInt(2, userId);
                        int rowsUpdated = stmtUpdate.executeUpdate();

                        return rowsUpdated > 0;
                    }
                } else {
                    System.out.println("Password lama salah.");
                    return false;
                }
            } else {
                System.out.println("User dengan ID tersebut tidak ditemukan.");
                return false;
            }

        } catch (SQLException e) {
            System.err.println("Gagal mengganti password: " + e.getMessage());
            return false;
        }
    }
    
    public static boolean gantiPasswordAdmin(int userId, String passwordBaru) {
    String queryUpdate = "UPDATE user SET password = ? WHERE id = ?";

    try (var conn = DBConnection.getConnection();
         PreparedStatement stmtUpdate = conn.prepareStatement(queryUpdate)) {

        // Hash password baru
        String hashedBaru = BCrypt.hashpw(passwordBaru, BCrypt.gensalt());

        stmtUpdate.setString(1, hashedBaru);
        stmtUpdate.setInt(2, userId);
        int rowsUpdated = stmtUpdate.executeUpdate();

        return rowsUpdated > 0;

    } catch (SQLException e) {
        System.err.println("Gagal mengganti password oleh admin: " + e.getMessage());
        return false;
        }
    }
    
    public static void editUser(User user) {
    String query = "UPDATE User SET nama = ?, username = ?, role = ? WHERE id = ?";

    try {
        PreparedStatement stmt = DBConnection.getConnection().prepareStatement(query);
        stmt.setString(1, user.getNama());
        stmt.setString(2, user.getUsername());
        stmt.setInt(3, user.getRole());
        stmt.setInt(4, user.getId());

        int rowsUpdated = stmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Data user berhasil diperbarui (tanpa mengubah password).");
        } else {
            System.out.println("User tidak ditemukan.");
        }

        stmt.close();
    } catch (Exception e) {
        System.err.println("Gagal memperbarui user: " + e.getMessage());
    }
}
}