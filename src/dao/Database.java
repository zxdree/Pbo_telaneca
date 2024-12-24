package dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Database {
    
    public static void setDataOrDelete(String query, String msg) {
        try (Connection conn = Koneksi.getConnection();
             Statement st = conn.createStatement()) {
            st.executeUpdate(query);
            if (!msg.isEmpty()) {
                JOptionPane.showMessageDialog(null, msg);
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static ResultSet getData(String query) {
        try {
            Connection conn = Koneksi.getConnection();
            Statement st = conn.createStatement();
            return st.executeQuery(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
