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
    private String harga_menu;
    private String deskripsi_menu;
    private String id_penjual;

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

    public String getHarga() {
        return harga_menu;
    }

    public void setHarga(String price) {
        this.harga_menu = price;
    }
    
    public String getIdPenjual() {
        return id_penjual;
    }

    public void setIdPenjual(String id_penjual) {
        this.id_penjual = id_penjual;
    }
}
