/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superkidsapplication.events;

import java.awt.Component;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JPanel;
import superkidsapplication.panels.MainFrame;
import superkidsapplication.panels.StartScreenPanel;
import superkidsapplication.panels.UserSelectionPanel;

/**
 *
 * @author baris
 */
public class PanelListener implements ComponentListener,
        ItemListener {

    private MainFrame frame;

    public PanelListener(MainFrame frame) {
        this.frame = frame;
    }

    public void addPanel(JPanel panel) {
        panel.addComponentListener(this);
    }

    public void componentResized(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void componentMoved(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void componentShown(ComponentEvent e) {
        Component component = e.getComponent();
        if (component.getName() != null && component.getName().equals("InitialSetup")) {
            frame.ExitItem.setEnabled(false);
            frame.BackItem.setEnabled(false);
            frame.ChildMenu.setEnabled(false);
            frame.ParentItem.setEnabled(false);
        } else if (component.getName() != null && component.getName().equals("StartScreen")) {
            frame.BackItem.setEnabled(false);
            frame.ExitItem.setEnabled(false);
            frame.ChildMenu.setEnabled(true);
            frame.ParentItem.setEnabled(true);
            StartScreenPanel start = (StartScreenPanel) component;
            start.isContinueNewGameEnabled();
        } else if (component.getName() != null && component.getName().equals("UserSelection")) {
            frame.BackItem.setEnabled(false);
            frame.ExitItem.setEnabled(false);
            frame.ChildMenu.setEnabled(false);
            frame.ParentItem.setEnabled(true);
            //refill the box
            UserSelectionPanel panel = (UserSelectionPanel)component;
            panel.fillBox();
        } else if (component.getName() != null && component.getName().equals("ParentalControl")) {
            frame.BackItem.setEnabled(true);
            frame.ExitItem.setEnabled(false);
            frame.ChildMenu.setEnabled(true);
            frame.ParentItem.setEnabled(false);
        }else if (component.getName() != null && component.getName().equals("Question")) {
            frame.BackItem.setEnabled(false);
            frame.ExitItem.setEnabled(true);
            frame.ChildMenu.setEnabled(true);
            frame.ParentItem.setEnabled(true);
        }
        else if (component.getName() != null && component.getName().equals("ScoreScreen")) {
            frame.BackItem.setEnabled(false);
            frame.ExitItem.setEnabled(false);
            frame.ChildMenu.setEnabled(true);
            frame.ParentItem.setEnabled(true);
        } 
         else if (component.getName() != null && component.getName().equals("Learning")) {
            frame.BackItem.setEnabled(false);
            frame.ExitItem.setEnabled(false);
            frame.ChildMenu.setEnabled(true);
            frame.ParentItem.setEnabled(true);
         }
        else {
            frame.ExitItem.setEnabled(true);
            frame.BackItem.setEnabled(true);
            frame.ChildMenu.setEnabled(true);
            frame.ParentItem.setEnabled(true);
        }
    }

    public void componentHidden(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void itemStateChanged(ItemEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
