/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package superkidsapplication;

/**
 *
 * @author baris
 */
public class NewGamePanel extends javax.swing.JPanel {

    /**
     * Creates new form NewGamePanel
     */
    public NewGamePanel() {
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 153, 255));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Level 1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 114, 150, 86));

        jLabel1.setText("Please pick a level");
        jLabel1.setFocusable(false);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 207, 44));

        jButton2.setText("Level 2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 114, 151, 86));

        jButton3.setText("Level 3");
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 114, 152, 86));

        jButton4.setText("Level 5");
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 249, 150, 86));

        jButton5.setText("Level 4");
        add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 249, 150, 86));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
