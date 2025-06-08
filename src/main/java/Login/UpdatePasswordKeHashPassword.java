/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import com.mycompany.testdbpkl.Connection;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdatePasswordKeHashPassword {
    public static void hashSemuaPassword() {
        String selectQuery = "SELECT id, password, hashed_password FROM user";
        String updateQuery = "UPDATE user SET hashed_password = ? WHERE id = ?";

        try (var conn = Connection.bukaKoneksi();
             PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
             ResultSet rs = selectStmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String plainPassword = rs.getString("password");
                String hashedPassword = rs.getString("hashed_password");

                if (hashedPassword == null || hashedPassword.isEmpty()) {
                    String hashed = BCrypt.hashpw(plainPassword, BCrypt.gensalt());

                    try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                        updateStmt.setString(1, hashed);
                        updateStmt.setInt(2, id);
                        updateStmt.executeUpdate();

                        System.out.println("Hashed password untuk user ID " + id + " berhasil ditambahkan.");
                    }
                } else {
                    System.out.println("User ID " + id + " sudah memiliki hashed password. Lewat.");
                }
            }

        } catch (SQLException e) {
            System.err.println("Gagal melakukan hashing password: " + e.getMessage());
        }
    }
}
