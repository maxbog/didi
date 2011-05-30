/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJPanel.java
 *
 * Created on 2011-05-28, 13:52:49
 */

package GUI;

import Basic.Grid;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JScrollPane;

/**
 *
 * @author DSidor
 */
public class GridPanel extends javax.swing.JPanel {

    public static final int VISIBLE_MAP = 0;
    public static final int VISIBLE_POTENTIAL = 1;
    public static final int VISIBLE_DENSITY = 2;

    /** Creates new form NewJPanel */
    public GridPanel() {
        initComponents();
        grid = new Grid(0,0);
    }
    /**
     * @param gr Grid to show in panel.
     */
    public void setGrid(Grid gr) {
        initComponents();
        grid = gr;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setName("Form"); // NOI18N
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method changing one cell of grid, which is clicked, if editingMoge is enabled
     * @param evt
     */
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if( !editPanel.isEditingMode() )
            return;

        int row = 0;
        int column = 0;
        try {
            column = (this.getMousePosition().x - xMargin) / cellSize;
            row = (this.getMousePosition().y - yMargin) / cellSize;
        } catch (Exception exception) {
            this.repaint();
            return;
        }

        if(column >= grid.getColumnsNumber() || this.getMousePosition().x < xMargin)
            column = -1;
        if(row >= grid.getRowsNumber() || this.getMousePosition().y < yMargin)
            row = -1;

        if(column==-1 || row==-1)
            return;

        grid.setMapCell(row, column, editPanel.getCellTypeSelected());
        paintCell(row, column);
    }//GEN-LAST:event_formMouseClicked

