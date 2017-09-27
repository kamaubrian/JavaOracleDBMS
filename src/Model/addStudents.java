/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;

/**
 *
 * @author brian-kamau
 */
public class addStudents extends mainModel {
    public boolean addStu(String id,String firstname,String lastname,String email,String phone) throws SQLException{
     dbConnect();
     String sql;
     sql="INSERT INTO Student values(?,?,?,?,?)";
     pst=conn.prepareStatement(sql);
     pst.setString(1,id);
     pst.setString(2,firstname);
     pst.setString(3,lastname);
     pst.setString(4,email);
     pst.setString(5,phone);
     pst.executeUpdate();   
     
     dbDisconnect();
      return true;
    }
    
    
}
