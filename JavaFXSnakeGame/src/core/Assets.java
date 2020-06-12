package core;

import javafx.scene.image.ImageView;

abstract class Assets {
    static ImageView snake_head = new ImageView(Assets.class.getClassLoader().getResource("images/head.png").toString());
    static ImageView snake_body = new ImageView(Assets.class.getClassLoader().getResource("images/body.png").toString());
}