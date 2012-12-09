package com.ece.superkids.images;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The <code>ImageManager</code> allows users to store their custom images to be used by the game.
 *
 * @author Ben Duong
 */
public interface ImageManager {

    /**
     * Save an image so it can be used.
     *
     * @param filePath the file path to the original image
     * @param fileName the name to save a copy of the image as
     * @return The key the image is saved under.
     */
    public String saveImage(String filePath, String fileName);

    /**
     * Delete a custom image.
     *
     * @param key the key for the image
     * @return true if delete successful, false otherwise
     */
    public boolean deleteImage(String key);
}
