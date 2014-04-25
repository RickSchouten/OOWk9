package ooweek9;

/**
 *
 * @author Sjaak Smetsers
** @version 1.0, 13-03-2013
 */

/**
 * A skelton class illustrating the use of the grid interface
 * 
 */
public class GridFiller {
    private Grid grid;              // the grid to be filled
    private ColorTable colorTable;  // a table for converting indexes to
                                    // rgb values
    
    /**
     * The constructur
     * @param grid to be filled
     */
    public GridFiller (Grid grid) {
    	colorTable = new ColorTable (20); // some random value, needs to be adjusted
        this.grid = grid;
    }

    /**
     * fills the whole grid with some arbitrarily chosen color
     * 
     */
    public void fill () {
        int grid_w = grid.getWidth(), grid_h = grid.getHeight();
        for (int i = 0; i < grid_w; i++) {
            for (int j = 0; j < grid_h; j++) {
                int color_index = i/5 * grid_w/5 + j/5;
                grid.setPixel(i, j, colorTable.getColor(color_index));
            }               
        }
    }
}
