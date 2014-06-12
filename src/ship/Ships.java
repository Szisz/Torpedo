/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ship;

import java.util.ArrayList;

/**
 *
 * @author szilard
 */
public class Ships {

    private ArrayList<Ship> ships;

    public Ships() {
        this.ships = new ArrayList<>();
    }

    public void addShip(Ship _ship) {
        ships.add(_ship);
    }

    public void deteleShip() {
        ships.remove(ships.size() - 1);
    }

    public ArrayList<Ship> Ships() {
        return ships;
    }

    public Ship getShip(int index) {
        return ships.get(index);
    }

    public int getFirstFreeShip(int size) {
        int retval = -1;
        int i = 0;
        boolean b = false;
        while (i < ships.size() && !b) {
            if (ships.get(i).getSize() == size && !ships.get(i).isValid()) {
                b = true;
                retval = i;
            }
            i++;
        }
        return retval;
    }
}
