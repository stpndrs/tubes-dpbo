/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tambahData;

import Pengguna.Guru;
import com.mycompany.testdbpkl.Connection;

import java.sql.PreparedStatement;

public class TambahGuru {

    public static void simpanGuru(Guru guru) {
        String query = "INSERT INTO guru (nama, alamat, nip, jenis_kelamin) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = Connection.bukaKoneksi().prepareStatement(query);
            stmt.setString(1, guru.getNama());
            stmt.setString(2, guru.getAlamat());
            stmt.setString(3, guru.getNip());
            stmt.setInt(4, guru.getJenis_kelamin());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Data guru berhasil ditambahkan.");
            } else {
                System.out.println("Gagal menambahkan data guru.");
            }

            stmt.close();
        } catch (Exception e) {
            System.err.println("Error saat menambahkan guru: " + e.getMessage());
        }
    }
}

