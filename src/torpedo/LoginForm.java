/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torpedo;

import com.jgoodies.common.base.Preconditions;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 *
 * @author latyak1
 */
public class LoginForm extends JPanel {

    JLabel userNameLbl;
    JTextField userName;
    JLabel pwdLbl;
    JPasswordField pwd;
    JButton loginBtn;
    JButton regBtn;

    JLabel errorMsgLbl;

    MainFrame frame;

    public LoginForm(MainFrame frame) {

        userNameLbl = new JLabel("Felhasználónév:");
        userName = new JTextField(20);
        pwdLbl = new JLabel("Jelszó:");
        pwd = new JPasswordField(20);
        loginBtn = new JButton("Bejelentlezés");
        regBtn = new JButton("Regisztráció");
        errorMsgLbl = new JLabel();
        errorMsgLbl.setForeground(Color.red);

        this.frame = frame;
        this.setLayout(new FormLayout("100px, 250px, 200px", "100px, 70px, 70px, 70px, 100px"));
        CellConstraints c = new CellConstraints();
        this.add(errorMsgLbl, c.xy(2, 1, CellConstraints.LEFT, CellConstraints.BOTTOM));
        this.add(userNameLbl, c.xy(2, 2, CellConstraints.LEFT, CellConstraints.CENTER));
        this.add(userName, c.xy(2, 2, CellConstraints.LEFT, CellConstraints.BOTTOM));
        this.add(pwdLbl, c.xy(2, 3, CellConstraints.LEFT, CellConstraints.CENTER));
        this.add(pwd, c.xy(2, 3, CellConstraints.LEFT, CellConstraints.BOTTOM));
        this.add(loginBtn, c.xy(2, 4, CellConstraints.LEFT, CellConstraints.BOTTOM));
        this.add(regBtn, c.xy(2, 4, CellConstraints.RIGHT, CellConstraints.BOTTOM));

       loginBtn.addMouseListener(new LoginEvent(this.frame));
        regBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.showCard("regForm");
                //SettingsForm s=new SettingsForm();
            }
        });
    }


    public JTextField getUserName() {
        return userName;
    }

    public JPasswordField getPwd() {
        return pwd;
    }

    public void setErrorMsgLbl(String msg) {
        this.errorMsgLbl.setText(msg);
    }

}
