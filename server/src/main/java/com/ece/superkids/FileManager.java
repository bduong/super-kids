package com.ece.superkids;

import java.io.File;

public interface FileManager {

    public File getCustomQuestionsFile();

    public File getUserFile(String userFile);

    public File getImagePathsFile();

    public File getDirectory();

    public File getImagesDirectory();
}
