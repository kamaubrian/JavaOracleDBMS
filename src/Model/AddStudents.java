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
public class AddStudents extends Base {
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
    
    public ArrayList<String> getUserDetailsById(String id) throws SQLException{
        ArrayList list = new ArrayList();
        String sql;
        dbConnect();
        sql="SELECT * FROM STUDENT WHERE ID =?";
        pst=conn.prepareStatement(sql);
        pst.setString(1,id);
        rst=pst.executeQuery();
        if(rst.next()){
            
            list.add(rst.getString("firstname"));
            list.add(rst.getString("lastname"));
            list.add(rst.getString("email"));
            list.add(rst.getString("phone"));
        }        
        return list;
    }
    public boolean DeleteStudentRecord(String id) throws SQLException{
        dbConnect();
        String sql;
        sql="DELETE FROM STUDENT WHERE ID =?";
        pst=conn.prepareStatement(sql);
        pst.setString(1,id);
        pst.executeUpdate();
        dbDisconnect();
        return true;
    }
    
}
