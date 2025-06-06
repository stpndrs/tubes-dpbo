/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tambahData;

import MissionUtil.Util;
import Pengguna.Guru;
import Pengguna.Siswa;
import data_monitoring.Monitoring;

public class inputMonitoring {

    public Monitoring inputDataMonitoring() {
        int idSiswa = Util.inputInt("Masukkan ID Siswa: ");
        int idGuru = Util.inputInt("Masukkan ID Guru: ");

        Siswa siswa = new Siswa();
        siswa.setId(idSiswa);

        Guru guru = new Guru();
        guru.setId(idGuru);

        Monitoring monitoring = new Monitoring();
        monitoring.setSiswa_id(siswa);
        monitoring.setGuru_id(guru);

        return monitoring;
    }
}
