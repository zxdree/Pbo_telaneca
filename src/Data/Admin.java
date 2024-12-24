/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author ASUS
 */
import Data.User;
public class Admin extends User {
    public Admin(int id, int idRole, String name, String email, String password) {
        super(idRole, name, email, password);
    }

    @Override
    public void login() {
        System.out.println("Admin " + name + " logged in.");
    }

    @Override
    public void register() {
        System.out.println("Admin " + name + " registered.");
    }

    @Override
    public String getNamaRole() {
        return "Admin";
    }
}
