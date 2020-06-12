package core;



public class Game {
    public Field field;
    private Food food;
    private Snake snake;
    public int status = 0;


    public Game(Field field) {
        this.field = field;
        snake = new Snake(field.getX() / 2, field.getY() / 2);
        food = newFood();
    }

    public Food newFood() {
        Food newFood = new Food().newFood();
        while (snake.intersect(newFood)) {
            newFood = new Food().newFood();
        }
        return newFood;
    }

    public void tick() {
        snake.move(food, field);
        if (!food.isAlive) {
            food = newFood();
        }
        checkStatus();
    }

    public void checkStatus() {
        if (!snake.isAlive) {
            status = -1;
        }
    }
}