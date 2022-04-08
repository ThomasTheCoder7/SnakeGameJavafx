package com.example.javafxproject;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 450);
        stage.setTitle("GAME ON!");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(windowEvent -> System.exit(0));
        MainController c = fxmlLoader.getController();
       scene.setOnKeyPressed(e -> {
         switch (e.getCode()){
             case RIGHT:
             case D:
                 if(c.dir == 'l')break;
                 c.dir = 'r';
                 break;
             case LEFT:
             case A:
                 if(c.dir == 'r')break;
                 c.dir = 'l';
                 break;
             case DOWN:
             case S:
                 if(c.dir == 'u')break;
                 c.dir = 'd';
                 break;
             case UP:
             case W:
                 if(c.dir == 'd')break;
                 c.dir = 'u';
                 break;

         }

       });
    }

    public static void main(String[] args) {
        playmusic("SONG.wav");
        launch();




    }



     static MediaPlayer mediaPlayer;
    static void playmusic(String music){
        URL f = Application.class.getResource(music);
        Media media = new Media(f.toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setVolume(0.02);
        mediaPlayer.play();



    }
}