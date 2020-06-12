package core;

import javafx.geometry.Rectangle2D;

public class Cell  {
    protected int x,y;
    protected boolean isAlive;

    public Cell() {
        isAlive = true;
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        isAlive = true;
    }
    public Rectangle2D getBoundary() {
        return new Rectangle2D(x, y, 25, 25);
    }

    public boolean intersect(Cell other) {
        return this.getBoundary().intersects(other.getBoundary());
    }

}