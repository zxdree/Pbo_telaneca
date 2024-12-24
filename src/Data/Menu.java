/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author ASUS
 */
public class Menu {
    private int id; // ID Menu (opsional, biasanya dari database)
    private int idPenjual;
    private String namaMenu;
    private String deskripsiMenu;
    private double hargaMenu;
    protected String jenis_menu;

    public String getJenis_menu() {
        return jenis_menu;
    }

    // Konstruktor
    public Menu(String namaMenu, int hargaMenu, String deskripsiMenu, int idPenjual) {
        this.namaMenu = namaMenu;
        this.hargaMenu = hargaMenu;
        this.deskripsiMenu = deskripsiMenu;
        this.idPenjual = idPenjual;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPenjual() {
        return idPenjual;
    }

    public void setIdPenjual(int idPenjual) {
        this.idPenjual = idPenjual;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public String getDeskripsiMenu() {
        return deskripsiMenu;
    }

    public void setDeskripsiMenu(String deskripsiMenu) {
        this.deskripsiMenu = deskripsiMenu;
    }

    public double getHargaMenu() {
        return hargaMenu;
    }

    public void setHargaMenu(double hargaMenu) {
        this.hargaMenu = hargaMenu;
    }

    // Metode untuk menampilkan informasi menu
    public void tampilMenu() {
        System.out.println("Nama Menu: " + namaMenu);
        System.out.println("Deskripsi: " + deskripsiMenu);
        System.out.println("Harga: " + hargaMenu);
        System.out.println("ID Penjual: " + idPenjual);
    }
       
}













