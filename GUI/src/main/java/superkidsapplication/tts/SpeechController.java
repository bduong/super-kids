package superkidsapplication.tts;

import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;

public interface SpeechController {

    void say(String speech) throws Exception;
}
