/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricitysystem.Adminstrated;

/**
 *
 * @author unique
 */
public class Admistrated {

    int adminstratedid;
    private String name, number, address, email, gender, password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAdminstratedid() {
        return adminstratedid;
    }

    public void setAdminstratedid(int adminstratedid) {
        this.adminstratedid = adminstratedid;
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

    public Admistrated(String email, String password, int adminstratedid) {
        this.email = email;
        this.password = password;
        this.adminstratedid = adminstratedid;
    }

    public Admistrated() {
    }

    @Override
    public String toString() {
        return "Admistrated{" + "email=" + email + ", password=" + password + '}';
    }

    public Admistrated(String name, String number, String address, String email, String gender, String password) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.password = password;
    }

    
    
}
