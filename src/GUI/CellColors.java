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
    public static Color getMapColor(int number){
        switch (number){
            case 0: return Color.WHITE;
            case -1: return Color.BLACK;
            case -2: return Color.GREEN;
            case 1: return Color.RED;
            default: return Color.YELLOW;
        }
    }

    public static Color getPotentialColor(int number, int maxValue){
        int colorIndex = number*360/maxValue;
        return Color.WHITE;
    }

    public static Color getDensityColor(double number){
        return Color.getHSBColor((1-(float)number)*2f/3f, 0.9f, 1f);
    }
}
