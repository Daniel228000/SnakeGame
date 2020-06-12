package core;

import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

public class Field {
    public int x, y;
    public Field(int x, int y ) {
    this.x = x;
    this.y = y;
    }
    public int getX(){return x;}
    public int getY(){return y;}
}
