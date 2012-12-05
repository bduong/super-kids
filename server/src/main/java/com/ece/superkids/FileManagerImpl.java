package com.ece.superkids;

import java.io.File;
import java.io.IOException;

/**
 * The <code>FileManagerImpl</code> allows access to the custom files stored on the local file system
 * in the user's home directory.
 *
 * This class is created in a singleton pattern.
 *
 * @author Ben Duong
 */
public class FileManagerImpl implements FileManager {

    private static String fileDirectory;
    private static final String customQuestionsFile = "customQuestions.txt";
    private static final String customImagePathFile = "custom_image_paths.properties";
    private static final String customImageFolder = "images";

    private FileManagerImpl() {
        String userHome = System.getProperty("user.home");
        fileDirectory = userHome + File.separator + ".superkidsdata";
    }

    private static class FileManagerFactory {
        private static final FileManagerImpl INSTANCE = new FileManagerImpl();
    }

    /**
     * Get the singleton instance of the FileManager.
     *
     * @return the instance
     */
    public static FileManagerImpl getInstance() {
        return FileManagerFactory.INSTANCE;
    }

    @Override
    public File getCustomQuestionsFile() {
        File customFile = new File(fileDirectory + File.separator + customQuestionsFile);
        if (!customFile.exists())
            try {
                customFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return customFile;
    }

    @Override
    public File getUserFile(final String userFile) {
        File customFile = new File(fileDirectory + File.separator + userFile);
        if (customFile.exists()){
            return customFile;
        }
        return null;
    }

    @Override
    public File getImagePathsFile() {
        File customFile = new File(fileDirectory + File.separator + customImagePathFile);
        if (!customFile.exists())
            try {
                customFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return customFile;
    }

    @Override
    public File getDirectory() {
        File directory = new File(fileDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        return directory;
    }

    @Override
    public File getImagesDirectory() {
        File imageDirectory = new File(fileDirectory + File.separator + customImageFolder);
        if (!imageDirectory.exists()) {
            imageDirectory.mkdirs();
        }
        return imageDirectory;
    }
}
