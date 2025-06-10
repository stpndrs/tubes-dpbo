/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import MissionUtil.Util;
import Model.Guru;
import Model.Siswa;
import Model.Monitoring;

public class inputMonitoring {

    public Monitoring inputDataMonitoring() {
        int idSiswa = Util.inputInt("Masukkan ID Siswa: ");
        int idGuru = Util.inputInt("Masukkan ID Guru: ");

        Monitoring monitoring = new Monitoring();
        monitoring.setSiswa_id(idSiswa);
        monitoring.setGuru_id(idGuru);

        return monitoring;
    }
}
