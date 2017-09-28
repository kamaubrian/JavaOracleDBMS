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
public class adminModel extends mainModel {
    public String getPassword() throws SQLException{
        String sql;
        String pass="";
        dbConnect();
        
        sql="select * from administrator where username = 'admin'";
        
        pst=conn.prepareStatement(sql);       
        rst = pst.executeQuery();
        if(rst.next()){
            
            pass= rst.getString("password");
            System.out.println("Its null Buddy"+pass);
            
        }       
        dbDisconnect();
        return pass;
    }
    
    
}
