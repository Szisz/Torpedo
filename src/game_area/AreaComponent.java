/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_area;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import ship.ShipComponent;

/**
 *
 * @author szilard
 */
public class AreaComponent extends ImagePanel {

    private ShipComponent ship;
    private boolean enable;

    public AreaComponent() {
        this.ship=null;
        this.enable=true;
    }

    AreaComponent(ArrayList<BufferedImage> images) {
        super(images);
        this.enable=true;
    }

    public ShipComponent getShip() {
        return ship;
    }

    public void setShip(ShipComponent ship) {
        this.ship = ship;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
