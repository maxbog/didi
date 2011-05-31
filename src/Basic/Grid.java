/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Basic;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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
    public static final int FLOOD_RADIUS = 3;
    private int columnsNumber;
    private int rowsNumber;
    private int[][] mapGrid;
    private int[][][] potentialGrid;
    private double[][] densityGrid;

    /***************AllGridsFunctions***************/
    /**
     * New empty grid, size=(0,0)
     */
    public Grid() {
        setSize(0, 0);
    }

    /**
     * New grid with empty cells
     * @param rows rows number
     * @param columns columns number
     */
    public Grid(int rows, int columns) {
        setSize(rows, columns);
    }

    /**
     *
     * @return number of columns
     */
    public int getColumnsNumber() {
        return columnsNumber;
    }

    /**
     *
     * @return number of rows
     */
    public int getRowsNumber() {
        return rowsNumber;
    }

    /**
     * Method sets new size of grid. It does not forgot values of old grid.
     * @param rows
     * @param columns
     */
    public void setSize(int rows, int columns) {
        int[][] temp = new int[rows][columns];
        potentialGrid = new int[rows][columns][1];
        densityGrid = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i < rowsNumber && j < columnsNumber) {
                    temp[i][j] = mapGrid[i][j];
                } else {
                    temp[i][j] = this.EMPTY;
                    potentialGrid[i][j][0] = 0;
                    densityGrid[i][j] = 0;
                }
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
    public int getMapCell(int x, int y) {
        return mapGrid[x][y];
    }

    /**
     *
     * @param x Row index.
     * @param y Column index.
     * @param value Type of cell: Grid.EMPTY, GRID.WALL etc.
     */
    public void setMapCell(int x, int y, int value) {
        mapGrid[x][y] = value;
    }

    /***************PotentialGridFunctions***************/
    /**
     * Calculates potentials of cells (distaces to exits).
     */
    public void calculatePotentials() {
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
    public int[] getPotential(int row, int column) {
        return potentialGrid[row][column];
    }

    /***************DensityGridFunctions***************/
    /**
     * Calculates density of each cell.
     */
    public void calculateDensities() {
        for (int i = 0; i < getRowsNumber(); i++) {
            for (int j = 0; j < getColumnsNumber(); j++) {
                densityGrid[i][j] = 0;
            }
        }
        for (int row = 0; row < getRowsNumber(); ++row) {
            for (int column = 0; column < getColumnsNumber(); ++column) {
                if (mapGrid[row][column] != WALL && mapGrid[row][column] != EXIT) {
                    calculateDensity(row, column);
                }
            }
        }
    }

    /**
     * Liczy gestosc dla jednej komorki
     * @param row wiersz komorki
     * @param column kolumna komorki
     */
    private void calculateDensity(int row, int column) {
        Queue<Position> toProcess = new LinkedList<Position>();
        Set<Position> processed = new HashSet<Position>();
        int all = 0, people = 0;
        toProcess.add(new Position(row, column));
        while (!toProcess.isEmpty()) {
            Position current = toProcess.poll();
            if (processed.contains(current)) {
                continue;
            }
            processed.add(current);
            // upewniamy sie zeby nie wyjsc poza tablice
            if (current.row < 0 || current.row >= getRowsNumber() || current.column < 0 || current.column >= getColumnsNumber()) {
                continue;
            }
            // opuszczamy sciany i wyjscia
            if (mapGrid[current.row][current.column] == WALL || mapGrid[current.row][current.column] == EXIT) {
                continue;
            }
            // sprawdzamy, czy komorka miesci sie w metryce
            int dRow = current.row - row, dColumn = current.column - column;
            if (dRow*dRow + dColumn*dColumn > FLOOD_RADIUS*FLOOD_RADIUS) {
                continue;
            }

            ++all;
            if (mapGrid[current.row][current.column] > 0) {
                ++people;
            }

            toProcess.add(new Position(current.row, current.column - 1));
            toProcess.add(new Position(current.row, current.column + 1));
            toProcess.add(new Position(current.row - 1, current.column));
            toProcess.add(new Position(current.row + 1, current.column));
        }
        if (all != 0) {
            densityGrid[row][column] = (double) people / (double) all;
        }
    }

    /**
     *
     * @param row
     * @param column
     * @return Density of selected cell.
     */
    public double getDensity(int row, int column) {
        return densityGrid[row][column];
    }

    /**
     * calculates all grids, basing on mapGrid.
     */
    public void calculateAll(){
        this.calculateDensities();
        this.calculatePotentials();
    }

    /**
     * Klasa pomocnicza dla liczenia gestosci, moze sie tez przydac gdzie indziej.
     * Przechowuje dwa inty - wiersz i kolumne.
     */
    class Position {

        public Position(int row, int column) {
            this.row = row;
            this.column = column;
        }
        public int row, column;

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Position)) {
                return false;
            }

            Position pos = (Position) obj;
            return row == pos.row && column == pos.column;
        }

        @Override
        public int hashCode() {
            return row * 100000 + column;
        }

        @Override
        public String toString() {
            return String.format("(%d,%d)", row, column);
        }
    }
}
