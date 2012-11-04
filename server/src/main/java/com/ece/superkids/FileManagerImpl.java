package com.ece.superkids;

import java.io.File;
import java.io.IOException;

public class FileManagerImpl implements FileManager {

    private static String fileDirectory;
    private static final String customQuestionsFile = "customQuestions.txt";
    private static final String customImagePathFile = "custom_image_paths.properties";

    private FileManagerImpl() {
        String userHome = System.getProperty("user.home");
        fileDirectory = userHome + File.separator + ".superkidsdata";
    }

    private static class FileManagerFactory {
        private static final FileManagerImpl INSTANCE = new FileManagerImpl();
    }

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
}
