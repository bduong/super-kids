package superkidsapplication.providers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

/**
 * The <code>FilePathMusicProvider</code> serves up the audio streams by using a key-value pair
 * for the path to the piece of music.
 *
 * @author Ben Duong
 */
public class FilePathMusicProvider implements MusicProvider{

    private static final String PROPERTY_FILE = "/providers/music_paths.properties";
    Map<String, String> musicPaths = new HashMap<String, String>();

    public FilePathMusicProvider() throws IOException {
        loadFilePaths();
    }

    /**
     * Load the file paths of the audio files.
     *
     * @throws IOException If we cannot open the file.
     */
    private void loadFilePaths() throws IOException {
        InputStream in = getClass().getResourceAsStream(PROPERTY_FILE);
        Properties filePaths = new Properties();

        filePaths.load(in);
        in.close();


        Enumeration e = filePaths.propertyNames();

        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            musicPaths.put(key, filePaths.getProperty(key));
        }
    }

    @Override
    public AudioInputStream getMusicStream(final String theme) {
        String path = musicPaths.get(theme.toLowerCase());
        try {
            return AudioSystem.getAudioInputStream(getClass().getResource(path));
        } catch (Exception e) {
            return null;
        }
    }
}
