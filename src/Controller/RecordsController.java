/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.*;
import View.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author brian-kamau
 */
public class RecordsController {
    
    static Records recordsmodel = new Records();
    static RecordsView recordView = new RecordsView();
    static DefaultTableModel tablemodel = (DefaultTableModel)recordView.getRecords().getModel();
    static Map itemList = new HashMap();
    static HomeHandler home = new HomeHandler();
    static DeleteHandler delete = new DeleteHandler();
    static AddStudents stuModel = new AddStudents();
    
    
    static class DeleteHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int row = tablemodel.getRowCount();
            int selectrow = recordView.getRecords().getSelectedRow();
            int selectcol = recordView.getRecords().getSelectedColumn();
            String id = tablemodel.getValueAt(selectrow,selectcol).toString();
                      
            try{
                System.out.println(id);
                 stuModel.DeleteStudentRecord(id);
                 tablemodel.removeRow(selectrow);
                
            }catch(Exception ex){
                System.out.println("Delete Handler Exception"+ex.getMessage());
            }           
        }             
    }
    
    static class HomeHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                recordView.dispose();
                StudentController.showMainPage();
            }catch(Exception ex){
                System.err.println("Home Handler Exception"+ex.getMessage());
            }         
        }
        
        
        
    }
    
    public static void populateTable(){
        try {
            ArrayList<ArrayList<String>> tableItems;
            tableItems=recordsmodel.fetchTableData();
            if(tablemodel.getRowCount()!=0){
                tablemodel.setRowCount(0);
                itemList.clear();
            }
            for(ArrayList<String> x : tableItems){
                Object[] items = {
                  x.get(0),x.get(1),x.get(2),x.get(3),x.get(4)
                };
                tablemodel.addRow(items);
                itemList.put(x.get(0),x.get(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecordsController.class.getName()).log(Level.SEVERE, null, ex);
        }
               
   }
    
    public static void showPage(){
        recordView.setTitle("Student Records");
        recordView.setResizable(false);
        recordView.setLocationRelativeTo(null);
        recordView.setSize(new Dimension(800,400));
        recordView.setVisible(true);
        recordView.goHome().addActionListener(home);
        recordView.DeleteRecord().addActionListener(delete);
        populateTable();
    }
    
    
}
