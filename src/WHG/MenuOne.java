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
 * This class is used to draw the very first menu on the screen.
 *
 * @author hill.david20
 */
public class MenuOne {

    /**
     * This method draws the menu on the screen.
     *
     * @param canvas is the screen in which to draw on.
     */
    public void draw(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 900, 600);
        gc.setStroke(Color.WHITE);
        gc.setFill(Color.WHITE);
        gc.strokeRect(280, 240, 340, 40);
        gc.setFont(new Font("BOLD", 15));
        gc.fillText("This is The World's Hardest Game. I guarantee you", 280, 350);
        gc.fillText("it is harder than any game you have ever played, or", 280, 370);
        gc.fillText("ever will play.", 280, 390);
        gc.setFont(new Font("BOLD", 25));
        gc.fillText("BEGIN", 420, 270);
    }

}
