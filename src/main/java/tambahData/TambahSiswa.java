/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tambahData;

import Pengguna.Siswa;
import com.mycompany.testdbpkl.Connection;

import java.sql.PreparedStatement;

public class TambahSiswa {
    public static void simpanSiswa(Siswa siswa) {
        String query = "INSERT INTO siswa (nama, alamat, nisn, kelas, jenis_kelamin) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = Connection.bukaKoneksi().prepareStatement(query);
            stmt.setString(1, siswa.getNama());
            stmt.setString(2, siswa.getAlamat());
            stmt.setString(3, siswa.getNisn());
            stmt.setString(4, siswa.getKelas());
            stmt.setInt(5, siswa.getJenis_kelamin());

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
