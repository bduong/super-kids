package providers;

import org.junit.Before;
import org.junit.Test;
import com.ece.superkids.ui.providers.MusicProvider;
import com.ece.superkids.ui.providers.ResourceProviderFactory;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static junit.framework.Assert.assertEquals;

public class FIlePathMusicProviderTests {

    private static final String KNOWN_THEME = "flyingaces";
    private static final String KNOWN_MUSIC = "/music/FlyingAces.wav";

    private MusicProvider musicProvider;

    @Before
    public void setupProvider() {
        musicProvider = ResourceProviderFactory.aMusicProvider();
    }

    @Test
    public void providerLoadsCorrectThemeMusic() throws UnsupportedAudioFileException, IOException {
        AudioInputStream audio = musicProvider.getMusicStream(KNOWN_THEME);
        AudioInputStream expected = AudioSystem.getAudioInputStream(getClass().getResource(KNOWN_MUSIC));

        assertAudioStreamsAreIdentical(audio, expected);
    }

    private void assertAudioStreamsAreIdentical(final AudioInputStream audio, final AudioInputStream expected)
            throws IOException {
        assertEquals(expected.available(), audio.available());

        byte[] ex = new byte[expected.available()];
        byte[] au = new byte[audio.available()];
        expected.read(ex, 0, expected.available());
        audio.read(au, 0 , audio.available());

        for (int num = 0; num < ex.length; num++ ) {
            assertEquals(ex[num], au[num]);
        }
    }
}
