/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author brian-kamau
 */
public class Records extends Base {
    
   public ArrayList<ArrayList<String>> fetchTableData() throws SQLException{
       dbConnect();
       ArrayList tableData = new ArrayList();
       String sql="SELECT * FROM STUDENT";
       stat=conn.createStatement();
       rst=stat.executeQuery(sql);
       
       while(rst.next()){
           ArrayList info = new ArrayList();
           info.add(rst.getString("ID"));
           info.add(rst.getString("FIRSTNAME"));
           info.add(rst.getString("LASTNAME"));
           info.add(rst.getString("EMAIL"));
           info.add(rst.getString("PHONE"));
           tableData.add(info);
       }
       
            
       dbDisconnect();
       
       return tableData;
   }
    
}
