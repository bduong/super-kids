package superkidsapplication.providers;

import sun.audio.AudioStream;

import javax.sound.sampled.AudioInputStream;

public interface MusicProvider {

    public AudioInputStream getMusicStream(String theme);
}
