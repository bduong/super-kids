package superkidsapplication.video;

import com.xuggle.mediatool.IMediaReader;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.xuggler.ICodec;
import com.xuggle.xuggler.IContainer;
import com.xuggle.xuggler.IStream;
import com.xuggle.xuggler.IStreamCoder;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class VideoPlayer {
    IMediaReader reader;
    public VideoViewer viewer;

    public VideoPlayer() {
        viewer = new VideoViewer();
    }

    public void play(String fileName) {
        reader = ToolFactory.makeReader(getClass().getResource(fileName).toString());
//        IContainer container = reader.getContainer();
//        for (int num = 0; num < container.getNumStreams(); num++) {
//            IStream stream = container.getStream(num);
//            IStreamCoder codec = stream.getStreamCoder();
//            if (codec.getCodecType()== ICodec.Type.CODEC_TYPE_VIDEO) {
//              JPanel panel = viewer.getPanel();
//                panel.setPreferredSize(new Dimension(codec.getWidth(), codec.getHeight()));
//                panel.setBounds(80, 180, codec.getWidth(), codec.getHeight());
//            }
//        }
        reader.setBufferedImageTypeToGenerate(BufferedImage.TYPE_3BYTE_BGR);
        reader.addListener(viewer);


    }

    public void run() {
        while (reader.readPacket() == null)
            ;
    }

    public JPanel getViewingPanel() {
        return (viewer == null) ? null : viewer.getPanel();
    }

    public static void main(String [] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        VideoPlayer vp = new VideoPlayer();
        frame.add(vp.viewer.getPanel());
        frame.pack();
        frame.setVisible(true);

        vp.play("/videos/shapes.mp4");


    }
}
