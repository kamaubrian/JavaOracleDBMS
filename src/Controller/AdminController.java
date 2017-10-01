/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Model.*;
/**
 *
 * @author brian-kamau
 */
public class AdminController {
    
    static AdminView adminV = new AdminView();
    static loginHandler login = new loginHandler();
    static Admin adminM = new Admin();
  
    static class loginHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String password = adminV.getPassword().getText();
                String admin = adminV.getAdmin().getText();
                if(password.isEmpty()){
                    JOptionPane.showMessageDialog(adminV,"Enter Password");
                    return;
                }
                if(password.equals(adminM.getPassword(admin))){
                    JOptionPane.showMessageDialog(adminV,"Feature Coming Soon");

                }else{
                    JOptionPane.showMessageDialog(adminV,"Password Incorrect for Admin");
                    adminV.getPassword().setText("");  
                }
                
                
            }catch(Exception ex){
                System.out.println("LoginHandler Exception"+ex.getMessage());
            }
            
        }
        
        
        
    }
    public static void  showAdminPage(){
        adminV.setTitle("Admin Console");
        adminV.setSize(new Dimension(380,180));
        adminV.setResizable(false);
        adminV.setLocationRelativeTo(null);
        adminV.loginAdmin().addActionListener(login);
        adminV.setVisible(true);
        
        
    }
    
}
