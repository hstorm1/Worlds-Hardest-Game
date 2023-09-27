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
 * This class is used to draw the second menu on the screen.
 *
 * @author hill.david20
 */
public class MenuTwo {

    /**
     * This method draws the menu on the screen.
     *
     * @param canvas is the screen in which to draw on.
     */
    public void draw(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITESMOKE);
        gc.fillRect(0, 0, 900, 600);
        gc.setFont(new Font("BOLD", 28));
        gc.setFill(Color.BLACK);
        gc.fillText("THE WORLD'S...", 50, 50);
        gc.fillText("Version 2.0", 700, 170);
        gc.fillText("MUSIC BY SNAYK", 675, 590);
        gc.setFont(new Font("BOLD", 110));
        gc.setFill(Color.BLUE);
        gc.fillText("HARDEST GAME", 45, 145);
        gc.setFont(new Font("BOLD", 70));
        gc.setStroke(Color.BLACK);
        gc.strokeRect(330, 420, 220, 130);
        gc.setFill(Color.RED);
        gc.fillText("PLAY", 360, 480);
        gc.fillText("GAME", 340, 540);
        gc.setFill(Color.BLACK);
        gc.fillRect(90, 310, 24, 24);
        gc.setFill(Color.RED);
        gc.fillRect(94, 314, 16, 16);
        gc.setStroke(Color.BLACK);
        gc.strokeLine(120, 300, 125, 290);
        gc.strokeLine(120, 300, 135, 300);
        gc.strokeOval(125, 260, 100, 50);
        gc.setFill(Color.WHITESMOKE);
        gc.fillOval(125, 288, 9, 9);
        gc.fillRect(130, 294, 5, 5);
        gc.setFill(Color.BLACK);
        gc.setFont(new Font("BOLD", 22));
        gc.fillText("Oh no...", 140, 290);
    }

}
