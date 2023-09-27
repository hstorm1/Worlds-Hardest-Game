/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WHG;

import javafx.scene.paint.Color;
import java.awt.Rectangle;

/**
 * This abstract class is used for a basic block in the game, including balls,
 * walls, coins, and the square.
 *
 * @author hill.david20
 */
public abstract class Block {

    private double width;
    private double height;
    private double x;
    private double y;
    private Color color;

    /**
     * Initialization constructor to construct a basic block in the game.
     *
     * @param myX is the x position.
     * @param myY is the y position.
     * @param w is the width.
     * @param h is the height.
     * @param col is the color.
     */
    public Block(double myX, double myY, double w, double h, Color col) {
        x = myX;
        y = myY;
        width = w;
        height = h;
        color = col;
    }

    /**
     * This sets the width of the block.
     *
     * @param w is the width that will be set to the instance variable.
     */
    public void setWidth(double w) {
        width = w;
    }

    /**
     * This sets the height of the block.
     *
     * @param h is the height that will be set to the instance variable.
     */
    public void setHeight(double h) {
        height = h;
    }

    /**
     * This sets the x position of the block.
     *
     * @param myX is the x position that will be set to the instance variable.
     */
    public void setX(double myX) {
        x = myX;
    }

    /**
     * This sets the y position of the block.
     *
     * @param myY is the y position that will be set to the instance variable.
     */
    public void setY(double myY) {
        y = myY;
    }

    /**
     * This sets the color of the block.
     *
     * @param col is the color that will be set to the instance variable.
     */
    public void setColor(Color col) {
        color = col;
    }

    /**
     * This is used to get the width of the block.
     *
     * @return the private instance variable width.
     */
    public double getWidth() {
        return width;
    }

    /**
     * This is used to get the height of the block.
     *
     * @return the private instance variable height.
     */
    public double getHeight() {
        return height;
    }

    /**
     * This is used to get the x position of the block.
     *
     * @return the private instance variable x.
     */
    public double getX() {
        return x;
    }

    /**
     * This is used to get the y position of the block.
     *
     * @return the private instance variable y.
     */
    public double getY() {
        return y;
    }

    /**
     * This is used to get the color of the block.
     *
     * @return the private instance variable color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * This abstract method will be used by the blocks to see if a block is
     * colliding with another block.
     *
     * @param block is the block that will be checked with for a collision with
     * another block.
     */
    public abstract void onCollision(Block block);

    /**
     * This boolean will return true or false based on if a collision is
     * happening.
     *
     * @param block is the block that will be checked with for a collision with
     * another block.
     * @return true or false based on if a block is intersecting with another
     * block.
     */
    public boolean checkCollision(Block block) {
        return getBounds().intersects(block.getBounds());
    }

    /**
     * This method is used to convert each block into a Rectangle so that the
     * intersects method can be used in the checkCollision method.
     *
     * @return a new Rectangle with the instance variables as the x, y, width,
     * and height, all casted as integers as the instance variables are doubles.
     */
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, (int) width, (int) height);
    }
}
