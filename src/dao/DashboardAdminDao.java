package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import Model.User;
import Model.Penjual;

public class DashboardAdminDao {

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT id, id_role, nama, email, password FROM user WHERE id_role = '1'";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int idRole = rs.getInt("id_role");
                String name = rs.getString("nama");
                String email = rs.getString("email");
                String password = rs.getString("password");

                User user;
                if (idRole == 1) {
                    user = new Penjual(id, idRole, name, email, password);
                } else {
                    user = new Penjual(id, idRole, name, email, password);
                }
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public User getUserById(int userId) {
        User user = null;
        String query = "SELECT id, id_role, nama, email, password FROM user WHERE id = ? AND id_role = 'Penjual'";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    int idRole = rs.getInt("id_role");
                    String name = rs.getString("nama");
                    String email = rs.getString("email");
                    String password = rs.getString("password");

                    if (idRole == 1) {
                        user = new Penjual(id, idRole, name, email, password); 
                    } else {
                        user = new Penjual(id, idRole, name, email, password);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }
}
