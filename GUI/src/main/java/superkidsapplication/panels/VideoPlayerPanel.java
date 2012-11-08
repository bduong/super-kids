/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superkidsapplication.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import javafx.application.Platform;
import javax.swing.JPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.embed.swing.JFXPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Heng
 */
public class VideoPlayerPanel extends JPanel{
    
    private String filepath=null;
    private Media media=null;
    private MediaPlayer mediaplayer=null;
    private MediaView mediaview=null;
    private Group root=null;
    private Scene scene = null;
    private JFXPanel jfxpanel=new JFXPanel();
    
    public VideoPlayerPanel(String str){
        //TODO constructor
        this.filepath=str;
        //this.setBackground(Color.red);
        this.setSize(640, 360);
        initAndShowGUI();
    }
    
    private void initAndShowGUI(){
        
        
        
        this.add(jfxpanel,BorderLayout.CENTER);
        this.setVisible(true);
        
        Platform.runLater(new Runnable(){
            @Override
            public void run(){
                initFX(jfxpanel);
            }
        });
    }
    
    private void initFX(JFXPanel jfxpenal){
        root=new Group();
        scene=new Scene(root,640,360);
        media=new Media(filepath);
        mediaplayer=new MediaPlayer(media);
        mediaview=new MediaView(mediaplayer);
        mediaplayer.setAutoPlay(true);
        root.getChildren().add(mediaview);
        jfxpanel.setScene(scene);
    }
}
