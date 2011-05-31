/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Others;

import Basic.Grid;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

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
    public static Grid openGrid(File file) {
        Grid grid = null;
        try {
            String[] numbers;
            FileReader r = new FileReader(file);
            BufferedReader reader = new BufferedReader(r);
            numbers = reader.readLine().split("#");
            if (numbers.length != 2) {
                return new Grid(0,0);
            }
            grid = new Grid(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
            for (int i = 0; i < grid.getRowsNumber(); i++) {
                if (!reader.ready()) {
                    break;
                }
                numbers = reader.readLine().split("#");
                for (int j = 0; j < grid.getColumnsNumber(); j++) {
                    grid.setMapCell(i, j, Integer.parseInt(numbers[j]));
                }
            }
            r.close();
        } catch (Exception exception) {
            return new Grid(0,0);
        }

        grid.calculateAll();
        return grid;
    }

    /**
     * Saves map grid in file.
     * @param file
     */
    public static void saveGrid(Grid grid, File file) {
        try {
            Writer output = new BufferedWriter(new FileWriter(file));
            output.write(Integer.toString(grid.getRowsNumber()) + "#"
                    + Integer.toString(grid.getColumnsNumber()) + "\n");
            for (int i = 0; i < grid.getRowsNumber(); i++) {
                for (int j = 0; j < grid.getColumnsNumber(); j++) {
                    output.write(Integer.toString(grid.getMapCell(i, j)) + "#");
                }
                output.write("\n");
            }
            output.close();
        } catch (Exception e) {
        }
    }
}
