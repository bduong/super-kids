package com.ece.superkids.testing;

import com.ece.superkids.FileManager;
import com.ece.superkids.FileManagerImpl;
import com.ece.superkids.images.ImageManager;
import com.ece.superkids.questions.QuestionDatabaseFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Properties;

import static org.junit.Assert.assertTrue;

public class ImageManagerTests {

    private static final String IMAGE_NAME = "testelephant";

    private File customImage;
    private ImageManager imageManager;
    private FileManager fileManager;

    @Before
    public void setup() throws IOException {
        customImage = new File(getClass().getResource("/elephant.png").getFile());
        imageManager = QuestionDatabaseFactory.anImageManager();
        fileManager = FileManagerImpl.getInstance();
    }

    @After
    public void clean() throws IOException {
        deleteImageFile();

//        File tempFile = File.createTempFile("imagepaths",".new");
//        File imagePathFile = fileManager.getImagePathsFile();
//        BufferedReader reader = new BufferedReader(new FileReader(imagePathFile));
//        FileWriter writer = new FileWriter(tempFile);
//
//        for (int ii = 0; ii < lineCount-1; ii++) {
//            writer.write(reader.readLine() + '\n');
//        }
//        reader.close();
//        writer.close();
//        imagePathFile.delete();
//        tempFile.renameTo(imagePathFile);

    }

    private void deleteImageFile() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream(fileManager.getImagePathsFile()));
        String imagePath = props.getProperty(IMAGE_NAME);
        File image = new File(imagePath);
        image.delete();

        props.remove(IMAGE_NAME);
        props.store(new FileWriter(fileManager.getImagePathsFile()), "Custom Images");
    }

    @Test
    public void canUploadCustomImage() throws IOException {
        imageManager.saveImage(customImage.getPath(), IMAGE_NAME);

        String lastLine = getLastLine(fileManager.getImagePathsFile());
        assertTrue(lastLine.contains(IMAGE_NAME));

        Properties props = new Properties();
        props.load(new FileInputStream(fileManager.getImagePathsFile()));
        String imagePath = props.getProperty(IMAGE_NAME);
        File image = new File(imagePath);
        assertTrue(image.exists());
    }

    private String getLastLine(File file) throws IOException {
        int lineCount = countLines(fileManager.getImagePathsFile());
        BufferedReader reader = new BufferedReader(new FileReader(file));
        for (int ii=0; ii < lineCount-1; ii ++) {
            reader.readLine();
        }
        return reader.readLine();
    }


    private int countLines(File file) throws IOException {
        int count = 0;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.readLine() != null) {
            count++;
        }
        reader.close();
        return count;
    }
}
