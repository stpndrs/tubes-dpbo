/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tambahData;

import Pengguna.User;
import com.mycompany.testdbpkl.Connection;

import java.sql.PreparedStatement;
import org.mindrot.jbcrypt.BCrypt;

public class TambahUser {
    public static void simpanUser(User user) {
        String query = "INSERT INTO User (nama, username, password, role) VALUES (?, ?, ?, ?)";
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

        try {
            PreparedStatement stmt = Connection.bukaKoneksi().prepareStatement(query);
            stmt.setString(1, user.getNama());
            stmt.setString(2, user.getUsename());
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
}