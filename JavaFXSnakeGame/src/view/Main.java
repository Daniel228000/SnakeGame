package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;


public class Main extends Application {
    public static final int PIXEL_SIZE = 25;

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            primaryStage.getIcons()
                    .add(new Image(Objects.requireNonNull(getClass()
                            .getClassLoader()
                            .getResourceAsStream("images/snake_icon.png"))));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        Parent root = null;
        //System.out.println(getClass().getResource("/sample/startMenu.fxml"));
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass()
                    .getClassLoader()
                    .getResource("view/startMenu.fxml")));

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(0);
        }

        primaryStage.setTitle("Snake");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();



    }



    public static void main(String[] args) {
        launch(args);
    }
}
