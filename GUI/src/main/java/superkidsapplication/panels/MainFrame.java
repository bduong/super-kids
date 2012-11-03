/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superkidsapplication.panels;

import javax.swing.JPanel;
import superkidsapplication.controllers.PanelController;

/**
 *
 * @author david
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    private JPanel startscreen;
    //get the panel controller to manage panels
    private PanelController controller;

    public MainFrame() {
        initComponents();
        //center frame relative to screen
        setLocationRelativeTo(null);
        //get the startscreen
        startscreen = StartScreenPanel.getInstance();
        //get panelcontroller
        controller = PanelController.getInstance();
        //set the mainFrame in PanelController (THIS IS DONE ONLY ONCE/ DO NOT DO IT AGAIN SOMEWHERE ELSE)
        controller.setMainFrame(this);
        //add the startscreen
        controller.addPanel(startscreen);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentArea = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        BackItem = new javax.swing.JMenuItem();
        ExitItem = new javax.swing.JMenuItem();
        ExitAppItem = new javax.swing.JMenuItem();
        ModeMenu = new javax.swing.JMenu();
        ParentItem = new javax.swing.JMenuItem();
        ChildMenu = new javax.swing.JMenu();
        LearnMode = new javax.swing.JMenuItem();
        QMode = new javax.swing.JMenuItem();
        HelpMenu = new javax.swing.JMenu();
        AboutItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Super Kids: The Ultimate Adventure");
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(800, 640));
        setName("mainframe"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(800, 640));

        contentArea.setBounds(new java.awt.Rectangle(0, 0, 800, 600));
        contentArea.setLayout(new java.awt.BorderLayout());
        getContentPane().add(contentArea, java.awt.BorderLayout.CENTER);

        jMenuBar1.setMaximumSize(new java.awt.Dimension(800, 22));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(800, 22));

        FileMenu.setText("File");

        BackItem.setText("Go Back");
        BackItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackItemActionPerformed(evt);
            }
        });
        FileMenu.add(BackItem);

        ExitItem.setText("Exit to Main");
        ExitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitItemActionPerformed(evt);
            }
        });
        FileMenu.add(ExitItem);

        ExitAppItem.setText("Exit Application");
        ExitAppItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitAppItemActionPerformed(evt);
            }
        });
        FileMenu.add(ExitAppItem);

        jMenuBar1.add(FileMenu);

        ModeMenu.setText("Mode");

        ParentItem.setText("Parent Mode");
        ParentItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParentItemActionPerformed(evt);
            }
        });
        ModeMenu.add(ParentItem);

        ChildMenu.setText("Child Mode");

        LearnMode.setText("Learning Mode");
        LearnMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LearnModeActionPerformed(evt);
            }
        });
        ChildMenu.add(LearnMode);

        QMode.setText("Question Mode");
        QMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QModeActionPerformed(evt);
            }
        });
        ChildMenu.add(QMode);

        ModeMenu.add(ChildMenu);

        jMenuBar1.add(ModeMenu);

        HelpMenu.setText("Help");

        AboutItem.setText("About");
        AboutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutItemActionPerformed(evt);
            }
        });
        HelpMenu.add(AboutItem);

        jMenuBar1.add(HelpMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //go back function
    private void BackItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackItemActionPerformed
        // TODO add your handling code here:     
        //go back one panel
        controller.goBackOnePanel();
    }//GEN-LAST:event_BackItemActionPerformed

    //exit to main menu
    private void ExitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitItemActionPerformed
        // TODO add your handling code here:
        controller.goToMainMenu();
    }//GEN-LAST:event_ExitItemActionPerformed

    private void AboutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutItemActionPerformed
        // TODO add your handling code here:
        AboutFrame about = new AboutFrame();
        about.setVisible(true);
    }//GEN-LAST:event_AboutItemActionPerformed

    private void ParentItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParentItemActionPerformed
        // TODO add your handling code here:
        ParentalControlPanel parentPanel = new ParentalControlPanel();
        controller.addPanel(parentPanel);
    }//GEN-LAST:event_ParentItemActionPerformed

    private void QModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QModeActionPerformed
        // TODO add your handling code here:
        controller.goToMainMenu();
    }//GEN-LAST:event_QModeActionPerformed

    private void LearnModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LearnModeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LearnModeActionPerformed

    private void ExitAppItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitAppItemActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitAppItemActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutItem;
    private javax.swing.JMenuItem BackItem;
    private javax.swing.JMenu ChildMenu;
    private javax.swing.JMenuItem ExitAppItem;
    private javax.swing.JMenuItem ExitItem;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JMenuItem LearnMode;
    private javax.swing.JMenu ModeMenu;
    private javax.swing.JMenuItem ParentItem;
    private javax.swing.JMenuItem QMode;
    public javax.swing.JPanel contentArea;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
