/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editProfilPengguna;

import com.mycompany.testdbpkl.Connection;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditPassword {

    public static boolean gantiPassword(int userId, String passwordLama, String passwordBaru) {
        String querySelect = "SELECT password FROM user WHERE id = ?";
        String queryUpdate = "UPDATE user SET password = ? WHERE id = ?";

        try (var conn = Connection.bukaKoneksi();
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
}
