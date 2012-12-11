/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ece.superkids.ui.events;

import com.ece.superkids.ui.frames.MainFrame;
import com.ece.superkids.ui.user.panels.StartScreenPanel;
import com.ece.superkids.ui.user.panels.UserSelectionPanel;
import java.awt.Component;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JPanel;

/**
 * This listener class <code>PanelListerner</code> listens to changes made
 * to the panels in the MainFrame
 * 
 * @author baris
 */
public class PanelListener implements ComponentListener,
        ItemListener {

    private MainFrame frame;

    /**
     * Creates a new PanelListener listens to changes made
     * to the panels in the MainFrame
     * 
     * @param frame , The main frame of the game
     */
    public PanelListener(MainFrame frame) {
        this.frame = frame;
    }

    public void addPanel(JPanel panel) {
        panel.addComponentListener(this);
    }

    /**
     * Does nothing right now
     * @param e
     */
    public void componentResized(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Does nothing right now
     * @param e
     */
    public void componentMoved(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Does nothing right now
     * @param e
     */
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

    /**
     * Does nothing right now
     * @param e
     */
    public void componentHidden(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Does nothing right now
     * @param e
     */
    public void itemStateChanged(ItemEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
