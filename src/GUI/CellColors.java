/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.Color;

/**
 *
 * @author DSidor
 */
public class CellColors {

    /**
     * gives colors
     * @param number
     * @return color connected to number
     */
    public static Color getColor(int number){
        switch (number){
            case 0: return Color.WHITE;
            case -1: return Color.BLACK;
            case -2: return Color.GREEN;
            case 1: return Color.RED;
            default: return Color.YELLOW;
        }
    }
}
