/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Basic;

/**
 *
 * @author DSidor
 */
public class Grid {
    
    public static final int EMPTY = 0;
    public static final int WALL = -1;
    public static final int EXIT = -2;
    public static final int BLOCKED = -3;
    public static final int PERSON1 = 1;
    public static final int PERSON2 = 2;
    public static final int PERSON3 = 3;
    public static final int PERSON4 = 4;

    private int columnsNumber;
    private int rowsNumber;
    private int[][] mapGrid;


    /**
     * New empty grid, size=(0,0)
     */
    public Grid(){
        columnsNumber = 0;
        rowsNumber = 0;
    }

    /**
     * New grid with empty cells
     * @param rows rows number
     * @param columns columns number
     */
    public Grid(int rows, int columns){
        columnsNumber = columns;
        rowsNumber = rows;
        mapGrid = new int[rows][columns];
        for(int i=0;i<rowsNumber;i++){
            for(int j=0;j<columnsNumber;j++){
                mapGrid[i][j]=this.EMPTY;
            }
        }
    }

    /**
     *
     * @param x Row Index
     * @param y Column Index
     * @return cell
     */
    public int getMapCell(int x, int y){
        return mapGrid[x][y];
    }

    public void setMapCell(int x, int y, int value){
        mapGrid[x][y] = value;
    }

    /**
     *
     * @return number of columns
     */
    public int getColumnsNumber(){
        return columnsNumber;
    }

    /**
     *
     * @return number of rows
     */
    public int getRowsNumber(){
        return rowsNumber;
    }

    public void setSize(int rows, int columns){
        int[][] temp = new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(i < rowsNumber && j < columnsNumber)
                    temp[i][j] = mapGrid[i][j];
                else
                    temp[i][j] = this.EMPTY;
            }
        }

        mapGrid = temp;
        columnsNumber = columns;
        rowsNumber = rows;
    }
}
