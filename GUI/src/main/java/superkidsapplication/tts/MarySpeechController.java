package superkidsapplication.tts;

import marytts.LocalMaryInterface;
import marytts.MaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.util.data.audio.AudioPlayer;

import javax.sound.sampled.AudioInputStream;
import java.util.Set;

public class MarySpeechController implements SpeechController{

    MaryInterface marytts;

    public MarySpeechController() throws MaryConfigurationException {
        marytts = new LocalMaryInterface();
        Set<String> voices = marytts.getAvailableVoices();
        System.out.println(voices.size());
        marytts.setVoice(voices.iterator().next());
        marytts.setVoice(voices.iterator().next());
        marytts.setVoice(voices.iterator().next());
        marytts.setVoice(voices.iterator().next());
    }

    @Override
    public void say(final String speech) throws Exception {
        AudioInputStream audio = marytts.generateAudio(speech);
        AudioPlayer player = new AudioPlayer(audio);
        player.start();
        player.join();
    }

    public static void main(String [] args) throws MaryConfigurationException {

        SpeechController speech = new MarySpeechController();
        try {
            speech.say("Shapes");
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.exit(0);
    }
}
