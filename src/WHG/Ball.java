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
 * This class is used to draw and update the blue balls in the game.
 *
 * @author hill.david20
 */
public class Ball extends Block implements Renderable, Updateable {

    private double xSpeed;
    private double ySpeed;
    private double originalX;
    private double originalY;
    private double originalXSpeed;
    private double originalYSpeed;
    /**
     * Initialization constructor to construct a ball. It extends block but since it moves,
     * it needs an x speed and a y speed.
     * @param x is the x position.
     * @param y is the y position.
     * @param w is the width.
     * @param h is the height.
     * @param col is the color.
     * @param xsp is the x speed.
     * @param ysp is the y speed.
     */
    public Ball(double x, double y, double w, double h, Color col, double xsp, double ysp) {
        super(x, y, w, h, col);
        originalX = x;
        originalY = y;
        xSpeed = xsp;
        ySpeed = ysp;
        originalXSpeed = xsp;
        originalYSpeed = ysp;
    }

    /**
     * This sets the x speed of the ball.
     *
     * @param xsp is the speed that will be set to the instance variable.
     */
    public void setXSpeed(double xsp) {
        xSpeed = xsp;
    }

    /**
     * This sets the y speed of the ball.
     *
     * @param ysp is the speed that will be set to the instance variable.
     */
    public void setYSpeed(double ysp) {
        ySpeed = ysp;
    }

    /**
     * This sets the original x speed of the ball and is used to keep track of
     * the original speed in level five so that the balls can freeze and then
     * reset with their original speed.
     *
     * @param oxsp is the speed that will be set to the instance variable.
     */
    public void setOriginalXSpeed(double oxsp) {
        originalXSpeed = oxsp;
    }

    /**
     * This sets the original y speed of the ball and is used to keep track of
     * the original speed in level five so that the balls can freeze and then
     * reset with their original speed.
     *
     * @param oysp is the speed that will be set to the instance variable.
     */
    public void setOrigianlYSpeed(double oysp) {
        originalYSpeed = oysp;
    }

    /**
     * This sets the original x position of the ball and is used to keep track
     * of the original position in level five so that when the balls reset, they
     * can go back to their original position.
     *
     * @param ox is the position that will be set to the instance variable.
     */
    public void setOriginalX(double ox) {
        originalX = ox;
    }

    /**
     * This sets the original y position of the ball and is used to keep track
     * of the original position in level five so that when the balls reset, they
     * can go back to their original position.
     *
     * @param oy is the position that will be set to the instance variable.
     */
    public void setOriginalY(double oy) {
        originalY = oy;
    }

    /**
     * This is used to get the xSpeed of the ball.
     *
     * @return the private instance variable xSpeed.
     */
    public double getXSpeed() {
        return xSpeed;
    }

    /**
     * This is used to get the ySpeed of the ball.
     *
     * @return the private instance variable ySpeed.
     */
    public double getYSpeed() {
        return ySpeed;
    }

    /**
     * This is used to get the original xSpeed of the ball.
     *
     * @return the private instance variable originalXSpeed.
     */
    public double getOriginalXSpeed() {
        return originalXSpeed;
    }

    /**
     * This is used to get the original ySpeed of the ball.
     *
     * @return the private instance variable originalYSpeed.
     */
    public double getOriginalYSpeed() {
        return originalYSpeed;
    }

    /**
     * This is used to get the original x position of the ball.
     *
     * @return the private instance variable originalX.
     */
    public double getOriginalX() {
        return originalX;
    }

    /**
     * This is used to get the original y position of the ball.
     *
     * @return the private instance variable originalY.
     */
    public double getOriginalY() {
        return originalY;
    }

    /**
     * This is used to check for collisions between other blocks and set the
     * speed to its opposite speed accordingly if a collision is detected.
     *
     * @param block is the block in which the ball is checking the collision
     * against.
     */
    @Override
    public void onCollision(Block block) {
        if (checkCollision(block)) {
            if (block.getHeight() == 4) {
                setYSpeed(getYSpeed() * -1);
            } else if (block.getWidth() == 4) {
                setXSpeed(getXSpeed() * -1);
            }
        }
    }

    /**
     * This method updates the ball location as it moves.
     *
     * @param canvas is the screen in which to draw on.
     */
    @Override
    public void update(Canvas canvas) {
        setX(getX() + xSpeed);
        setY(getY() + ySpeed);
    }

    /**
     * This method draws the ball on the screen with another blue oval a few
     * frames inside the ball as all the balls in the game are drawn with a
     * black color so that the ball has a blue center and a black outline.
     *
     * @param canvas is the screen in which to draw on.
     * @param col is the color that will be used for the object.
     */
    @Override
    public void draw(Canvas canvas, Color col) {
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        graphics.setFill(super.getColor());
        graphics.fillOval(getX(), getY(), getWidth(), getHeight());
        graphics.setFill(Color.BLUE);
        graphics.fillOval(getX() + 3, getY() + 3, getWidth() - 6, getHeight() - 6);
    }
}
