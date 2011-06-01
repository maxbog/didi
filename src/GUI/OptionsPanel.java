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
        populationLabel = new javax.swing.JLabel();
        populationField = new javax.swing.JTextField();
        radiusLabel = new javax.swing.JLabel();
        pLabel = new javax.swing.JLabel();
        wLabel = new javax.swing.JLabel();
        radiusField = new javax.swing.JTextField();
        pField = new javax.swing.JTextField();
        wField = new javax.swing.JTextField();

        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(250, 300));

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(ewakuacja.EwakuacjaApp.class).getContext().getResourceMap(OptionsPanel.class);
        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jSeparator1.setName("jSeparator1"); // NOI18N

        populationLabel.setText(resourceMap.getString("populationLabel.text")); // NOI18N
        populationLabel.setName("populationLabel"); // NOI18N

        populationField.setText(resourceMap.getString("populationField.text")); // NOI18N
        populationField.setMinimumSize(new java.awt.Dimension(20, 20));
        populationField.setName("populationField"); // NOI18N
        populationField.setPreferredSize(new java.awt.Dimension(60, 20));
        populationField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                populationFieldActionPerformed(evt);
            }
        });

        radiusLabel.setText(resourceMap.getString("radiusLabel.text")); // NOI18N
        radiusLabel.setName("radiusLabel"); // NOI18N

        pLabel.setText(resourceMap.getString("pLabel.text")); // NOI18N
        pLabel.setName("pLabel"); // NOI18N

        wLabel.setText(resourceMap.getString("wLabel.text")); // NOI18N
        wLabel.setName("wLabel"); // NOI18N

        radiusField.setText(resourceMap.getString("radiusField.text")); // NOI18N
        radiusField.setName("radiusField"); // NOI18N
        radiusField.setPreferredSize(new java.awt.Dimension(60, 20));

        pField.setText(resourceMap.getString("pField.text")); // NOI18N
        pField.setName("pField"); // NOI18N
        pField.setPreferredSize(new java.awt.Dimension(60, 20));

        wField.setText(resourceMap.getString("wField.text")); // NOI18N
        wField.setName("wField"); // NOI18N
        wField.setPreferredSize(new java.awt.Dimension(60, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radiusLabel)
                            .addComponent(populationLabel))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(radiusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(populationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(11, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pLabel)
                            .addComponent(wLabel))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                    .addComponent(populationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(populationLabel))
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
                .addContainerGap(156, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void populationFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_populationFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_populationFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField pField;
    private javax.swing.JLabel pLabel;
    private javax.swing.JTextField populationField;
    private javax.swing.JLabel populationLabel;
    private javax.swing.JTextField radiusField;
    private javax.swing.JLabel radiusLabel;
    private javax.swing.JTextField wField;
    private javax.swing.JLabel wLabel;
    // End of variables declaration//GEN-END:variables

}
