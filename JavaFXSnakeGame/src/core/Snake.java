package core;

import java.util.ArrayList;
import java.util.List;

public class Snake {

public static List<Cell> snake = new ArrayList<>();
    public enum Direction {
        LEFT, RIGHT, UP, DOWN
    }
public boolean isAlive = true;
private Direction direction = Direction.LEFT;

    public Snake(int x, int y) {
        Cell snake1 = new Cell (x, y);
        Cell snake2 = new Cell (x + 1, y);
        snake.add(snake1);
        snake.add(snake2);
    }
    public List<Cell> getSnake(){
        return snake;

    }
    public Direction getDirection(){
        return direction;
    }
    public void setDirection(Direction newDirection) {
        if (checkDirection(newDirection)) {
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
            direction = newDirection;
        }
    }

    public boolean checkDirection(Direction newDirection) {
        switch (newDirection) {
            case UP:
                if (direction == Direction.DOWN) return true;
            case DOWN:
                if (direction == Direction.UP) return true;
            case LEFT:
                if (direction == Direction.RIGHT) return true;
            case RIGHT:
                if (direction == Direction.LEFT) return true;
        }
        return false;
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
        for (int i = 0; i < snake.size() - 1; i++) {
            if (other.intersect(snake.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void move(Food food, Field field) {
        Cell newHead = newHead();
        if (isOutOfField(newHead, field)) {
            isAlive = false;
        } else {
                if (intersect(newHead)) {
                    isAlive = false;
                    return;
                } else if (newHead.x == food.x & newHead.y == food.y) {
                    food.isAlive = false;
                    snake.add(0, newHead);
                } else
                snake.add(0, newHead);
            }
                removeTail();
            }


    public boolean isOutOfField(Cell newHead, Field field) {
        return newHead.x >= field.getX() || newHead.x < 0 || newHead.y < 0 || newHead.y >= field.getY();
    }
}
