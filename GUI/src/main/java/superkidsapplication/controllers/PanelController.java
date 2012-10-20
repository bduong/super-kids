package superkidsapplication.controllers;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import superkidsapplication.panels.MainFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * THIS CLASS CONTROLS PANELS THAT ARE ADDED TO THE MAIN FRAME
 * BASICALLY ALLOWS THE USAGE OF GO BACK FUNCTION
 * SINGLETON PATTERN IS USED FOR ACCESS GLOBALLY
 * THIS CONTROLLER ALLOWS YOU TO ADD AND REMOVE FRAMES EASILY BY JUST CALLING THE
 * APPROPRIATE FUNCTION WHEN A BUTTON IS CLICKED
 */
/**
 *
 * @author baris
 */
public class PanelController {

    private ArrayList<JPanel> panels;
    private MainFrame mainFrame;
    
    private PanelController(){
        panels=new ArrayList<JPanel>();
    }

    private static class PanelControllerHolder {
        public static final PanelController INSTANCE = new PanelController();
    }

    public static PanelController getInstance() {
        return PanelControllerHolder.INSTANCE;
    }
    
    public void setMainFrame(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    //add to panels list.
    //add to mainFrame.
    public void addPanel(JPanel panel) {
        //first add to list
        panels.add(panel);
        //if we are not on start panel
        //set the panel before invisible
        if(onStartPanel()==false){
        panels.get(panels.size()-2).setVisible(false);
        }
        //now add this new panel to the frame itself
        mainFrame.add(panel, java.awt.FlowLayout.LEFT);
        //and change the visiblity to true
        panel.setVisible(true);
    }

    //removes the last panel from the list by setting it invisible and removing it from the list
    //shouldnt call this directly
    //call goBackOnePanel instead
    public void removePanel() {
        //set last panel invisible
        panels.get(panels.size()-1).setVisible(false);
        //then remove from list
        panels.remove(panels.size()-1);
    }

    //are we on start panel?
    private boolean onStartPanel() {
        if (panels.size()==1) {
            return true;
        }
        return false;
    }
    
    //get the current panel in the list/visible on the main frame.
    public JPanel getCurrentPanel(){
        return panels.get(panels.size()-1);
    }
    
    //when going back only remove the last panel from the list and set the panel before that visible.
    public void goBackOnePanel(){
              
        //if there is only one panel in the list then you are in the main menu, so return this function
        if(this.onStartPanel()){
            return;
        }
        //remove last panel from list and set it invisible
        removePanel();
        //set the panel before the last panel visible
        panels.get(panels.size()-1).setVisible(true);
    }
    
    //go to main menu (startscree) directly
    //this removes all panels from the panels list
    //and sets the startscreen to visible
    public void goToMainMenu(){
        //remove all panels until the first panel
       while(panels.size()!=1){
           removePanel();
       } 
       //set the startscreen visible
       panels.get(panels.size()-1).setVisible(true);
    }
}
