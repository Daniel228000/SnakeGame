package core;

import javafx.geometry.Rectangle2D;

public class Cell  {
    public int x,y;
    protected boolean isAlive;

    public Cell() {
        isAlive = true;
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        isAlive = true;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}