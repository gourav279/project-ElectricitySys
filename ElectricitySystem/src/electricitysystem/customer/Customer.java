/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricitysystem.customer;

/**
 *
 * @author unique
 */
public class Customer {
    private String customerId,name,number,address,meterno,email;
    
    

    public Customer(String name, String number, String address, String meterno, String email) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.meterno = meterno;
        this.email = email;
    }

    Customer() {
        super(); //To change body of generated methods, choose Tools | Templates.
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getMeterno() {
        return meterno;
    }

    public void setMeterno(String meterno) {
        this.meterno = meterno;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Customer(String customerId,String name, String number, String address, String meterno, String email) {
        this.customerId=customerId;
        this.name = name;
        this.number = number;
        this.address = address;
        this.meterno = meterno;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cust{" + "name=" + name + ", number=" + number + ", address=" + address + ", meterno=" + meterno + ", email=" + email + '}';
    }

    
    
}
