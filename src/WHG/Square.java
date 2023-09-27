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
 * This class is used to draw and update the red square in the game.
 *
 * @author hill.david20
 */
public class Square extends Block implements Renderable, Updateable {

    private double xVelocity;
    private double yVelocity;
    private double originalX;
    private double originalY;
    private int deathCount = 0;
    private boolean hit = false;

    /**
     * Initialization constructor to construct the square. It extends block but
     * since it moves, it needs an x velocity and a y velocity.
     *
     * @param x is the x position.
     * @param y is the y position.
     * @param wid is the width.
     * @param ht is the height.
     * @param col is the color.
     * @param xvel is the x velocity.
     * @param yvel is the y velocity.
     */
    public Square(double x, double y, double wid, double ht, Color col, double xvel, double yvel) {
        super(x, y, wid, ht, col);
        originalX = x;
        originalY = y;
        xVelocity = xvel;
        deathCount = 0;
        hit = false;
    }

    /**
     * This sets the x velocity of the square.
     *
     * @param xvel is the velocity that will be set to the instance variable.
     */
    public void setXVel(double xvel) {
        xVelocity = xvel;
    }

    /**
     * This sets the y velocity of the square.
     *
     * @param yvel is the velocity that will be set to the instance variable.
     */
    public void setYVel(double yvel) {
        yVelocity = yvel;
    }

    /**
     * This is used to get the x velocity of the square.
     *
     * @return the private instance variable xVelocity.
     */
    public double getXVel() {
        return xVelocity;
    }

    /**
     * This is used to get the y velocity of the square.
     *
     * @return the private instance variable yVelocity.
     */
    public double getYVel() {
        return yVelocity;
    }

    /**
     * This sets the original x position of the square.
     *
     * @param origX is the original x position that will be set to the instance
     * variable.
     */
    public void setOriginalX(double origX) {
        originalX = origX;
    }

    /**
     * This sets the original y position of the square.
     *
     * @param origY is the original y position that will be set to the instance
     * variable.
     */
    public void setOriginalY(double origY) {
        originalY = origY;
    }

    /**
     * This is used to get the original x position of the square.
     *
     * @return the private instance variable originalX.
     */
    public double getOriginalX() {
        return originalX;
    }

    /**
     * This is used to get the original y position of the square.
     *
     * @return the private instance variable originalY.
     */
    public double getOriginalY() {
        return originalY;
    }

    /**
     * This is used to get the death count of the square.
     *
     * @return the private instance variable deathCount.
     */
    public int getDeathCount() {
        return deathCount;
    }

    /**
     * This sets the death count of the square.
     *
     * @param dc is the death count that will be set to the instance variable.
     */
    public void setDeathCount(int dc) {
        deathCount = dc;
    }

    /**
     * This is used to see if the square has been hit or not.
     *
     * @return the private instance variable hit that says if the square has
     * been hit.
     */
    public boolean getHit() {
        return hit;
    }

    /**
     * This sets whether the square is hit or not, thereby saying if the square
     * can move or not.
     *
     * @param hit is the boolean that will be set to the instance variable.
     */
    public void setHit(boolean hit) {
        this.hit = hit;
    }

    /**
     * This method checks to see if the square is colliding with anything. If it
     * was with a wall, it sets the position of the square back to being inside
     * the wall; if it was with a ball, it sets the hit instance variable to
     * true so that the square cannot move; if it was with a coin, the coin
     * disappears.
     *
     * @param block is the block it is checking the collision against the square
     * with.
     */
    @Override
    public void onCollision(Block block) {
        if (checkCollision(block)) {
            if (block instanceof Wall) {
                if (block.getWidth() == 4 && getX() < block.getX()) {
                    setX(block.getX() - getWidth());
                }
                if (block.getHeight() == 4 && getY() < block.getY()) {
                    setY(block.getY() - getHeight());
                }
                if (block.getWidth() == 4 && getX() > block.getX()) {
                    setX(block.getX() + block.getWidth());
                }
                if (block.getHeight() == 4 && getY() > block.getY()) {
                    setY(block.getY() + block.getHeight());
                }
            }
            if (block instanceof Ball) {
                hit = true;
            }
            if (block instanceof Coin) {
                ((Coin) block).disappear();
            }
        }
    }

    /**
     * This resets the square back to its original position, sets hit to false
     * so that the square can move again, and sets the death count to increment
     * by one.
     */
    public void reset() {
        super.setX(originalX);
        super.setY(originalY);
        setDeathCount(getDeathCount() + 1);
        hit = false;
    }

    /**
     * This method updates the square location on the screen when it moves.
     *
     * @param canvas is the screen in which to draw on.
     */
    @Override
    public void update(Canvas canvas) {
        setX(getX() + xVelocity);
        setY(getY() + yVelocity);
    }

    /**
     * This method draws the square on the screen with another black oval a few
     * frames outside the square as the square in the game is drawn with a red
     * color so that the square has a red center and a black outline.
     *
     * @param canvas is the screen in which to draw on.
     * @param color is the color that will be used for the object.
     */
    @Override
    public void draw(Canvas canvas, Color color) {
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        graphics.setFill(Color.BLACK);
        graphics.fillRect(getX() - 4, getY() - 4, getWidth() + 8, getHeight() + 8);
        graphics.setFill(super.getColor());
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());
    }
}
