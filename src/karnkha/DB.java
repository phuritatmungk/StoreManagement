/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karnkha;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;  

public class DB {
    
    public static String servername = "localhost";
    public static String username = "root";
    public static String dbname = "storedb";
    public static Integer portnumber = 3306;
    public static String password = "";// no password
    
    
    // create a function to create and get the connection
    public static Connection getConnection()
    {
        
        MysqlDataSource datasource = new MysqlDataSource();
        
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);
        datasource.setPassword(password);
        
        try {
            return datasource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public static void connect() {  
        Connection conn = null;  
        try {  
            String url = "jdbc:sqlite:C:/sqlite/db/storedb.db";  
            conn = DriverManager.getConnection(url);  
              
            System.out.println("Connection to SQLite has been established.");  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            try {  
                if (conn != null) {  
                    conn.close();  
                }  
            } catch (SQLException ex) {  
                System.out.println(ex.getMessage());  
            }  
        }  
    }  
    
    public static Connection mycon() {
        Connection con = null;
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/storedb","root", "");
            }catch (SQLException e) {
                System.out.println(e);
            }
        return con;
    }
}
