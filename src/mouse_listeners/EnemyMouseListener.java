/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouse_listeners;

import game_area.AreaComponent;
import game_area.GameArea;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import torpedo.MainFrame;

/**
 *
 * @author szilard
 */
public class EnemyMouseListener extends BaseMouseListener {

    public EnemyMouseListener(AreaComponent _comp, GameArea _area) {
        super(_comp, _area);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.subject.isEnable()) {
            try {
                String index_i=MainFrame.fillString(2, '0', ""+this.subject.getY()/subject.getWidth());
                String index_j=MainFrame.fillString(2, '0', ""+this.subject.getX()/subject.getWidth());
                MainFrame.client.sendClients(""+MainFrame.connect_client_id, "shot_"+index_i + "_" + index_j);
            } catch (IOException ex) {
                Logger.getLogger(EnemyMouseListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
