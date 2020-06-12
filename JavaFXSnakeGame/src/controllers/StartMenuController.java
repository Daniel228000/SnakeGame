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
    Parent root;
    static final int WIDTH = 800;
    static final int HEIGHT = 800;

    @FXML
    public void startGame() throws IOException {
        //System.out.println(getClass().getResource("/view/game.fxml"));
        field = new Field(WIDTH, HEIGHT);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("/view/game.fxml"));
        root = loader.load();
        MainController controller = loader.getController();
        Game game = new Game(field);
        controller.setGame(game);
        controller.timerOfMoving();
        controller.drawScene();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);

    }
}

