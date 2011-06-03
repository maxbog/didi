/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Basic;

import Basic.Grid.Position;
import GUI.GridPanel;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 *
 * @author JKW
 */
public class Simulation{

    private Grid startGrid;
    private Grid simGrid;
    private double transitionCoef=1.0;  // wspolczynnik w z reguly1
    private Queue<PersonPosition> peopleToProcess;
    private int time;
    private GridPanel gridPanel;
    private Random random = new Random();

    public Simulation() {
        simGrid = new Grid(0, 0);
        startGrid = new Grid(0, 0);
    }

    /**
     * Regula przejscia dla spokojnego czlowieka. Zwraca nowa pozycje lub taka sama, jesli nie ma mozliwosci wykonania ruchu
     * @param row
     * @param column
     * @return nastepna pozycja, ktora zajmuje człowiek
     */
    public Position transitionRule1(int row, int column) {

        double thisCellCost, tempCost;
        thisCellCost = Double.POSITIVE_INFINITY;//transitionCoef * (simGrid.getPotential(row, column))[0] + (1 - transitionCoef) * simGrid.getAverageExitDens(0); // tu nie halo!
        for (int i = 1; i <= simGrid.getExitsCount(); ++i) {
            tempCost = transitionCoef * (simGrid.getPotential(row, column))[i] + (1 - transitionCoef) * simGrid.getAverageExitDens(i - 1);
            if (tempCost < thisCellCost) {
                thisCellCost = tempCost;
            }
        }

        Position[] Positions = new Position[8];
        Positions[0] = new Position(row + 1, column - 1); // leftTop
        Positions[1] = new Position(row + 1, column); // middleTop
        Positions[2] = new Position(row + 1, column + 1); // rightTop
        Positions[3] = new Position(row, column - 1); //leftMiddle
        Positions[4] = new Position(row, column + 1); //rightMiddle
        Positions[5] = new Position(row - 1, column - 1); //leftBottom
        Positions[6] = new Position(row - 1, column); //middleBottom
        Positions[7] = new Position(row - 1, column + 1); //rightBottom

        double[] minCellCost = new double[8];
        double minCost;

        for (int i = 0; i < 8; ++i) {

            if ((Positions[i].row >= 0 && Positions[i].row < simGrid.getRowsNumber())
                    && (Positions[i].column >= 0) && Positions[i].column < simGrid.getColumnsNumber()) {
                if(simGrid.getMapCell(Positions[i].row, Positions[i].column) == Grid.EXIT) {
                    return Positions[i];
                }
                 if(simGrid.getMapCell(Positions[i].row, Positions[i].column) == Grid.EMPTY) {

                    minCost = Double.POSITIVE_INFINITY;//transitionCoef * (simGrid.getPotential(Positions[i].row, Positions[i].column))[1] + (1 - transitionCoef) * simGrid.getAverageExitDens(0);
                    for (int j = 1; j <= simGrid.getExitsCount(); ++j) {
                        tempCost = transitionCoef * (simGrid.getPotential(Positions[i].row, Positions[i].column))[j] + (1 - transitionCoef) * simGrid.getAverageExitDens(j - 1);
                        if (tempCost < minCost && tempCost <= thisCellCost) {
                            minCost = tempCost;
                        }
                    }
                    minCellCost[i] = minCost;
                }else {
                minCellCost[i] = java.lang.Double.POSITIVE_INFINITY;}

            } else {
                minCellCost[i] = java.lang.Double.POSITIVE_INFINITY;
            }
        }
        Position newPosition = new Position(row, column);
        minCost = Double.POSITIVE_INFINITY;//minCellCost[0];
        for (int i = 0; i < 8; ++i) {
            if (minCellCost[i] < minCost) {
                minCost = minCellCost[i];
            }
        }
        if(minCost == Double.POSITIVE_INFINITY)
            return new Position(row, column);
        LinkedList<Position> equalMinPos = new LinkedList<Position>();
        for (int i = 0; i < 8; i++){
            if(minCellCost[i]==minCost){
                equalMinPos.add(Positions[i]);
            }
        }
        newPosition = equalMinPos.get(random.nextInt(equalMinPos.size()));
        return newPosition;
    }
    
     /**
     * Regula przejscia dla człowieka mocno spanikowanego. Zwraca nowa pozycje lub taka sama, jesli nie ma mozliwosci wykonania ruchu
     * @param row
     * @param column
     * @return nastepna pozycja, ktora zajmuje człowiek
     */
 
