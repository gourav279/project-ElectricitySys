/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricitysystem.customer;

import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author unique
 */
public interface CustomerDuo {
    
    public int insert(Customer customer);

    public int delete(int customerId);
    
    public int update(Customer customer);

    public ObservableList<Customer> getAllCustomer();

    public Customer getCustomer(int customerId);
    
    public Customer getCustomer(String number);
    
}
