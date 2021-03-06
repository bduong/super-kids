/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ece.superkids.ui.customui;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * This GUI class <code>ImageLabel</code>
 * extends JLabel so that images get resized and center in the JLabel
 * 
 * @author david cheung
 */
public class ImageLabel extends JLabel {
    
    public Image image;
    private ImageObserver imageObserver;
    private int iconwidth, iconheight;
    
    
    /**
    * This GUI class ImageLabel
    * extends JLabel so that images get resized and center in the JLabel
    */
    public ImageLabel() {
        super();
    }
    
    
    @Override
    public void setIcon(Icon icon)
    {
        super.setIcon(null);
        
        if (icon != null)
        {
            iconwidth = icon.getIconWidth();
            iconheight = icon.getIconHeight();
            image = iconToImage(icon);
        }
        super.repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (image != null)
        {
            int w, h, maxw, maxh;

            if (iconwidth < getWidth())
            {

                maxw = iconwidth;
                w = getWidth()/2 - iconwidth/2;
            }
            else
            {
                maxw = getWidth();
                w = 0;
            }
            if (iconheight < getHeight())
            {
                maxh = iconheight;
                h = getHeight()/2 - iconheight/2;
            }
            else
            {
                maxh = getHeight();
                h = 0;
            }

            g.drawImage(image, w, h, maxw, maxh, imageObserver);
        }
    }
    
    static Image iconToImage(Icon icon) {
        if (icon instanceof ImageIcon) {
            return ((ImageIcon)icon).getImage();
        } else {
            int w = icon.getIconWidth();
            int h = icon.getIconHeight();
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gd = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gd.getDefaultConfiguration();
            BufferedImage image = gc.createCompatibleImage(w, h);
            Graphics2D g = image.createGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.dispose();
            return image;
        }
    }
    
}
