package core;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Game {
    private Field field;
    private Food food = new Food(-1, -1);
    private Snake snake;
    private List<Cell> snakeParts;
    private Random random = new Random();
    public static List <Food.Bonus> bonusList = new ArrayList<>();
    private List<Cell> cells = new ArrayList<>();
    private int score = 0;


    public Game(Field field) {
        this.field = field;
        snake = new Snake(field.getX() / 2, field.getY() / 2);
        food = food.newFood();
        snakeParts = snake.getSnake();
        bonusList = getBonuses();
        Wall wall = new Wall();
        cells = wall.finalWall();


    }

   public Field getField(){return field;}
   public Food getFood() {return food;}
   public Snake getSnake() {return snake;}
   public List<Cell> getPoints(){
        return cells;
    }
    public void tick() throws InterruptedException {
        snake.move(food, field);

        for (Cell cell : snakeParts) {
                if (pointIntersect(cells, cell.x, cell.y)) snake.isAlive = false;
            }
            if (!food.isAlive()) {
                bonusList.add(food.getType());
                if (bonusList.contains(Food.Bonus.DOUBLE_SCORE)) {
                    setScore(score + 2);
                }
                else setScore(score + 1);
                snakeParts.add(new Cell(food.getX(), food.getY()));
                food = recursiveIntersectForFood(cells);
                food.setFoodType(random.nextInt(10));
            }
        }
    public  boolean isInBonusList(Food.Bonus bonus) {
        for (Food.Bonus bonus1: bonusList){
            if (bonus1 == bonus) return true;
        }
        return false;
    }
    public void deleteBonus(Food.Bonus bonus) {
        bonusList.remove(bonus);
    }

    public Food recursiveIntersectForFood(List<Cell> cells){
        food = food.newFood();
        if (pointIntersect(cells, food.getX(), food.getY())) recursiveIntersectForFood( cells);
        return food;
    }
    public List<Food.Bonus> getBonuses() {
        return bonusList;
    }

    public boolean checkStatus() {
        return (snake.isAlive);
    }
    public int getScore() {return score;}
    public void setScore(int newScore) {
        score = newScore;
    }
    public boolean pointIntersect(List<Cell> cells, int x, int y){
        for (Cell cell: cells) {
            if (cell.getX() == x && cell.getY() == y) return true;
        }
        return false;
    }
}