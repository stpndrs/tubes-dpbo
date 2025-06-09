package ViewAdmin;

import java.util.ArrayList;

/**
 * Data Siswa PKL
 * @author Axio
 */
public class DataG {
    private String nama;
    private String alamat;
    private String jenisKelamin;
    private String Nip;
   

  
    private static ArrayList<DataG> Guru = new ArrayList<>();
    
    public static void data (){
        Guru.add(new DataG("awdada","dawdawd","Laki-Laki","awdawd"));
        Guru.add(new DataG("awda2312da","dawda2131wd","perempuan","aw12313dawd"));
        Guru.add(new DataG("awdada","dawd2133awd","perempuan","awdawd"));
        Guru.add(new DataG("awdada","dawdawd","Laki-Laki","awdawd"));
        Guru.add(new DataG("awdada","dawdawd","Laki-Laki","awdawd"));

    

    }

    public DataG(String nama, String alamat, String jenisKelamin, String Nip) {
        this.nama = nama;
        this.alamat = alamat;
        this.jenisKelamin = jenisKelamin;
        this.Nip = Nip;
        
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getNip() {
        return Nip;
    }

    public void setNip(String Nip) {
        this.Nip = Nip;
    }

    
    public static ArrayList<DataG> getGuru() {
        return Guru;
    }

    public static void setGuru(ArrayList<DataG> Guru) {
        DataG.Guru = Guru;
    }
    
    

}