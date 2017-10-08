/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.*;
/**
 *
 * @author brian-kamau
 */
public class Admin extends Base {
    public String getPassword(String username) throws SQLException{
        String sql;
        String pass="";
        dbConnect();
        
        sql="select * from administrator where username = ?";      
        pst=conn.prepareStatement(sql);
        pst.setString(1, username);
        rst = pst.executeQuery();
        if(rst.next()){
            
            pass= rst.getString("password");
        }       
        dbDisconnect();
        return pass;
    }
    
    
}
