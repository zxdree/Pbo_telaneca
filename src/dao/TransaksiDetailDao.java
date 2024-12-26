
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DetailTransaksi;


public class TransaksiDetailDao {
    public static ArrayList<DetailTransaksi> getAllDetailTransaksiByTransaksi(int idTransaksi) {
    ArrayList<DetailTransaksi> arrayList = new ArrayList<>();
    String query = "SELECT dt.*, m.nama_menu " +
                   "FROM detail_transaksi dt " +
                   "JOIN menu m ON dt.id_menu = m.id " +
                   "WHERE dt.id_transaksi = ?";
    
    try (Connection conn = Koneksi.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setInt(1, idTransaksi); 
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                DetailTransaksi menu = new DetailTransaksi();
                menu.setIdTransaksi(rs.getInt("id_transaksi"));
                menu.setIdMenu(rs.getInt("id_menu"));
                menu.setNamaMenu(rs.getString("nama_menu"));
                menu.setJumlah(rs.getInt("jumlah"));
                menu.setHargaJumlah(rs.getDouble("harga_jumlah"));
                arrayList.add(menu);
            }
        }
    } catch (SQLException e) {
        System.err.println("Error retrieving data: " + e.getMessage());
    }
    return arrayList;
}

}
