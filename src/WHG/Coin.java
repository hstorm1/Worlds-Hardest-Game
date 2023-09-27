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
 * This class is used to draw and update the yellow coins in the game.
 *
 * @author hill.david20
 */
public class Coin extends Block implements Renderable {

    private double originalX = 0;
    private double originalY = 0;

    /**
     * Initialization to construct a coin in the game. It also initializes
     * originalX and originalY to keep track of the old position of the coin so
     * it can reset it accordingly.
     *
     * @param x is the x position.
     * @param y is the y position.
     * @param w is the width.
     * @param h is the height.
     * @param col is the color
     */
    public Coin(double x, double y, double w, double h, Color col) {
        super(x, y, w, h, col);
        originalX = x;
        originalY = y;
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
     * This sets the original x position of the block.
     *
     * @param orig is the x position that will be set to the instance variable.
     */
    public void setOriginalX(double orig) {
        originalX = orig;
    }

    /**
     * This sets the original y position of the block.
     *
     * @param orig is the y position that will be set to the instance variable.
     */
    public void setOriginalY(double orig) {
        originalY = orig;
    }

    /**
     * This plays the "Ding sound effect" when the square collides with the coin
     * and also sets the x and y positions to -50, making it disappear from the
     * screen.
     */
    public void disappear() {
        String filepath = "Ding Sound Effect.wav";
        musicStuff musicObject = new musicStuff();
        musicObject.playMusic(filepath);
        super.setX(-50);
        super.setY(-50);
    }

    /**
     * This sets the coin to its original position.
     */
    public void reset() {
        super.setX(originalX);
        super.setY(originalY);
    }

    /**
     * This method draws the coin on the screen with another yellow oval a few
     * frames inside the coin as all the coins in the game are drawn with a
     * black color so that the coin has a yellow center and a black outline.
     *
     * @param canvas is the screen in which to draw on.
     * @param col is the color that will be used for the object.
     */
    @Override
    public void draw(Canvas canvas, Color col) {
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        graphics.setFill(super.getColor());
        graphics.fillOval(getX(), getY(), getWidth(), getHeight());
        graphics.setFill(Color.YELLOW);
        graphics.fillOval(getX() + 3, getY() + 3, getWidth() - 6, getHeight() - 6);
    }
}
