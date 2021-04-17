/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungkd.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class DBUtils {
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        Class.forName(driver);
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Book_Management";
        String user = "sa";
        String pass = "140383";
        conn = DriverManager.getConnection(url, user, pass);
        return conn;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Connect: " + getConnection());
    }
}
