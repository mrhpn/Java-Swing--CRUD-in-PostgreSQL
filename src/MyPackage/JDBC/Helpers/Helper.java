/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage.JDBC.Helpers;

import MyPackage.JDBC.UserRegister;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author GIC
 */
public class Helper {
    
    public static void showDialog(String message, String title, Integer messageType) {
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }
    
    public static int showConfirmationDialog(String message, String title, Integer dialogType) {
        return JOptionPane.showConfirmDialog(
            null, 
            "Do you want to delete the select row?\n The operation cannot be undone once it is succeeded!", 
            "Are you sure?", 
            JOptionPane.YES_NO_CANCEL_OPTION
        );
    }
    
    public static boolean isNullOrEmpty(String str) {
        return (str != null && !str.trim().isEmpty()) ? false : true;
    }
}
