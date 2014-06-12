/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouse_listeners;

import game_area.AreaComponent;
import game_area.GameArea;
import java.awt.event.MouseEvent;

/**
 *
 * @author szilard
 */
public class SelfMouseListener extends BaseMouseListener {

    private int temp_img_index;

    public SelfMouseListener(AreaComponent _comp, GameArea _area) {
        super(_comp, _area);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (subject.getImgIndex() != 2) {
            subject.changeImage(0);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (this.subject.isEnable()) {
            if (this.subject.isEnable()) {
                int firstFreeShip = area.Ships().getFirstFreeShip(area.getSetShip());
                if (firstFreeShip != -1) {
                    temp_img_index = subject.getImgIndex();
                    int firstFreeComp = area.getShip(firstFreeShip).getFirstFreeComp();
                    if (firstFreeComp != -1) {
                        if (area.getShip(firstFreeShip).validCompPos(firstFreeComp, this.subject.getX() / subject.getWidth(), this.subject.getY() / subject.getWidth())) {
                            subject.changeImage(1);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.subject.isEnable()) {
            int firstFreeShip = area.Ships().getFirstFreeShip(area.getSetShip());
            if (firstFreeShip != -1) {
                temp_img_index = subject.getImgIndex();
                int firstFreeComp = area.getShip(firstFreeShip).getFirstFreeComp();
                if (firstFreeComp != -1) {
                    if (area.getShip(firstFreeShip).validCompPos(firstFreeComp, this.subject.getX() / subject.getWidth(), this.subject.getY() / subject.getWidth())) {
                        area.getShip(firstFreeShip).setCompPos(firstFreeComp, this.subject.getX() / subject.getWidth(), this.subject.getY() / subject.getWidth());
                        area.getComponent(this.subject.getX() / subject.getWidth(), this.subject.getY() / subject.getWidth()).setShip(area.getShip(firstFreeShip).getComp(firstFreeComp));
                        subject.changeImage(2);
                    }
                }
            }
        }
    }
}
