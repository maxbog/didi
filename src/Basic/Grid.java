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
    private int[][][] potentialGrid;
    private int[][] densityGrid;
/***************AllGridsFunctions***************/
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
        this.setSize(rows, columns);
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

    /**
     * Method sets new size of grid. It does not forgot values of old grid.
     * @param rows
     * @param columns
     */
    public void setSize(int rows, int columns){
        int[][] temp = new int[rows][columns];
        potentialGrid = new int[rows][columns][1];
        densityGrid = new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(i < rowsNumber && j < columnsNumber)
                    temp[i][j] = mapGrid[i][j];
                else
                    temp[i][j] = this.EMPTY;
                potentialGrid[i][j][0]=0;
                densityGrid[i][j]=0;
            }
        }

        mapGrid = temp;
        columnsNumber = columns;
        rowsNumber = rows;
    }

/***************MapGridFunctions***************/

    /**
     *
     * @param x Row Index
     * @param y Column Index
     * @return Type of cell: Grid.EMPTY, GRID.WALL etc.
     */
    public int getMapCell(int x, int y){
        return mapGrid[x][y];
    }

    /**
     *
     * @param x Row index.
     * @param y Column index.
     * @param value Type of cell: Grid.EMPTY, GRID.WALL etc.
     */
    public void setMapCell(int x, int y, int value){
        mapGrid[x][y] = value;
    }

    /***************PotentialGridFunctions***************/
    /**
     * Calculates potentials of cells (distaces to exits).
     */
    public void calculatePotentials(){
        //TODO liczenie potencjalow - odleglosci od wszystkich wejsc.
        //proponuje:
        //potentialGrid[i][j]=new int[a+1]; - a = ilosc wyjsc
        //potentialGrid[i][j][0]=min; - min = odleglosc do najblizszego wyjscia
    }

    /**
     * Method returns array of potentials in selected cell.
     * Array[0] is a distance to the nearest exit.
     * @param row
     * @param column
     * @return Array of potential of cell.
     */
    public int[] getPotential(int row, int column){
        return potentialGrid[row][column];
    }

    /***************DensityGridFunctions***************/
    /**
     * Calculates density of each cell.
     */
    public void calculateDensities(){
        //TODO liczenie gestosci na siatce.
        //Wielkosc obszaru to parametr z ustawien, moze byc jako parametr funkcji.

        //np. densityGrid[1][2] = 7;
    }

    /**
     *
     * @param row
     * @param column
     * @return Density of selected cell.
     */
    public int getDensity(int row, int column){
        return densityGrid[row][column];
    }
}
