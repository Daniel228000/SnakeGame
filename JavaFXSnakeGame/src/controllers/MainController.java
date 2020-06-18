package controllers;


import core.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;

public class MainController{

    private int time;
    private Game game;
    public GridPane gridPane;
    private Timeline timeLine;
    private Drawer drawer;
    private int timeOfInvisibility = 100;
    private boolean invisibilityIsActive = false;
    private boolean extraLifeIsActive = false;
    private int timeOfDoubleScore = 0;
    private List<Food.Bonus> bonusList;
    private int snakeSize = 0;
    private int number = 0;
    private boolean isDoubleScoreActive = false;


    public void timerOfMoving(){

        time = 100;

        timeLine = new Timeline(new KeyFrame(Duration.millis(time), event -> {
            try {
                game.tick();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setBonusList(game.getBonuses());
           if(game.isInBonusList(Food.Bonus.DOUBLE_SCORE) && !isDoubleScoreActive){
               timeOfDoubleScore = 12000;
               isDoubleScoreActive = true;
           }
           if (timeOfDoubleScore >= 0) timeOfDoubleScore = timeOfDoubleScore - time;
           if (timeOfDoubleScore < 0) {
               game.deleteBonus(Food.Bonus.DOUBLE_SCORE);
               isDoubleScoreActive = false;
           }

            if (number == 0) {
                number = game.getSnake().getSnake().size();
            }
            if (number != 0) {
                if (game.getSnake().getSnake().size() == number + 3) {
                    bonusList.remove(Food.Bonus.EXTRA_LIFE);
                    number = 0;
                }
            }
        if (!invisibilityIsActive) {
            setterOfBonusTime();
            invisibilityIsActive = true;
        }
            boolean isAlive = game.checkStatus();
        if (!isAlive)  { gameOver(); }
            else {
            drawer.drawScene();
            }
            if (timeOfInvisibility >= 0) timeOfInvisibility = timeOfInvisibility - time;
            if (timeOfInvisibility < 0) {
                game.deleteBonus(Food.Bonus.INVISIBILITY);
                invisibilityIsActive = false;
        }

        setGraphicsOnPane();
}
));
    }
public void setterOfBonusTime(){
    if(game.isInBonusList(Food.Bonus.INVISIBILITY)){
        timeOfInvisibility = 9000;
    }
}
    public void setBonusList(List<Food.Bonus> bonusList) {
        this.bonusList = bonusList;
    }

    @FXML
    public void KeyPressed(KeyEvent k) {
        switch (k.getCode()) {
            case A:
            case LEFT: {
                game.getSnake().setDirection(Snake.Direction.LEFT);
                break;
            }
            case D:
            case RIGHT: {
                game.getSnake().setDirection(Snake.Direction.RIGHT);
                break;
            }
            case S:
            case DOWN: {
                game.getSnake().setDirection(Snake.Direction.DOWN);
                break;
            }
            case W:
            case UP: {
                game.getSnake().setDirection(Snake.Direction.UP);
                break;
            }
            case ESCAPE: {
                System.exit(0);
            }
        }
    }
    private void setGraphicsOnPane() {
        gridPane.getChildren().clear();
        ImageView[][] images = drawer.getArrayOfImages();
        for (int y = 0; y < game.getField().getY(); y++) {
            for (int x = 0; x < game.getField().getX() ; x++) {
                gridPane.add(images[x][y], x, y);
            }
        }
    }
    public void drawScene(Game game) {
        drawer = new Drawer(game);
        drawer.drawScene();
        setGraphicsOnPane();
        gridPane.setFocusTraversable(true);
        timeLine.setCycleCount(Animation.INDEFINITE);
        timeLine.play();
    }

    private void gameOver()  {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Snake");
        alert.setHeaderText("GAME OVER");
        System.out.println( "Your score: " + game.getScore());
        alert.show();
        Thread myThread = new Thread();
        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(136);
    }
    public void setGame(Game game) {
        this.game = game;
    }
}