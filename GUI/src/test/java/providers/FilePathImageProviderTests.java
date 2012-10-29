package providers;

import org.junit.Before;
import org.junit.Test;
import superkidsapplication.providers.ImageProvider;
import superkidsapplication.providers.ResourceProviderFactory;

import javax.swing.*;

import java.awt.image.BufferedImage;

import static junit.framework.Assert.assertEquals;

public class FilePathImageProviderTests {

    private static final String KNOWN_KEY = "circle";
    private static final String KNOWN_PATH = "/question/pictures/circle.png";

    private ImageProvider imageProvider;

    @Before
    public void setup() {
        imageProvider = ResourceProviderFactory.anImageProvider();
    }

    @Test
    public void providerCanRetrieveCorrectImages() {
        ImageIcon icon =  imageProvider.getImage(KNOWN_KEY);
        ImageIcon expected = new ImageIcon(getClass().getResource(KNOWN_PATH));

        BufferedImage expectedImage = convertToBufferedImage(expected);
        BufferedImage actualImage = convertToBufferedImage(icon);

        assertImagesAreIdentical(expectedImage, actualImage);
    }

    private void assertImagesAreIdentical(final BufferedImage expectedImage, final BufferedImage actualImage) {
        assertEquals(expectedImage.getHeight(), actualImage.getHeight());
        assertEquals(expectedImage.getWidth(), actualImage.getWidth());
        for (int h = 0 ; h < expectedImage.getHeight(); h++) {
            for (int w = 0; w < expectedImage.getWidth(); w++) {
                assertEquals("Pixel w:" + w + " h:" + h + " do not match", expectedImage.getRGB(w, h),
                        actualImage.getRGB(w, h));
            }
        }
    }

    private BufferedImage convertToBufferedImage(final ImageIcon expected) {
        BufferedImage expectedImage = new BufferedImage(expected.getIconWidth(), expected.getIconHeight(),
                BufferedImage.TYPE_INT_RGB);
        expectedImage.getGraphics().drawImage(expected.getImage(), 0 ,0 , null);
        return expectedImage;
    }
}
