/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import Data.Menu;

public class DBMenu {
    private Connection conn;
    private final koneksi k = new koneksi();
    
public boolean insertMenu(Menu menu) throws SQLException {
    String query = "INSERT INTO menu (nama_menu, harga_menu, deskripsi_menu, id_penjual, jenis_menu) " +
                   "VALUES (?, ?, ?, ? , ?)";
    try (Connection conn = k.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
        ps.setString(1, menu.getNamaMenu());
        ps.setDouble(2, menu.getHargaMenu());
        ps.setString(3, menu.getDeskripsiMenu());
        ps.setInt(4, menu.getIdPenjual()); // Set username untuk subquery
        ps.setString(5, (menu instanceof MenuMakanan) ? "Makanan" : "Minuman");
        return ps.executeUpdate() > 0;
    }
    
    
}

  public boolean updateMenu(Menu menu) throws SQLException{
        //langkah 1
        conn = k.getConnection();
        
        //langkah 2
        String kueri = "UPDATE menu SET nama_menu=?, harga_menu=?, deskripsi_menu=? , id_penjual=?, jenis_menu=? WHERE nama_menu";
        PreparedStatement ps = conn.prepareStatement(kueri);
        ps.setString(1, menu.getNamaMenu());
        ps.setDouble(2, menu.getHargaMenu());
        ps.setString(3, menu.getDeskripsiMenu()); 
        ps.setString(5, (menu instanceof MenuMakanan) ? "Makanan" : "Minuman");
        ps.setInt(6, menu.getIdPenjual());
        
        //langkah 3
        int rowAffected = ps.executeUpdate();
        
        //langkah 4 & 5
        ps.close(); conn.close();
        return rowAffected == 1;
    }
  
  public Menu getMenuById(int idMenu) throws SQLException {
     conn = k.getConnection();
    String sql = "SELECT id, nama_menu, harga_menu, deskripsi_menu, id_penjual, jenis_menu FROM menu WHERE id = ?";
    try (Connection conn = k.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, idMenu); // Set ID menu sebagai parameter
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            // Ambil data dari result set
            String namaMenu = rs.getString("nama_menu");
            int harga = rs.getInt("harga_menu");
            String deskripsi = rs.getString("deskripsi_menu");
            String kategori = rs.getString("jenis_menu");
            int idPenjual = rs.getInt("id_penjual");

            // Tentukan objek berdasarkan kategori
            if (kategori.equalsIgnoreCase("Makanan")) {
                return new MenuMakanan(namaMenu, harga, deskripsi, idPenjual, kategori);
            } else {
                return new MenuMinuman(namaMenu, harga, deskripsi, idPenjual, kategori);
            }
        }
    }
    return null; // Jika menu tidak ditemukan
}



    
   



    

    
}
