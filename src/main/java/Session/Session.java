/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Session;

import DataBase.DBConnection;
//import com.mycompany.testdbpkl.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Session {

    private static int id_user;
    private static String nama;
    private static String username;
    private static String password;
    private static int role;

    // Untuk Siswa
    private static int id_siswa;
    private static String nisn;
    private static String alamat_siswa;
    private static int jenis_kelamin_siswa;
    private static String kelas;

    // Untuk Guru
    private static int id_guru;
    private static String nip;
    private static String alamat_guru;
    private static int jenis_kelamin_guru;

    // Untuk Instansi
    private static int id_instansi;
    private static String nama_instansi;
    private static String alamat_instansi;
    private static String telepon;
    private static int kuota;

    // ===================== SETTER =====================

    public static void setId_user(int id) {
        id_user = id;
    }

    public static void setRole(int r) {
        role = r;
    }

    // ===================== GETTER =====================

    public static int getId_user() {
        return id_user;
    }

    public static int getRole() {
        return role;
    }

    public static String getNama() {
        return nama;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    // === Siswa ===
    public static int getId_siswa() {
        return id_siswa;
    }

    public static String getNisn() {
        return nisn;
    }

    public static String getAlamat_siswa() {
        return alamat_siswa;
    }

    public static int getJenis_kelamin_siswa() {
        return jenis_kelamin_siswa;
    }

    public static String getKelas() {
        return kelas;
    }

    // === Guru ===
    public static int getId_guru() {
        return id_guru;
    }

    public static String getNip() {
        return nip;
    }

    public static String getAlamat_guru() {
        return alamat_guru;
    }

    public static int getJenis_kelamin_guru() {
        return jenis_kelamin_guru;
    }

    // === Instansi ===
    public static int getId_instansi() {
        return id_instansi;
    }

    public static String getNama_instansi() {
        return nama_instansi;
    }

    public static String getAlamat_instansi() {
        return alamat_instansi;
    }

    public static String getTelepon() {
        return telepon;
    }

    public static int getKuota() {
        return kuota;
    }

    // ===================== SESSION LOADER =====================

    public static void sessionSiswa() {
        String sql = "SELECT s.id, s.nisn, s.alamat, s.jenis_kelamin, s.kelas, " +
                     "u.nama, u.username, u.password " +
                     "FROM siswa s JOIN user u ON s.user_id = u.id " +
                     "WHERE u.id = ?";

        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id_user);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id_siswa = rs.getInt("id");
                nisn = rs.getString("nisn");
                alamat_siswa = rs.getString("alamat");
                jenis_kelamin_siswa = rs.getInt("jenis_kelamin");
                kelas = rs.getString("kelas");

                nama = rs.getString("nama");
                username = rs.getString("username");
                password = rs.getString("password");
            }

        } catch (Exception e) {
            System.err.println("Gagal memuat sesi siswa: " + e.getMessage());
        }
    }

    public static void sessionGuru() {
        String sql = "SELECT g.id, g.nip, g.alamat, g.jenis_kelamin, " +
                     "u.nama, u.username, u.password " +
                     "FROM guru g JOIN user u ON g.user_id = u.id " +
                     "WHERE u.id = ?";

        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id_user);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id_guru = rs.getInt("id");
                nip = rs.getString("nip");
                alamat_guru = rs.getString("alamat");
                jenis_kelamin_guru = rs.getInt("jenis_kelamin");

                nama = rs.getString("nama");
                username = rs.getString("username");
                password = rs.getString("password");
            }

        } catch (Exception e) {
            System.err.println("Gagal memuat sesi guru: " + e.getMessage());
        }
    }

    public static void sessionInstansi() {
        String sql = "SELECT i.id, i.nama, i.alamat, i.telepon, i.kuota, " +
                     "u.nama AS user_nama, u.username, u.password " +
                     "FROM instansi i JOIN user u ON i.user_id = u.id " +
                     "WHERE u.id = ?";

        try (PreparedStatement stmt = DBConnection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id_user);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id_instansi = rs.getInt("id");
                nama_instansi = rs.getString("nama");
                alamat_instansi = rs.getString("alamat");
                telepon = rs.getString("telepon");
                kuota = rs.getInt("kuota");

                nama = rs.getString("user_nama");
                username = rs.getString("username");
                password = rs.getString("password");
            }

        } catch (Exception e) {
            System.err.println("Gagal memuat sesi instansi: " + e.getMessage());
        }
    }
    
    public static void clear() {
        id_user = 0;
        nama = null;
        username = null;
        password = null;
        role = 0;

        // Siswa
        id_siswa = 0;
        nisn = null;
        alamat_siswa = null;
        jenis_kelamin_siswa = 0;
        kelas = null;

        // Guru
        id_guru = 0;
        nip = null;
        alamat_guru = null;
        jenis_kelamin_guru = 0;

        // Instansi
        id_instansi = 0;
        nama_instansi = null;
        alamat_instansi = null;
        telepon = null;
        kuota = 0;
    }
}

