/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin;

import com.mycompany.guiitubespbo.MainMenu;

/**
 *
 * @author Axioo Pongo
 */
public class Siswa extends MainMenu {
    private String nama;
    private boolean absen;
    

    
    
// true = absen, false = hadir

    public Siswa(String nama, boolean absen) {
        this.nama = nama;
        this.absen = absen;
    }

    // Getter untuk nama
    public String getNama() {
        return nama;
    }

    // Setter untuk nama
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter untuk status absen
    public boolean isAbsen() {
        return absen;
    }

    // Setter untuk status absen
    public void setAbsen(boolean absen) {
        this.absen = absen;
    }
}

