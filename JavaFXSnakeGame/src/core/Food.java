package core;

public class Food extends Cell {

    public boolean isAlive = true;
    public int x,y;

    public Food(int x, int y) {
        super(x, y);
    }
    public Food(){ }
    public int getX(){
        return x;
    }
    public int getY() {
        return y;
    }
    public Food newFood() {
        return new Food((int) Math.random(), (int) Math.random());
    }
}
