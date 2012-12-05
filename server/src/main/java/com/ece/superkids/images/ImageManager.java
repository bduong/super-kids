package com.ece.superkids.images;

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
     */
    public void saveImage(String filePath, String fileName);
}
