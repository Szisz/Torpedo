/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_panel;

import game_area.GameArea;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import mouse_listeners.EnemyMouseListener;
import mouse_listeners.SelfMouseListener;
import ship.Ship;
import ship.Ships;

/**
 *
 * @author szilard
 */
public class GamePanel extends JPanel {

    private final ArrayList<BufferedImage> images;
    private GameArea<EnemyMouseListener> enemyArea;
    private GameArea<SelfMouseListener> selfArea;
    private Ships ships;
    private JButton[] shipsButton;
    private JButton deleteShipButton;
    private JPanel buttonPanel;

    public GamePanel() throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        //this.setBounds(5, 5, 500, 300);
        //this.setLayout(null);
        //setSize(300, 300);
        this.setVisible(true);
        //this.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
        this.images = new ArrayList();
        images.add(ImageIO.read(new File("unit.png")));
        images.add(ImageIO.read(new File("unit_2.png")));
        images.add(ImageIO.read(new File("unit_3.png")));

        this.ships = new Ships();
        ships.addShip(new Ship(1, ships));
        ships.addShip(new Ship(1, ships));
        ships.addShip(new Ship(2, ships));
        ships.addShip(new Ship(3, ships));
        ships.addShip(new Ship(4, ships));

        /*buttonPanel = new JPanel(null);
        buttonPanel.setVisible(true);
        buttonPanel.setBounds(380, 5, 80, 200);
        //buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        shipsButton = new JButton[4];
        for (int i = 0; i < 4; i++) {
            shipsButton[i] = new JButton("" + (i + 1));
            shipsButton[i].setLayout(null);
            shipsButton[i].setBounds(0, 0 + (i * 30), 80, 30);
            buttonPanel.add(shipsButton[i]);

            shipsButton[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    int setShip = Integer.parseInt(((JButton) e.getSource()).getText());
                    if (selfArea.getSetShip() != setShip) {
                        selfArea.setSetShip(setShip);
                    } else {
                        int firstFreeShip = selfArea.Ships().getFirstFreeShip(setShip);
                        if (firstFreeShip != -1) {
                            for (int i = 0; i < ships.getShip(firstFreeShip).getSize(); i++) {
                                if (ships.getShip(firstFreeShip).getComp(i).isValid_comp()) {
                                    selfArea.getAreaComponents()[ships.getShip(firstFreeShip).getComp(i).getX()][ships.getShip(firstFreeShip).getComp(i).getY()].changeImage(0);
                                }
                            }
                            ships.getShip(firstFreeShip).clearComponent();
                        }
                        selfArea.setSetShip(0);
                    }
                }
            });
        }

        deleteShipButton = new JButton("DEL");
        deleteShipButton.setLayout(null);
        deleteShipButton.setBounds(0, 150, 80, 30);
        deleteShipButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < ships.Ships().size(); i++) {
                    ships.getShip(i).clearComponent();
                }
                for (int i = 0; i < selfArea.getAreaComponents().length; i++) {
                    for (int j = 0; j < selfArea.getAreaComponents()[i].length; j++) {
                        selfArea.getAreaComponents()[i][j].changeImage(0);
                    }
                }
            }
        });
        buttonPanel.add(deleteShipButton);*/

        enemyArea = new GameArea(6, 6, images, EnemyMouseListener.class, null);
        //enemyArea.setLocation(5, 5);
        selfArea = new GameArea(6, 6, images, SelfMouseListener.class, ships);
        //selfArea.setLocation(200, 5);

        //this.add(buttonPanel);
        this.add(enemyArea);
        this.add(selfArea);
    }

    public GameArea<EnemyMouseListener> getEnemyArea() {
        return enemyArea;
    }

    public GameArea<SelfMouseListener> getSelfArea() {
        return selfArea;
    }
}
