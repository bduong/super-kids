package com.ece.superkids;

import java.io.File;

/**
 * The <code>FileManager</code> allows access to custom files stored on the local filesystem.
 * Removes the dependency on file paths.
 *
 * @author Ben Duong
 */
public interface FileManager {

    /**
     * Get the path to the file holding the custom questions.
     *
     * @return the path to the custom question file
     */
    public File getCustomQuestionsFile();

    public File getUserFile(String userFile);

    /**
     * Get the path to the file holding the custom image path key-value pairs.
     *
     * @return the path to the custom image path file
     */
    public File getImagePathsFile();

    /**
     * Get the root directory all of the custom data is stored in.
     *
     * @return the root directory.
     */
    public File getDirectory();

    /**
     * Get the directory where the custom images are stored.
     *
     * @return the image directory
     */
    public File getImagesDirectory();
}
