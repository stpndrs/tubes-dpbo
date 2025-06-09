/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import MissionUtil.Util;
import Model.Instansi;

public class InputInstansi {
    public static Instansi inputDataInstansi() {
        String nama = Util.inputString("Nama Instansi: ");
        String alamat = Util.inputString("Alamat: ");
        String telpon = Util.inputString("Telpon: ");
        int kouta = Util.inputInt("Kouta: ");

        return new Instansi(kouta, nama, alamat, telpon);
    }
}