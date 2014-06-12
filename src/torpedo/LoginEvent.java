/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package torpedo;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author latyak1
 */
class LoginEvent implements MouseListener{

    MainFrame frame;
    private Home home;
    public LoginEvent(MainFrame frame) {
        this.frame=frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    Db.openCon();
        String pwd=new String(frame.getLoginForm().getPwd().getPassword());
        String userName=frame.getLoginForm().getUserName().getText();

        try {
            if(Db.loginValidate(userName, pwd)){
                home = new Home(frame, userName);
                frame.addCard(home, "home");
                frame.showCard("home");
                home.setUser(userName);
            }
            else{
                frame.getLoginForm().setErrorMsgLbl("Hibás felhasználónév vagy jelszó!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginEvent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginEvent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(LoginEvent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoginEvent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(LoginEvent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(LoginEvent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(LoginEvent.class.getName()).log(Level.SEVERE, null, ex);
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
