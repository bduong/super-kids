/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ece.superkids.ui.user.panels;

import com.ece.superkids.ui.controllers.MusicController;

/**
 * Creates new form <code>SoundPanel</code>
 * This panel controls the background music.
 * @author baris & DavidC
 */
public class SoundPanel extends javax.swing.JPanel {

    
    MusicController mController;
    /**
     * Creates new form SoundPanel
     * This panel controls the background music.
     */
    private SoundPanel() {
        mController = MusicController.getInstance();
        initComponents();
    }

    private static class OptionsPanelHolder {

        public static final SoundPanel INSTANCE = new SoundPanel();
    }

    public static SoundPanel getInstance() {
        return SoundPanel.OptionsPanelHolder.INSTANCE;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        onOffGroup = new javax.swing.ButtonGroup();
        volumeSlider = new javax.swing.JSlider();
        volumeLabel = new javax.swing.JLabel();
        musicOnButton = new javax.swing.JRadioButton();
        musicOffButton = new javax.swing.JRadioButton();
        musicLabel = new javax.swing.JLabel();
        changeMusicBox = new javax.swing.JComboBox();
        selectThemeLabel = new javax.swing.JLabel();

        setBounds(new java.awt.Rectangle(0, 0, 300, 400));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(300, 300));

        volumeSlider.setMaximum(200);
        volumeSlider.setValue(100);
        volumeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                volumeSliderStateChanged(evt);
            }
        });

        volumeLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        volumeLabel.setForeground(new java.awt.Color(255, 255, 255));
        volumeLabel.setText("Volume");

        onOffGroup.add(musicOnButton);
        musicOnButton.setSelected(true);
        musicOnButton.setText("ON");
        musicOnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musicOnButtonActionPerformed(evt);
            }
        });

        onOffGroup.add(musicOffButton);
        musicOffButton.setText("OFF");
        musicOffButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musicOffButtonActionPerformed(evt);
            }
        });

        musicLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        musicLabel.setForeground(new java.awt.Color(255, 255, 255));
        musicLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        musicLabel.setText("Music");

        changeMusicBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GameForest", "FlyingAces" }));
        changeMusicBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeMusicBoxActionPerformed(evt);
            }
        });

        selectThemeLabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        selectThemeLabel.setForeground(new java.awt.Color(255, 255, 255));
        selectThemeLabel.setText("Select Main Theme");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(61, 61, 61)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(selectThemeLabel)
                            .add(musicLabel)
                            .add(changeMusicBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 151, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(musicOnButton)
                                .add(35, 35, 35)
                                .add(musicOffButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(layout.createSequentialGroup()
                        .add(54, 54, 54)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(volumeSlider, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                            .add(volumeLabel))))
                .add(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(33, 33, 33)
                .add(volumeLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(volumeSlider, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 56, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(musicLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(musicOnButton)
                    .add(musicOffButton))
                .add(47, 47, 47)
                .add(selectThemeLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(changeMusicBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void changeMusicBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeMusicBoxActionPerformed
        // TODO add your handling code here:
        String theme = (String) changeMusicBox.getSelectedItem();
        System.out.println("Theme Selected: " + theme);
        mController.loadThemeMusic(theme);
    }//GEN-LAST:event_changeMusicBoxActionPerformed

    private void musicOffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musicOffButtonActionPerformed
        // TODO add your handling code here:
        mController.stopMusic();
    }//GEN-LAST:event_musicOffButtonActionPerformed

    private void musicOnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musicOnButtonActionPerformed
        // TODO add your handling code here:
        mController.playMusic();
    }//GEN-LAST:event_musicOnButtonActionPerformed

    private void volumeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_volumeSliderStateChanged
        // TODO add your handling code here:
        double vol = volumeSlider.getValue();
        vol = vol / 100; //convert to between 0.0 and 2.0 (gain)
        System.out.println("Volume: " + vol);
        mController.setVolume(vol);
    }//GEN-LAST:event_volumeSliderStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox changeMusicBox;
    private javax.swing.JLabel musicLabel;
    private javax.swing.JRadioButton musicOffButton;
    private javax.swing.JRadioButton musicOnButton;
    private javax.swing.ButtonGroup onOffGroup;
    private javax.swing.JLabel selectThemeLabel;
    private javax.swing.JLabel volumeLabel;
    private javax.swing.JSlider volumeSlider;
    // End of variables declaration//GEN-END:variables

    public boolean isMusicON() {
        return musicOnButton.isSelected();
    }
}
