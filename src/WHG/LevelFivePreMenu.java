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
 * This class is used to draw the menu that pops up once level four is completed
 * right before level five.
 *
 * @author hill.david20
 */
public class LevelFivePreMenu {

    /**
     * This method draws the menu on the screen.
     *
     * @param canvas is the screen in which to draw on.
     */
    public void draw(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITESMOKE);
        gc.fillRect(0, 0, 900, 600);
        gc.setFill(Color.BLACK);
        gc.setFont(new Font("BOLD", 50));
        gc.fillText("TIP:", 50, 150);
        gc.setFont(new Font("BOLD", 30));
        gc.fillText("The following level is impossible.", 140, 150);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(355, 450, 150, 100);
        gc.setFill(Color.RED);
        gc.setFont(new Font("BOLD", 70));
        gc.fillText("GO", 380, 525);
    }
}
