/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torpedo;


import game_panel.GamePanel;
import jatekter.GameClient;
import java.awt.CardLayout;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

import javax.swing.JPanel;


/**
 *
 * @author latyak1
 */
public class MainFrame extends JFrame {

    private JPanel cards;
    private CardLayout cl;

    //private Home home;
    private LoginForm loginForm;
    private RegForm regForm;
    private GamePanel gamePanel;
    public static GameClient client;
    public static int connect_client_id;

    public MainFrame() throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        cards = new JPanel(new CardLayout());
        cl = (CardLayout) cards.getLayout();
        gamePanel = new GamePanel();
        loginForm = new LoginForm(this);
        regForm = new RegForm(this);
        //home = new Home(this);

        initCards();
        showCard("loginform");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(this);
        setVisible(true);
        
        
        this.client = new GameClient("localhost", 666, gamePanel);
        client.connect();
        System.out.println(client.getID());
        if (client.getID() == 0) {
            connect_client_id = 1;
        } else {
            connect_client_id = 0;
        }

    }

   
    public LoginForm getLoginForm() {
        return loginForm;
    }
    
    /*public Home getHome() {
        //return home;
    }*/
    
      public RegForm getRegForm() {
        return regForm;
    }

    private void initCards() {
        cards.add(loginForm, "loginForm");
       // cards.add(home, "home");
        cards.add(regForm, "regForm");

        add(cards);
    }
    
    public void addCard(JPanel card, String name){
        cards.add(card, name);
        add(cards);
    }

    public void showCard(String show) {
        cl.show(cards, show);
    }

        public static String fillString(int size, char fillChar, String original) {
        char[] fillArray = new char[size];
        Arrays.fill(fillArray, fillChar);

        int min_size = Math.min(size, original.length());
        for (int i = 0; i < min_size; i++) {
            fillArray[size - (min_size - i)] = original.charAt(i);
        }

        String retval = new String();
        for (int i = 0; i < size; i++) {
            retval += fillArray[i];
        }
        return retval;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

        
}
