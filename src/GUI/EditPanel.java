/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditPanel.java
 *
 * Created on 2011-05-28, 19:38:45
 */
package GUI;

import Basic.Grid;
import ewakuacja.EwakuacjaView;

/**
 *
 * @author DSidor
 */
public class EditPanel extends javax.swing.JPanel {

    /** Creates new form EditPanel */
    public EditPanel() {
        initComponents();
        initFields();
    }

    private void initFields() {
        emptyColorPanel.setBackground(CellColors.getMapColor(Grid.EMPTY));
        wallColorPanel.setBackground(CellColors.getMapColor(Grid.WALL));
        obstacleColorPanel.setBackground(CellColors.getMapColor(Grid.OBSTACLE));
        exitColorPanel.setBackground(CellColors.getMapColor(Grid.EXIT));
        personColorPanel.setBackground(CellColors.getMapColor(Grid.PERSON1));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cellTypeButtons = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rowsSpinner = new javax.swing.JSpinner();
        columnsSpinner = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        emptyCellButton = new javax.swing.JRadioButton();
        wallCellButton = new javax.swing.JRadioButton();
        exitCellButton = new javax.swing.JRadioButton();
        personCellButton = new javax.swing.JRadioButton();
        emptyColorPanel = new javax.swing.JPanel();
        wallColorPanel = new javax.swing.JPanel();
        exitColorPanel = new javax.swing.JPanel();
        personColorPanel = new javax.swing.JPanel();
        obstacleCellButton = new javax.swing.JRadioButton();
        obstacleColorPanel = new javax.swing.JPanel();
        editingButton = new javax.swing.JCheckBox();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(ewakuacja.EwakuacjaApp.class).getContext().getResourceMap(EditPanel.class);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel1.border.title"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        rowsSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000, 1));
        rowsSpinner.setEnabled(false);
        rowsSpinner.setName("rowsSpinner"); // NOI18N
        rowsSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rowsSpinnerStateChanged(evt);
            }
        });

        columnsSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000, 1));
        columnsSpinner.setEnabled(false);
        columnsSpinner.setName("columnsSpinner"); // NOI18N
        columnsSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                columnsSpinnerStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rowsSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(columnsSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rowsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(columnsSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel2.border.title"))); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N

        cellTypeButtons.add(emptyCellButton);
        emptyCellButton.setSelected(true);
        emptyCellButton.setText(resourceMap.getString("emptyCellButton.text")); // NOI18N
        emptyCellButton.setEnabled(false);
        emptyCellButton.setName("emptyCellButton"); // NOI18N
        emptyCellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emptyCellButtonActionPerformed(evt);
            }
        });

        cellTypeButtons.add(wallCellButton);
        wallCellButton.setText(resourceMap.getString("wallCellButton.text")); // NOI18N
        wallCellButton.setEnabled(false);
        wallCellButton.setName("wallCellButton"); // NOI18N
        wallCellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wallCellButtonActionPerformed(evt);
            }
        });

        cellTypeButtons.add(exitCellButton);
        exitCellButton.setText(resourceMap.getString("exitCellButton.text")); // NOI18N
        exitCellButton.setEnabled(false);
        exitCellButton.setName("exitCellButton"); // NOI18N
        exitCellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitCellButtonActionPerformed(evt);
            }
        });

        cellTypeButtons.add(personCellButton);
        personCellButton.setText(resourceMap.getString("personCellButton.text")); // NOI18N
        personCellButton.setEnabled(false);
        personCellButton.setName("personCellButton"); // NOI18N
        personCellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personCellButtonActionPerformed(evt);
            }
        });

        emptyColorPanel.setName("emptyColorPanel"); // NOI18N

        javax.swing.GroupLayout emptyColorPanelLayout = new javax.swing.GroupLayout(emptyColorPanel);
        emptyColorPanel.setLayout(emptyColorPanelLayout);
        emptyColorPanelLayout.setHorizontalGroup(
            emptyColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        emptyColorPanelLayout.setVerticalGroup(
            emptyColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        wallColorPanel.setName("wallColorPanel"); // NOI18N

        javax.swing.GroupLayout wallColorPanelLayout = new javax.swing.GroupLayout(wallColorPanel);
        wallColorPanel.setLayout(wallColorPanelLayout);
        wallColorPanelLayout.setHorizontalGroup(
            wallColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        wallColorPanelLayout.setVerticalGroup(
            wallColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        exitColorPanel.setName("exitColorPanel"); // NOI18N

        javax.swing.GroupLayout exitColorPanelLayout = new javax.swing.GroupLayout(exitColorPanel);
        exitColorPanel.setLayout(exitColorPanelLayout);
        exitColorPanelLayout.setHorizontalGroup(
            exitColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        exitColorPanelLayout.setVerticalGroup(
            exitColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        personColorPanel.setName("personColorPanel"); // NOI18N

        javax.swing.GroupLayout personColorPanelLayout = new javax.swing.GroupLayout(personColorPanel);
        personColorPanel.setLayout(personColorPanelLayout);
        personColorPanelLayout.setHorizontalGroup(
            personColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        personColorPanelLayout.setVerticalGroup(
            personColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        cellTypeButtons.add(obstacleCellButton);
        obstacleCellButton.setText(resourceMap.getString("obstacleCellButton.text")); // NOI18N
        obstacleCellButton.setEnabled(false);
        obstacleCellButton.setName("obstacleCellButton"); // NOI18N
        obstacleCellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obstacleCellButtonActionPerformed(evt);
            }
        });

        obstacleColorPanel.setName("obstacleColorPanel"); // NOI18N

        javax.swing.GroupLayout obstacleColorPanelLayout = new javax.swing.GroupLayout(obstacleColorPanel);
        obstacleColorPanel.setLayout(obstacleColorPanelLayout);
        obstacleColorPanelLayout.setHorizontalGroup(
            obstacleColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        obstacleColorPanelLayout.setVerticalGroup(
            obstacleColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(wallColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(exitColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(personColorPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(emptyColorPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(obstacleColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emptyCellButton)
                    .addComponent(wallCellButton)
                    .addComponent(obstacleCellButton)
                    .addComponent(exitCellButton)
                    .addComponent(personCellButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emptyCellButton)
                    .addComponent(emptyColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wallCellButton)
                    .addComponent(wallColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(obstacleColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(obstacleCellButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(exitColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(personColorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(exitCellButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(personCellButton))))
        );

        editingButton.setText(resourceMap.getString("editingButton.text")); // NOI18N
        editingButton.setName("editingButton"); // NOI18N
        editingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editingButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editingButton)
                .addContainerGap(69, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editingButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void emptyCellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emptyCellButtonActionPerformed
        cellTypeSelected = Grid.EMPTY;
    }//GEN-LAST:event_emptyCellButtonActionPerformed

    private void wallCellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wallCellButtonActionPerformed
        cellTypeSelected = Grid.WALL;
    }//GEN-LAST:event_wallCellButtonActionPerformed

    private void exitCellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitCellButtonActionPerformed
        cellTypeSelected = Grid.EXIT;
    }//GEN-LAST:event_exitCellButtonActionPerformed

    private void personCellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personCellButtonActionPerformed
        cellTypeSelected = Grid.PERSON1;
    }//GEN-LAST:event_personCellButtonActionPerformed

    private void editingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editingButtonActionPerformed
        boolean enable = editingButton.isSelected();
        if (enable) {
            rowsSpinner.setValue(gridPanel.getGridRowsNumber());
            columnsSpinner.setValue(gridPanel.getGridColumnsNumber());
            mapGridChanged = true;
        }

        editingMode = enable;

        rowsSpinner.setEnabled(enable);
        columnsSpinner.setEnabled(enable);

        emptyCellButton.setEnabled(enable);
        wallCellButton.setEnabled(enable);
        obstacleCellButton.setEnabled(enable);
        exitCellButton.setEnabled(enable);
        personCellButton.setEnabled(enable);

        if (mainWindow != null) {
            mainWindow.setEditMode(enable);
            if(!enable) {
                gridPanel.getGrid().identifyExits();
                gridPanel.getGrid().calculatePotentials();
            }
        }

    }//GEN-LAST:event_editingButtonActionPerformed

    private void rowsSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rowsSpinnerStateChanged
        if (editingMode) {
            gridPanel.setGridSize(Integer.parseInt(rowsSpinner.getValue().toString()),
                    Integer.parseInt(columnsSpinner.getValue().toString()));
        }
    }//GEN-LAST:event_rowsSpinnerStateChanged

    private void columnsSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_columnsSpinnerStateChanged
        if (editingMode) {
            gridPanel.setGridSize(Integer.parseInt(rowsSpinner.getValue().toString()),
                    Integer.parseInt(columnsSpinner.getValue().toString()));
        }
    }//GEN-LAST:event_columnsSpinnerStateChanged

    private void obstacleCellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obstacleCellButtonActionPerformed
        cellTypeSelected = Grid.OBSTACLE;
    }//GEN-LAST:event_obstacleCellButtonActionPerformed

    /**
     * Setting gridPanel, will not work without this.
     * @param panel
     */
    public void setGridPanel(GridPanel panel) {
        gridPanel = panel;
    }

    /**
     * Setting mainWindow, will not work without this.
     * @param window
     */
    public void setMainWindow(EwakuacjaView window) {
        mainWindow = window;
    }

    /**
     * Lets to check if editing mode is enabled.
     * @return true, if editing mode is enabled.
     */
    public boolean isEditingMode() {
        return editingMode;
    }

    /**
     * Exit from editing mode.
     */
    public void stopEditing() {
        editingButton.setSelected(false);
        editingButtonActionPerformed(null);
    }

    /**
     * Use this method to get type of cell selected.
     * @return selected cell type, according to values in Grid class.
     */
    public int getCellTypeSelected() {
        return cellTypeSelected;
    }

    /**
     * Method to get information if grid has been changed after last saving.
     * Precisely it checks if editMode has been enabled.
     * @return
     */
    public boolean getMapGridChanged() {
        return mapGridChanged;
    }

    /**
     * Sents information about changing grid after saving.
     * @param aFlag
     */
    public void setMapGridChanged(boolean aFlag) {
        mapGridChanged = aFlag;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup cellTypeButtons;
    private javax.swing.JSpinner columnsSpinner;
    private javax.swing.JCheckBox editingButton;
    private javax.swing.JRadioButton emptyCellButton;
    private javax.swing.JPanel emptyColorPanel;
    private javax.swing.JRadioButton exitCellButton;
    private javax.swing.JPanel exitColorPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton obstacleCellButton;
    private javax.swing.JPanel obstacleColorPanel;
    private javax.swing.JRadioButton personCellButton;
    private javax.swing.JPanel personColorPanel;
    private javax.swing.JSpinner rowsSpinner;
    private javax.swing.JRadioButton wallCellButton;
    private javax.swing.JPanel wallColorPanel;
    // End of variables declaration//GEN-END:variables
    int cellTypeSelected = Grid.EMPTY;
    GridPanel gridPanel;
    EwakuacjaView mainWindow = null;
    private boolean editingMode = false;
    private boolean mapGridChanged = false;
}
