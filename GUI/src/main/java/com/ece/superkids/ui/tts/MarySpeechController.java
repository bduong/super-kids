package com.ece.superkids.ui.tts;

import javax.sound.sampled.AudioInputStream;
import marytts.LocalMaryInterface;
import marytts.MaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.util.data.audio.AudioPlayer;

/**
 * The <code>MarySpeechController</code> uses the MARY text-to-speech engine
 * in order to generate audio files that contain speech patterns.
 *
 * @author Ben Duong
 */
public class MarySpeechController implements SpeechController{

    MaryInterface marytts;

    private MarySpeechController()  {
        try {
            marytts = new LocalMaryInterface();
            marytts.setVoice(marytts.getAvailableVoices().iterator().next());
        } catch (MaryConfigurationException e) {
            e.printStackTrace();
        }
    }

    private static class MarySpeechControllerFactory {
        private static final SpeechController INSTANCE = new MarySpeechController();
    }

    public static SpeechController getInstance() {
        return MarySpeechControllerFactory.INSTANCE;
    }

    @Override
    public void say(final String sentence) throws Exception {
        AudioInputStream audio = marytts.generateAudio(sentence);
        AudioPlayer player = new AudioPlayer(audio);
        player.start();
        player.join();
    }

    /**
     * This method is to test out the TTS engine with an arbitrary sentences.
     */
    public static void main(String [] args) throws Exception {
        SpeechController speechController = MarySpeechController.getInstance();
        speechController.say("Something");
        System.exit(0);
    }
}
