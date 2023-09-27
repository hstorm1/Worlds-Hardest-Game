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
 * This class is used to draw the menu that pops up once the game is completed.
 *
 * @author hill.david20
 */
public class GameCompletedMenu {

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
        gc.setFont(new Font("BOLD", 80));
        gc.fillText("CONGRATULATIONS!", 70, 150);
        gc.setFont(new Font("BOLD", 35));
        gc.fillText("You have completed The World's Hardest Game!", 75, 200);
        gc.fillText("TOTAL DEATHS: ", 280, 300);
        gc.setFont(new Font("BOLD", 26));
        gc.fillText("World Record: David Hill: 0 deaths. Speedrun time: 42.88 seconds", 75, 350);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(305, 420, 220, 130);
        gc.setFont(new Font("BOLD", 50));
        gc.setFill(Color.BLUE);
        gc.fillText("BACK TO", 315, 480);
        gc.fillText("MENU", 343, 530);
    }
}
