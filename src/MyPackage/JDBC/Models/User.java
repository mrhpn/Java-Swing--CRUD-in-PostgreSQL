/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage.JDBC.Models;

import MyPackage.JDBC.Helpers.Helper;
import MyPackage.JDBC.Logs.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 * JOptionPane Message Type
 * 0 - Error
 * 1 - Information
 * 2 - Warning
 * 3 - Question
*/

/**
 *
 * @author GIC
 */
public class User {

    private String username;
    private String phone;
    private String address;
    
    private final DBConnection DB_CONNECTION;
    Connection connection;
    
    public User () {
        DB_CONNECTION = new DBConnection();
        connection = DB_CONNECTION.getConnection();
    }
        
    public User (String username, String phone, String address) {
        this.username = username;
        this.phone = phone;
        this.address = address;
        
        DB_CONNECTION = new DBConnection();
        connection = DB_CONNECTION.getConnection();
    }
    
    public void insert() {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO users (username, phone, address) VALUES (?,?,?)")) {
            statement.setString(1, username);        
            statement.setString(2, phone);
            statement.setString(3, address);
            statement.executeUpdate();
            
            Helper.showDialog("User Saved!", "Success", 1);
        } 
        catch(SQLException e) {
            Logger.Log(e.getMessage());
            Helper.showDialog("Something Failed!", "Error", 0);
        }
    }
    
    public void update(Integer id) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE users SET username=?, phone=?, address=? WHERE id=" + id)) {
            statement.setString(1, username);
            statement.setString(2, phone);
            statement.setString(3, address);
            statement.executeUpdate();
            
            Helper.showDialog("User Updated!", "Success", 1);
        }
        catch(SQLException e) {
            Logger.Log(e.getMessage());
            Helper.showDialog("Something Failed!", "Error", 0);
        }
    }
    
    public void delete(Integer id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id=" + id);) {
            statement.executeUpdate();
            
            Helper.showDialog("User Deleted!", "Success", 1);
        }
        catch(SQLException e) {
            Logger.Log(e.getMessage());
            Helper.showDialog("Something Failed!", "Error", 0);
        }
    }
    
    public void repaintTable(JTable table) {
        ResultSet resultSet;
        
        try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM users ORDER BY id ASC")) {
            resultSet = statement.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch(SQLException e) {
            Logger.Log(e.getMessage());
            Helper.showDialog("Something Failed!", "Error", 0);
        }
    }
    
}
