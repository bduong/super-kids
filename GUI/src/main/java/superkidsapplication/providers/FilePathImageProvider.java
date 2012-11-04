package superkidsapplication.providers;

import com.ece.superkids.FileManagerImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.swing.*;

public class FilePathImageProvider implements ImageProvider{

    private static final String PROPERTY_FILE = "/providers/image_paths.properties";
    private static File CUSTOM_PROPERTY_FILE = FileManagerImpl.getInstance().getImagePathsFile();
    Map<String, Path> imagePaths = new HashMap<String, Path>();

    public FilePathImageProvider() throws IOException {
        loadAllImagePaths();
    }

    private void loadAllImagePaths() throws IOException {
        loadImagePaths(getClass().getResourceAsStream(PROPERTY_FILE), Mode.DEFAULT);
        loadImagePaths(new FileInputStream(CUSTOM_PROPERTY_FILE), Mode.CUSTOM);
    }

    private void loadImagePaths(InputStream in, Mode mode) throws IOException {
        Properties filePaths = new Properties();
        filePaths.load(in);
        in.close();

        Enumeration e = filePaths.propertyNames();

        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            imagePaths.put(key, new Path(filePaths.getProperty(key), mode));
        }
    }

    @Override
    public ImageIcon getImage(final String key) {
        String path = imagePaths.get(key.toLowerCase()).getPath();
        Mode mode = imagePaths.get(key.toLowerCase()).getMode();
        if (mode == Mode.DEFAULT) {
            return new ImageIcon(getClass().getResource(path));
        } else {
            return new ImageIcon(path);
        }

    }

    @Override
    public void refresh() {
        imagePaths.clear();
        try {
            loadAllImagePaths();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printAllImagePaths() {
        for (String key : imagePaths.keySet()) {
            System.out.println(key + " -- " + imagePaths.get(key));
        }
    }

    private enum Mode{
        CUSTOM, DEFAULT
    }

    private class Path{
        private String path;
        private Mode mode;

        private Path(final String path, final Mode mode) {
            this.path = path;
            this.mode = mode;
        }

        public String getPath() {
            return path;
        }

        public Mode getMode() {
            return mode;
        }
    }
}
