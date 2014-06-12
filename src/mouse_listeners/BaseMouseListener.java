/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mouse_listeners;

import game_area.AreaComponent;
import game_area.GameArea;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author szilard
 */
public class BaseMouseListener implements MouseListener{
    
    protected AreaComponent subject;
    protected GameArea area;
    
    public BaseMouseListener(AreaComponent _comp, GameArea _area){
        this.subject=_comp;
        this.area=_area;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
