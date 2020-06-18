package core;

import core.Food.Bonus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static core.Food.Bonus.*;

public class Snake {

    private static List<Cell> snake = new ArrayList<>();

    public enum Direction {
        LEFT, RIGHT, UP, DOWN
    }

    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;
    public Snake(int x, int y) {
        Cell snake1 = new Cell(x, y);
        Cell snake2 = new Cell(x + 1, y);
        Cell snake3 = new Cell(x + 2, y);
        snake.add(snake1);
        snake.add(snake2);
        snake.add(snake3);
    }

    public List<Cell> getSnake() {
        return snake;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction newDirection) {
        if( snake.size() > 1) {
            switch (this.direction) {
                case LEFT:
                case RIGHT:
                    if (snake.get(0).x == snake.get(1).x) return;
                    break;
                case UP:
                case DOWN:
                    if (snake.get(0).y == snake.get(1).y) return;
                    break;
            }
        }
            else switch (this.direction) {
                case LEFT:
                case RIGHT:
                case UP:
                case DOWN:
            }
            direction = newDirection;
        }



    public Cell newHead() {
        Cell head = new Cell(-1, -1);
        switch(direction) {
            case LEFT:
                head = new Cell(snake.get(0).x - 1, snake.get(0).y);
                break;
            case RIGHT:
                head = new Cell(snake.get(0).x + 1, snake.get(0).y);
                break;
            case UP:
                head = new Cell(snake.get(0).x, snake.get(0).y - 1);
                break;
            case DOWN:
                head = new Cell(snake.get(0).x, snake.get(0).y + 1);
                break;
        }
        return head;
    }
    public void removeTail() {
        snake.remove(snake.size() - 1);
    }
    public boolean intersect(Cell other) {
        for (Cell segment: snake) {
            if (other.x == segment.x & other.y == segment.y) {
                return true;
            }
        }
        return false;
    }

    public void move(Food food, Field field) throws InterruptedException {
        Cell newHead = newHead();
        if (isOutOfField(newHead, field)) {
            if (Game.bonusList.contains(EXTRA_LIFE)){
                Thread.sleep(1);
            }else {
                isAlive = false;
                snake.clear();

            }
        } else {
            if (intersect(newHead)) {
                if (!Game.bonusList.contains(INVISIBILITY)) {
                    isAlive = false;
                }
            }
              else if (newHead.x == food.getX() && newHead.y == food.getY()) {
                food.setStatus(false);
                snake.add(0, newHead);


                 }
             else
                snake.add(0, newHead);

                removeTail();
            }
        }

    public boolean isOutOfField(Cell newHead, Field field) {
        return newHead.x >= field.getX() - 1 || newHead.x < 1 || newHead.y < 1 || newHead.y >= field.getY() - 1;
    }
}
