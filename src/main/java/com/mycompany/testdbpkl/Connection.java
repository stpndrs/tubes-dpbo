/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testdbpkl;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pongo
 */
public class Connection {

    private static java.sql.Connection conn;
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_NAME = "dpbo_pkl";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/" + DB_NAME;
    private static final String DB_UNAME = "root";
    private static final String DB_PASS = "";

    public static java.sql.Connection bukaKoneksi() {
        System.out.println("testasd");
        if (conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PASS);
            } catch (ClassNotFoundException e) {
                System.err.format("Class not found");
            } catch (SQLException e) {
                System.err.format("SQL State: $s\n$s", e.getSQLState(), e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
