package core;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Drawer {
    private ImageView[][] arrayOfImages;
    private Game graphicsGame;
    private int score = 0;
    private int widthOfImage;
    private int heightOfImage;
    private Field field;
    private List<Cell> cells;
    private Snake snake;
    private Food food;


    public Drawer(Game game) {
        this.graphicsGame = game;
        arrayOfImages = new ImageView[game.getField().getX()][game.getField().getY()];
        field = graphicsGame.getField();
        cells = graphicsGame.getPoints();
        widthOfImage = 800 / field.getX();
        heightOfImage = 800 / field.getY();
        snake = graphicsGame.getSnake();
        food = graphicsGame.getFood();
        redraw();
    }

    public void redraw() {
        for (int x = 0; x < field.getX(); x++) {
            for (int y = 0; y < field.getY(); y++) {
                if (y == 0 || y == 39) {
                    ImageView newImageWall = new ImageView();
                    newImageWall.setImage(Assets.wall);
                    newImageWall.setFitWidth(widthOfImage);
                    newImageWall.setFitHeight(heightOfImage);
                    arrayOfImages[x][y] = newImageWall;
                }
            }
        }
        for (int y = 0; y < field.getY(); y++) {
            for (int x = 0; x < field.getX(); x++) {
                ImageView newImageWall = new ImageView();
                newImageWall.setImage(Assets.wall);
                if (x == 0) {
                    newImageWall.setFitWidth(widthOfImage);
                    newImageWall.setFitHeight(heightOfImage);
                    arrayOfImages[x][y] = newImageWall;
                } else if (x == 39) {
                    newImageWall.setFitWidth(widthOfImage);
                    newImageWall.setFitHeight(heightOfImage);
                    arrayOfImages[x][y] = newImageWall;
                }
            }
        }

        for (int x = 1; x < field.getX() - 1; x++) {
            for (int y = 1; y < field.getY() - 1; y++) {
                ImageView newImage = new ImageView();
                newImage.setImage(Assets.empty);
                newImage.setFitWidth(widthOfImage);
                newImage.setFitHeight(heightOfImage);
                  if (!graphicsGame.pointIntersect(cells, x, y))
                arrayOfImages[x][y] = newImage;
             }
        }
        ImageView newImageWalls = new ImageView();
        newImageWalls.setImage(Assets.wall);
        newImageWalls.setFitWidth(widthOfImage);
        newImageWalls.setFitHeight(heightOfImage);
        for (Cell cell : cells) {
            arrayOfImages[cell.getX()][cell.getY()] = newImageWalls;
        }
    }
    public void drawEmpty(){
        ImageView emptyWall = new ImageView();
        for (int x = 1; x < field.getX() - 1; x++) {
            for (int y = 1; y < field.getY() - 1; y++) {
                if (arrayOfImages[x][y] == null) arrayOfImages[x][y] = emptyWall;
            }
        }
    }
    public void drawFruit() {
        ImageView newImage = new ImageView();
        switch (graphicsGame.getFood().getType()) {
            case SPEED_UP:{
                newImage.setImage(Assets.redApple);
                break;
            }
            case NONE:{
                newImage.setImage(Assets.greenApple);
                break;
            }
            case EXTRA_LIFE:{
                newImage.setImage(Assets.purpleApple);
                break;
            }
            case SPEED_DOWN:{
                newImage.setImage(Assets.blueApple);
                break;
            }
            case DOUBLE_SCORE:{
                newImage.setImage(Assets.orangeApple);
                break;
            }
            case INVISIBILITY: {
                newImage.setImage(Assets.yellowApple);
                break;
            }
        }
        newImage.setFitWidth(widthOfImage);
        newImage.setFitHeight(heightOfImage);
        arrayOfImages[graphicsGame.getFood().getX()][graphicsGame.getFood().getY()] = newImage;
    }
    public void drawSnake() {
        ImageView newImageHead = new ImageView();
        newImageHead.setImage(Assets.snake_head);
        newImageHead.setFitWidth(widthOfImage);
        newImageHead.setFitHeight(heightOfImage);
        arrayOfImages[snake.getSnake().get(0).x][snake.getSnake().get(0).y] = newImageHead;
        for (int i = 1; i < snake.getSnake().size(); i++) {
            ImageView newImageBody = new ImageView();
            newImageBody.setImage(Assets.snake_body);
            newImageBody.setFitWidth(widthOfImage);
            newImageBody.setFitHeight(heightOfImage);
            arrayOfImages[snake.getSnake().get(i).x][snake.getSnake().get(i).y] = newImageBody;
        }
    }
    public void drawScore(){

    }

    public void drawScene() {
        redraw();
        drawFruit();
        if (snake.isAlive) {
            drawSnake();
        }
        drawEmpty();

    }


    public ImageView[][] getArrayOfImages(){
        return arrayOfImages;
    }



}
