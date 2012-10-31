package superkidsapplication.providers;

import javax.swing.*;

public interface ImageProvider {

    public ImageIcon getImage(String key);

    public void refresh();
}
