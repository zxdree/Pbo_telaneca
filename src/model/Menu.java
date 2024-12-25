/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dewi Puspita Sari
 */
public class Menu {
    private int id;
    private String nama_menu;
    private double harga_menu;
    private String deskripsi_menu;
    private int id_penjual;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return nama_menu;
    }

    public void setName(String name) {
        this.nama_menu = name;
    }

    public String getDeskripsi() {
        return deskripsi_menu;
    }

    public void setDeskripsi(String category) {
        this.deskripsi_menu = category;
    }

    public double getHarga() {
        return harga_menu;
    }

    public void setHarga(double price) {
        this.harga_menu = price;
    }
    
    public int getIdPenjual() {
        return id_penjual;
    }

    public void setIdPenjual(int id_penjual) {
        this.id_penjual = id_penjual;
    }
}
