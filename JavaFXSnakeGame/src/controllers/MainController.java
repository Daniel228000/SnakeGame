package controllers;

import core.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.awt.event.ActionEvent;

public class MainController{

    public Field field;
    private int time;
    private Food food;
    private Snake snake;
    public Game game;
    public GraphicsContext gc;
    public GridPane gridPane;
    private Timeline timeLine;
    Drawer drawer;

    public void timerOfMoving(){
        time = 300;
        timeLine = new Timeline(new KeyFrame(Duration.millis(time), this::doStep));
    }

    private void doStep(javafx.event.ActionEvent event) {
        game.tick();
        switch(game.status) {
            case -1:
                gameOver();
                break;
            case 0:
                break;
        }
        drawer.drawSnake(snake.getDirection(), gc);
        drawer.drawObjects(gc);
    }



    public void KeyPressed(KeyEvent k) {
        switch (k.getCode()) {
            case A:
            case LEFT: {
                snake.setDirection(Snake.Direction.LEFT);
                break;
            }
            case D:
            case RIGHT: {
                snake.setDirection(Snake.Direction.RIGHT);
                break;
            }
            case S:
            case DOWN: {
                snake.setDirection(Snake.Direction.DOWN);
                break;
            }
            case W:
            case UP: {
                snake.setDirection(Snake.Direction.UP);
                break;
            }
            case ESCAPE: {
                System.exit(0);
            }
        }
    }

    public void drawScene() {
        drawer = new Drawer(game);
        drawer.drawSnake(snake.getDirection(), gc);
        drawer.drawObjects(gc);
        gridPane.setFocusTraversable(true);
        timeLine.setCycleCount(Animation.INDEFINITE);
        timeLine.play();
    }

    private void gameOver() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Snake");
        alert.setHeaderText("GAME OVER");
        alert.show();
    }
    public void setGame(Game game) {
        this.game = game;
    }
}