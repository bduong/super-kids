/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superkidsapplication;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class StartScreen extends javax.swing.JPanel {
    
    private Main mainFrame;
    

    /**
     * Creates new form StartScreen
     */
    public StartScreen(Main mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScreenComponents = new javax.swing.JLayeredPane();
        ContinueGame = new javax.swing.JButton();
        NewGame = new javax.swing.JButton();
        Options = new javax.swing.JButton();
        BackGround = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new java.awt.BorderLayout());

        ScreenComponents.setAlignmentX(0.0F);
        ScreenComponents.setAlignmentY(0.0F);
        ScreenComponents.setMinimumSize(new java.awt.Dimension(800, 600));
        ScreenComponents.setSize(new java.awt.Dimension(800, 600));

        ContinueGame.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ContinueGame.setForeground(new java.awt.Color(255, 255, 255));
        ContinueGame.setText("Continue Game");
        ContinueGame.setAlignmentY(0.0F);
        ContinueGame.setBorderPainted(false);
        ContinueGame.setContentAreaFilled(false);
        ContinueGame.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ContinueGame.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ContinueGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinueGameActionPerformed(evt);
            }
        });
        ContinueGame.setBounds(487, 190, 190, 50);
        ScreenComponents.add(ContinueGame, javax.swing.JLayeredPane.DEFAULT_LAYER);

        NewGame.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        NewGame.setForeground(new java.awt.Color(255, 255, 255));
        NewGame.setText("New Game");
        NewGame.setBorderPainted(false);
        NewGame.setContentAreaFilled(false);
        NewGame.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NewGame.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        NewGame.setMaximumSize(new java.awt.Dimension(180, 29));
        NewGame.setMinimumSize(new java.awt.Dimension(180, 29));
        NewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGameActionPerformed(evt);
            }
        });
        NewGame.setBounds(520, 240, 150, 50);
        ScreenComponents.add(NewGame, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Options.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        Options.setForeground(new java.awt.Color(255, 255, 255));
        Options.setText("Options");
        Options.setBorderPainted(false);
        Options.setContentAreaFilled(false);
        Options.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Options.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Options.setMaximumSize(new java.awt.Dimension(180, 29));
        Options.setMinimumSize(new java.awt.Dimension(180, 29));
        Options.setSize(new java.awt.Dimension(140, 50));
        Options.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionsActionPerformed(evt);
            }
        });
        Options.setBounds(530, 290, 140, 50);
        ScreenComponents.add(Options, javax.swing.JLayeredPane.DEFAULT_LAYER);

        BackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/startscreen/startscreen_background/Slide1.jpg"))); // NOI18N
        BackGround.setAlignmentY(0.0F);
        BackGround.setBounds(0, 0, 760, 560);
        ScreenComponents.add(BackGround, javax.swing.JLayeredPane.DEFAULT_LAYER);

        add(ScreenComponents, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void ContinueGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinueGameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContinueGameActionPerformed

    //if new game is clicked
    private void NewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewGameActionPerformed
        // TODO add your handling code here:
        
        //create a newgame panel
        NewGamePanel gamePanel = new NewGamePanel();
        //set the visibility of the current panel (Startscreen) to false
        this.setVisible(false);
        //add the panel (gameframe) to the main frame
        mainFrame.add(gamePanel, java.awt.FlowLayout.LEFT);
        //add this panel to the panels list stored in mainFrame class
        mainFrame.addToPanelList(gamePanel);
        
    }//GEN-LAST:event_NewGameActionPerformed

    private void OptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OptionsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackGround;
    private javax.swing.JButton ContinueGame;
    private javax.swing.JButton NewGame;
    private javax.swing.JButton Options;
    private javax.swing.JLayeredPane ScreenComponents;
    // End of variables declaration//GEN-END:variables
}
