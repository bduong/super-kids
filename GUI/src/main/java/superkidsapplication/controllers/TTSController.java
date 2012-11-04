/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superkidsapplication.controllers;

import java.io.IOException;

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
    }
   
    
}
