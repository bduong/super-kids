package superkidsapplication.providers;

import java.io.IOException;

public class ResourceProviderFactory {

    private static ImageProvider imageProvider;

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
}
