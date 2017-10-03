/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author brian-kamau
 */
public abstract class BaseModel {
    
    private static final String dbDriver="oracle.jdbc.driver.OracleDriver";
    private static final String dbUrl ="jdbc:oracle:thin:@localhost:1521:xe";
    private static final String dbUsername="hr";
    private static final String dbPassword ="hr";
    protected PreparedStatement pst =null;
    protected Statement stat= null;
    protected Connection conn = null;
    protected ResultSet rst = null;
    
    protected BaseModel() {
        //String sql;
        //dbConnect();
        /*
            try{
        
            sql="CREATE TABLE Students(
        "
        
        
        }catch(Exception ex){
            System.out.println("Creating Tables Exception"+ex.getMessage());
        }
        
        
        */
        
    }
    
    public final boolean dbConnect(){
        boolean success = true;
        try{
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
            
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Oracle Connection Error"+ex.getMessage());
            success = false;
        }
        return success;
    }
    public final boolean dbDisconnect(){
        try{
            if(rst!=null){
                rst.close();
            }
            if(conn!=null){
                conn.close();
            }
            if(stat!=null){
                stat.close();
            }
            
        }catch(Exception ex){
            System.out.println("Disconnecting Exception"+ex.getMessage());
        }
                        
        return true;
        
    }
    
    
    
}
