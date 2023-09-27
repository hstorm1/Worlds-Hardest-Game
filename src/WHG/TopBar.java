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
 * This class is used to draw the black top bar at the top of the screen that
 * displays the menu button, what level you are on, and the death count.
 *
 * @author hill.david20
 */
public class TopBar {

    /**
     * This method draws the top bar on the screen.
     *
     * @param canvas is the screen in which to draw on.
     */
    public void draw(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 900, 50);
        gc.setFont(new Font("BOLD", 30));
        gc.setFill(Color.WHITE);
        gc.fillText("MENU", 10, 35);
        gc.fillText("DEATHS: ", 700, 35);
        gc.fillText("/5", 425, 35);
    }
}
