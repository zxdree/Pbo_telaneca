package model;

import java.util.Date;

/**
 *
 * @author Dewi Puspita Sari
 */
public class Transaksi {
    private int id_transaksi;
    private String catatan;
    private Date tgl_transaksi;
    private String nama_pembeli;
    private String no_telp;
    private double total_bayar;
    private int id_penjual;
    
    public int getId() {
        return id_transaksi;
    }

    public void setId(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setTglTransaksi(Date tgl_transaksi) {
        this.tgl_transaksi = tgl_transaksi;
    }

    public Date getTglTransaksi() {
        return tgl_transaksi;
    }
    
    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public String getNamaPembeli() {
        return nama_pembeli;
    }

    public void setNamaPembeli(String nama_pembeli) {
        this.nama_pembeli = nama_pembeli;
    }

    public String getNoTelp() {
        return no_telp;
    }

    public void setNoTelp(String no_telp) {
        this.no_telp = no_telp;
    }
    
    public double getTotalBayar() {
        return total_bayar;
    }

    public void setTotalBayar(double total_bayar) {
        this.total_bayar = total_bayar;
    }
    
    public int getidPenjual() {
        return id_penjual;
    }

    public void setIdPenjual(int id_penjual) {
        this.id_penjual = id_penjual;
    }
}
