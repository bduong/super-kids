/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superkidsapplication.panels;

import java.util.ArrayList;
import java.util.Map;
import superkidsapplication.controllers.PanelController;
import superkidsapplication.controllers.TTSController;
import superkidsapplication.customui.ImageLabel;
import superkidsapplication.events.Session;

/**
 *
 * @author david Cheung
 */
public class ScoreScreenPanel extends javax.swing.JPanel {

    /**
     * Creates new form ScoreScreenPanel
     */
    private Session session = Session.aSession();
    private ArrayList<StarPanel> stars = new ArrayList(5);
    private PanelController controller = PanelController.getInstance();

    public ScoreScreenPanel() {
        this.setName("ScoreScreen");
        initComponents();
        avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource(session.getLoggedInUser().getImage())));
        displayStars();
        //end the state for user
        session.getLoggedInUser().endState();
    }

    private void displayStars() {
        //get total score for this level
        int totalscore = session.getLoggedInUser().getState().getTotalScore();
        //get the scores size
        Map scores = session.getLoggedInUser().getState().getAllScores();
        //find average score
        int score = totalscore / scores.size(); //scoring for the category
        int num_stars = score / 2; //One star per 2points
        System.out.println(totalscore + " " + scores.size() + " " + score);
        System.out.println(num_stars);
        for (int i = 0; i < num_stars; i++) {
            stars.add(i, new StarPanel());
            this.starPanel.add(stars.get(i));
        }

        if(num_stars == 1){
             TTSController.TTS("Good Job! You should try this level again.");
        }
        if (num_stars < 4) {
            TTSController.TTS("Good Job!");
        } else {
            TTSController.TTS("Excellent Job!");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        textLabel = new javax.swing.JLabel();
        avatar = new ImageLabel();
        starPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        jLayeredPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLayeredPane1MouseClicked(evt);
            }
        });

        textLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        textLabel.setForeground(new java.awt.Color(255, 255, 255));
        textLabel.setText("Congratulations");
        textLabel.setBounds(260, 370, 290, 80);
        jLayeredPane1.add(textLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/characters/Boy.png"))); // NOI18N
        avatar.setIconTextGap(0);
        avatar.setBounds(250, 120, 270, 240);
        jLayeredPane1.add(avatar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        starPanel.setOpaque(false);
        starPanel.setBounds(0, 430, 800, 150);
        jLayeredPane1.add(starPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Click to continue");
        jLabel1.setBounds(690, 580, 110, 16);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/ScoreScreen.png"))); // NOI18N
        background.setBounds(0, 0, 800, 600);
        jLayeredPane1.add(background, javax.swing.JLayeredPane.DEFAULT_LAYER);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLayeredPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLayeredPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLayeredPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLayeredPane1MouseClicked
        // TODO add your handling code here:
        if(session.getLoggedInUser().isCurrentLevelFinished()){
            controller.addPanel(new NewGamePanel("Continue"));
            TTSController.TTS("You have finished this level.");
        }
        else{
            controller.goToSubjectMenu();
            TTSController.TTS("You have finished this category.");
        }
    }//GEN-LAST:event_jLayeredPane1MouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avatar;
    private javax.swing.JLabel background;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel starPanel;
    private javax.swing.JLabel textLabel;
    // End of variables declaration//GEN-END:variables
}
