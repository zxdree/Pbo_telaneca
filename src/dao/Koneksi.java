package dao;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

public class Koneksi {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pbo_telaneca?serverTimezone=Asia/Jakarta";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";
    
    private static final MysqlDataSource dataSource = new MysqlDataSource();
    
    static {
        dataSource.setUrl(DB_URL);
        dataSource.setUser(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);
    }
    
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
