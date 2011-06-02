/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Basic;

import Basic.Grid;
import Basic.Grid.Position;

/**
 *
 * @author JKW
 */
public class Simulation {
    
    private Grid simGrid;
    private double transitionCoef;  // wspolczynnik w z reguly1
    
    /**
     * Regula przejscia dla spokojnego czlowieka. Zwraca nowa pozycje lub taka sama, jesli nie ma mozliwosci wykonania ruchu
     * @param row
     * @param column
     * @return nastepna pozycja, ktora zajmuje człowiek
     */
    public Position transitionRule1(int row, int column) {
      
        double thisCellCost, tempCost;            
        thisCellCost = transitionCoef * (simGrid.getPotential(row,column))[1] + (1-transitionCoef)*simGrid.getAverageExitDens(0); // tu nie halo!
        for (int i = 2; i <= simGrid.getExitsCount(); ++i) {
            tempCost = transitionCoef * (simGrid.getPotential(row,column))[i] + (1-transitionCoef)*simGrid.getAverageExitDens(i);
            if (tempCost < thisCellCost) thisCellCost = tempCost;        
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
     
        for ( int i=0; i< 8; ++i ) {
            
            if ((Positions[i].row >= 0 && Positions[i].row < simGrid.getRowsNumber()) 
                 && (Positions[i].column >= 0) && Positions[i].column < simGrid.getColumnsNumber() 
                 && simGrid.getMapCell(Positions[i].row, Positions[i].column) == Grid.EMPTY) {       
                
                    minCost = transitionCoef * (simGrid.getPotential(Positions[i].row, Positions[i].column))[1] + (1-transitionCoef)*simGrid.getAverageExitDens(0);
                    for ( int j=1; j<=simGrid.getExitsCount(); ++j ) {
                         tempCost = transitionCoef * (simGrid.getPotential(Positions[i].row, Positions[i].column))[i] + (1-transitionCoef)*simGrid.getAverageExitDens(i);
                    if (tempCost < minCost) minCost = tempCost;
                }
                minCellCost[i] = minCost;
                  
            }
        else minCellCost[i] = java.lang.Double.MAX_VALUE;
        }
        int id=0;
        Position newPosition = new Position(row,column);
        minCost = minCellCost[0];
        for ( int i=1; i<8; ++i ) {
            if ( minCellCost[i] < minCost ) {
                minCost = minCellCost[i];
                id = i;               
            }
            if ( minCost < thisCellCost ) newPosition = Positions[id];
        }
             
        return newPosition;
    }
    
    
    
}
    
