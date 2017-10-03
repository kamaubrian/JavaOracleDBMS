/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.*;
import Model.*;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author brian-kamau
 */
public class StudentController {
    
    
    static{
            try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
}
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
}
        
              
    }
    
    static adminHandler records = new adminHandler();
    static submitHandler submit = new submitHandler();
    static StudentView stuView = new StudentView();
    static AddStudents stuModel = new AddStudents();
    static AdminView adminv = new AdminView();
    static SearchHandler search = new SearchHandler();
    
    static class submitHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
            String id,phone;
            String fname,lname,email;
            id=stuView.getID().getText();
            phone = stuView.getPhone().getText();
            fname=stuView.getFirstName().getText();
            lname=stuView.getLastName().getText();
            email=stuView.getEmail().getText();
            
            if(stuView.getID().getText().isEmpty()||
                    stuView.getFirstName().getText().isEmpty()||
                    stuView.getLastName().getText().isEmpty()||
                    stuView.getEmail().getText().isEmpty()||
                    stuView.getPhone().getText().isEmpty()){
                JOptionPane.showMessageDialog(stuView,"Please Fill In Empty Field");
                return;
            }
            if(!stuModel.checkDetailsExist(id, email)){
                stuModel.addStu(id, fname, lname, email, phone);
                 JOptionPane.showMessageDialog(stuView,"Submit Success");
                 stuView.getID().setText("");
                 stuView.getFirstName().setText("");
                 stuView.getLastName().setText("");
                 stuView.getEmail().setText("");
                 stuView.getPhone().setText("");
            }else{
                JOptionPane.showMessageDialog(stuView,"User Details Already Exists");
            }
                        
            }catch(Exception ex){
                System.out.println("Commit Exception"+ex.getMessage());
            }           
        }        
    }
    static class adminHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
               // JOptionPane.showMessageDialog(stuView, "Coming Soon","Feature Coming Soon",2);
               showAdminPage();
                
            }catch(Exception ex){
                System.out.println("Records Handler Exception " +ex.getMessage());
            }
        }      
    }
    static class SearchHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
              
               String id = stuView.searchUser().getText();
               if(!id.isEmpty()){
               if(stuModel.getUserDetailsById(id)!=null){
                   for(String list :stuModel.getUserDetailsById(id)){
                   JOptionPane.showMessageDialog(stuView,list);
                   stuView.searchUser().setText("");
               }
                  // JOptionPane.showMessageDialog(stuView,stuModel.getUserDetailsById(id));
                   
                  
               }else{
                   JOptionPane.showMessageDialog(stuView, "Student Not Found");
               }
               }else{
                   stuView.searchUser().setCaretColor(Color.red);
                   JOptionPane.showMessageDialog(stuView,"Enter Admission Number");
               }
            }catch(Exception ex){
                System.err.println("Search Exception"+ex.getMessage());
            }            
            
        }
        
    }
    public static void main(String [] args){
        stuView.submitData().addActionListener(submit);
        stuView.getRecords().addActionListener(records);
        stuView.getUsers().addActionListener(search);
        stuView.getRecords().setEnabled(true);
        stuView.setResizable(false);
        stuView.setTitle("Oracle in Java");
        stuView.setSize(new Dimension(420,370));
        stuView.setLocationRelativeTo(null);
        stuView.setVisible(true);                
    }   
    public static void showAdminPage(){
       stuView.dispose();
       AdminController.showAdminPage();
        
        
    }
}
