/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Transaksi;

/**
 *
 * @author NANDA
 */
public class TransaksiDAO {
    private final Connection conn; // Connection untuk database
    private static final Logger LOGGER = Logger.getLogger(TransaksiDAO.class.getName());

    // Konstruktor
    public TransaksiDAO() {
        conn = Koneksi.getConn(); // Mendapatkan koneksi dari kelas Koneksi
        if (conn == null) {
            throw new IllegalStateException("Koneksi ke database gagal. Periksa konfigurasi koneksi.");
        }
    }

    // Tambah Transaksi (ke tabel transaksi dan detail_transaksi)
    public boolean tambahTransaksi(String namaPelanggan, String catatan, String noTelp, int idPenjual, List<int[]> detailMenu) {
        String sqlTransaksi = "INSERT INTO transaksi (tgl_transaksi, nama_pembeli, catatan, total_bayar, id_penjual, no_telp) VALUES (CURRENT_DATE, ?, ?, ?, ?, ?)";
        String sqlDetail = "INSERT INTO detail_transaksi (id_transaksi, id_menu, jumlah, harga_jumlah) VALUES (?, ?, ?, ?)";
        try {
            // Mulai transaksi
            conn.setAutoCommit(false);

            // 1. Simpan ke tabel transaksi
            PreparedStatement stmtTransaksi = conn.prepareStatement(sqlTransaksi, Statement.RETURN_GENERATED_KEYS);
            double totalBayar = 0;

            for (int[] detail : detailMenu) {
                totalBayar += detail[2]; // Harga total dihitung dari detail menu
            }

            stmtTransaksi.setString(1, namaPelanggan);
            stmtTransaksi.setString(2, catatan);
            stmtTransaksi.setDouble(3, totalBayar);
            stmtTransaksi.setInt(4, idPenjual);
            stmtTransaksi.setString(5, noTelp);

            stmtTransaksi.executeUpdate();

            // Ambil ID transaksi yang baru dimasukkan
            ResultSet generatedKeys = stmtTransaksi.getGeneratedKeys();
            int idTransaksi;
            if (generatedKeys.next()) {
                idTransaksi = generatedKeys.getInt(1); // Ambil ID transaksi yang benar
            } else {
                throw new SQLException("Gagal mendapatkan ID transaksi.");
            }

            // 2. Simpan ke tabel detail_transaksi
            PreparedStatement stmtDetail = conn.prepareStatement(sqlDetail);
            for (int[] detail : detailMenu) {
                int idMenu = detail[0];
                int jumlah = detail[1];
                double hargaJumlah = detail[2];

                stmtDetail.setInt(1, idTransaksi);
                stmtDetail.setInt(2, idMenu);
                stmtDetail.setInt(3, jumlah);
                stmtDetail.setDouble(4, hargaJumlah);

                stmtDetail.addBatch();
            }

            stmtDetail.executeBatch(); // Eksekusi batch untuk detail transaksi

            // Commit transaksi
            conn.commit();
            conn.setAutoCommit(true);
            return true;
        } catch (SQLException e) {
            try {
                conn.rollback(); // Batalkan transaksi jika terjadi kesalahan
            } catch (SQLException rollbackEx) {
                LOGGER.log(Level.SEVERE, "Error saat rollback transaksi.", rollbackEx);
            }
            LOGGER.log(Level.SEVERE, "Error saat menambahkan transaksi.", e);
            return false;
        }
    }

    // Reset AUTO_INCREMENT untuk tabel transaksi
    public void resetAutoIncrement() {
        try {
            String sql = "ALTER TABLE transaksi AUTO_INCREMENT = 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            LOGGER.log(Level.INFO, "AUTO_INCREMENT berhasil direset.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Gagal mereset AUTO_INCREMENT.", e);
        }
    }

    // Ambil semua transaksi
    public List<Transaksi> getAllTransaksi() {
        // Tambahkan logika untuk membaca semua data dari tabel transaksi jika diperlukan
        return null;
    }

    public boolean updateTransaksi(int idTransaksi, String namaPembeli, String catatan, String noTelp, double totalBayar) {
    String sql = "UPDATE transaksi SET nama_pembeli = ?, catatan = ?, no_telp = ?, total_bayar = ? WHERE id_transaksi = ?";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, namaPembeli);  // Nama Pembeli
        stmt.setString(2, catatan);     // Catatan
        stmt.setString(3, noTelp);      // No. Telp
        stmt.setDouble(4, totalBayar);  // Total Bayar
        stmt.setInt(5, idTransaksi);    // ID Transaksi

        int rowsUpdated = stmt.executeUpdate(); // Eksekusi query
        return rowsUpdated > 0; // True jika ada baris yang diperbarui
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    
    public boolean deleteTransaksi(int idTransaksi) {
    String sqlDeleteDetail = "DELETE FROM detail_transaksi WHERE id_transaksi = ?";
    String sqlDeleteTransaksi = "DELETE FROM transaksi WHERE id_transaksi = ?";
    try {
        // Mulai transaksi
        conn.setAutoCommit(false);

        // 1. Hapus data dari tabel detail_transaksi
        PreparedStatement stmtDeleteDetail = conn.prepareStatement(sqlDeleteDetail);
        stmtDeleteDetail.setInt(1, idTransaksi);
        stmtDeleteDetail.executeUpdate();

        // 2. Hapus data dari tabel transaksi
        PreparedStatement stmtDeleteTransaksi = conn.prepareStatement(sqlDeleteTransaksi);
        stmtDeleteTransaksi.setInt(1, idTransaksi);
        int rowsDeleted = stmtDeleteTransaksi.executeUpdate();

        // Commit transaksi
        conn.commit();
        conn.setAutoCommit(true);

        return rowsDeleted > 0; // Return true jika ada transaksi yang dihapus
    } catch (SQLException e) {
        try {
            conn.rollback(); // Rollback jika terjadi kesalahan
        } catch (SQLException rollbackEx) {
            rollbackEx.printStackTrace();
        }
        e.printStackTrace();
        return false;
    }
}



}

