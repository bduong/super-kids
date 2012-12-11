/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ece.superkids.ui.parent.panels;

import com.ece.superkids.questions.QuestionDatabaseFactory;
import com.ece.superkids.questions.QuestionManager;
import com.ece.superkids.questions.entities.Question;
import com.ece.superkids.questions.enums.QuestionCategory;
import com.ece.superkids.questions.enums.QuestionLevel;
import com.ece.superkids.questions.enums.QuestionType;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import com.ece.superkids.ui.controllers.PanelController;

/**
 * Creates new form <code>AddQuestionPanel</code>
 * This panel allows to add custom questions to the game.
 * 
 * @author baris & david c
 */
public class AddQuestionPanel extends javax.swing.JPanel {

    
    QuestionManager qm;
    int choiceSelected;
    String type="TEXT";
    private PanelController panelC = PanelController.getInstance();
    private int addstate;

    /**
     * Creates new form AddQuestionPanel
     * This panel allows to add custom questions to the game
     */
    public AddQuestionPanel() {
        initComponents();
        choiceSelected = 0;
        qm = QuestionDatabaseFactory.aQuestionManager();
        fillLevelBox();
        picButton1.setVisible(false);
        picButton2.setVisible(false);
        picButton3.setVisible(false);
        picButton4.setVisible(false);
        addstate = 0;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        questionField = new javax.swing.JTextField();
        choice2Field = new javax.swing.JTextField();
        choice3Field = new javax.swing.JTextField();
        choice4Field = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        choice1Field = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        levelBox = new javax.swing.JComboBox();
        catBox = new javax.swing.JComboBox();
        choice2Button = new javax.swing.JRadioButton();
        choice1Button = new javax.swing.JRadioButton();
        choice3Button = new javax.swing.JRadioButton();
        choice4Button = new javax.swing.JRadioButton();
        picButton1 = new javax.swing.JButton();
        picButton2 = new javax.swing.JButton();
        picButton3 = new javax.swing.JButton();
        picButton4 = new javax.swing.JButton();
        typeBox = new javax.swing.JComboBox();

        setOpaque(false);
        setSize(new java.awt.Dimension(520, 435));

        questionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionFieldActionPerformed(evt);
            }
        });

        choice2Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choice2FieldActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Question");

        choice1Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choice1FieldActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Choice 1");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Choice 4");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Choice 2");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Choice 3");

        levelBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelBoxActionPerformed(evt);
            }
        });

        buttonGroup1.add(choice2Button);
        choice2Button.setForeground(new java.awt.Color(255, 255, 255));
        choice2Button.setText("Set Answer");
        choice2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choice2ButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(choice1Button);
        choice1Button.setForeground(new java.awt.Color(255, 255, 255));
        choice1Button.setSelected(true);
        choice1Button.setText("Set Answer");
        choice1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choice1ButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(choice3Button);
        choice3Button.setForeground(new java.awt.Color(255, 255, 255));
        choice3Button.setText("Set Answer");
        choice3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choice3ButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(choice4Button);
        choice4Button.setForeground(new java.awt.Color(255, 255, 255));
        choice4Button.setText("Set Answer");
        choice4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choice4ButtonActionPerformed(evt);
            }
        });

        picButton1.setText("P");
        picButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                picButton1ActionPerformed(evt);
            }
        });

        picButton2.setText("P");
        picButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                picButton2ActionPerformed(evt);
            }
        });

        picButton3.setText("P");
        picButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                picButton3ActionPerformed(evt);
            }
        });

        picButton4.setText("P");
        picButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                picButton4ActionPerformed(evt);
            }
        });

        typeBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TEXT", "PICTURE" }));
        typeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeBoxActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(32, 32, 32)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, choice4Field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 152, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, choice3Field, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, choice2Field)
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, choice1Field)))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(picButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .add(picButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, picButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .add(picButton4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(choice3Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 146, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(choice4Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 146, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(choice2Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 146, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(choice1Button, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 146, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 57, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(typeBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(levelBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(questionField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 240, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(catBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(layout.createSequentialGroup()
                        .add(70, 70, 70)
                        .add(addButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 182, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(174, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(catBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(levelBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(typeBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(questionField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(choice1Field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(choice1Button)
                    .add(picButton1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(choice2Field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(choice2Button)
                    .add(picButton2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(choice3Field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(picButton3)
                    .add(choice3Button))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(choice4Field, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(choice4Button)
                            .add(picButton4))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(addButton))
                    .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void choice2FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choice2FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_choice2FieldActionPerformed

    private void choice1FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choice1FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_choice1FieldActionPerformed

    private void questionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_questionFieldActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        if (addstate == 0)
        {
            Question q = new Question();
            //set question
            q.setQuestion(questionField.getText());
            //set level
            q.setLevel((QuestionLevel) levelBox.getSelectedItem());
            //set category
            q.setCategory((QuestionCategory) catBox.getSelectedItem());
            //set choices
            List<String> choice = new ArrayList<String>();
            choice.add(choice1Field.getText());
            choice.add(choice2Field.getText());
            choice.add(choice3Field.getText());
            choice.add(choice4Field.getText());
            q.setChoices(choice);
            //set answer
            buttonGroup1.getSelection();
            //set answer
            q.setAnswer(choice.get(choiceSelected));
            //set type
            q.setType(QuestionType.valueOf(type));
            //set explanation
            q.setExplaination("");
            //add question
            qm.addQuestion(q);
            jLabel5.setText("Question Added");
            
            addstate++;
            choice1Field.setEnabled(false);
            choice1Field.setText("");
            choice2Field.setEnabled(false);
            choice2Field.setText("");
            choice3Field.setEnabled(false);
            choice3Field.setText("");
            choice4Field.setEnabled(false);
            choice4Field.setText("");
            questionField.setEnabled(false);
            questionField.setText("");
            picButton1.setEnabled(false);
            picButton2.setEnabled(false);
            picButton3.setEnabled(false);
            picButton4.setEnabled(false);
            choice1Button.setEnabled(false);
            choice2Button.setEnabled(false);
            choice3Button.setEnabled(false);
            choice4Button.setEnabled(false);
            typeBox.setEnabled(false);
            levelBox.setEnabled(false);
            catBox.setEnabled(false);
            addButton.setText("Add Another");
        }
        else
        {
            addstate = 0;
            choice1Field.setEnabled(true);
            choice2Field.setEnabled(true);
            choice3Field.setEnabled(true);
            choice4Field.setEnabled(true);
            questionField.setEnabled(true);
            picButton1.setEnabled(true);
            picButton2.setEnabled(true);
            picButton3.setEnabled(true);
            picButton4.setEnabled(true);
            choice1Button.setEnabled(true);
            choice2Button.setEnabled(true);
            choice3Button.setEnabled(true);
            choice4Button.setEnabled(true);
            typeBox.setEnabled(true);
            levelBox.setEnabled(true);
            catBox.setEnabled(true);
            addButton.setText("Add");
            jLabel5.setText("");
            
        }
        
    }//GEN-LAST:event_addButtonActionPerformed

    private void choice1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choice1ButtonActionPerformed
        // TODO add your handling code here:
        choiceSelected = 0;
    }//GEN-LAST:event_choice1ButtonActionPerformed

    private void choice2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choice2ButtonActionPerformed
        // TODO add your handling code here:
        choiceSelected = 1;
    }//GEN-LAST:event_choice2ButtonActionPerformed

    private void choice3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choice3ButtonActionPerformed
        // TODO add your handling code here:
        choiceSelected = 2;
    }//GEN-LAST:event_choice3ButtonActionPerformed

    private void choice4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choice4ButtonActionPerformed
        // TODO add your handling code here:
        choiceSelected = 3;
    }//GEN-LAST:event_choice4ButtonActionPerformed

    private void levelBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelBoxActionPerformed
        // TODO add your handling code here:
        QuestionLevel level = (QuestionLevel) levelBox.getSelectedItem();
        fillCatBox(level);
    }//GEN-LAST:event_levelBoxActionPerformed

    private void picButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_picButton1ActionPerformed
        // TODO add your handling code here:
        handleCustomPicture(choice1Field);
    }//GEN-LAST:event_picButton1ActionPerformed

    private void picButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_picButton2ActionPerformed
        // TODO add your handling code here:
        handleCustomPicture(choice2Field);
    }//GEN-LAST:event_picButton2ActionPerformed

    private void picButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_picButton3ActionPerformed
        // TODO add your handling code here:
        handleCustomPicture(choice3Field);
    }//GEN-LAST:event_picButton3ActionPerformed

    private void picButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_picButton4ActionPerformed
        // TODO add your handling code here:
        handleCustomPicture(choice4Field);
    }//GEN-LAST:event_picButton4ActionPerformed

    private void typeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeBoxActionPerformed
        // TODO add your handling code here:
        type = (String) typeBox.getSelectedItem();
        if (type.equals("PICTURE")) {
            picButton1.setVisible(true);
            picButton2.setVisible(true);
            picButton3.setVisible(true);
            picButton4.setVisible(true);
        }
        if (type.equals("TEXT")) {
            picButton1.setVisible(false);
            picButton2.setVisible(false);
            picButton3.setVisible(false);
            picButton4.setVisible(false);
        }
    }//GEN-LAST:event_typeBoxActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox catBox;
    private javax.swing.JRadioButton choice1Button;
    private javax.swing.JTextField choice1Field;
    private javax.swing.JRadioButton choice2Button;
    private javax.swing.JTextField choice2Field;
    private javax.swing.JRadioButton choice3Button;
    private javax.swing.JTextField choice3Field;
    private javax.swing.JRadioButton choice4Button;
    private javax.swing.JTextField choice4Field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox levelBox;
    private javax.swing.JButton picButton1;
    private javax.swing.JButton picButton2;
    private javax.swing.JButton picButton3;
    private javax.swing.JButton picButton4;
    private javax.swing.JTextField questionField;
    private javax.swing.JComboBox typeBox;
    // End of variables declaration//GEN-END:variables

    private void fillLevelBox() {
        for (QuestionLevel l : QuestionLevel.values()) {
            levelBox.addItem(l);
        }
    }

    private void fillCatBox(QuestionLevel l) {
        catBox.removeAllItems();
        for (QuestionCategory c : l.getCategories()) {
            catBox.addItem(c);
        }
    }

    private void handleCustomPicture(JTextField field) {
        panelC.addPanel(new QuestionPicturePanel(field));
    }
}
