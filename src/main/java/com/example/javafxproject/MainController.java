package com.example.javafxproject;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


import java.net.URL;


import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;


public class MainController extends Application implements Initializable {

    public ImageView img;
    @FXML Slider volumeslider;
    @FXML AnchorPane p;
    @FXML Pane ControlsPane;
    @FXML Label score;
    double x = 0,y = 0;
    char dir = 'r';
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        img.setImage(new Image(mute.toString()));
        HighArray h = new HighArray();
        Thread snake = new Thread(() -> {
            AtomicInteger scr = new AtomicInteger();
            scr.set(0);
            score.setText("Score = "+scr);
           for (int i = 0;i<10;i++) h.insert(new Rectangle(10,10,Color.RED));
                spawnMelon();
            while(true) {
                if(x < 0)x=744;
                if(x > 744)x=0;
                if(y > 445)y=0;
                if(y < 0)y=443;




                if((x>=c.getX()-5&&x<=c.getX()+c.getWidth()+5)&&(y>=c.getY()-5&&y<=c.getY()+c.getHeight()+5)){

                    Platform.runLater(()->{
                        scr.addAndGet(10);
                        score.setText("Score = "+scr);
                        for(int i = 0;i<10;i++){

                            h.insert(new Rectangle(10,10,Color.RED));
                            p.getChildren().add(h.getR(h.nElems-1));
                            h.getR(h.nElems-1).setX(x);
                            h.getR(h.nElems-1).setY(y);
                        }
                        spawnMelon();
                         //p.getChildren().addAll(h.getA());
                         h.getR(0).setX(x);
                         h.getR(0).setY(y);
                    });

                }
                direction();
               for(int i = h.nElems-1;i>0;i--) {
                   if (x == h.getR(i).getX() && y ==  h.getR(i).getY()) System.exit(1);
                   h.getR(i).setX( h.getR(i-1).getX());        //tail X
                   h.getR(i).setY( h.getR(i-1).getY());        //tail Y
               }
                h.getR(0).setX(x);       //head X
                h.getR(0).setY(y);       //head Y




                try {Thread.sleep(50);} catch (InterruptedException e) {e.printStackTrace();}
            }
        });
        snake.start();
        p.getChildren().add(c);
        Platform.runLater(() -> p.getChildren().addAll(h.getA()));


    }


        Random r = new Random();
        Rectangle c = new Rectangle(10,10,new Color(r.nextDouble(),r.nextDouble(),r.nextDouble(),1));


    public void spawnMelon(){
        c.setFill(Color.color(r.nextDouble(),r.nextDouble(),r.nextDouble(),1));
        c.setX(r.nextInt(736)+1);
        c.setY(r.nextInt(434)+1);

    }



    double Rate = 3;


    public void direction(){

        switch (dir){
            case 'r':
                x+=Rate;
                y+=0;
                break;

            case 'l':
                x-=Rate;
                y+=0;
                break;

            case 'd':
                x+=0;
                y+=Rate;
                break;

            case 'u':

                x+=0;
                y-=Rate;
                break;
        }

    }

    boolean M = false;
    URL unmute = Application.class.getResource("mute.png");
    URL mute = Application.class.getResource("speaker.png");
    public void mute(MouseEvent mouseEvent) {

        if(M)
        {
            Image i = new Image(mute.toString());
            mediaPlayer.setVolume(0.02);
            M = false;
            img.setImage(i);
        }
        else
        {
            Image i = new Image(unmute.toString());
            mediaPlayer.setVolume(0);
            M = true;
            img.setImage(i);
        }


    }
}