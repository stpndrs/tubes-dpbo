/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MissionUtil;
import java.util.Scanner;

/**
 *
 * @author Pongo
 */
public class Util {
    private static final Scanner scanner = new Scanner(System.in);

    // Input String dengan pesan
    public static String inputString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    // Input Integer dengan pesan dan validasi
    public static int inputInt(String message) {
        int result;
        while (true) {
            System.out.print(message);
            try {
                result = Integer.parseInt(scanner.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka bulat.");
            }
        }
    }
}
