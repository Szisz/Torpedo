/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ship;

/**
 *
 * @author szilard
 */
public class Ship {

    private int size;
    private ShipComponent[] component;
    private Ships otherShips;

    public Ship(int comp_num, Ships _others) {
        this.size = comp_num;
        this.otherShips = _others;
        component = new ShipComponent[comp_num];
        for (int i = 0; i < comp_num; i++) {
            component[i] = new ShipComponent(-1, -1);
        }
    }

    public void setCompPos(int comp_id, int x, int y) {
        component[comp_id].setPosition(x, y);
        component[comp_id].setValid_comp(true);
    }

    public void compDamaged(int comp_id) {
        component[comp_id].setDamaged(true);
    }

    public boolean validCompPos(int comp_pos, int x, int y) {
        boolean retval = true;
        for (int i = 0; i < otherShips.Ships().size(); i++) {
            if (otherShips.getShip(i).isValid()) {
                for (int j = 0; j < otherShips.getShip(i).size; j++) {
                    if ((x == otherShips.getShip(i).component[j].getX() && y == otherShips.getShip(i).component[j].getY()) || (Math.abs(x - otherShips.getShip(i).component[j].getX()) + Math.abs(y - otherShips.getShip(i).component[j].getY())) < 2) {
                        retval = false;
                    }
                }
            }
        }
        if (retval == true && comp_pos > 0) {
            int neighbor_comp_num = 0;
            boolean same_comp = false;
            for (int i = 0; i < component.length; i++) {
                if ((x == component[i].getX() ^ y == component[i].getY()) && ((component[i].getY() + 1 == y || component[i].getY() - 1 == y) ^ (x == component[i].getX() + 1 || x == component[i].getX() - 1))) {
                    neighbor_comp_num++;
                }
                if (x == component[i].getX() && y == component[i].getY()) {
                    same_comp = true;
                }
            }

            if (neighbor_comp_num != 1 || same_comp) {
                retval = false;
            }
        }
        return retval;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ShipComponent getComp(int comp_index) {
        return component[comp_index];
    }

    public boolean isValid() {
        boolean retval = true;
        for (int i = 0; i < component.length; i++) {
            if (!component[i].isValid_comp()) {
                retval = false;
            }
        }
        return retval;
    }

    public int getFirstFreeComp() {
        int retval = -1;
        int j = 0;
        boolean l = false;
        while (j < component.length && !l) {
            if (!component[j].isValid_comp()) {
                l = true;
                retval = j;
            }
            j++;
        }
        return retval;
    }
    
    public void clearComponent(){
        for(int i=0; i<component.length; i++){
            component[i].setValid_comp(false);
            component[i].setPosition(-1, -1);
        }
    }
}
