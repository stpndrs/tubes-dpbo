/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tambahData;

import Pengguna.Instansi;
import com.mycompany.testdbpkl.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class tambahInstansi{
    public static void simpanInstansi(Instansi instansi) {
        String query = "INSERT INTO instansi (nama, alamat, telpon, kouta) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = Connection.bukaKoneksi().prepareStatement(query);
            stmt.setString(1, instansi.getNama());
            stmt.setString(2, instansi.getAlamat());
            stmt.setString(3, instansi.getTelpon());
            stmt.setInt(4, instansi.getKouta());

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
}
