package superkidsapplication.providers;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FilePathImageProvider implements ImageProvider{

    private static final String PROPERTY_FILE = "/question/image_paths.properties";
    Map<String, String> imagePaths;


    public FilePathImageProvider() throws IOException {
        InputStream in = getClass().getResourceAsStream(PROPERTY_FILE);
        Properties filePaths = new Properties();
        filePaths.load(in);
        in.close();

        imagePaths = new HashMap();
        Enumeration e = filePaths.propertyNames();

        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            imagePaths.put(key, filePaths.getProperty(key));
        }
    }


    @Override
    public ImageIcon getImage(final String key) {
        String path = imagePaths.get(key);
        return new ImageIcon(getClass().getResource(path));

    }

    public void printAllImagePaths() {
        for (String key : imagePaths.keySet()) {
            System.out.println(key + " -- " + imagePaths.get(key));
        }
    }
}
