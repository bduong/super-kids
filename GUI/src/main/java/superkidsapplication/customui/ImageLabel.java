/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superkidsapplication.customui;

/**
 *
 * @author david
 */
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
 *
 * @author david cheung
 */
public class ImageLabel extends JLabel {
    
    public Image image;
    private ImageObserver imageObserver;
    
    
    public ImageLabel() {
        super();
    }
    
    
    @Override
    public void paint(Graphics g) {
        //super.paint(g);
        int w, h, maxw, maxh;
        image = iconToImage(this.getIcon());
     
        if (this.getIcon().getIconWidth() < getWidth())
        {
            
            maxw = this.getIcon().getIconWidth();
            w = getWidth()/2 - this.getIcon().getIconWidth()/2;
        }
        else
        {
            maxw = getWidth();
            w = 0;
        }
        if (this.getIcon().getIconHeight() < getHeight())
        {
            maxh = this.getIcon().getIconHeight();
            h = getHeight()/2 - this.getIcon().getIconHeight()/2;
        }
        else
        {
            maxh = getHeight();
            h = 0;
        }
        
        g.drawImage(image, w, h, maxw, maxh, imageObserver);
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
