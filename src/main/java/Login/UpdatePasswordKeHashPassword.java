/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import DataBase.DBConnection;
//import com.mycompany.testdbpkl.Connection;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdatePasswordKeHashPassword {

    // Cek apakah password sudah di-hash dengan BCrypt
    private static boolean isBCryptHashed(String password) {
        return password != null && password.startsWith("$2") && password.length() == 60;
    }

    public static void hashSemuaPassword() {
        String selectQuery = "SELECT id, password FROM user";
        String updateQuery = "UPDATE user SET password = ? WHERE id = ?";

        try (var conn = DBConnection.getConnection();
             PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
             ResultSet rs = selectStmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String password = rs.getString("password");

                if (!isBCryptHashed(password)) {
                    // Password belum di-hash → hash dan simpan kembali
                    String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

                    try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                        updateStmt.setString(1, hashed);
                        updateStmt.setInt(2, id);
                        updateStmt.executeUpdate();

                        System.out.println("User ID " + id + ": password berhasil di-hash dan diperbarui.");
                    }
                } else {
                    System.out.println("User ID " + id + ": password sudah hashed, dilewati.");
                }
            }

        } catch (SQLException e) {
            System.err.println("Gagal memproses password: " + e.getMessage());
        }
    }
}
