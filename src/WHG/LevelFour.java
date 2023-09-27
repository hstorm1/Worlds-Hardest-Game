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
 * This class is used to draw level four on the screen to be played.
 *
 * @author hill.david20
 */
public class LevelFour {

    private ArrayList<Ball> balls;
    private ArrayList<Wall> walls;
    private Square square;
    private Coin coin1;
    private Coin coin2;
    private boolean collide;
    Ball rotatingball1, rotatingball2;

    /**
     * Initialization constructor to initialize the array lists, square, and
     * coins. It initializes all the walls and balls to be placed in the level
     * as well, including two special instance variables which are the rotating
     * balls.
     *
     * @param s is the square.
     * @param c1 is the first coin.
     * @param c2 is the second coin.
     */
    public LevelFour(Square s, Coin c1, Coin c2) {
        collide = true;
        balls = new ArrayList<>();
        walls = new ArrayList<>();
        square = s;
        coin1 = c1;
        coin2 = c2;
        Wall wall = new Wall(410, 100, 40, 4, Color.BLACK);
        Wall wall2 = new Wall(410, 100, 4, 40, Color.BLACK);
        Wall wall3 = new Wall(450, 100, 4, 40, Color.BLACK);
        Wall wall4 = new Wall(210, 140, 204, 4, Color.BLACK);
        Wall wall5 = new Wall(450, 140, 200, 4, Color.BLACK);
        Wall wall6 = new Wall(210, 140, 4, 290, Color.BLACK);
        Wall wall7 = new Wall(650, 140, 4, 290, Color.BLACK);
        Wall wall8 = new Wall(210, 430, 200, 4, Color.BLACK);
        Wall wall9 = new Wall(454, 430, 200, 4, Color.BLACK);
        Wall wall10 = new Wall(410, 430, 4, 40, Color.BLACK);
        Wall wall11 = new Wall(450, 430, 4, 40, Color.BLACK);
        Wall wall12 = new Wall(410, 470, 44, 4, Color.BLACK);
        addWall(wall, wall2, wall3, wall4, wall5, wall6, wall7, wall8, wall9, wall10, wall11, wall12);
        rotatingball1 = new Ball(422, 145, 19, 19, Color.BLACK, -3, 0);
        rotatingball2 = new Ball(422, 410, 19, 19, Color.BLACK, 3, 0);
        Ball ball1 = new Ball(216, 145, 19, 19, Color.BLACK, 3, 0);
        Ball ball2 = new Ball(629, 169, 19, 19, Color.BLACK, -3, 0);
        Ball ball3 = new Ball(216, 193, 19, 19, Color.BLACK, 6, 0);
        Ball ball4 = new Ball(629, 217, 19, 19, Color.BLACK, -3, 0);
        Ball ball5 = new Ball(216, 241, 19, 19, Color.BLACK, 3, 0);
        Ball ball6 = new Ball(629, 265, 19, 19, Color.BLACK, -6, 0);
        Ball ball7 = new Ball(216, 289, 19, 19, Color.BLACK, 3, 0);
        Ball ball8 = new Ball(629, 313, 19, 19, Color.BLACK, -3, 0);
        Ball ball9 = new Ball(216, 337, 19, 19, Color.BLACK, 6, 0);
        Ball ball10 = new Ball(629, 361, 19, 19, Color.BLACK, -3, 0);
        Ball ball11 = new Ball(216, 385, 19, 19, Color.BLACK, 3, 0);
        Ball ball12 = new Ball(629, 409, 19, 19, Color.BLACK, -6, 0);
        addBall(ball1, ball2, ball3, ball4, ball5, ball6, ball7, ball8, ball9, ball10, ball11, ball12);
    }

    /**
     * This method adds multiple balls in the array list in one call. It helps
     * from having to call one method many times.
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
     * @param b11 is one of the balls to be added to the array list.
     * @param b12 is one of the balls to be added to the array list.
     */
    public void addBall(Ball b1, Ball b2, Ball b3, Ball b4, Ball b5, Ball b6, Ball b7,
            Ball b8, Ball b9, Ball b10, Ball b11, Ball b12) {
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
        balls.add(b11);
        balls.add(b12);
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
     * @param w8 is one of the walls to be added to the array list.
     * @param w9 is one of the walls to be added to the array list.
     * @param w10 is one of the walls to be added to the array list.
     * @param w11 is one of the walls to be added to the array list.
     * @param w12 is one of the walls to be added to the array list.
     */
    public void addWall(Wall w1, Wall w2, Wall w3, Wall w4, Wall w5, Wall w6, Wall w7, Wall w8, Wall w9, Wall w10, Wall w11, Wall w12) {
        walls.add(w1);
        walls.add(w2);
        walls.add(w3);
        walls.add(w4);
        walls.add(w5);
        walls.add(w6);
        walls.add(w7);
        walls.add(w8);
        walls.add(w9);
        walls.add(w10);
        walls.add(w11);
        walls.add(w12);
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
        coin1.draw(canvas, coin1.getColor());
        coin2.draw(canvas, coin2.getColor());
        square.draw(canvas, square.getColor());
        rotatingball1.draw(canvas, rotatingball1.getColor());
        rotatingball2.draw(canvas, rotatingball2.getColor());
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
        rotatingball1.update(canvas);
        rotatingball2.update(canvas);
    }

    /**
     * This method goes through each array list of objects and checks collisions
     * between all of them.
     */
    public void checkCollide() {
        if (collide) {
            square.onCollision(rotatingball1);
            square.onCollision(rotatingball2);
        }
        for (Wall w : walls) {
            square.onCollision(w);
            for (Ball b : balls) {
                b.onCollision(w);
                if (collide) {
                    square.onCollision(b);
                }
            }
            if (rotatingball1.checkCollision(w)) {
                /*code to rotate the two rotating balls in the correct direction based on their original speed.
                     It also sets them a little bit out of their original position so that they will not get stuck inside the wall.
                 */
                if (rotatingball1.getXSpeed() == -3) {
                    rotatingball1.setX(rotatingball1.getX() + 3);
                    rotatingball2.setX(rotatingball2.getX() - 2);
                    rotatingball1.setXSpeed(0);
                    rotatingball1.setYSpeed(3);
                    rotatingball2.setXSpeed(0);
                    rotatingball2.setYSpeed(-3);
                } else if (rotatingball1.getYSpeed() == 3) {
                    rotatingball1.setY(rotatingball1.getY() - 2);
                    rotatingball2.setY(rotatingball2.getY() + 2);
                    rotatingball1.setXSpeed(3);
                    rotatingball1.setYSpeed(0);
                    rotatingball2.setXSpeed(-3);
                    rotatingball2.setYSpeed(0);
                } else if (rotatingball1.getXSpeed() == 3) {
                    rotatingball1.setX(rotatingball1.getX() - 3);
                    rotatingball2.setX(rotatingball2.getX() + 2);
                    rotatingball1.setXSpeed(0);
                    rotatingball1.setYSpeed(-3);
                    rotatingball2.setXSpeed(0);
                    rotatingball2.setYSpeed(3);
                } else if (rotatingball1.getYSpeed() == -3) {
                    rotatingball1.setY(rotatingball1.getY() + 2);
                    rotatingball2.setY(rotatingball2.getY() - 2);
                    rotatingball1.setXSpeed(-3);
                    rotatingball1.setYSpeed(0);
                    rotatingball2.setXSpeed(3);
                    rotatingball2.setYSpeed(0);
                }
            }
        }
        square.onCollision(coin1);
        square.onCollision(coin2);
    }
}
