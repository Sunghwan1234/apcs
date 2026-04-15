package lab.lab.lab6_6p2_GOL;

public class Cell implements CellTemplate {
  private int row, col;
  private boolean alive=false;

  public Cell(int row, int col) {
    this.row=row;
    this.col=col;
  }

  @Override
  public int getRow() {
    return row;
  }

  @Override
  public int getCol() {
    return col;
  }
  @Override
  public boolean isAlive() {
    return alive;
  }

  @Override
  public void setAlive(boolean alive) {
    this.alive = alive;
  }

  @Override
  public boolean shouldLive(Cell[][] cells) {
    int neighbors = 0;
    for (int r=this.row-1; r<=this.row+1; r++) {
      for (int c=this.col-1; c<=this.col+1; c++) {
        if (r<0||r>=cells.length||c<0||c>=cells[r].length) {
          continue;
        }
        if (r==row && c==col) {continue;}
        neighbors+=cells[r][c].isAlive()?1:0;
      }
    }

    if (isAlive()) {
      return neighbors>=2 && neighbors<=3;
    } else {
      return neighbors==3;
    }
  }

  
  
}
