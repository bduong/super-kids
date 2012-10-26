/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superkidsapplication.controllers;

import java.applet.*;
import javax.swing.*;


/**
 *
 * @author baris
 * MUSIC by
 * www.nosoapradio.us
 * track: GameForest
 */

public class MusicController extends JApplet{
    
    private AudioClip song;
    
    private MusicController(){  
    }
    
    private static class MusicControllerHolder {
        public static final MusicController INSTANCE = new MusicController();
    }

    public static MusicController getInstance() {
        return MusicController.MusicControllerHolder.INSTANCE;
    }
    
    //load main theme
    public void loadThemeMusic(){
        song = Applet.newAudioClip(getClass().getResource("/music/GameForest.wav"));
    }
         
    public void playMusic() {
            song.loop(); // Play in a loop 
    }
    
    public void stopMusic() {
            song.stop(); // Stop
    }
}
