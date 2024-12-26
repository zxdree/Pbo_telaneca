/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dewi Puspita Sari
 */
public class DetailTransaksi {
    private int id_detail_transaksi;
    private int id_transaksi;
    private int id_menu;
    private int jumlah;
    private double harga_jumlah;
    private String namaMenu;
    
    public int getId() {
        return id_detail_transaksi;
    }

    public void setId(int id) {
        this.id_detail_transaksi = id;
    }

    public int getIdTransaksi() {
        return id_transaksi;
    }

    public void setIdTransaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }
    
    public int getIdMenu() {
        return id_menu;
    }

    public void setIdMenu(int id_menu) {
        this.id_menu = id_menu;
    }
    
    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
    public double getHargaJumlah() {
        return harga_jumlah;
    }

    public void setHargaJumlah(double harga_jumlah) {
        this.harga_jumlah = harga_jumlah;
    }
    
    // Getters dan Setters untuk namaMenu
    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }
}
