package superkidsapplication.tts;

import marytts.exceptions.SynthesisException;

public interface SpeechController {

    void say(String sentence) throws Exception;

}
