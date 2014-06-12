/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torpedo;

import game_panel.GamePanel;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author latyak1
 */
public class Home extends JPanel {

    private JTabbedPane tabbedPane;
    private JPanel userPn;
    private JSplitPane sph;
    private JSplitPane spv;
    private JMenuBar mb;
    private JMenu mSettings;
    private JMenu mLogout;
    private MainFrame frame;

    public Home(MainFrame frame) throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        this.frame = frame;
        this.setLayout(new BorderLayout());
        tabbedPane = new JTabbedPane();
        userPn = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sph = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        spv = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        mb = new JMenuBar();
        mSettings = new JMenu("Beállítások");
        mLogout = new JMenu("Kijelentkezés");

        initMenu();
        initSplitPane();

        this.add(spv);

    }

    private void initSplitPane() throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{

        initTab("sda");
        initTab("sdsere");
        initTab("ser");
        initTab("sesa");

        sph.setDividerLocation(200);
        spv.setDividerLocation(300);
        sph.setOneTouchExpandable(true);

        JPanel profilePn = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel chatPn = new JPanel();

        //profilePn.add(new JLabel("profile"));
        profilePn.add(frame.getGamePanel());

        chatPn.setLayout(new BorderLayout());
        chatPn.add(tabbedPane, BorderLayout.CENTER);
        chatPn.setBackground(Color.white);

        spv.add(sph);

        spv.add(chatPn);
        sph.add(userPn);
        sph.add(profilePn);

        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        initTree();

    }

    private void initTab(String name) {
        if (tabbedPane.indexOfTab(name) == -1) {

            JTextPane tp = new JTextPane();
            JScrollPane msg = new JScrollPane(tp);

            JScrollPane input = new JScrollPane(new JTextPane());

            JButton submit = new JButton("Küldés");

            tp.setText("asdasda d asd asd asd s");

            tp.setEditable(false);

            JPanel container = new JPanel();

            container.setLayout(new BorderLayout());
            container.add(msg, BorderLayout.CENTER);
            container.add(input, BorderLayout.SOUTH);
            container.add(submit, BorderLayout.EAST);

            tabbedPane.add(name, new JScrollPane(container));
            tabbedPane.setTabComponentAt(tabbedPane.getTabCount() - 1,
                    new ButtonTabComponent(tabbedPane));
        }
        tabbedPane.setSelectedIndex(tabbedPane.indexOfTab(name));

    }

    private void initTree() {

        DefaultMutableTreeNode friends = new DefaultMutableTreeNode("Barátok");
        DefaultMutableTreeNode online = new DefaultMutableTreeNode("Online");
        DefaultMutableTreeNode offline = new DefaultMutableTreeNode("Offline");

        DefaultMutableTreeNode u1 = new DefaultMutableTreeNode("User1");
        DefaultMutableTreeNode u2 = new DefaultMutableTreeNode("User2");
        DefaultMutableTreeNode u3 = new DefaultMutableTreeNode("User3");

        online.add(u1);
        online.add(u2);

        offline.add(u3);

        friends.add(online);
        friends.add(offline);

        JTree treefriends = new JTree(friends);

        for (int i = 0; i < treefriends.getRowCount(); i++) {
            treefriends.expandRow(i);
        }

        userPn.add(treefriends);
    }

    private void initMenu() {
        JMenuItem miProfile = new JMenuItem();
        mb.setLayout(new BoxLayout(mb, BoxLayout.LINE_AXIS));
        mb.add(mSettings);
        mb.add(mLogout);
        
        mSettings.add(miProfile);
        
        frame.setJMenuBar(mb);

    }
    
    public void setUser(String userName){
        User user=new User(userName);
    }

    /*private void initToolBar() {
     JToolBar toolbar = new JToolBar("TB");
     JButton btEditor = new JButton(editoraction);
     JButton btData = new JButton(dataaction);
     JButton btMegnyit = new JButton(openaction);
     //btEditor.setAction(editoraction);
     toolbar.add(btMegnyit);
     toolbar.add(btEditor);
     toolbar.add(btData);

     add(toolbar, BorderLayout.PAGE_START);
     }*/
}
