/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

/**
 *
 * @author ASUS
 */
interface Role {
    int getIdRole();
    String getNamaRole();
}

// Abstract Class User
public abstract class User implements Role {
    protected int id;
    protected int idRole;
    protected String name;
    protected String email;
    protected String password;
    

   

    // Constructor
    public User(int id, int idRole, String name, String email, String password) {
        this.id = id;
        this.idRole = idRole;
        this.name = name;
        this.email = email;
        this.password = password;
    }
     public User(int idRole, String name, String email, String password) {
        this.idRole = idRole;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getter and Setter Methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    // Abstract Methods
    public abstract void login();
    public abstract void register();

    @Override
    public abstract String getNamaRole();
}




// Class Admin



