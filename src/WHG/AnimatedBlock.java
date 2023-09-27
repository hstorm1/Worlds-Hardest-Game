/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WHG;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This class is an extension of block and implements the Renderable interface
 * and is used to draw the blocks in the background that change color.
 *
 * @author hill.david20
 */
public class AnimatedBlock extends Block implements Renderable {

    public int R = 255;
    public int G = 255;
    public int B = 255;

    /**
     * Initialization constructor to construct an animated block. A super call
     * is all that's needed because this extends block, and it only has one method.
     *
     * @param x is the x position.
     * @param y is the y position.
     * @param w is the width.
     * @param h is the height.
     * @param col is the color.
     */
    public AnimatedBlock(double x, double y, double w, double h, Color col) {
        super(x, y, w, h, col);
    }

    /**
     * This method is used to change the animated blocks smoothly and
     * constantly.
     *
     * @param canvas is the screen in which to draw on.
     */
    public void change(Canvas canvas) {
        if (R <= 255 && G == 255 && B == 255) {
            super.setColor(Color.rgb(R, G, B));
            R--;
        }
        if (R == 50 && G <= 255 && B == 255) {
            super.setColor(Color.rgb(R, G, B));
            G--;
        }
        if (R == 50 && G == 50 && B <= 255) {
            super.setColor(Color.rgb(R, G, B));
            B--;
        }
        if (R >= 50 && G == 50 && B == 50) {
            super.setColor(Color.rgb(R, G, B));
            R++;
        }
        if (R == 255 && G >= 50 && B == 50) {
            super.setColor(Color.rgb(R, G, B));
            G++;
        }
        if (R == 255 && G == 255 && B >= 50) {
            super.setColor(Color.rgb(R, G, B));
            B++;
        }
        if (R > 255) {
            R = 255;
        }
        if (G > 255) {
            G = 255;
        }
        if (B > 255) {
            G = 255;
        }
    }

    /**
     * This method does nothing but must be added as this class is an extension
     * of the block class.
     *
     * @param block is the block that would be checking the collision with.
     */
    @Override
    public void onCollision(Block block) {
    }

    /**
     * This method draws the animated block on the screen.
     *
     * @param canvas is the screen in which to draw on.
     * @param col is the color that will be used for the object.
     */
    @Override
    public void draw(Canvas canvas, Color col) {
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        graphics.setFill(super.getColor());
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());
    }
}
