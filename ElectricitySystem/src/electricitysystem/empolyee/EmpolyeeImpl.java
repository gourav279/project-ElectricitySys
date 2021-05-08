/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricitysystem.empolyee;

import electricitysystem.Adminstrated.Admistrated;
import electricitysystem.dbsource.MysqlConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author unique
 */
public class EmpolyeeImpl implements EmpolyeeDuo {

    @Override
    public int insert(Empolyee emp) {
        int i = 0;
        Connection con = MysqlConnector.connectDb();
        String query = "insert into empolyee(name,number,address,gender,email,password) values (?,?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, emp.getName());
            pst.setString(2, emp.getNumber());
            pst.setString(3, emp.getAddress());
            pst.setString(4, emp.getGender());
            pst.setString(5, emp.getEmail());
            pst.setString(6, emp.getPassword());
            i = pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return i;
    }

    @Override
    public int delete(int empId) {
        int i = 0;
        Connection con = MysqlConnector.connectDb();
        String query = "delete from empolyee where empolyeeid=" + empId;
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
    public ObservableList<Empolyee> getAllEmp() {
        Connection con = MysqlConnector.connectDb();
        String query = "select * from empolyee";
        ObservableList<Empolyee> list = FXCollections.observableArrayList();
        try {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
//                System.out.println(rs.getString("empolyeeid"));
                list.add(new Empolyee(rs.getInt("empolyeeid"), rs.getString("name"), rs.getString("number"), rs.getString("address"), rs.getString("email"),rs.getString("gender"),rs.getString("password")));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    @Override
    public Empolyee getEmp(String email, String password) {
        Empolyee e = new Empolyee();
        Connection con = MysqlConnector.connectDb();
        String query = "select * from empolyee where email='" + email + "' and password= '" + password + "'";
        ObservableList<Empolyee> list = FXCollections.observableArrayList();
        try {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                e = new Empolyee(rs.getInt("empolyeeid"), rs.getString("email"), rs.getString("password"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return e;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Admistrated getAdmin(String email, String password) {
        Admistrated a = new Admistrated();
        Connection con = MysqlConnector.connectDb();
        String query = "select * from customer where email='" + email + "' and password= '" + password + "'";
        
        try {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                a = new Admistrated(rs.getString("email"), rs.getString("password"), rs.getInt("adminstratedid"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return a;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertAdmin(Admistrated admin) {
        int i = 0;
        Connection con = MysqlConnector.connectDb();
        String query = "insert into empolyee(name,number,address,gender,email,password) values (?,?,?,?,?,?)";
        PreparedStatement pst;
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, admin.getName());
            pst.setString(2, admin.getNumber());
            pst.setString(3, admin.getAddress());
            pst.setString(4, admin.getGender());
            pst.setString(5, admin.getEmail());
            pst.setString(6, admin.getPassword());
            i = pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return i; //To change body of generated methods, choose Tools | Templates.
    }

}
