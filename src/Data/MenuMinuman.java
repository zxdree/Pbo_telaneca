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
public class MenuMinuman extends Data.Menu {
    private String jenisMinuman;

    // Konstruktor
    public MenuMinuman(String namaMenu, int hargaMenu, String deskripsiMenu, int idPenjual, String jenisMinuman) {
        super(namaMenu, hargaMenu, deskripsiMenu, idPenjual);
        this.jenisMinuman = jenisMinuman;
    }

    // Getter dan Setter untuk jenis minuman
    public String getJenisMinuman() {
        return jenisMinuman;
    }

    public void setJenisMinuman(String jenisMinuman) {
        this.jenisMinuman = jenisMinuman;
    }

    // Override tampilMenu untuk mencetak informasi jenis minuman
    @Override
    public void tampilMenu() {
        super.tampilMenu();
        System.out.println("Jenis Minuman: " + jenisMinuman);
    }
}
