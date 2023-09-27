/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WHG;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * This class is used to draw the third menu on the screen.
 *
 * @author hill.david20
 */
public class MenuThree {

    /**
     * This method draws the menu on the screen.
     *
     * @param canvas is the screen in which to draw on.
     */
    public void draw(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFont(new Font("BOLD", 30));
        gc.setFill(Color.WHITESMOKE);
        gc.fillRect(0, 0, 900, 600);
        gc.setFill(Color.BLACK);
        gc.fillText("You are the ", 50, 50);
        gc.setFill(Color.RED);
        gc.fillText("red ", 210, 50);
        gc.setFill(Color.BLACK);
        gc.fillText("square. Avoid the ", 260, 50);
        gc.setFill(Color.BLUE);
        gc.fillText("blue ", 500, 50);
        gc.setFill(Color.BLACK);
        gc.fillText("circles and collect the", 565, 50);
        gc.setFill(Color.rgb(223, 232, 76));
        gc.fillText("yellow ", 50, 90);
        gc.setFill(Color.BLACK);
        gc.fillText("circles. Once you have collected all of the yellow", 140, 90);
        gc.fillText("circles, move to the ", 50, 130);
        gc.setFill(Color.GREEN);
        gc.fillText("green ", 315, 130);
        gc.setFill(Color.BLACK);
        gc.fillText("beacon to complete the level.", 400, 130);
        gc.fillText("You must complete all 5 levels in order to receive your score.", 50, 170);
        gc.fillText("Your score is a reflection of how many times you have died;", 50, 210);
        gc.fillText("the less, the better.", 50, 250);
        gc.fillText("To move the square, use the arrow keys or W,A,S,D.", 50, 330);
        gc.fillText("", 0, 0);
        gc.setFont(new Font("BOLD", 70));
        gc.setStroke(Color.BLACK);
        gc.strokeRect(580, 420, 220, 130);
        gc.setFill(Color.RED);
        gc.fillText("PLAY", 610, 480);
        gc.fillText("GAME", 590, 540);
        gc.strokeRect(80, 420, 220, 130);
        gc.setFont(new Font("BOLD", 50));
        gc.setFill(Color.BLUE);
        gc.fillText("BACK TO", 90, 480);
        gc.fillText("MENU", 118, 530);
    }

}
