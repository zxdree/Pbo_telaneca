/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author ASUS
 */

public class SessionManager {
    private static User loggedInUser;
    private static int id;
    private static Menu getidMenu;

    // Simpan user yang sedang login
    public static void setLoggedInUser(User user) {
        loggedInUser = user;
        System.out.println("User dengan ID: " + user.getId() + " berhasil login.");
    }

    // Ambil user yang sedang login
    public static User getLoggedInUser() {
        return loggedInUser;
    }

    // Hapus sesi login
    public static void clearSession() {
        loggedInUser = null;
    }

    // Cek apakah ada user yang login
    public static boolean isLoggedIn() {
        return loggedInUser != null;
    }
     public static void displayLoggedInUserId() {
        if (isLoggedIn()) {
            System.out.println("ID User yang sedang login: " + loggedInUser.getId());
        } else {
            System.out.println("Tidak ada user yang login.");
        }
    }
     
    public static void setMenuUser(Menu menu) {
        getidMenu = menu;
        System.out.println("User dengan ID: " + menu.getId() + " berhasil login.");
    }
      public static Menu getIdMenu() {
        return getidMenu ;
    }

}

