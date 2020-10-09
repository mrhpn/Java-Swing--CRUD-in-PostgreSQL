/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPackage.JDBC.Logs;

import java.io.FileWriter;

/**
 *
 * @author GIC
 */
public class Logger {
    public static void Log(String message) {
        try (FileWriter writer = new FileWriter("logs.log")) {
            writer.append(message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
