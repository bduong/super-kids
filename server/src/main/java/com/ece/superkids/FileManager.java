package com.ece.superkids;

import java.io.File;

public interface FileManager {

    File getCustomQuestionsFile();

    File getUserFile(String userName);

    File getImagePathsFile();

    File getDirectory();
}
