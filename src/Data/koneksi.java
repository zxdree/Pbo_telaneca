/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

public class koneksi {
    private static koneksi instance; // Singleton instance
    private final MysqlDataSource dataSource;

    // Constructor private untuk mengimplementasikan Singleton
    koneksi() {

        dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/pbo_telaneca?serverTimezone=Asia/Jakarta");
        dataSource.setUser("root");
        dataSource.setPassword("");
    }

    // Method untuk mendapatkan instance tunggal dari kelas koneksi
    public static koneksi getInstance() {
        if (instance == null) {
            synchronized (koneksi.class) {
                if (instance == null) {
                    instance = new koneksi();
                }
            }
        }
        return instance;
    }

    // Method untuk mendapatkan koneksi ke database
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