    public Position transitionRule3(int row, int column) {

        int pot, tempPot, id = -1;
        int exitId[] = new int[2];
        for (int i = 0; i < 2; ++i) {
            pot = Integer.MAX_VALUE;
            for (int j = 1; j <= simGrid.getExitsCount(); ++j) {
                tempPot = simGrid.getPotential(row, column)[j];
                if (tempPot < pot && j != id) {
                    pot = tempPot;
                    exitId[i] = j;
                    id = j;
                }
            }
        }

        if (simGrid.getAverageExitDens(exitId[0]-1) <= simGrid.getAverageExitDens(exitId[1]-1)) {
            id = exitId[0];
        } else {
            id = exitId[1];
        }

        Position[] Positions = new Position[8];
        Positions[0] = new Position(row + 1, column - 1); // leftTop
        Positions[1] = new Position(row + 1, column); // middleTop
        Positions[2] = new Position(row + 1, column + 1); // rightTop
        Positions[3] = new Position(row, column - 1); //leftMiddle
        Positions[4] = new Position(row, column + 1); //rightMiddle
        Positions[5] = new Position(row - 1, column - 1); //leftBottom
        Positions[6] = new Position(row - 1, column); //middleBottom
        Positions[7] = new Position(row - 1, column + 1); //rightBottom

        int minPot = Integer.MAX_VALUE;
        int minCellPot[] = new int[8];
        
        for (int i = 0; i < 8; ++i) {
            if ((Positions[i].row >= 0 && Positions[i].row < simGrid.getRowsNumber())
                    && (Positions[i].column >= 0) && Positions[i].column < simGrid.getColumnsNumber()) {
                if (simGrid.getMapCell(Positions[i].row, Positions[i].column) == Grid.EXIT) {
                    return Positions[i];
                }
                if (simGrid.getMapCell(Positions[i].row, Positions[i].column) == Grid.EMPTY) {
                    tempPot = simGrid.getPotential(Positions[i].row, Positions[i].column)[id];
                    if (tempPot < minPot) {
                        minPot = tempPot;
                    }
                }

                minCellPot[i] = minPot;
            } else {
                minCellPot[i] = Integer.MAX_VALUE;
            }
        }
        
        Position newPosition = new Position(row, column);
        if (minPot == Integer.MAX_VALUE) {
            return new Position(row, column);
        }

        LinkedList<Position> equalMinPos = new LinkedList<Position>();
        for (int i = 0; i < 8; i++) {
            if (minCellPot[i] == minPot) {
                equalMinPos.add(Positions[i]);
            }
        }
        newPosition = equalMinPos.get(random.nextInt(equalMinPos.size()));
        return newPosition;

    }
    
        /**
     * Regula przejscia dla człowieka totalnie spanikowanego. Zwraca nowa pozycje lub taka sama, jesli nie ma mozliwosci wykonania ruchu
     * @param row
     * @param column
     * @return nastepna pozycja, ktora zajmuje człowiek
     */
    
    public Position transitionRule4(int row, int column) {

        Position[] Positions = new Position[8];
        Positions[0] = new Position(row + 1, column - 1); // leftTop
        Positions[1] = new Position(row + 1, column); // middleTop
        Positions[2] = new Position(row + 1, column + 1); // rightTop
        Positions[3] = new Position(row, column - 1); //leftMiddle
        Positions[4] = new Position(row, column + 1); //rightMiddle
        Positions[5] = new Position(row - 1, column - 1); //leftBottom
        Positions[6] = new Position(row - 1, column); //middleBottom
        Positions[7] = new Position(row - 1, column + 1); //rightBottom

        LinkedList<Position> newPos = new LinkedList<Position>();
        for (int i = 0; i < 8; i++) {
            if ((Positions[i].row >= 0 && Positions[i].row < simGrid.getRowsNumber())
                    && (Positions[i].column >= 0) && Positions[i].column < simGrid.getColumnsNumber()) {
                if (simGrid.getMapCell(Positions[i].row, Positions[i].column) == Grid.EXIT) {
                    return Positions[i];
                }
                if (simGrid.getMapCell(Positions[i].row, Positions[i].column) == Grid.EMPTY) {
                    newPos.add(Positions[i]);
                }
            }
        }
        
        if (newPos.isEmpty())
            return new Position(row, column);
        Position newPosition = newPos.get(random.nextInt(newPos.size()));
        return newPosition;

    }
     

    public void step() {
        peopleToProcess = new PriorityQueue<PersonPosition>();
        for (Position pos : simGrid.identifyPeople()) {
            peopleToProcess.add(new PersonPosition(simGrid.getMapCell(pos.row, pos.column), pos, time));
        }
        while (!peopleToProcess.isEmpty()) {
            PersonPosition current = peopleToProcess.poll();
            Position newPosition = current.pos;
            int panic = getSimGrid().getMapCell(current.pos.row, current.pos.column);
            if(panic > 76) {
                newPosition = transitionRule4(current.pos.row, current.pos.column);
            } else if(panic > 50) {
                newPosition = transitionRule3(current.pos.row, current.pos.column);
            } else if (panic > 25) {
                //newPosition = transitionRule2(current.pos.row, current.pos.column);
            } else {
                newPosition = transitionRule1(current.pos.row, current.pos.column);
            }
            if (!newPosition.equals(current.pos)) {
                if(simGrid.getMapCell(newPosition.row, newPosition.column) == Grid.EXIT)
                    simGrid.setMapCell(current.pos.row, current.pos.column, Grid.EMPTY);
                if (simGrid.getMapCell(newPosition.row, newPosition.column) == Grid.EMPTY) {
                    simGrid.setMapCell(newPosition.row, newPosition.column, simGrid.getMapCell(current.pos.row, current.pos.column));
                    simGrid.setMapCell(current.pos.row, current.pos.column, Grid.EMPTY);
                }
            }
            ++time;
        }
        gridPanel.repaintGrid();
    }

    private static class PersonPosition implements Comparable<PersonPosition> {

        public PersonPosition(int potential, Position pos, int time) {
            this.potential = potential;
            this.pos = pos;
        }
        public int potential;
        public Position pos;
        public int time;

        public int compareTo(PersonPosition o) {
            if (potential != o.potential) {
                return potential - o.potential;
            }
            return time - o.time;
        }
    }

    public Grid getSimGrid() {
        return simGrid;
    }

    public Grid getStartGrid() {
        return startGrid;
    }

    public void setGrid(Grid newGrid) {
        startGrid = new Grid(newGrid);
        simGrid = newGrid;
        gridPanel.setGrid(simGrid);
    }

    public void setGridPanel(GridPanel panel) {
        gridPanel = panel;
    }

    public void resetMap(){
        simGrid = new Grid(startGrid);
        gridPanel.setGrid(simGrid);
    }
}
