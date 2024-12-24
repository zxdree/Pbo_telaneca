package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Menu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dewi Puspita Sari
 */
public class MenuDao {
    public static void save(Menu menus){
        String query = "insert into product(nama_menu,harga_menu,deskripsi_menu) values('"+menus.getName()+"','"+menus.getHarga()+"','"+menus.getDeskripsi()+"')";
        Database.setDataOrDelete(query, "Menu Added Successfully");
    }
    
//    public static ArrayList<Menu>getAllRecords(){
//        ArrayList<Menu>arrayList = new ArrayList<>();
//        try{
//          ResultSet rs = Database.getData("select * from menu");
//          while(rs.next()){
//              Menu menu = new Menu();
//              menu.setId(rs.getInt("id"));
//              menu.setName(rs.getString("nama_menu"));
//              menu.setHarga(rs.getString("harga_menu"));
//              menu.setDeskripsi(rs.getString("deskripsi_menu"));
//              arrayList.add(menu);
//          }
//        }
//        catch(SQLException e){
//            JOptionPane.showMessageDialog(null, e);
//        }
//        return arrayList;
//    }
    
    public static ArrayList<Menu> getAllMenus() {
    ArrayList<Menu> arrayList = new ArrayList<>();
    String query = "SELECT * FROM menu ";
    
    try (Connection conn = Koneksi.getConn(); 
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        
        // Iterate through the result set and populate the array list
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


    
    public static void update(Menu menu){
        String query = "update menu set nama_menu ='"+menu.getName()+"',harga_menu ='"+menu.getHarga()+"',deskripsi_menu ='"+menu.getDeskripsi()+"'where id ='"+menu.getId()+"'";
        Database.setDataOrDelete(query, "Menu Updated Successfully");
    }
    
    public static void delete(String id){
        String query = "delete from menu where id = '"+id+"'";
        Database.setDataOrDelete(query, "Menu Deleted Successfully");
    }
    
//    public static ArrayList<Menu>getAllRecordsByCategory(String category){
//        ArrayList<Menu> arrayList = new ArrayList<>();
//        try{
//            ResultSet rs = Database.getData("select * from product where category='"+category+"'");
//            while(rs.next()){
//                Menu product = new Menu();
//                product.setName(rs.getString("name"));
//                arrayList.add(product);
//            }
//        }
//        catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
//        }
//        
//       return arrayList;
//    }
    
//    public static ArrayList<Menu>menuName(String name, String category){
//        ArrayList<Menu> arrayList = new ArrayList<>();
//        try{
//            ResultSet rs = Database.getData("select * from product where name like '%"+name+"%' and category '"+category+"'");
//            while(rs.next()){
//                Product product = new Product();
//                product.setName(rs.getString("name"));
//                arrayList.add(product);
//            }
//        }
//        catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
//        }
//        
//       return arrayList;
//    }
    
    public static Menu getProductByname(String name){
        Menu product = new Menu();
        try{
            ResultSet rs = Database.getData("select * from product where name='"+name+"'");
            while(rs.next()){
                product.setName(rs.getString(2));
                product.setDeskripsi(rs.getString(4));
                product.setHarga(rs.getString(3));
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return product;
    }
}