    /**
     * Method changing cells of grid, which are pushed while moving mouse
     * @param evt
     */
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        formMouseClicked(evt);
}//GEN-LAST:event_formMouseDragged

    /**
     * Repaint grid after changing cells by clicking od draging.
     * @param evt
     */
    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        this.repaint();
        grid.calculateDensities();
    }//GEN-LAST:event_formMouseReleased

    /**
     * Method repaints one cell of grid. Use this if you do not have to repaint whole grid.
     * @param row
     * @param column
     */
    public void paintCell(int row, int column){
        Graphics2D g2d = (Graphics2D) this.getGraphics();
        g2d.setColor(CellColors.getMapColor(grid.getMapCell(row, column)));
        g2d.fillRect(xMargin+cellSize*column, yMargin+cellSize*row, cellSize, cellSize);
        
//        if(drawLines){
//            g2d.setColor(Color.GRAY);
//            for(int i=1;i<grid.getRowsNumber();i++){
//                g2d.drawLine(xMargin, yMargin+i*cellSize,
//                        xMargin+grid.getColumnsNumber()*cellSize-1, yMargin+i*cellSize);
//            }
//            for(int i=1;i<grid.getColumnsNumber();i++){
//                g2d.drawLine(xMargin+i*cellSize, yMargin,
//                        xMargin+i*cellSize, yMargin+grid.getRowsNumber()*cellSize-1);
//            }
//        }
    }

    /**
     * Method repaints all visible grid.
     */
    public void repaintGrid(){
        this.repaint();
    }

    /**
     * Paints map cells.
     * @param g2d
     * @param rect
     */
    private void paintMap(Graphics2D g2d, Rectangle rect){
        for(int i=0;i<grid.getRowsNumber();i++){
            for(int j=0;j<grid.getColumnsNumber();j++){
                int xView = xMargin+cellSize*j;
                int yView = yMargin+cellSize*i;
                if( xView + cellSize < rect.x || yView + cellSize < rect.y ||
                        xView > rect.x + rect.width || yView > rect.y + rect.height) //rysuje tylko jeżeli widać element
                    continue;
                g2d.setColor(CellColors.getMapColor(grid.getMapCell(i, j)));
                g2d.fillRect( xView, yView, cellSize, cellSize);
            }
        }
    }

    /**
     * Paints potential cells.
     * @param g2d
     * @param rect
     */
    public void paintPotential(Graphics2D g2d, Rectangle rect){
        for(int i=0;i<grid.getRowsNumber();i++){
            for(int j=0;j<grid.getColumnsNumber();j++){
                int xView = xMargin+cellSize*j;
                int yView = yMargin+cellSize*i;
                if( xView + cellSize < rect.x || yView + cellSize < rect.y ||
                        xView > rect.x + rect.width || yView > rect.y + rect.height) //rysuje tylko jeżeli widać element
                    continue;
                if(grid.getMapCell(i, j) == Grid.WALL)
                    g2d.setColor(CellColors.getMapColor(Grid.WALL));
                else
                    g2d.setColor(CellColors.getPotentialColor(grid.getPotential(i, j)[0],100)); //TODO sidor: zmienic 100 i 0.
                g2d.fillRect( xView, yView, cellSize, cellSize);
            }
        }
    }

    /**
     * Paints density cells.
     * @param g2d
     * @param rect
     */
    public void paintDensity(Graphics2D g2d, Rectangle rect){
        for(int i=0;i<grid.getRowsNumber();i++){
            for(int j=0;j<grid.getColumnsNumber();j++){
                int xView = xMargin+cellSize*j;
                int yView = yMargin+cellSize*i;
                if( xView + cellSize < rect.x || yView + cellSize < rect.y ||
                        xView > rect.x + rect.width || yView > rect.y + rect.height) //rysuje tylko jeżeli widać element
                    continue;
                if(grid.getMapCell(i, j) == Grid.WALL)
                    g2d.setColor(CellColors.getMapColor(Grid.WALL));
                else
                    g2d.setColor(CellColors.getDensityColor(grid.getDensity(i, j)));
                g2d.fillRect( xView, yView, cellSize, cellSize);
                if(drawNumbers && grid.getMapCell(i, j) != Grid.WALL){
                    g2d.setColor(Color.BLACK);
                    String density = Double.toString(grid.getDensity(i, j)*100);
                    density = density.substring(0, density.indexOf('.'));
                    g2d.drawString(density, xView+2, yView+15);
                }
            }
        }
    }

    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(Color.LIGHT_GRAY);
        g2d.clearRect(0, 0, this.getWidth(), this.getHeight());

        if(grid == null || grid.getColumnsNumber()==0 || grid.getRowsNumber() == 0)
            return;

        Rectangle rect = scrollPane.getViewport().getViewRect(); //widoczny prostokat

        g2d.setColor(Color.BLACK);
        g2d.drawRect(xMargin-1, yMargin-1, grid.getColumnsNumber()*cellSize+1,
                grid.getRowsNumber()*cellSize+1);
        g2d.drawRect(xMargin-2, yMargin-2, grid.getColumnsNumber()*cellSize+3,
                grid.getRowsNumber()*cellSize+3);

        switch(visibleGrid){
            case GridPanel.VISIBLE_MAP: paintMap(g2d, rect); break;
            case GridPanel.VISIBLE_POTENTIAL: paintPotential(g2d, rect); break;
            case GridPanel.VISIBLE_DENSITY: paintDensity(g2d, rect); break;
        }

        if(drawLines){
            g2d.setColor(Color.GRAY);
            for(int i=1;i<grid.getRowsNumber();i++){
                if(yMargin+i*cellSize < rect.y || yMargin+i*cellSize > rect.y + rect.height)
                    continue; // rysuje tylko widoczne
                g2d.drawLine(xMargin, yMargin+i*cellSize,
                        xMargin+grid.getColumnsNumber()*cellSize-1, yMargin+i*cellSize);
            }
            for(int i=1;i<grid.getColumnsNumber();i++){
                if(xMargin+i*cellSize < rect.x || xMargin+i*cellSize > rect.x + rect.width)
                    continue; // rysuje tylko widoczne
                g2d.drawLine(xMargin+i*cellSize, yMargin,
                        xMargin+i*cellSize, yMargin+grid.getRowsNumber()*cellSize-1);
            }
        }

        this.setPreferredSize(new Dimension(grid.getColumnsNumber()*cellSize+2*xMargin,
                grid.getRowsNumber()*cellSize+2*yMargin));
        
    }

    @Override
    public void update( Graphics g )
    {
        paint(g);
    }

    /**
     * Increase size of cell, grid is bigger.
     */
    public void zoomPlus(){
        if(cellSize<30)
            cellSize+=2;
        this.setSize(new Dimension(grid.getColumnsNumber()*cellSize+2*xMargin,
                grid.getRowsNumber()*cellSize+2*yMargin));
        this.repaint();
    }

    /**
     * Decrease size of cell, grid is smaller.
     */
    public void zoomMinus(){
        if(cellSize>4)
            cellSize-=2;
        this.setSize(new Dimension(grid.getColumnsNumber()*cellSize+2*xMargin,
                grid.getRowsNumber()*cellSize+2*yMargin));
        this.repaint();
    }

    /**
     *
     * @param aFlag True to make lines visible, false to hide them.
     */
    public void setDrawingLines(boolean aFlag){
        drawLines = aFlag;
        this.repaint();
    }

    public void setDrawingNumbers(boolean aFlag){
        drawNumbers = aFlag;
        this.repaint();
    }

    /** Method changes size of grid.
     * Never changes cells which are in smaller grid.
     * Adds empty cells, if new grid is bigger.
     * @param rows Number of rows.
     * @param columns Number of columns.
     */
    public void setGridSize(int rows, int columns){
        grid.setSize(rows, columns);
        this.setSize(new Dimension(grid.getColumnsNumber()*cellSize+2*xMargin,
                grid.getRowsNumber()*cellSize+2*yMargin));
        this.revalidate();
        this.repaint();
    }

    /**
     * Setting editPanel, will not work without this.
     * @param panel
     */
    public void setEditPanel(EditPanel panel){
        editPanel = panel;
    }

    /**
     * Setting editPanel, will not work correctly without this.
     * @param pane
     */
    public void setScrollPane(JScrollPane pane){
        scrollPane = pane;
    }

    /**
     *
     * @return Number of columns of grid.
     */
    public int getGridColumnsNumber(){
        return grid.getColumnsNumber();
    }

    /**
     *
     * @return Number of rows of grid.
     */
    public int getGridRowsNumber(){
        return grid.getRowsNumber();
    }

    /**
     * Method sets which grid will be visible.
     * @param aFlag VISIBLE_MAP, VISIBLE_POTENTIAL or VISIBLE_DESTINY
     */
    public void setVisibleGrid(int aFlag){
        switch(aFlag){
            case GridPanel.VISIBLE_MAP:
            case GridPanel.VISIBLE_POTENTIAL:
            case GridPanel.VISIBLE_DENSITY:{
                visibleGrid = aFlag;
                break;
            }
            default: {
                visibleGrid = GridPanel.VISIBLE_MAP;
            }
        }
        this.repaintGrid();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private final int xMargin = 8;
    private final int yMargin = 8;
    private int cellSize = 21;
    private boolean drawLines = true;
    private boolean drawNumbers = true;
    private Grid grid = null;
    private int visibleGrid = this.VISIBLE_MAP;

    EditPanel editPanel;
    JScrollPane scrollPane;
}
