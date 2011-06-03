/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
    public static final int OBSTACLE = -4;
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
    private double[][][] bottleneckGrid;
    private List<Set<Position>> exits;
    private int maxPotential;

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

    public Grid(Grid other) {
        setSize(other.rowsNumber, other.columnsNumber);
        for (int row = 0; row < rowsNumber; ++row) {
            for (int column = 0; column < columnsNumber; ++column) {
                mapGrid[row][column] = other.mapGrid[row][column];
            }
        }
        calculateAll();
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

    @Override
    public Grid clone() {
        Grid newGrid = new Grid(this.rowsNumber, this.columnsNumber);
        for (int i = 0; i < this.rowsNumber; i++) {
            for (int j = 0; j < this.columnsNumber; j++) {
                newGrid.setMapCell(i, j, this.mapGrid[i][j]);
            }
        }
        return newGrid;
    }

    /**
     * Method sets new size of grid. It does not forgot values of old grid.
     * @param rows
     * @param columns
     */
    public final void setSize(int rows, int columns) {
        int[][] temp = new int[rows][columns];
        potentialGrid = new int[rows][columns][1];
        densityGrid = new double[rows][columns];
        bottleneckGrid = new double[rows][columns][1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i < rowsNumber && j < columnsNumber) {
                    temp[i][j] = mapGrid[i][j];
                } else {
                    temp[i][j] = Grid.EMPTY;
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
        calculateNeighbourDensities(x, y);
    }

    /***************PotentialGridFunctions***************/
    /**
     * Calculates potentials of cells (distaces to exits).
     */
    public void calculatePotentials() {
        maxPotential = 0;
        for (int i = 0; i < getExitsCount(); ++i) {
            calculatePotential(i);
        }
        for (int row = 0; row < getRowsNumber(); ++row) {
            for (int column = 0; column < getColumnsNumber(); ++column) {
                for (int exit = 1; exit < exits.size() + 1; ++exit) {
                    if (potentialGrid[row][column][0] > potentialGrid[row][column][exit]) {
                        potentialGrid[row][column][0] = potentialGrid[row][column][exit];
                    }
                }
            }
        }
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

    /**
     * Wyszukuje na mapie wszystkie wyjscia ewakuacyjne
     */
    public void identifyExits() {
        exits = new ArrayList<Set<Position>>();
        Set<Position> processed = new HashSet<Position>();
        for (int row = 0; row < getRowsNumber(); ++row) {
            for (int column = 0; column < getColumnsNumber(); ++column) {
                if (mapGrid[row][column] == Grid.EXIT && !processed.contains(new Position(row, column))) {
                    exits.add(identifyExit(new Position(row, column), processed));
                }
            }
        }
        potentialGrid = new int[getRowsNumber()][getColumnsNumber()][exits.size() + 1];
        for (int row = 0; row < getRowsNumber(); ++row) {
            for (int column = 0; column < getColumnsNumber(); ++column) {
                for (int exit = 0; exit < exits.size() + 1; ++exit) {
                    potentialGrid[row][column][exit] = Integer.MAX_VALUE;
                }
            }
        }
    }

    /**
     *
     * @return ilosc wyjsc ewakuacyjnych znajdujacych sie na mapie
     */
    public int getExitsCount() {
        return exits.size();
    }

    /**
     * Zwraca zbior komorek, z ktorych sklada sie konkretne wyjscie
     * @param exit wyjscie, o ktore pytamy
     * @return zbior komorek, z ktorych sklada sie wyjscie
     */
    public Set<Position> getExit(int exit) {
        return exits.get(exit);
    }

    /**
     * Usrednia zatloczenie wyjscia - potrzebne do reguly przejscia, chyba, ze wymyslimy jakos inaczej ;]
     * @param exit wyjscie, o ktore pytamy
     * @return srednie zatloczenia
     */
    public double getAverageExitDens(int exit) {
        double avDens = 0;
        for (Position pos : getExit(exit)) {
            avDens = avDens + getDensity(pos.row, pos.column);
        }
        avDens = avDens / getExit(exit).size();
        return avDens;
    }

    /**
     *
     * @return najwiekszy potencjal znajdujacy sie na mapie
     */
    public int getMaxPotential() {
        return maxPotential;
    }

    private Set<Position> identifyExit(Position position, Set<Position> processed) {
        Queue<Position> toProcess = new LinkedList<Position>();
        HashSet<Position> inExit = new HashSet<Position>();
        toProcess.add(position);
        while (!toProcess.isEmpty()) {
            Position current = toProcess.poll();
            processed.add(current);

            inExit.add(current);

            final Position left = new Position(current.row, current.column - 1);
            final Position right = new Position(current.row, current.column + 1);
            final Position up = new Position(current.row - 1, current.column);
            final Position down = new Position(current.row + 1, current.column);

            if (shouldProcessExit(left, processed)) {
                toProcess.add(left);
            }
            if (shouldProcessExit(right, processed)) {
                toProcess.add(right);
            }
            if (shouldProcessExit(up, processed)) {
                toProcess.add(up);
            }
            if (shouldProcessExit(down, processed)) {
                toProcess.add(down);
            }
        }
        return inExit;
    }

    private boolean shouldProcessExit(final Position pos, Set<Position> processed) {
        return pos.row >= 0 && pos.row < getRowsNumber()
                && pos.column >= 0 && pos.column < getColumnsNumber()
                && mapGrid[pos.row][pos.column] == Grid.EXIT
                && !processed.contains(pos);
    }

    private void calculatePotential(int exit) {
        Queue<Potential> toProcess = new LinkedList<Potential>();
        HashSet<Position> processed = new HashSet<Position>();
        for (Position exitPos : exits.get(exit)) {
            toProcess.add(new Potential(exitPos, 0));
        }
        while (!toProcess.isEmpty()) {
            Potential current = toProcess.poll();
            if (processed.contains(current.pos)) {
                continue;
            }
            processed.add(current.pos);

            potentialGrid[current.pos.row][current.pos.column][exit + 1] = current.dist;
            if (current.dist > maxPotential) {
                maxPotential = current.dist;
            }

            final Potential left = new Potential(new Position(current.pos.row, current.pos.column - 1), current.dist + 1);
            final Potential right = new Potential(new Position(current.pos.row, current.pos.column + 1), current.dist + 1);
            final Potential up = new Potential(new Position(current.pos.row - 1, current.pos.column), current.dist + 1);
            final Potential down = new Potential(new Position(current.pos.row + 1, current.pos.column), current.dist + 1);
            final Potential upleft = new Potential(new Position(current.pos.row - 1, current.pos.column - 1), current.dist + 1);
            final Potential upright = new Potential(new Position(current.pos.row - 1, current.pos.column + 1), current.dist + 1);
            final Potential downleft = new Potential(new Position(current.pos.row + 1, current.pos.column - 1), current.dist + 1);
            final Potential downright = new Potential(new Position(current.pos.row + 1, current.pos.column + 1), current.dist + 1);

            if (shouldProcessPotential(left, exit)) {
                toProcess.add(left);
            }
            if (shouldProcessPotential(right, exit)) {
                toProcess.add(right);
            }
            if (shouldProcessPotential(up, exit)) {
                toProcess.add(up);
            }
            if (shouldProcessPotential(down, exit)) {
                toProcess.add(down);
            }

            if (!(isWall(up.pos) && isWall(left.pos)) && shouldProcessPotential(upleft, exit)) {
                toProcess.add(upleft);
            }
            if (!(isWall(up.pos) && isWall(right.pos)) && shouldProcessPotential(upright, exit)) {
                toProcess.add(upright);
            }
            if (!(isWall(down.pos) && isWall(left.pos)) && shouldProcessPotential(downleft, exit)) {
                toProcess.add(downleft);
            }
            if (!(isWall(down.pos) && isWall(right.pos)) && shouldProcessPotential(downright, exit)) {
                toProcess.add(downright);
            }
        }
    }

    private boolean shouldProcessPotential(final Potential pot, int exit) {
        return pot.pos.row >= 0 && pot.pos.row < getRowsNumber()
                && pot.pos.column >= 0 && pot.pos.column < getColumnsNumber()
                && mapGrid[pot.pos.row][pot.pos.column] != Grid.EXIT
                && mapGrid[pot.pos.row][pot.pos.column] != Grid.OBSTACLE
                && mapGrid[pot.pos.row][pot.pos.column] != Grid.WALL
                && pot.dist < potentialGrid[pot.pos.row][pot.pos.column][exit + 1];
    }

    private boolean isWall(final Position pos) {
        return pos.row >= 0 && pos.row < getRowsNumber()
                && pos.column >= 0 && pos.column < getColumnsNumber()
                && (mapGrid[pos.row][pos.column] == Grid.WALL
                || mapGrid[pos.row][pos.column] == Grid.OBSTACLE);
    }

    /***************DensityGridFunctions***************/
    /**
     * Calculates density of each cell.
     */
    public void calculateDensities() {
        for (int row = 0; row < getRowsNumber(); row++) {
            for (int column = 0; column < getColumnsNumber(); column++) {
                densityGrid[row][column] = 0;
            }
        }
        for (int row = 0; row < getRowsNumber(); ++row) {
            for (int column = 0; column < getColumnsNumber(); ++column) {
                if (mapGrid[row][column] != Grid.WALL && mapGrid[row][column] != Grid.OBSTACLE) {
                    calculateDensity(row, column);
                }
            }
        }
    }

    /**
     * Przelicza gestosc dla komorek sasiadujacych z dana
     * @param row wiersz komorki danej
     * @param column kolumna komorki danej
     */
    private void calculateNeighbourDensities(int row, int column) {
        Queue<Position> toProcess = new LinkedList<Position>();
        Set<Position> processed = new HashSet<Position>();
        toProcess.add(new Position(row, column));
        while (!toProcess.isEmpty()) {
            Position current = toProcess.poll();
            if (processed.contains(current)) {
                continue;
            }
            processed.add(current);

            calculateDensity(current.row, current.column);

            final Position left = new Position(current.row, current.column - 1);
            final Position right = new Position(current.row, current.column + 1);
            final Position up = new Position(current.row - 1, current.column);
            final Position down = new Position(current.row + 1, current.column);

            if (shouldBeProcessed(left, row, column)) {
                toProcess.add(left);
            }
            if (shouldBeProcessed(right, row, column)) {
                toProcess.add(right);
            }
            if (shouldBeProcessed(up, row, column)) {
                toProcess.add(up);
            }
            if (shouldBeProcessed(down, row, column)) {
                toProcess.add(down);
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
        int all = 0, occupied = 0;
        toProcess.add(new Position(row, column));
        while (!toProcess.isEmpty()) {
            Position current = toProcess.poll();
            if (processed.contains(current)) {
                continue;
            }
            processed.add(current);

            ++all;
            if (mapGrid[current.row][current.column] > 0) {
                ++occupied;
            }

            final Position left = new Position(current.row, current.column - 1);
            final Position right = new Position(current.row, current.column + 1);
            final Position up = new Position(current.row - 1, current.column);
            final Position down = new Position(current.row + 1, current.column);

            if (shouldBeProcessed(left, row, column)) {
                toProcess.add(left);
            }
            if (shouldBeProcessed(right, row, column)) {
                toProcess.add(right);
            }
            if (shouldBeProcessed(up, row, column)) {
                toProcess.add(up);
            }
            if (shouldBeProcessed(down, row, column)) {
                toProcess.add(down);
            }
        }
        if (all != 0) {
            densityGrid[row][column] = (double) occupied / (double) all;
        }
    }

    private boolean shouldBeProcessed(Position current, int row, int column) {
        // upewniamy sie zeby nie wyjsc poza tablice
        if (current.row < 0 || current.row >= getRowsNumber() || current.column < 0 || current.column >= getColumnsNumber()) {
            return false;
        }
        // omijamy sciany
        if (mapGrid[current.row][current.column] == Grid.WALL || mapGrid[current.row][current.column] == Grid.OBSTACLE) {
            return false;
        }
        // czy miescimy sie w metryce
        int dRow = current.row - row;
        int dColumn = current.column - column;
        if (dRow * dRow + dColumn * dColumn > Grid.FLOOD_RADIUS * Grid.FLOOD_RADIUS) {
            return false;
        }
        return true;
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
    public void calculateAll() {
        this.calculateDensities();
        this.identifyExits();
        this.calculatePotentials();
    }

    /* Bottleneck functions */
    public void calculateBottleNecks() {
        for (int i = 0; i < this.getRowsNumber(); i++) {
            for (int j = 0; j < this.getColumnsNumber(); j++) {
                if (!this.isWall(new Position(i, j))) {
                    bottleneckGrid[i][j] = this.calculateBottleNeck(i, j);
                }
            }
        }
    }

    public double[] calculateBottleNeck(int row, int column) {
        final Position[] Positions = new Position[8];
        Positions[0] = new Position(row + 1, column - 1); // leftTop =
        Positions[1] = new Position(row + 1, column); // middleTop
        Positions[2] = new Position(row + 1, column + 1); // rightTop
        Positions[3] = new Position(row, column - 1); //leftMiddle
        Positions[4] = new Position(row, column + 1); //rightMiddle
        Positions[5] = new Position(row - 1, column - 1); //leftBottom
        Positions[6] = new Position(row - 1, column); //middleBottom
        Positions[7] = new Position(row - 1, column + 1); //rightBottom

        int[] treshold = this.getPotential(row, column);
        double[] coefs = new double[this.getExitsCount()];

        for (int i = 0; i < this.getExitsCount(); i++) {
            //System.out.println("Treshold: "+treshold[i]);
            int M = 0;
            int N = 0;
            for (int j = 0; j < Positions.length; j++) {

                if (!this.isWall(Positions[j])) {
                    //System.out.println("Potential: "+this.getPotential(Positions[j].row,Positions[j].column)[i]);
                    if ((Positions[j].row > 0) && (Positions[j].column > 0)
                            && (Positions[j].row < this.getRowsNumber()) && (Positions[j].column < this.getColumnsNumber())) {
                        if (this.getPotential(Positions[j].row, Positions[j].column)[i] != treshold[i]) {
                            if (this.getPotential(Positions[j].row, Positions[j].column)[i] > treshold[i]) {
                                N++;
                            } else {
                                M++;
                            }
                        }
                    }
                }
            }
            if (N > M && N != 0) {
                coefs[i] = 1 - (double) M / ((double) N);
            } else if (N == 0) {
                coefs[i] = 0;
            } else {
                coefs[i] = 0;
            }
            //System.out.println(coefs[i]+" "+M+" "+N);
        }
        return coefs;
    }

    public double[] getBottleNeck(int row, int column) {
        return bottleneckGrid[row][column];
    }

    public Set<Position> identifyPeople() {
        Set<Position> people = new HashSet<Position>();
        for (int row = 0; row < getRowsNumber(); ++row) {
            for (int column = 0; column < getColumnsNumber(); ++column) {
                if (mapGrid[row][column] > 0) {
                    people.add(new Position(row, column));
                }
            }
        }
        return people;
    }

    public void updatePanicLevels() {
        for (Position person : identifyPeople()) {
            int count = 1, sum = getMapCell(person.row, person.column);
            final Position[] positions = new Position[8];
            positions[0] = new Position(person.row + 1, person.column - 1); // leftTop
            positions[1] = new Position(person.row + 1, person.column); // middleTop
            positions[2] = new Position(person.row + 1, person.column + 1); // rightTop
            positions[3] = new Position(person.row, person.column - 1); //leftMiddle
            positions[4] = new Position(person.row, person.column + 1); //rightMiddle
            positions[5] = new Position(person.row - 1, person.column - 1); //leftBottom
            positions[6] = new Position(person.row - 1, person.column); //middleBottom
            positions[7] = new Position(person.row - 1, person.column + 1); //rightBottom
            for (int i = 0; i < positions.length; ++i) {
                if (positions[i].row >= 0 && positions[i].row < getRowsNumber()
                        && positions[i].column >= 0 && positions[i].column < getColumnsNumber()
                        && getMapCell(positions[i].row, positions[i].column) > 0) {
                    ++count;
                    sum += getMapCell(positions[i].row, positions[i].column);
                }
            }
            setMapCell(person.row, person.column, sum / count);
        }
    }

    /* ###  ###*/
    /**
     * Klasa pomocnicza reprezentujaca pozycje na mapie.
     * Przechowuje dwa inty - wiersz i kolumne.
     */
    public static class Position {

        /**
         * Tworzy nowa pozycje
         * @param row wiersz
         * @param column kolumna
         */
        public Position(int row, int column) {
            this.row = row;
            this.column = column;
        }
        /**
         * Wiersz
         */
        public int row;
        /**
         * kolumna
         */
        public int column;

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

    private class Potential {

        public Potential(Position pos, int dist) {
            this.pos = pos;
            this.dist = dist;
        }
        public Position pos;
        public int dist;

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Potential)) {
                return false;
            }

            Potential pot = (Potential) obj;
            return dist == pot.dist && pos == pot.pos;
        }

        @Override
        public int hashCode() {
            return pos.hashCode() ^ dist;
        }

        @Override
        public String toString() {
            return String.format("(%d,%d,%d)", pos.row, pos.column, dist);
        }
    }
}
