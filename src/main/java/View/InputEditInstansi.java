/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import MissionUtil.Util;
import Model.Instansi;

public class InputEditInstansi {
    public static Instansi inputDataEdit() {
        int id = Util.inputInt("Masukkan ID instansi yang ingin diubah: ");
        String nama = Util.inputString("Nama baru: ");
        String alamat = Util.inputString("Alamat baru: ");
        String telpon = Util.inputString("Telpon baru: ");
        int kouta = Util.inputInt("Kouta baru: ");
        String pembimbing_instansi = Util.inputString("Masukkan pembimbing: ");

        Instansi instansi = new Instansi(kouta, nama, alamat, telpon, pembimbing_instansi);
        instansi.setId(id);
        return instansi;
    }
}
