package core;

import javafx.scene.paint.Color;

import java.util.Random;

public class Food extends Cell {

    private boolean isAlive = true;
    public int x,y;
    private Bonus type = Bonus.NONE;
    private Random random = new Random();
    public Food food;
    public enum Bonus {
        NONE, SPEED_UP, SPEED_DOWN, EXTRA_LIFE, INVISIBILITY, DOUBLE_SCORE
    }

    //public Food(int x, int y) {super(x, y);}
    public Food(int x, int y){
        this.x = x;
        this.y = y;

    }
    public int getX(){
        return x;
    }
    public int getY() {
        return y;
    }
    public Food newFood() {
        food = new Food( random.nextInt(39),  random.nextInt(40));
        while(food.y < 2 || food.x < 2 || food.y > 38 || food.x > 38) food = new Food(random.nextInt(39),  random.nextInt(40)) ;
        return food;
    }
    public void setFoodType (int foodType) {
        switch (foodType) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
                type = Bonus.NONE;
                break;
            case 6:

                type = Bonus.SPEED_UP;
                break;
            case 7:

                type = Bonus.EXTRA_LIFE;
                break;
            case 8:

                type = Bonus.INVISIBILITY;
                break;
            case 9:

                type = Bonus.DOUBLE_SCORE;
                break;
            case 10:

                type = Bonus.SPEED_DOWN;
                break;
        }
    }
    public Bonus getType(){
        return type;
    }
    public boolean isAlive (){return isAlive;}
    public void setStatus(boolean status){this.isAlive = status;}
}
