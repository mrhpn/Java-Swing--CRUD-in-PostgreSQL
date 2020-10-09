/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage.JDBC.Models;

import MyPackage.JDBC.Logs.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author GIC
 */
public class DBConnection {
    
    Connection connection;
    static final String DB_CONNECTION_STRING = "jdbc:postgresql://localhost:5432/company";
    static final String DB_USERNAME = "postgres";
    static final String DB_PASSWORD = "root";
    
    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(DB_CONNECTION_STRING, DB_USERNAME, DB_PASSWORD);
        } 
        catch (SQLException e) {
            Logger.Log(e.getMessage());
            JOptionPane.showMessageDialog(null, "Something Failed!", "Error", JOptionPane.ERROR_MESSAGE);
        } 
       
        return connection;
    }
}
