/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jatekter;

import game_panel.GamePanel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ship.ShipComponent;
import torpedo.MainFrame;

/**
 *
 * @author szilard
 */
public class GameClient extends MyClient {

    private GamePanel game;

    public GameClient(String _host, int _port, GamePanel _game) {
        super(_host, _port);
        this.game = _game;
    }

    @Override
    public void run() {
        //Különböző üzenetek milyen hatással vannak a GamePanelra
        while (true) {
            try {
                String message = input.readUTF();
                System.out.println(message);
                String action = message.substring(0, 4);
                switch (action) {
                    case "shot": {
                        String str_i = message.substring(5, 7);
                        String str_j = message.substring(8, 10);
                        int i = Integer.parseInt(str_i);
                        int j = Integer.parseInt(str_j);
                        ShipComponent comp=game.getSelfArea().getComponent(i, j).getShip();
                        if (comp != null/* && !comp.getDamaged()*/) {
                            comp.setDamaged(true);
                            MainFrame.client.sendClients("" + MainFrame.connect_client_id, "hit1_" + str_i + "_" + str_j);
                        } else {
                            MainFrame.client.sendClients("" + MainFrame.connect_client_id, "hit0_" + str_i + "_" + str_j);
                        }
                    }
                    break;
                    case "hit1":{
                        System.out.println("találtam");
                        String str_i = message.substring(5, 7);
                        String str_j = message.substring(8, 10);
                        int i = Integer.parseInt(str_i);
                        int j = Integer.parseInt(str_j);
                        game.getEnemyArea().getComponent(i, j).changeImage(2);
                    }
                    break;
                    case "hit0":{
                        System.out.println("nem találtam");
                        String str_i = message.substring(5, 7);
                        String str_j = message.substring(8, 10);
                        int i = Integer.parseInt(str_i);
                        int j = Integer.parseInt(str_j);
                        game.getEnemyArea().getComponent(i, j).changeImage(1);
                    }
                    break;
                    default: {
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(GameClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
