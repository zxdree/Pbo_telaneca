/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author ASUS
 */
import Data.Menu;
public class MenuMakanan extends Data.Menu {
    private String jenisMakanan;

    // Konstruktor
    public MenuMakanan(String namaMenu, int hargaMenu, String deskripsiMenu, int idPenjual, String jenisMakanan) {
        super(namaMenu, hargaMenu, deskripsiMenu, idPenjual);
        this.jenisMakanan = jenisMakanan;
    }

    // Getter dan Setter untuk jenis makanan
    public String getJenisMakanan() {
        return jenisMakanan;
    }

    public void setJenisMakanan(String jenisMakanan) {
        this.jenisMakanan = jenisMakanan;
    }

    // Override tampilMenu untuk mencetak informasi jenis makanan
    @Override
    public void tampilMenu() {
        super.tampilMenu();
        System.out.println("Jenis Makanan: " + jenisMakanan);
    }
}
