/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author brian-kamau
 */
public class AddStudents extends BaseModel {
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
    
    public ArrayList<String> getUser(String id,String email) throws SQLException{
        ArrayList stuList = new ArrayList();
        dbConnect();
        String sql="SELECT * FROM STUDENT  where id = ?  AND email = ?";
        pst=conn.prepareStatement(sql);
        pst.setString(1,id);
        pst.setString(2,email);
        rst = pst.executeQuery();
        if(rst.next()){           
            stuList.add(rst.getString("id"));
            stuList.add(rst.getString("email"));
        }       
        return stuList;
    }
    public boolean checkDetailsExist(String id,String username) throws SQLException{
        return !getUser(id,username).isEmpty();     
    }
    
    
}
