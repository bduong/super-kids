/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ece.superkids.ui.controllers;

import javax.sound.sampled.*;
import com.ece.superkids.ui.providers.MusicProvider;
import com.ece.superkids.ui.providers.ResourceProviderFactory;

/**
 * <code>MusicController</code>
 * 
 * @author baris
 * 
 * MUSIC by www.nosoapradio.us
 *
 * a method to play audio clips:
 * http://www3.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html
 *
 * also http://www.developer.com/java/other/print.php/2173111
 *
 * a large wav file cannot be played using the method in the first link refer to
 * this article: http://codeidol.com/java/swing/Audio/Play-Non-Trivial-Audio/
 * you get this exception: javax.sound.sampled.LineUnavailableException: Failed
 * to allocate clip data: Requested buffer too large. it needs to be buffered,
 * thats why we are using the PlayThread.
 *
 */
public class MusicController {

    private AudioFormat audioFormat;
    private AudioInputStream audioInputStream;
    private SourceDataLine sourceDataLine;
    private Boolean stopPlayback;
    private String theme;
    private boolean firstLoad;
    private MusicProvider musicProvider;

    private MusicController() {
        //initally not playing
        stopPlayback = true;
        //this the first loading of theme
        firstLoad = true;
        musicProvider = ResourceProviderFactory.aMusicProvider();
    }

    private static class MusicControllerHolder {

        public static final MusicController INSTANCE = new MusicController();
    }

    /**
     * @return instance of music controller 
     */
    public static MusicController getInstance() {
        return MusicController.MusicControllerHolder.INSTANCE;
    }

    
    /**
     * load main theme
     * @param themeToLoad theam to load 
     */
    public void loadThemeMusic(String themeToLoad) {
        theme = themeToLoad;
        try {
            if (audioInputStream != null) audioInputStream.close();
            if (firstLoad) {
                audioInputStream = musicProvider.getMusicStream(theme);
                audioFormat = audioInputStream.getFormat();
                System.out.println("Audio Format: " + audioFormat);

                DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);

                sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
                firstLoad = false;
            } //then you are changing the song
            else {
                audioInputStream = musicProvider.getMusicStream(theme);
                System.out.println("Theme song is changed to: "+ theme);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * play the music
     */
    public void playMusic() {
        //if the music has been stopped before...
        if (stopPlayback) {
            //then restart.
            //this prevents creating new threads when there is one already running
            stopPlayback = false;
            System.out.println("Start play thread");
            new PlayThread().start();
        }
    }

    /**
     * stop the music
     */
    public void stopMusic() {
        stopPlayback = true;
    }

    /**
     * set the volume
     * @param gain gain to be set 
     */
    public void setVolume(double gain) {
        FloatControl gainControl = (FloatControl) sourceDataLine.getControl(FloatControl.Type.MASTER_GAIN);
        // set the gain
        float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
        gainControl.setValue(dB);
    }

//=============================================//
 /**
  * Inner class to play back the data from the audio file.
  */ 
 private class PlayThread extends Thread {

        byte tempBuffer[] = new byte[10000];

        public void run() {
            try {
                sourceDataLine.open(audioFormat);
                sourceDataLine.start();

                int cnt;
                //Keep looping until stopPlayback is set to true.
                while (!stopPlayback) {
                    cnt = audioInputStream.read(tempBuffer, 0, tempBuffer.length);
                    if (cnt > 0) {
                        //Write data to the internal buffer of
                        // the data line where it will be
                        // delivered to the speaker.
                        sourceDataLine.write(
                                tempBuffer, 0, cnt);
                    }//if end of stream then reset
                    if (cnt == -1) {
                        System.out.println("Reset the input(open file again)");
                        audioInputStream.close();
                        audioInputStream = musicProvider.getMusicStream(theme);
                    }
                }//end while
                
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0);
            }//end catch
        }//end run
    }//end inner class PlayThread
//===================================//
}