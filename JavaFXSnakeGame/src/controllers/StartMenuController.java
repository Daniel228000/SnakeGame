package controllers;

import core.Field;
import core.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartMenuController {
    Stage stage;
    Field field;
    private static final int WIDTH = 780;
    private static final int HEIGHT = 780;
    private static final int SIZE = 40;
    @FXML
    public void startGame() throws IOException {
       field = new Field(SIZE, SIZE);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        Parent root = loader.load();
        Game game = new Game(field);
       MainController controller = loader.getController();
       controller.setGame(game);
       controller.timerOfMoving();
       controller.drawScene(game);
       Scene scene = new Scene(root, WIDTH, HEIGHT);
       stage.setScene(scene);

    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}

