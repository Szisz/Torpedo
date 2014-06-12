/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game_area;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import javax.swing.JPanel;
import ship.Ship;
import ship.Ships;

/**
 *
 * @author szilard
 * @param <T>
 */
public class GameArea<T extends MouseListener> extends JPanel{
     
    private Ships ships;
    private AreaComponent[][] parts;
    private final Class<T> listenerType;
    private int settingShip;
    
    public GameArea(int part_x, int part_y, ArrayList<BufferedImage> images, Class<T> _listenerType, Ships _ships) throws InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException{
        //this.setLayout(null);
        this.setLayout(new GridLayout(part_x, part_y));
        this.setVisible(true);
        //this.setBackground(Color.ORANGE);
        this.listenerType=_listenerType;
        this.ships=_ships;
        this.settingShip=0;
        Constructor<T> c=listenerType.getConstructor(AreaComponent.class, GameArea.class);
        
        
        
        parts=new AreaComponent[part_x][part_y];
        for(int i=0; i<parts.length; i++){
            for(int j=0; j<parts[i].length; j++){
                parts[i][j]=new AreaComponent(images);
                //parts[i][j].setBounds(i*(parts[i][j].getImgSize()+1), j*(parts[i][j].getImgSize()+1), parts[i][j].getImgSize()/*+1*/, parts[i][j].getImgSize()/*+1*/);
                parts[i][j].addMouseListener(c.newInstance(parts[i][j], this));
                this.add(parts[i][j]);
            }
        }
        //this.setBounds(0, 0, (part_x*parts[0][0].getImgSize()+part_x)-1, (part_y*parts[0][0].getImgSize()+part_y)-1);
    }
    
    public void enableClick(boolean enable){
        for(int i=0; i<parts.length; i++){
            for(int j=0; j<parts[i].length; j++){
                parts[i][j].setEnable(enable);
            }
        }
    }
    
    public void enableClick(boolean enable, int i, int j){
        parts[i][j].setEnable(enable);
    }
    
    public AreaComponent getComponent(int i, int j){
        return parts[i][j];
    }

    public int getSetShip() {
        return settingShip;
    }

    public void setSetShip(int setShip) {
        this.settingShip = setShip;
    }
    
    public ArrayList<Ship> getShip(){
        return ships.Ships();
    }
    
    public Ships Ships(){
        return ships;
    }
    
    public Ship getShip(int index){
        return ships.getShip(index);
    }
    
    public AreaComponent[][] getAreaComponents(){
        return parts;
    }
}
