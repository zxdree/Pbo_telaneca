/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
import Model.User;

public class Penjual extends User {

    public Penjual(int id, int idRole, String name, String email, String password) {
        super(id,idRole, name, email, password);
        
    }
    @Override
    public void login() {
        System.out.println("Penjual " + name + " logged in.");
    }

    @Override
    public void register() {
        System.out.println("Penjual " + name + " registered.");
    }

    @Override
    public String getNamaRole() {
        return "Penjual";
    }
}
