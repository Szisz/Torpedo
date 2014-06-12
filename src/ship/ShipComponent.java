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
public class ShipComponent {
    private int x_pos;
    private int y_pos;
    private boolean damaged;
    private boolean valid_comp;
    
    public ShipComponent(int x, int y){
        this.x_pos=x;
        this.y_pos=y;
        this.damaged=false;
        this.valid_comp=false;
    }
    
    public void setPosition(int x, int y){
        this.x_pos=x;
        this.y_pos=y;
    }
    
    public int getX(){
        return x_pos;
    }
    
    public int getY(){
        return y_pos;
    }
    
    public boolean getDamaged(){
        return damaged;
    }
    
    public void setDamaged(boolean damaged){
        this.damaged=damaged;
    }

    public boolean isValid_comp() {
        return valid_comp;
    }

    public void setValid_comp(boolean valid_comp) {
        this.valid_comp = valid_comp;
    }
}
