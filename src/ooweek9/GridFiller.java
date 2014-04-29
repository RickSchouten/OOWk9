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
    	colorTable = new ColorTable (514);
        this.grid = grid;
    }

    /**
     * fills the whole grid with some arbitrarily chosen color
     * 
     */
    public void fill (double xmid, double ymid, double xwidth, double ywidth) {
        double gridw = grid.getWidth(), gridh = grid.getHeight();
        double xscale = xwidth/gridw, yscale = ywidth/gridh, xstart = xmid - xwidth/2, ystart = ymid + ywidth/2;
        for (int i = 0; i < gridw; i++) {
            for (int j = 0; j < gridh; j++) {
                double a = xstart + i*xscale;
                double b = ystart - j*yscale;
                grid.setPixel(i, j, colorTable.getColor(mandelNumber(a, b)));
            }               
        }
    }
    
    private int mandelNumber(double a, double b){
        int mandel = 0;
        double x = a, y = b;
        while(x*x + y*y <= 4 && mandel <= 1024){
            double xnext = x*x - y*y + a;
            y = 2*x*y + b;
            x = xnext;
            mandel++;
        }
        if(mandel > 1024)
            mandel = 0;
        return mandel;
    }
    
}
