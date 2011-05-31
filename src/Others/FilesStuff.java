/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Others;

import Basic.Grid;
import java.io.File;

/**
 *
 * @author DSidor
 */
public class FilesStuff {

    /**
     * Opens file.
     * @param file
     * @return grid which is written in file.
     */
    public static Grid openGrid(File file){
        Grid grid= new Grid(0,0);

        grid.calculateAll();
        return grid;
    }

    /**
     * Saves map grid in file.
     * @param file
     */
    public static void saveGrid(Grid grid, File file){
        
    }
}
