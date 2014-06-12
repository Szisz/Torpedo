/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game_area;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author szilard
 * 
 * Csak egyenlő oldalú képek, egyező méretű képek listája adható át!!!
 * 
 */
public class ImagePanel extends JPanel {
    
    private BufferedImage aktiv_img;
    private ArrayList<BufferedImage> images;
    private Integer Size = null;
    private int aktiv_img_num;
    
    public ImagePanel() {
    }
    
    public ImagePanel(ArrayList<BufferedImage> _images) {
        this.images=_images;
        this.aktiv_img = images.get(0);
        this.aktiv_img_num = 0;
        this.Size=this.aktiv_img.getWidth()+100;
        this.setBounds(0, 0, this.Size, this.Size);
        this.setSize(this.Size, this.Size);
        //this.setMinimumSize(new Dimension(this.Size, this.Size));
        //this.setLayout(null);
        this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        this.setVisible(true);
    }
    
    public void changeImage(int image_index) {
        this.aktiv_img = images.get(image_index);
        this.aktiv_img_num=image_index;
        this.Size=this.aktiv_img.getWidth();
        this.repaint();
    }
    
    public int getImgIndex(){
        return aktiv_img_num;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(aktiv_img, 0, 0, this.Size, this.Size, null);
    }
    
    public int getImgSize(){
        return this.Size;
    }
}
