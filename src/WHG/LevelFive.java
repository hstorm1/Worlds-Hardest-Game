/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WHG;

import java.util.ArrayList;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

/**
 * This class is used to draw level five on the screen to be played.
 *
 * @author hill.david20
 */
public class LevelFive {

    private ArrayList<Ball> balls;
    private ArrayList<Wall> walls;
    private Square square;
    private Coin coin;
    private double speed, speed2;
    private boolean collide;
    Wall wall8; //wall8 is the one vertical wall at the top that the balls can go through but the square cannot.

    /**
     * Initialization constructor to initialize the array lists, square, coin,
     * and speeds. It initializes all the walls and balls to be placed in the
     * level as well.
     *
     * @param s is the square.
     * @param c is the one coin in this level.
     */
    public LevelFive(Square s, Coin c) {
        collide = true;
        balls = new ArrayList<>();
        walls = new ArrayList<>();
        square = s;
        coin = c;
        speed = 2.25;
        speed2 = 1.6;
        Wall wall1 = new Wall(140, 150, 600, 4, Color.BLACK);
        Wall wall2 = new Wall(140, 150, 4, 300, Color.BLACK);
        Wall wall3 = new Wall(740, 150, 4, 300, Color.BLACK);
        Wall wall4 = new Wall(140, 450, 604, 4, Color.BLACK);
        Wall wall5 = new Wall(140, 255, 250, 4, Color.BLACK);
        Wall wall6 = new Wall(481, 255, 205, 4, Color.BLACK);
        Wall wall7 = new Wall(240, 355, 500, 4, Color.BLACK);
        wall8 = new Wall(435, 150, 4, 105, Color.BLACK);
        addWall(wall1, wall2, wall3, wall4, wall5, wall6, wall7);
        Ball ball1 = new Ball(174, 160, 19, 19, Color.BLACK, speed, 0);
        Ball ball2 = new Ball(198, 160, 19, 19, Color.BLACK, speed, 0);
        Ball ball3 = new Ball(720, 232, 19, 19, Color.BLACK, 6.5, 0);
        Ball ball4 = new Ball(145, 184, 19, 19, Color.BLACK, -6.5, 0);
        Ball ball5 = new Ball(501, 270, 19, 19, Color.BLACK, 0, speed2);
        Ball ball6 = new Ball(351, 326, 19, 19, Color.BLACK, 0, -speed2);
        Ball ball7 = new Ball(428, 360, 19, 19, Color.BLACK, 0, -speed2);
        Ball ball8 = new Ball(630, 431, 19, 19, Color.BLACK, 0, speed2);
        Ball ball9 = new Ball(145, 430, 19, 19, Color.BLACK, -6.5, 0);
        Ball ball10 = new Ball(720, 407, 19, 19, Color.BLACK, 6.5, 0);
        addBall(ball1, ball2, ball3, ball4, ball5, ball6, ball7, ball8, ball9, ball10);
        for (int i = 160; i < 233; i += 24) {
            addBall(new Ball(150, i, 19, 19, Color.BLACK, speed, 0));
            addBall(new Ball(222, i, 19, 19, Color.BLACK, speed, 0));
        }
        for (int i = 260; i < 333; i += 24) {
            if (i != 308) {
                addBall(new Ball(222, i, 19, 19, Color.BLACK, speed2, 0));
            }
            if (i != 284) {
                addBall(new Ball(294, i, 19, 19, Color.BLACK, speed2, 0));
            }
        }
        for (int i = 390; i < 725; i += 24) {
            addBall(new Ball(i, 360, 19, 19, Color.BLACK, speed2, 0));
        }
        for (double i = 360.5; i < 440; i += 23) {
            addBall(new Ball(323, i, 19, 19, Color.BLACK, -speed, 0));
            addBall(new Ball(383, i, 19, 19, Color.BLACK, -speed, 0));
        }
    }

    /**
     * This method adds a ball to the array list of balls.
     *
     * @param b1 is the ball to be added to the array list.
     */
    public void addBall(Ball b1) {
        balls.add(b1);
    }

