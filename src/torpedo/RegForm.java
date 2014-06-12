/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torpedo;

import javax.swing.*;

import com.jgoodies.common.base.Preconditions;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author latyak1
 */
public class RegForm extends JPanel {

    JLabel userNameLbl;
    JTextField userName;
    JLabel nickNameLbl;
    JTextField nickName;
    JLabel pwdLbl;
    JPasswordField pwd;
    JLabel confPwdLbl;
    JPasswordField confPwd;
    JButton regBtn;
    JButton backBtn;
    JLabel errorMsgLbl;
    JLabel countryLbl;
    JComboBox country;
    MainFrame frame;

    public RegForm(MainFrame frame) {
        userNameLbl = new JLabel("Felhasználónév:");
        userName = new JTextField(20);
        nickNameLbl = new JLabel("Becenév:");
        nickName = new JTextField(20);
        countryLbl = new JLabel("Ország:");
        country = new JComboBox();
        pwdLbl = new JLabel("Jelszó:");
        pwd = new JPasswordField(20);
        confPwdLbl = new JLabel("Jelszó megerősítése:");
        confPwd = new JPasswordField(20);
        errorMsgLbl = new JLabel();
        errorMsgLbl.setForeground(Color.red);
        regBtn = new JButton("Regisztrálás");
        backBtn = new JButton("<< Vissza");
        
        for (int i = 0; i < 10; i++) {
             country.addItem(new ComboItem("Visible String "+i, "Value "+i));
        }
       
        

        this.frame = frame;
        this.setLayout(new FormLayout("100px, 350px, 200px", "70px, 70px, 70px, 70px, 70px, 70px, 70px"));
        CellConstraints c = new CellConstraints();
        this.add(errorMsgLbl, c.xy(2, 1, CellConstraints.LEFT, CellConstraints.CENTER));
        this.add(userNameLbl, c.xy(2, 2, CellConstraints.LEFT, CellConstraints.CENTER));
        this.add(userName, c.xy(2, 2, CellConstraints.LEFT, CellConstraints.BOTTOM));
        this.add(nickName, c.xy(2, 3, CellConstraints.LEFT, CellConstraints.BOTTOM));
        this.add(nickNameLbl, c.xy(2, 3, CellConstraints.LEFT, CellConstraints.CENTER));
        this.add(country, c.xy(2, 4, CellConstraints.LEFT, CellConstraints.BOTTOM));
        this.add(countryLbl, c.xy(2, 4, CellConstraints.LEFT, CellConstraints.CENTER));
        this.add(pwdLbl, c.xy(2, 5, CellConstraints.LEFT, CellConstraints.CENTER));
        this.add(pwd, c.xy(2, 5, CellConstraints.LEFT, CellConstraints.BOTTOM));
        this.add(confPwdLbl, c.xy(2, 6, CellConstraints.LEFT, CellConstraints.CENTER));
        this.add(confPwd, c.xy(2, 6, CellConstraints.LEFT, CellConstraints.BOTTOM));

        this.add(regBtn, c.xy(2, 7, CellConstraints.RIGHT, CellConstraints.BOTTOM));
        this.add(backBtn, c.xy(2, 7, CellConstraints.LEFT, CellConstraints.BOTTOM));

        regBtn.addMouseListener(new RegEvent(this.frame));
        backBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.showCard("loginForm");
            }
        });
        
       

    }
    
    public JTextField getUserName() {
        return userName;
    }
    
     public JTextField getNickName() {
        return nickName;
    }

    public JPasswordField getPwd() {
        return pwd;
    }
    
    public JPasswordField getConfPwd() {
        return confPwd;
    }
    
    public String getCountry() {
        Object item = country.getSelectedItem();
        String value = ((ComboItem)item).getValue();  
        
        return value;
    }

    public void setErrorMsgLbl(String msg) {
        this.errorMsgLbl.setText(msg);
    }

}
