/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package torpedo;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author latyak1
 */
class RegEvent implements MouseListener {
    
    MainFrame frame;
    JLabel errorMsgLbl;

    public RegEvent(MainFrame frame) {
        this.frame = frame;
        errorMsgLbl = new JLabel();
        errorMsgLbl.setForeground(Color.red);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        String errorMsg="";
        
        String pwd = new String(frame.getRegForm().getPwd().getPassword());
        String userName = new String(frame.getRegForm().getUserName().getText());
        String confPwd = new String(frame.getRegForm().getConfPwd().getPassword());
        String nickName = new String(frame.getRegForm().getNickName().getText());
        String country = frame.getRegForm().getCountry();
        
        Db.openCon();
        try {
            if (FormValidate.required(pwd, userName, confPwd, nickName, country)) {
                
                if(userName.length() < 4){
                    errorMsg="A felhasználónévnek minimum 5 karaterből kell állnia!";
                }
                
                if(Db.existsUser(userName)){
                    errorMsg="A felhasználónév már foglalt!";
                }
                
                 if(nickName.length() < 4){
                   errorMsg="A becenévnek minimum 5 karaterből kell állnia!";
                }
                
                 if(nickName.equals(userName)){
                     errorMsg="A felhasználónév nem egyezhet meg a becenévvel!";
                 }
                 
                 if(pwd.length() < 5){
                     errorMsg="A jelszónak minimum 6 karaterből kell állnia!";
                 }
                 
                 if(!pwd.equals(confPwd)){
                     errorMsg="A két jelszó nem egyezik meg!";              
                 }
                 
                            
                
            }
            else
                errorMsg="Minden mező kitöltése kötelező!";
            
            
            if(errorMsg.isEmpty()){
                Db.registration(userName, nickName, pwd, country);
                System.out.println("succ");
            }
            else{
                frame.getRegForm().setErrorMsgLbl(errorMsg);
                System.out.println("error");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RegEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        Db.closeCon();
        
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
