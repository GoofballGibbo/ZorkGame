package game.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import game.Main.*;
import game.Characters.*;


public class GameGUI extends Application{

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

