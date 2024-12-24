package dao;


import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dewi Puspita Sari
 */
public class Koneksi {
    public static Connection getConn() {
        MysqlDataSource dataSource = new MysqlDataSource();
        String DB_URL = "jdbc:mysql://localhost:3306/pbo_telaneca";
        String DB_USERNAME = "root";
        String DB_PASSWORD = "";

        dataSource.setUrl(DB_URL);
        dataSource.setUser(DB_USERNAME); 
        dataSource.setPassword(DB_PASSWORD);

        try {
            Connection conn = dataSource.getConnection(); 
            return conn;
        } catch (SQLException ex) {
            System.out.println("Eksepsi akses data: " + ex.getMessage());
            return null;
        }
    }
}
