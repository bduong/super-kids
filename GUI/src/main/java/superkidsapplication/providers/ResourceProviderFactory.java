package superkidsapplication.providers;

import java.io.IOException;

public class ResourceProviderFactory {

    private static ImageProvider imageProvider;
    private static MusicProvider musicProvider;

    public static ImageProvider anImageProvider() {
        if (imageProvider == null) {
            try {
                imageProvider = new FilePathImageProvider();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return imageProvider;
    }

    public static MusicProvider aMusicProvider() {
        if(musicProvider == null) {
            try {
                musicProvider = new FilePathMusicProvider();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return musicProvider;
    }
}
