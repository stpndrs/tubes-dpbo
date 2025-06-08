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

public class AuthService {

    // Mengembalikan true jika login berhasil
    public static boolean login(String username, String password) {
        String query = "SELECT password FROM user WHERE username = ?";

        try {
            PreparedStatement stmt = Connection.bukaKoneksi().prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("password");

                // Cek apakah password cocok
                if (hashedPassword != null && BCrypt.checkpw(password, hashedPassword)) {
                    return true; // Login berhasil
                }
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Gagal melakukan login: " + e.getMessage());
        }

        return false; // Login gagal
    }
}
