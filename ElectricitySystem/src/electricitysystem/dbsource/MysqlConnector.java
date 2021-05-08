/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricitysystem.dbsource;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import java.sql.Connection;

/**
 *
 * @author unique
 */
public class MysqlConnector {
    
    Connection conn = null;
    public static Connection connectDb() {
        try {
            MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
            ds.setURL("jdbc:mysql://localhost/electricity");
            ds.setUser("root");
            ds.setPassword("");
            Connection conn = ds.getConnection();
            return conn;
        } catch (Exception e) { 
            return null;
        }
    }
    
}
