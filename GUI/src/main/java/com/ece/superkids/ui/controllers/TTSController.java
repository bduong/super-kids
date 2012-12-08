/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ece.superkids.ui.controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.ece.superkids.ui.tts.MarySpeechController;
import com.ece.superkids.ui.tts.SpeechController;

/**
 *
 * @author david C
 */
public class TTSController {
    
    //Use this if you want to have text to speech
    public static void TTS(String string)
    {
        //Mac Only
        if (System.getProperty("os.name").contains("OS X")) {
            try {
                Runtime.getRuntime().exec(new String[]{"say", string});
            } catch (IOException ex) {
                //Something
            }
        }
        //if not on MAC
        else{
            SpeechController mary = MarySpeechController.getInstance();
            try {
                mary.say(string);
            } catch (Exception ex) {
                Logger.getLogger(TTSController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
    
}
