/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editProfilPengguna;

import MissionUtil.Util;
import Pengguna.Guru;

public class InputEditGuru {
    public static Guru inputDataEdit() {
        int id = Util.inputInt("Masukkan ID guru yang ingin diubah: ");
        String nama = Util.inputString("Nama baru: ");
        String alamat = Util.inputString("Alamat baru: ");
        String nip = Util.inputString("NIP baru: ");
        int jk = Util.inputInt("Jenis Kelamin (0 = Laki-laki, 1 = Perempuan): ");

        Guru guru = new Guru(jk, nama, alamat, nip);
        guru.setId(id);
        return guru;
    }
}
