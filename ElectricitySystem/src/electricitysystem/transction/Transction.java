/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricitysystem.transction;

import electricitysystem.customer.Customer;

/**
 *
 * @author unique
 */
public class Transction {

    private String month;
    private double paid, totalamount;
    private long currentunit, lastunit;
    private Customer customer;

    public Transction(String month, double paid, double totalamount, long currentunit, long lastunit, Customer customer) {
        this.month = month;
        this.paid = paid;
        this.totalamount = totalamount;
        this.currentunit = currentunit;
        this.lastunit = lastunit;
        this.customer = customer;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }

    public long getCurrentunit() {
        return currentunit;
    }

    public void setCurrentunit(long currentunit) {
        this.currentunit = currentunit;
    }

    public long getLastunit() {
        return lastunit;
    }

    public void setLastunit(long lastunit) {
        this.lastunit = lastunit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
