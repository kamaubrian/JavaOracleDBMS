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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author brian-kamau
 */
public class studentController {
    
    
    static{
                                try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
}
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
}
        
        
        
    }
    
    static submitHandler submit = new submitHandler();
    static studentView stuView = new studentView();
    static addStudents stuModel = new addStudents();
    
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
            stuModel.addStu(id, fname, lname, email, phone);
            }catch(Exception ex){
                System.out.println("Commit Exception"+ex.getMessage());
            }
            
             JOptionPane.showMessageDialog(stuView,"Submit Success");
        }        
    }
    public static void main(String [] args){
        stuView.submitData().addActionListener(submit);
        stuView.setLocationRelativeTo(null);
        stuView.setVisible(true);                
    }   
}
