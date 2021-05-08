package electricitysystem.customer;

import electricitysystem.dbsource.MysqlConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author unique
 */
public class CustomerImpl implements CustomerDuo {

    @Override
    public int insert(Customer customer) {
        int i = 0;
        Connection con = MysqlConnector.connectDb();
        String query = "insert into customer(name,number,address,meterno,email) values (?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, customer.getName());
            pst.setString(2, customer.getNumber());
            pst.setString(3, customer.getAddress());
            pst.setString(4, customer.getMeterno());
            pst.setString(5, customer.getEmail());
            i = pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return i;
    }

    @Override
    public int delete(int customerId) {
        int i = 0;
        Connection con = MysqlConnector.connectDb();
        String query = "delete from customer where customerid=" + customerId;
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(query);
            i = pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return i;
    }

    @Override
    public ObservableList<Customer> getAllCustomer() {
        Connection con = MysqlConnector.connectDb();
        String query = "select * from customer";
        ObservableList<Customer> list = FXCollections.observableArrayList();
        try {
            PreparedStatement pst = con.prepareStatement(query);  
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Customer(rs.getString("customerid"), rs.getString("name"), rs.getString("number"), rs.getString("address"), rs.getString("meterno"), rs.getString("email")));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    @Override
    public Customer getCustomer(int customerId) {
        Customer c = new Customer();
        Connection con = MysqlConnector.connectDb();
        String query = "select * from customer where customerid=" + customerId;
        ObservableList<Customer> list = FXCollections.observableArrayList();
        try {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                c = new Customer(rs.getString("customerid"), rs.getString("name"), rs.getString("number"), rs.getString("address"), rs.getString("meterno"), rs.getString("email"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return c;
    }

    @Override
    public int update(Customer c) {
        int i = 0;
        Connection con = MysqlConnector.connectDb();
        String query = "update customer set name='" + c.getName() + "' number='" + c.getNumber() + "' address='" + c.getAddress() + "' email='" + c.getEmail() + "' meterno='" + c.getMeterno() + "'";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(query);
            i = pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return i;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer getCustomer(String number) {
        Customer c = new Customer();
        Connection con = MysqlConnector.connectDb();
        String query = "select * from customer where number=" + number;
        ObservableList<Customer> list = FXCollections.observableArrayList();
        try {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                c = new Customer(rs.getString("customerid"), rs.getString("name"), rs.getString("number"), rs.getString("address"), rs.getString("meterno"), rs.getString("email"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return c; //To change body of generated methods, choose Tools | Templates.
    }

}
