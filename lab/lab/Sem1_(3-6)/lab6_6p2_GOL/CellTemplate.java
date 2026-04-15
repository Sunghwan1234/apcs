package lab.lab.lab6_6p2_GOL;

/**
 * This is the interface that the Cell class should implement.
 */
public interface CellTemplate {
    /**
     * Returns current row
     * 
     * @return row the current row
     */
    public int getRow();

    /**
     * Returns current column
     * 
     * @return col the current column
     */
    public int getCol();

    /**
     * Returns true if this cell is alive;
     * false otherwirse.
     * 
     * @return whether this cell is alive or dead
     */
    public boolean isAlive();

    /**
     * Sets cell's alive status.
     * 
     * @param alive the new status.
     */
    public void setAlive(boolean alive);

    /**
     * This method should consider the rules of Conway's Game of Life. If the cell
     * should live, it returns true, otherwise, false.
     * 
     * @param cells a 2D array of Cell objects.
     * @return true if the cell should live; false otherwise.
     */
    public boolean shouldLive(Cell[][] cells);
}