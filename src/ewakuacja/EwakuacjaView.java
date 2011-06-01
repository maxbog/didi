/*
 * EwakuacjaView.java
 */

package ewakuacja;

import Basic.Grid;
import GUI.GridPanel;
import GUI.OpenConfirmWindow;
import Others.FilesStuff;
import java.awt.AWTEvent;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 * The application's main frame.
 */
public class EwakuacjaView extends FrameView {

    public EwakuacjaView(SingleFrameApplication app) {
        super(app);

        initComponents();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
        progressBar.setVisible(true);
        grid = new Grid(0,0);
        gridPanel.setGrid(grid);

        this.getFrame().setTitle("Symulacja ewakuacji");
        
        setConnections();
        scrollPane = gridScrollPane;
        Toolkit.getDefaultToolkit().addAWTEventListener( new AWTEventListener()
        {
            public void eventDispatched(AWTEvent e)
            {
                if(e.getID() != 401)
                    return;
                KeyEvent evt = (KeyEvent)e;
                if(evt.isControlDown()){
                        Point point = scrollPane.getViewport().getViewPosition();
                    switch (evt.getKeyCode()){
                        case KeyEvent.VK_UP:
                            point.y-=10;
                            if(point.y < 0)
                                point.y = 0;
                            break;
                        case KeyEvent.VK_DOWN:
                            point.y += 10;
                            break;
                        case KeyEvent.VK_LEFT:
                            point.x-=10;
                            if(point.x < 0)
                                point.x = 0;
                            break;
                        case KeyEvent.VK_RIGHT:
                            point.x += 10;
                            break;
                    }
                    scrollPane.getViewport().setViewPosition(point);
                    scrollPane.getViewport().revalidate();
                }
            }
        }, AWTEvent.KEY_EVENT_MASK);
    }

