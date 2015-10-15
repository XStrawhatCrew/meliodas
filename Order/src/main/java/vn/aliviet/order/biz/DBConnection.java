/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aliviet.order.biz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author windluffy
 */
public class DBConnection {
    private Connection conn = null;

    public DBConnection() {
        this.connect();
    }
    
    private void connect(){
        try {
            String url = "jdbc:mysql://localhost:3306/orderhang";
            String user = "root";
            String password = "hoaanh";
            
            Class.forName("com.mysql.jdbc.Driver");
            
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Connection getConnection() {
        return this.conn;
    }
    
    
}
