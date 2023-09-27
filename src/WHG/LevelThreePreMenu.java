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
 * This class is used to draw the menu that pops up once level two is completed
 * right before level three.
 *
 * @author hill.david20
 */
public class LevelThreePreMenu {

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
        gc.fillText("Don't just jump right into a level you've never played", 140, 150);
        gc.fillText("before! Analyze the level beforehand and plan out how you", 55, 190);
        gc.fillText("are going to beat it. Remember, the objective is to beat the", 55, 230);
        gc.fillText("game with the least amount of deaths, not in the fastest time.", 55, 270);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(355, 450, 150, 100);
        gc.setFill(Color.RED);
        gc.setFont(new Font("BOLD", 70));
        gc.fillText("GO", 380, 525);
    }
}
