/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tambahData;

import MissionUtil.Util;
import Pengguna.User;

public class InputUser {
    public static User inputDataUser() {
        String nama = Util.inputString("Nama: ");
        String username = Util.inputString("Username: ");
        String password = Util.inputString("Password: ");
        int role = Util.inputInt("role: ");

        return new User(nama, username, password, role);
    }
}