    /**
     * This method adds multiple balls in the array list in one call. It helps
     * from having to call the method above many times.
     *
     * @param b1 is one of the balls to be added to the array list.
     * @param b2 is one of the balls to be added to the array list.
     * @param b3 is one of the balls to be added to the array list.
     * @param b4 is one of the balls to be added to the array list.
     * @param b5 is one of the balls to be added to the array list.
     * @param b6 is one of the balls to be added to the array list.
     * @param b7 is one of the balls to be added to the array list.
     * @param b8 is one of the balls to be added to the array list.
     * @param b9 is one of the balls to be added to the array list.
     * @param b10 is one of the balls to be added to the array list.
     */
    public void addBall(Ball b1, Ball b2, Ball b3, Ball b4, Ball b5, Ball b6, Ball b7, Ball b8, Ball b9, Ball b10) {
        balls.add(b1);
        balls.add(b2);
        balls.add(b3);
        balls.add(b4);
        balls.add(b5);
        balls.add(b6);
        balls.add(b7);
        balls.add(b8);
        balls.add(b9);
        balls.add(b10);
    }

    /**
     * This method adds multiple walls in the array list in one call. It helps
     * from having to call one method many times.
     *
     * @param w1 is one of the walls to be added to the array list.
     * @param w2 is one of the walls to be added to the array list.
     * @param w3 is one of the walls to be added to the array list.
     * @param w4 is one of the walls to be added to the array list.
     * @param w5 is one of the walls to be added to the array list.
     * @param w6 is one of the walls to be added to the array list.
     * @param w7 is one of the walls to be added to the array list.
     */
    public void addWall(Wall w1, Wall w2, Wall w3, Wall w4, Wall w5, Wall w6, Wall w7) {
        walls.add(w1);
        walls.add(w2);
        walls.add(w3);
        walls.add(w4);
        walls.add(w5);
        walls.add(w6);
        walls.add(w7);
    }

    /**
     * This method sets whether the collision should be on with the balls and
     * the square or not.
     *
     * @param c is the boolean that will be set to the instance variable.
     */
    public void setCollide(boolean c) {
        collide = c;
    }

    /**
     * This method gets the collision state between the square and the balls.
     *
     * @return the private instance variable collide.
     */
    public boolean getCollide() {
        return collide;
    }

    /**
     * This method gets the array list of balls.
     *
     * @return the private instance variable balls.
     */
    public ArrayList<Ball> getBalls() {
        return balls;
    }

    /**
     * This method draws all of the objects on the screen.
     *
     * @param canvas is the screen in which to draw on.
     */
    public void drawAll(Canvas canvas) {
        for (Ball b : balls) {
            b.draw(canvas, b.getColor());
        }
        for (Wall w : walls) {
            w.draw(canvas, w.getColor());
        }
        square.draw(canvas, square.getColor());
        wall8.draw(canvas, wall8.getColor());
        coin.draw(canvas, coin.getColor());
    }

    /**
     * This method updates the objects that need to be updated on the screen.
     *
     * @param canvas is the canvas in which to draw on.
     */
    public void updateAll(Canvas canvas) {
        for (Ball b : balls) {
            b.update(canvas);
        }
        square.update(canvas);
    }

    /**
     * This method goes through each array list of objects and checks collisions
     * between all of them.
     */
    public void checkCollide() {
        for (Wall w : walls) {
            for (Ball b : balls) {
                b.onCollision(w);
                if (collide) {
                    square.onCollision(b);
                }
                //this specific level of the game freezes the balls when the square is hit, shown here, and then resets them later.
                if (square.checkCollision(b) && collide) {
                    for (Ball b2 : balls) {
                        b2.setXSpeed(0);
                        b2.setYSpeed(0);
                    }
                }
            }
            square.onCollision(w);
        }
        square.onCollision(wall8);
        square.onCollision(coin);
    }

    /**
     * This method resets the balls to their original positions and speeds once
     * the square is also reset.
     */
    public void resetAllBalls() {
        for (Ball b : balls) {
            b.setX(b.getOriginalX());
            b.setY(b.getOriginalY());
            b.setXSpeed(b.getOriginalXSpeed());
            b.setYSpeed(b.getOriginalYSpeed());
        }
    }
}
