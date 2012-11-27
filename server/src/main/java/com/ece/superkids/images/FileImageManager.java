package com.ece.superkids.images;

import com.ece.superkids.FileManager;
import com.ece.superkids.FileManagerImpl;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class FileImageManager implements ImageManager {

    FileManager fileManager = FileManagerImpl.getInstance();

    @Override
    public void saveImage(final String filePath, final String fileName) {
        File imageDirectory = fileManager.getImagesDirectory();
        String ext = filePath.substring(filePath.lastIndexOf("."));

        File newImage = new File(imageDirectory.getPath() + File.separator + fileName + ext);
        int counter = 0;
        while (newImage.exists()) {
            newImage = new File(imageDirectory.getPath() + File.separator + fileName + "-" + ++counter + ext);
        }
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(fileManager.getImagePathsFile()));
            if (counter > 0) {
                props.put(fileName + counter, newImage.getPath());
            } else {
                props.put(fileName, newImage.getPath());
            }

            FileWriter writer = new FileWriter(fileManager.getImagePathsFile());
            props.store(writer, "Custom Images");
            writer.close();

            FileUtils.copyFile(new File(filePath), newImage);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
