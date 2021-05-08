/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricitysystem.empolyee;

/**
 *
 * @author unique
 */
public class Empolyee {

    private int empolyeeid;
    private String name,number,address,email,gender,password;
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmpolyeeid() {
        return empolyeeid;
    }

    public void setEmpolyeeid(int empolyeeid) {
        this.empolyeeid = empolyeeid;
    }
    
    
    
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Empolyee(int empolyeeid, String name, String number, String address, String email, String gender, String password) {
        this.empolyeeid = empolyeeid;
        this.name = name;
        this.number = number;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.password = password;
    }

    public Empolyee(String name, String number, String address, String email, String gender, String password) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.password = password;
    }
    
    

    public Empolyee(int empolyeeid, String email, String password) {
        this.empolyeeid = empolyeeid;
        this.email = email;
        this.password = password;
    }

    

    public Empolyee() {
        super();
    }
    
    
    
}
