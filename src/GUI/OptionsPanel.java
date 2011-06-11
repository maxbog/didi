/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJPanel.java
 *
 * Created on 2011-05-28, 14:22:05
 */
package GUI;

import Basic.Simulation;
import java.awt.Color;

/**
 *
 * @author DSidor
 */
public class OptionsPanel extends javax.swing.JPanel {

    /** Creates new form NewJPanel */
    public OptionsPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        radiusLabel = new javax.swing.JLabel();
        pLabel = new javax.swing.JLabel();
        wLabel = new javax.swing.JLabel();
        radiusField = new javax.swing.JTextField();
        pField = new javax.swing.JTextField();
        wField = new javax.swing.JTextField();
        stepButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        pauseButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        restartButton = new javax.swing.JButton();
        delayTimerSpinner = new javax.swing.JSpinner();
        delayTimerLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        stepsLabel = new javax.swing.JLabel();
        zeroStepsButton = new javax.swing.JButton();
        peopleNumberLabel = new javax.swing.JLabel();

        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(250, 300));

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(ewakuacja.EwakuacjaApp.class).getContext().getResourceMap(OptionsPanel.class);
        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jSeparator1.setName("jSeparator1"); // NOI18N

        radiusLabel.setText(resourceMap.getString("radiusLabel.text")); // NOI18N
        radiusLabel.setName("radiusLabel"); // NOI18N

        pLabel.setText(resourceMap.getString("pLabel.text")); // NOI18N
        pLabel.setName("pLabel"); // NOI18N

        wLabel.setText(resourceMap.getString("wLabel.text")); // NOI18N
        wLabel.setName("wLabel"); // NOI18N

        radiusField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        radiusField.setText(resourceMap.getString("radiusField.text")); // NOI18N
        radiusField.setName("radiusField"); // NOI18N
        radiusField.setPreferredSize(new java.awt.Dimension(60, 20));
        radiusField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiusFieldActionPerformed(evt);
            }
        });

        pField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        pField.setText(resourceMap.getString("pField.text")); // NOI18N
        pField.setName("pField"); // NOI18N
        pField.setPreferredSize(new java.awt.Dimension(60, 20));
        pField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pFieldActionPerformed(evt);
            }
        });

        wField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        wField.setText(resourceMap.getString("wField.text")); // NOI18N
        wField.setName("wField"); // NOI18N
        wField.setPreferredSize(new java.awt.Dimension(60, 20));
        wField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wFieldActionPerformed(evt);
            }
        });

        stepButton.setText(resourceMap.getString("stepButton.text")); // NOI18N
        stepButton.setName("stepButton"); // NOI18N
        stepButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stepButtonActionPerformed(evt);
            }
        });

        startButton.setText(resourceMap.getString("startButton.text")); // NOI18N
        startButton.setName("startButton"); // NOI18N
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        pauseButton.setText(resourceMap.getString("pauseButton.text")); // NOI18N
        pauseButton.setName("pauseButton"); // NOI18N
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });

        jSeparator2.setName("jSeparator2"); // NOI18N

        restartButton.setText(resourceMap.getString("restartButton.text")); // NOI18N
        restartButton.setName("restartButton"); // NOI18N
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });

        delayTimerSpinner.setModel(new javax.swing.SpinnerListModel(new String[] {"0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1.0"}));
        delayTimerSpinner.setName("delayTimerSpinner"); // NOI18N
        delayTimerSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                delayTimerSpinnerStateChanged(evt);
            }
        });

        delayTimerLabel.setText(resourceMap.getString("delayTimerLabel.text")); // NOI18N
        delayTimerLabel.setName("delayTimerLabel"); // NOI18N

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSeparator3.setName("jSeparator3"); // NOI18N

        jSeparator4.setName("jSeparator4"); // NOI18N

        jSeparator5.setName("jSeparator5"); // NOI18N

        stepsLabel.setFont(resourceMap.getFont("stepsLabel.font")); // NOI18N
        stepsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stepsLabel.setText(resourceMap.getString("stepsLabel.text")); // NOI18N
        stepsLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("stepsLabel.border.title"))); // NOI18N
        stepsLabel.setName("stepsLabel"); // NOI18N

        zeroStepsButton.setText(resourceMap.getString("zeroStepsButton.text")); // NOI18N
        zeroStepsButton.setName("zeroStepsButton"); // NOI18N
        zeroStepsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zeroStepsButtonActionPerformed(evt);
            }
        });

        peopleNumberLabel.setFont(resourceMap.getFont("peopleNumberLabel.font")); // NOI18N
        peopleNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        peopleNumberLabel.setText(resourceMap.getString("peopleNumberLabel.text")); // NOI18N
        peopleNumberLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("peopleNumberLabel.border.title"))); // NOI18N
        peopleNumberLabel.setName("peopleNumberLabel"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator5, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(restartButton)
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(radiusLabel)
                .addGap(31, 31, 31)
                .addComponent(radiusField, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stepButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pauseButton)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pLabel)
                    .addComponent(wLabel)
                    .addComponent(delayTimerLabel))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(delayTimerSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(pField, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(wField, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(zeroStepsButton, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(stepsLabel, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(peopleNumberLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radiusLabel)
                    .addComponent(radiusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delayTimerSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delayTimerLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton)
                    .addComponent(stepButton)
                    .addComponent(pauseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(restartButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(peopleNumberLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stepsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(zeroStepsButton)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        stepButton.getAccessibleContext().setAccessibleName(resourceMap.getString("stepButton.AccessibleContext.accessibleName")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    private void stepButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stepButtonActionPerformed
        simulation.step();
    }//GEN-LAST:event_stepButtonActionPerformed

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartButtonActionPerformed
        simulation.pauseSimulation();
        simulation.resetMap();
        gridPanel.repaintGrid();
        simulation.setZeroSteps();
        peopleNumberLabel.setText(Integer.toString(simulation.getSimGrid().getPeopleCount()));
    }//GEN-LAST:event_restartButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        simulation.startSimulation();
    }//GEN-LAST:event_startButtonActionPerformed

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed
        simulation.pauseSimulation();
    }//GEN-LAST:event_pauseButtonActionPerformed

    private void delayTimerSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_delayTimerSpinnerStateChanged
        simulation.setDelayTime(Float.parseFloat(delayTimerSpinner.getValue().toString()));
    }//GEN-LAST:event_delayTimerSpinnerStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        simulation.setGrid(simulation.getSimGrid());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void radiusFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiusFieldActionPerformed
        int rad = 0;
        try {
            rad = Integer.parseInt(radiusField.getText());
        } catch (Exception exception) {
            rad = 0;
        }
        if (rad <= 0) {
            radiusField.setForeground(Color.red);
            return;
        }
        radiusField.setForeground(Color.black);
        simulation.setFloodRadius(rad);
    }//GEN-LAST:event_radiusFieldActionPerformed

    private void pFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pFieldActionPerformed
        double p = -1;
        try {
            p = Double.parseDouble(pField.getText());
        } catch (Exception exception) {
            p = -1;
        }
        if (p < 0 || p > 1) {
            pField.setForeground(Color.red);
            return;
        }
        pField.setForeground(Color.black);
        simulation.setGlobalBlockProbability(p);
    }//GEN-LAST:event_pFieldActionPerformed

    private void wFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wFieldActionPerformed
        double w = -1;
        try {
            w = Double.parseDouble(wField.getText());
        } catch (Exception exception) {
            w = -1;
        }
        if (w < 0 || w > 1) {
            wField.setForeground(Color.red);
            return;
        }
        wField.setForeground(Color.black);
        simulation.setTransitionCoef(w);
    }//GEN-LAST:event_wFieldActionPerformed

    private void zeroStepsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zeroStepsButtonActionPerformed
        simulation.setZeroSteps();
    }//GEN-LAST:event_zeroStepsButtonActionPerformed

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }

    public void setGridPanel(GridPanel panel) {
        gridPanel = panel;
    }

    public void setStepsNumber(int number) {
        stepsLabel.setText(Integer.toString(number));
    }

    public void setPeolpeNumber(int number) {
        peopleNumberLabel.setText(Integer.toString(number));
    }

    public void setPeolpeNumber() {
        if (simulation == null) {
            return;
        }
        int number = simulation.getSimGrid().getPeopleCount();
        peopleNumberLabel.setText(Integer.toString(number));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel delayTimerLabel;
    private javax.swing.JSpinner delayTimerSpinner;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField pField;
    private javax.swing.JLabel pLabel;
    private javax.swing.JButton pauseButton;
    private javax.swing.JLabel peopleNumberLabel;
    private javax.swing.JTextField radiusField;
    private javax.swing.JLabel radiusLabel;
    private javax.swing.JButton restartButton;
    private javax.swing.JButton startButton;
    private javax.swing.JButton stepButton;
    private javax.swing.JLabel stepsLabel;
    private javax.swing.JTextField wField;
    private javax.swing.JLabel wLabel;
    private javax.swing.JButton zeroStepsButton;
    // End of variables declaration//GEN-END:variables
    private Simulation simulation;
    private GridPanel gridPanel;
}
