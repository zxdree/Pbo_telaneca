package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Menu;

public class MenuDao {
    
    public static void save(Menu menu) {
        String query = "INSERT INTO menu (nama_menu, harga_menu, deskripsi_menu) VALUES (?, ?, ?)";
        try (Connection conn = Koneksi.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, menu.getName());
            pstmt.setString(2, menu.getHarga());
            pstmt.setString(3, menu.getDeskripsi());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Menu Added Successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error adding menu: " + e.getMessage());
        }
    }

    public static ArrayList<Menu> getAllMenusByPenjual(int idPenjual) {
        ArrayList<Menu> arrayList = new ArrayList<>();
        String query = "SELECT * FROM menu WHERE id_penjual = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, idPenjual); // Set parameter id_penjual
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Menu menu = new Menu();
                    menu.setId(rs.getInt("id"));
                    menu.setName(rs.getString("nama_menu"));
                    menu.setHarga(rs.getString("harga_menu"));
                    menu.setDeskripsi(rs.getString("deskripsi_menu"));
                    arrayList.add(menu);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        }
        return arrayList;
    }

    
    public static ArrayList<Menu> getAllMenus() {
        ArrayList<Menu> arrayList = new ArrayList<>();
        String query = "SELECT * FROM menu";
        
        try (Connection conn = Koneksi.getConnection(); 
             Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setId(rs.getInt("id"));
                menu.setName(rs.getString("nama_menu"));
                menu.setHarga(rs.getString("harga_menu"));
                menu.setDeskripsi(rs.getString("deskripsi_menu"));
                arrayList.add(menu);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving data: " + e.getMessage());
        }
        return arrayList;
    }

    public static void update(Menu menu) {
        String query = "UPDATE menu SET nama_menu = ?, harga_menu = ?, deskripsi_menu = ? WHERE id = ?";
        try (Connection conn = Koneksi.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, menu.getName());
            pstmt.setString(2, menu.getHarga());
            pstmt.setString(3, menu.getDeskripsi());
            pstmt.setInt(4, menu.getId());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Menu Updated Successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error updating menu: " + e.getMessage());
        }
    }

    public static void delete(int id) {
        String query = "DELETE FROM menu WHERE id = ?";
        try (Connection conn = Koneksi.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Menu Deleted Successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error deleting menu: " + e.getMessage());
        }
    }

     public static Menu getMenuByName(String name) {
        Menu menu = null;
        String query = "SELECT * FROM menu WHERE nama_menu = ?";
        try (Connection conn = Koneksi.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    menu = new Menu();
                    menu.setId(rs.getInt("id"));
                    menu.setName(rs.getString("nama_menu"));
                    menu.setHarga(rs.getString("harga_menu"));
                    menu.setDeskripsi(rs.getString("deskripsi_menu"));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving menu: " + e.getMessage());
        }
        return menu;
    }
}
