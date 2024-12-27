/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NANDA
 */
public class Transaksi {
    private int idTransaksi;
    private String tglTransaksi;
    private String namaPembeli;
    private String catatan;
    private double totalBayar;
    private int idPenjual;
    private String noTelp;

    // Constructor
    public Transaksi(int idTransaksi, String tglTransaksi, String namaPembeli, String catatan, double totalBayar, int idPenjual, String noTelp) {
        this.idTransaksi = idTransaksi;
        this.tglTransaksi = tglTransaksi;
        this.namaPembeli = namaPembeli;
        this.catatan = catatan;
        this.totalBayar = totalBayar;
        this.idPenjual = idPenjual;
        this.noTelp = noTelp;
    }

    // Getter dan Setter
    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(String tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    public String getNamaPembeli() {
        return namaPembeli;
    }

    public void setNamaPembeli(String namaPembeli) {
        this.namaPembeli = namaPembeli;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(double totalBayar) {
        this.totalBayar = totalBayar;
    }

    public int getIdPenjual() {
        return idPenjual;
    }

    public void setIdPenjual(int idPenjual) {
        this.idPenjual = idPenjual;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
}

