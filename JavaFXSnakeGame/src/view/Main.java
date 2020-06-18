package view;

import controllers.StartMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
//Виды фруктов:
//Зеленый - нет бонуса
//Желтый - змейка не умирает от поедания самой себя, длится 60 шагов змейки
//Красный - увеличение скорости вдвое на 10 шагов
//Фиолетовый - дополнительная жизнь, при столкновении со степной происходит задержка, чтобы игрок мог сменить направление движения змейки
//
//
//
//
//
//
//
//
//
//
//


public class Main extends Application {
    public static final int PIXEL_SIZE = 20;

    @Override
    public void start(Stage stage) throws Exception{
       try {
           stage.getIcons()
                   .add(new Image(getClass().getResourceAsStream("boginya.png")));
           } catch (Exception e) {
           System.err.println(e.getMessage());
           System.exit(0);
       }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("startMenu.fxml"));
        Parent root = loader.load();
        StartMenuController startMenuController = loader.getController();
        System.out.println( loader.getController().toString());
        startMenuController.setStage(stage);

        stage.setTitle("Snake");
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();



    }



    public static void main(String[] args) {
        launch(args);
    }
}
