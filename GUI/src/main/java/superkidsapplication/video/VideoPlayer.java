package superkidsapplication.video;

import com.xuggle.mediatool.IMediaReader;
import com.xuggle.mediatool.IMediaViewer;
import com.xuggle.mediatool.ToolFactory;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class VideoPlayer {
    IMediaReader reader;
    public VideoViewer viewer;

    public VideoPlayer() {
        viewer = new VideoViewer();
    }

    public void run() {
        reader = ToolFactory.makeReader(getClass().getResource("/videos/shapes.mp4").toString());
        reader.setBufferedImageTypeToGenerate(BufferedImage.TYPE_3BYTE_BGR);
        reader.addListener(viewer);
        while (reader.readPacket() == null)
            ;

    }

    public static void main(String [] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        VideoPlayer vp = new VideoPlayer();
        frame.add(vp.viewer.getPanel());
        frame.pack();
        frame.setVisible(true);

        vp.run();


    }
}
