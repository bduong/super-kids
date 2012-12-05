package superkidsapplication.tts;

/**
 * The <code>SpeechController</code> allows access to a text-to-speech engine
 * to play words through audio.
 *
 * @author Ben Duong
 */
public interface SpeechController {

    /**
     * Say a given sentence.
     *
     * @param sentence the sentence to play
     * @throws Exception If we cannot synthesize the speech audio.
     */
    void say(String sentence) throws Exception;
}
