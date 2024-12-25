/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Transaksi;

/**
 *
 * @author Dewi Puspita Sari
 */
public class TransaksiDao {
    public static ArrayList<Transaksi> getAllTransaksiByPenjual(int idPenjual) {
        ArrayList<Transaksi> arrayList = new ArrayList<>();
        String query = "SELECT * FROM transaksi WHERE id_penjual = ?";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, idPenjual);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Transaksi transaksi = new Transaksi();
                    transaksi.setId(rs.getInt("id_transaksi"));
                    transaksi.setCatatan(rs.getString("catatan"));
                    transaksi.setNamaPembeli(rs.getString("nama_pembeli"));
                    transaksi.setNoTelp(rs.getString("no_telp"));
                    transaksi.setTotalBayar(rs.getDouble("total_bayar"));
                    arrayList.add(transaksi);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving data: " + e.getMessage());
        }
        return arrayList;
    }
}