    /**
     * Method sets connections between panels
     */
    private void setConnections(){
        editPanel.setGridPanel(gridPanel);
        editPanel.setMainWindow(this);
        gridPanel.setEditPanel(editPanel);
        gridPanel.setScrollPane(gridScrollPane);
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = EwakuacjaApp.getApplication().getMainFrame();
            aboutBox = new EwakuacjaAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        EwakuacjaApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        optionsTabs = new javax.swing.JTabbedPane();
        optionsPanel1 = new GUI.OptionsPanel();
        editPanel = new GUI.EditPanel();
        gridScrollPane = new javax.swing.JScrollPane();
        gridPanel = new GUI.GridPanel();
        mapRadioButton = new javax.swing.JRadioButton();
        potentialRadioButton = new javax.swing.JRadioButton();
        potentialComboBox = new javax.swing.JComboBox();
        densityRadioButton = new javax.swing.JRadioButton();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu OpenFileMenuButton = new javax.swing.JMenu();
        newMenuButton = new javax.swing.JMenuItem();
        openMenuButton = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        saveMenuButton = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        viewMenu = new javax.swing.JMenu();
        ShowGridLines = new javax.swing.JCheckBoxMenuItem();
        showGridNumbersMenuButton = new javax.swing.JCheckBoxMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        zoomMinus = new javax.swing.JMenuItem();
        zoomPlus = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        StatusLabel = new javax.swing.JLabel();
        viewRadioButtons = new javax.swing.ButtonGroup();

        mainPanel.setName("mainPanel"); // NOI18N

        optionsTabs.setName("optionsTabs"); // NOI18N
        optionsTabs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                optionsTabsStateChanged(evt);
            }
        });

        optionsPanel1.setName("optionsPanel1"); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(ewakuacja.EwakuacjaApp.class).getContext().getResourceMap(EwakuacjaView.class);
        optionsTabs.addTab(resourceMap.getString("optionsPanel1.TabConstraints.tabTitle"), optionsPanel1); // NOI18N

        editPanel.setName("editPanel"); // NOI18N
        optionsTabs.addTab(resourceMap.getString("editPanel.TabConstraints.tabTitle"), editPanel); // NOI18N

        gridScrollPane.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        gridScrollPane.setName("gridScrollPane"); // NOI18N

        gridPanel.setName("gridPanel"); // NOI18N

        javax.swing.GroupLayout gridPanelLayout = new javax.swing.GroupLayout(gridPanel);
        gridPanel.setLayout(gridPanelLayout);
        gridPanelLayout.setHorizontalGroup(
            gridPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        gridPanelLayout.setVerticalGroup(
            gridPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
        );

        gridScrollPane.setViewportView(gridPanel);

        viewRadioButtons.add(mapRadioButton);
        mapRadioButton.setSelected(true);
        mapRadioButton.setText(resourceMap.getString("mapRadioButton.text")); // NOI18N
        mapRadioButton.setName("mapRadioButton"); // NOI18N
        mapRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mapRadioButtonStateChanged(evt);
            }
        });

        viewRadioButtons.add(potentialRadioButton);
        potentialRadioButton.setText(resourceMap.getString("potentialRadioButton.text")); // NOI18N
        potentialRadioButton.setName("potentialRadioButton"); // NOI18N
        potentialRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                potentialRadioButtonStateChanged(evt);
            }
        });

        potentialComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Najlepsze", "Wyjście 1", "Wyjście 2", "Wyjście 3" }));
        potentialComboBox.setEnabled(false);
        potentialComboBox.setName("potentialComboBox"); // NOI18N
        potentialComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                potentialComboBoxActionPerformed(evt);
            }
        });

        viewRadioButtons.add(densityRadioButton);
        densityRadioButton.setText(resourceMap.getString("densityRadioButton.text")); // NOI18N
        densityRadioButton.setName("densityRadioButton"); // NOI18N
        densityRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                densityRadioButtonStateChanged(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(mapRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(potentialRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(potentialComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(densityRadioButton))
                    .addComponent(gridScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionsTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mapRadioButton)
                            .addComponent(potentialRadioButton)
                            .addComponent(potentialComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(densityRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gridScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                    .addComponent(optionsTabs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 296, Short.MAX_VALUE))
                .addContainerGap())
        );

        menuBar.setName("menuBar"); // NOI18N

        OpenFileMenuButton.setText(resourceMap.getString("OpenFileMenuButton.text")); // NOI18N
        OpenFileMenuButton.setMinimumSize(new java.awt.Dimension(27, 19));
        OpenFileMenuButton.setName("OpenFileMenuButton"); // NOI18N

        newMenuButton.setText(resourceMap.getString("newMenuButton.text")); // NOI18N
        newMenuButton.setName("newMenuButton"); // NOI18N
        newMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuButtonActionPerformed(evt);
            }
        });
        OpenFileMenuButton.add(newMenuButton);

        openMenuButton.setText(resourceMap.getString("openMenuButton.text")); // NOI18N
        openMenuButton.setName("openMenuButton"); // NOI18N
        openMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuButtonActionPerformed(evt);
            }
        });
        OpenFileMenuButton.add(openMenuButton);

        jSeparator2.setName("jSeparator2"); // NOI18N
        OpenFileMenuButton.add(jSeparator2);

        saveMenuButton.setText(resourceMap.getString("saveMenuButton.text")); // NOI18N
        saveMenuButton.setName("saveMenuButton"); // NOI18N
        saveMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuButtonActionPerformed(evt);
            }
        });
        OpenFileMenuButton.add(saveMenuButton);

        jSeparator3.setName("jSeparator3"); // NOI18N
        OpenFileMenuButton.add(jSeparator3);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(ewakuacja.EwakuacjaApp.class).getContext().getActionMap(EwakuacjaView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        OpenFileMenuButton.add(exitMenuItem);

        menuBar.add(OpenFileMenuButton);

        viewMenu.setText(resourceMap.getString("viewMenu.text")); // NOI18N
        viewMenu.setMinimumSize(new java.awt.Dimension(43, 19));
        viewMenu.setName("viewMenu"); // NOI18N

        ShowGridLines.setSelected(true);
        ShowGridLines.setText(resourceMap.getString("ShowGridLines.text")); // NOI18N
        ShowGridLines.setName("ShowGridLines"); // NOI18N
        ShowGridLines.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowGridLinesActionPerformed(evt);
            }
        });
        viewMenu.add(ShowGridLines);

        showGridNumbersMenuButton.setSelected(true);
        showGridNumbersMenuButton.setText(resourceMap.getString("showGridNumbersMenuButton.text")); // NOI18N
        showGridNumbersMenuButton.setName("showGridNumbersMenuButton"); // NOI18N
        showGridNumbersMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGridNumbersMenuButtonActionPerformed(evt);
            }
        });
        viewMenu.add(showGridNumbersMenuButton);

        jSeparator1.setName("jSeparator1"); // NOI18N
        viewMenu.add(jSeparator1);

        zoomMinus.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_MINUS, java.awt.event.InputEvent.CTRL_MASK));
        zoomMinus.setText(resourceMap.getString("zoomMinus.text")); // NOI18N
        zoomMinus.setName("zoomMinus"); // NOI18N
        zoomMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomMinusActionPerformed(evt);
            }
        });
        viewMenu.add(zoomMinus);

        zoomPlus.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_EQUALS, java.awt.event.InputEvent.CTRL_MASK));
        zoomPlus.setText(resourceMap.getString("zoomPlus.text")); // NOI18N
        zoomPlus.setName("zoomPlus"); // NOI18N
        zoomPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomPlusActionPerformed(evt);
            }
        });
        viewMenu.add(zoomPlus);

        menuBar.add(viewMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setMinimumSize(new java.awt.Dimension(47, 19));
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setText(resourceMap.getString("aboutMenuItem.text")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        StatusLabel.setText(resourceMap.getString("StatusLabel.text")); // NOI18N
        StatusLabel.setName("StatusLabel"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusMessageLabel)
                    .addComponent(StatusLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 329, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(statusMessageLabel)
                            .addComponent(statusAnimationLabel)
                            .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addComponent(StatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void zoomMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomMinusActionPerformed
        gridPanel.zoomMinus();
    }//GEN-LAST:event_zoomMinusActionPerformed

    private void zoomPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomPlusActionPerformed
        gridPanel.zoomPlus();
    }//GEN-LAST:event_zoomPlusActionPerformed

    private void ShowGridLinesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowGridLinesActionPerformed
        gridPanel.setDrawingLines(ShowGridLines.isSelected());
    }//GEN-LAST:event_ShowGridLinesActionPerformed

    private void mapRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mapRadioButtonStateChanged
        if(mapRadioButton.isSelected())
            gridPanel.setVisibleGrid(GridPanel.VISIBLE_MAP);
        else
            editPanel.stopEditing();
    }//GEN-LAST:event_mapRadioButtonStateChanged

    private void potentialRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_potentialRadioButtonStateChanged
        if(potentialRadioButton.isSelected()){
            gridPanel.setVisibleGrid(GridPanel.VISIBLE_POTENTIAL);

            if(grid.getExitsCount() + 1 != potentialComboBox.getItemCount()){
                javax.swing.DefaultComboBoxModel model = new DefaultComboBoxModel();
                model.addElement("Najlepsze");
                for(int i = 0; i < grid.getExitsCount(); i++)
                    model.addElement("Wyjście " + Integer.toString(i+1));
                potentialComboBox.setModel(model);
                gridPanel.setVisiblePotential(potentialComboBox.getSelectedIndex());
            }
            potentialComboBox.setEnabled(true);
        }
        else
            potentialComboBox.setEnabled(false);
    }//GEN-LAST:event_potentialRadioButtonStateChanged

    private void densityRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_densityRadioButtonStateChanged
        if(densityRadioButton.isSelected())
            gridPanel.setVisibleGrid(GridPanel.VISIBLE_DENSITY);
    }//GEN-LAST:event_densityRadioButtonStateChanged

    private void showGridNumbersMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGridNumbersMenuButtonActionPerformed
        gridPanel.setDrawingNumbers(showGridNumbersMenuButton.isSelected());
    }//GEN-LAST:event_showGridNumbersMenuButtonActionPerformed

    private void optionsTabsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_optionsTabsStateChanged
        if(optionsTabs.getSelectedComponent() != editPanel){
            editPanel.stopEditing();
        }
}//GEN-LAST:event_optionsTabsStateChanged

    private void openMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuButtonActionPerformed
        editPanel.stopEditing();
        if(editPanel.getMapGridChanged()){
            if(openConfirmWindow == null){
                openConfirmWindow = new OpenConfirmWindow(this.getFrame(), true);
            }
            else
                openConfirmWindow.setVisible(true);

            switch(openConfirmWindow.getReturnStatus()){
                case OpenConfirmWindow.RET_CANCEL: return;
                case OpenConfirmWindow.RET_SAVE: saveMenuButtonActionPerformed(evt); return;
                case OpenConfirmWindow.RET_DECLINE: break;
                default: return;
            }
        }

        if(fileChooser == null){
            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(".\\"));
        }
        if(fileChooser.showOpenDialog(this.getFrame()) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            grid=FilesStuff.openGrid(file);
            gridPanel.setGrid(grid);
            editPanel.setMapGridChanged(false);
        }
    }//GEN-LAST:event_openMenuButtonActionPerformed

    private void saveMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuButtonActionPerformed
        editPanel.stopEditing();
        if(fileChooser == null){
            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(".\\"));
        }
        if(fileChooser.showSaveDialog(this.getFrame()) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            FilesStuff.saveGrid(grid, file);
            editPanel.setMapGridChanged(false);
        }
    }//GEN-LAST:event_saveMenuButtonActionPerformed

    private void newMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMenuButtonActionPerformed
        editPanel.stopEditing();
        if(editPanel.getMapGridChanged()){
            if(openConfirmWindow == null){
                openConfirmWindow = new OpenConfirmWindow(this.getFrame(), true);
            }
            else
                openConfirmWindow.setVisible(true);

            switch(openConfirmWindow.getReturnStatus()){
                case OpenConfirmWindow.RET_CANCEL: return;
                case OpenConfirmWindow.RET_SAVE: saveMenuButtonActionPerformed(evt); break;
                case OpenConfirmWindow.RET_DECLINE: break;
                default: return;
            }
        }
        grid=new Grid(0,0);
        gridPanel.setGrid(grid);
    }//GEN-LAST:event_newMenuButtonActionPerformed

    private void potentialComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_potentialComboBoxActionPerformed
        gridPanel.setVisiblePotential(potentialComboBox.getSelectedIndex());
    }//GEN-LAST:event_potentialComboBoxActionPerformed

    /**
     * 
     * @param aFlag Turn mode into(true) or out of{false) edit mode
     */
    public void setEditMode(boolean aFlag){
        mapRadioButton.setSelected(aFlag);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem ShowGridLines;
    private javax.swing.JLabel StatusLabel;
    private javax.swing.JRadioButton densityRadioButton;
    private GUI.EditPanel editPanel;
    private GUI.GridPanel gridPanel;
    private javax.swing.JScrollPane gridScrollPane;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JRadioButton mapRadioButton;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newMenuButton;
    private javax.swing.JMenuItem openMenuButton;
    private GUI.OptionsPanel optionsPanel1;
    private javax.swing.JTabbedPane optionsTabs;
    private javax.swing.JComboBox potentialComboBox;
    private javax.swing.JRadioButton potentialRadioButton;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JMenuItem saveMenuButton;
    private javax.swing.JCheckBoxMenuItem showGridNumbersMenuButton;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JMenu viewMenu;
    private javax.swing.ButtonGroup viewRadioButtons;
    private javax.swing.JMenuItem zoomMinus;
    private javax.swing.JMenuItem zoomPlus;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;
    Grid grid;

    private JDialog aboutBox;
    private JFileChooser fileChooser;
    private OpenConfirmWindow openConfirmWindow;
    private static JScrollPane scrollPane;
}
