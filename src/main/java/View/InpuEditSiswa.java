/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import MissionUtil.Util;
import Model.Siswa;

public class InpuEditSiswa {
    public static Siswa inputDataEdit() {
        int id = Util.inputInt("Masukkan ID siswa yang ingin diubah: ");
        String nama = Util.inputString("Nama baru: ");
        String alamat = Util.inputString("Alamat baru: ");
        String nisn = Util.inputString("NISN baru: ");
        String kelas = Util.inputString("Kelas baru: ");
        int jk = Util.inputInt("Jenis Kelamin (0 = Laki-laki, 1 = Perempuan): ");

        Siswa siswa = new Siswa(jk, nama, alamat, nisn, kelas);
        siswa.setId(id);
        return siswa;
    }
}
