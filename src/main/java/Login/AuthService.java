/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DataBase.DBConnection;
import org.mindrot.jbcrypt.BCrypt;
import Session.Session;

public class AuthService {

    public static boolean login(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = (Connection) DBConnection.getConnection(); // Koneksi baru setiap kali login
            if (con == null) {
                System.out.println("Koneksi database null");
                return false;
            }

            String query = "SELECT * FROM user WHERE username = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("password");
                int idUser = rs.getInt("id");
                int role = rs.getInt("role");

                // Periksa password
                if (BCrypt.checkpw(password, hashedPassword)) {
                    Session.setId_user(idUser);
                    Session.setRole(role);
                    System.out.println("Login berhasil untuk user ID: " + idUser);
                    return true;
                } else {
                    System.out.println("Password salah.");
                    return false;
                }
            } else {
                System.out.println("Username tidak ditemukan.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Gagal melakukan login: " + e.getMessage());
            return false;
        } finally {
            // Tutup semua resources (best practice)
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }
}
