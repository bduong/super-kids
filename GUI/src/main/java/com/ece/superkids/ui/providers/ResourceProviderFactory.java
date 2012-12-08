package com.ece.superkids.ui.providers;

import java.io.IOException;

/**
 * The <code>ResourceProviderFactory</code> provides access to resource providers used
 * by the UI elements.
 *
 * @author Ben Duong
 */
public class ResourceProviderFactory {

    private static ImageProvider imageProvider;
    private static MusicProvider musicProvider;

    /**
     * Get the image provider.
     *
     * @return The image provider.
     */
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

    /**
     * Get the music provider.
     *
     * @return The music provider.
     */
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
