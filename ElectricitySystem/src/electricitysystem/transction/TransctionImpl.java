/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricitysystem.transction;

import electricitysystem.customer.Customer;
import electricitysystem.dbsource.MysqlConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author unique
 */
public class TransctionImpl implements TransctionDuo {

    @Override
    public int insert(Transction transction) {
        int i = 0;
        Connection con = MysqlConnector.connectDb();
        String query = "insert into transction(customerid,month,currentunit,lastunit,paid,totalamount) values (?,?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, transction.getCustomer().getCustomerId());
            pst.setString(2, transction.getMonth());
            pst.setDouble(3, transction.getCurrentunit());
            pst.setDouble(4, transction.getLastunit());
            pst.setDouble(5, transction.getPaid());
            pst.setDouble(6, transction.getTotalamount());
            i = pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return i; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<Transction> getAllTransction() {
        Connection con = MysqlConnector.connectDb();
        String query = "select * from transction as t join customer as c where t.customerid=c.customerid";
        ObservableList<Transction> list = FXCollections.observableArrayList();
        try {
            PreparedStatement pst = con.prepareStatement(query);  
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
//                list.add(new Transction(rs.getString("customerid"), rs.getString("name"), rs.getString("number"), rs.getString("address"), rs.getString("meterno"), rs.getString("email")));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Update(int transctionid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
