package core;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import view.Main;

import java.util.List;

public class Drawer {
    private Food food;
    private  List<Cell> snake;
    private  Field field;
    private Game game;


    public Drawer(Game game) {
        this.game = game;
    }
    public void drawSnake(Snake.Direction direction, GraphicsContext graphicsContext){
        switch (direction) {
            case RIGHT: {
                Assets.snake_head.setRotate(-90);
                break;
            }
            case DOWN: {
                Assets.snake_head.setRotate(0);
                break;
            }
            case UP: {
                Assets.snake_head.setRotate(180);
                break;
            }
            case LEFT: {
                Assets.snake_head.setRotate(90);
                break;
            }
        }
        graphicsContext.drawImage(Assets.snake_head.snapshot(new SnapshotParameters(), null), snake.get(0).x, snake.get(0).y, Main.PIXEL_SIZE, Main.PIXEL_SIZE);
        for (int i = 1; i <= snake.size() - 1; i++) {
            graphicsContext.drawImage(Assets.snake_body.getImage(), snake.get(i).x, snake.get(i).y, Main.PIXEL_SIZE, Main.PIXEL_SIZE);
        }
    }
    public void drawObjects(GraphicsContext gc) {
        gc.fillRect(field.getX(), field.getY(), Main.PIXEL_SIZE, Main.PIXEL_SIZE);
        gc.fillRect(food.getX(), food.getY(), Main.PIXEL_SIZE, Main.PIXEL_SIZE);
    }




}
