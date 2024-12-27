package Data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Data.User;

public class DBuser {
    private final koneksi k = new koneksi(); // Instance koneksi
    private Penjual Penjual;
    private Admin Admin;

    // Method untuk menambahkan data penjual ke database
    public boolean insertPenjual(User user) throws SQLException {
        String sql = "INSERT INTO user (id_role, nama, email, password) VALUES (?, ?, ?, ?)";
        try (Connection conn = k.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, user.getIdRole());
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            return ps.executeUpdate() > 0; // Jika berhasil di-insert, return true
        }
    }
    
    public Penjual login(String email, String password) throws SQLException {
        String sql = "SELECT id, id_role, nama, email, password FROM user WHERE email = ? AND password = ?";
        try (Connection conn = k.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Ambil data pengguna
                int id = rs.getInt("id");
                int idRole = rs.getInt("id_role");
                String nama = rs.getString("nama");
                
                System.out.println("ID: " + id);
                System.out.println("ID Role: " + idRole);
                System.out.println("Nama: " + nama);
                
                // Tentukan objek User berdasarkan id_role
                if (idRole == 1) {
                    Penjual penjual = new Penjual(id, idRole, nama, email, password);
                    // Sesuaikan dengan konstruktor 
                    return penjual;
                }
            }
        }
        return null; // Login gagal, tidak ada user ditemukan
    }
    
    public Admin loginAdmin(String email, String password) throws SQLException {
        String sql = "SELECT id, id_role, nama, email, password FROM user WHERE email = ? AND password = ?";
        try (Connection conn = k.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Ambil data pengguna
                int id = rs.getInt("id");
                int idRole = rs.getInt("id_role");
                String nama = rs.getString("nama");
                
                System.out.println("ID: " + id);
                System.out.println("ID Role: " + idRole);
                System.out.println("Nama: " + nama);
                
               
                if (idRole == 2) {
                    
                    return Admin = new Admin(id, idRole, nama, email, password); // Sesuaikan dengan konstruktor Penjual
                }
            }
        }
        return null; // Login gagal, tidak ada user ditemukan
    }

    // Method untuk mengecek apakah data duplikat (email/nama_kedai sudah ada)
    public boolean isDuplicate(User user) throws SQLException {
        String sql = "SELECT COUNT(*) FROM user WHERE email = ? OR nama_kedai = ?";
        try (Connection conn = k.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getName());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Jika hasil lebih dari 0, berarti data duplikat
            }
        }
        return false;
    }

    // Method untuk mendapatkan ID penjual berdasarkan email
    public int getIdPenjual(User a) throws SQLException {
        String email = a.getEmail(); 
        String query = "SELECT id_penjual FROM penjual WHERE email = ?"; // Subquery untuk mengambil idPenjual berdasarkan email
        Connection conn = k.getConnection(); // Koneksi database
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        int idPenjual = 0;
        if (rs.next()) {
        idPenjual = rs.getInt("id_penjual");
        } 
        return 0;
    }
}
