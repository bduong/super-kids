package superkidsapplication.providers;

import javax.sound.sampled.AudioInputStream;

/**
 * The <code>MusicProvider</code> allows access to music files through a key.
 *
 * @author Ben Duong
 */
public interface MusicProvider {

    /**
     * Get the audio stream for a given piece of music.
     *
     * @param theme the theme to use
     * @return The audio stream.
     */
    public AudioInputStream getMusicStream(String theme);
}
