package Main.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import Main.Main.*;
import Main.Characters.*;

import java.util.Locale;


public class GameGUI extends Application {

    ZorkULGame game;
    Player player;

    @Override
    public void start(Stage stage) throws Exception {
        game = new ZorkULGame();




        //Parent root = FXMLLoader.load(getClass().getResource("/GUI/game_scene.fxml"));
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI/game_scene.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch(args);
    }
}

