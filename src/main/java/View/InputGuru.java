/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import MissionUtil.Util;
import Model.Guru;

public class InputGuru {

    public static Guru inputDataGuru() {
        String nama = Util.inputString("Nama: ");
        String alamat = Util.inputString("Alamat: ");
        String nip = Util.inputString("NIP: ");
        int jenisKelamin = Util.inputInt("Jenis Kelamin (1=Laki-laki, 2=Perempuan): ");

        return new Guru(jenisKelamin, nama, alamat, nip);
    }
}