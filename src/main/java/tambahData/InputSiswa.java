/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tambahData;

import MissionUtil.Util;
import Pengguna.Siswa;

public class InputSiswa {
    public static Siswa inputDataSiswa() {
        String nama = Util.inputString("Nama: ");
        String alamat = Util.inputString("Alamat: ");
        String nisn = Util.inputString("NISN: ");
        String kelas = Util.inputString("Kelas: ");
        int jenisKelamin = Util.inputInt("Jenis Kelamin (1=Laki-laki, 2=Perempuan): ");

        return new Siswa(jenisKelamin, nama, alamat, nisn, kelas);
    }
}
