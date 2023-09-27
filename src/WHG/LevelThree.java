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
 * This class is used to draw level three on the screen to be played.
 *
 * @author hill.david20
 */
public class LevelThree {

    private ArrayList<Ball> balls;
    private ArrayList<Wall> walls;
    private Square square;
    private Coin coin;
    private boolean collide;
    Wall invis;
    private double speed;

    /**
     * Initialization constructor to initialize the array lists, square, coin,
     * and speed of the balls. It initializes all the walls and balls to be
     * placed in the level as well, including one special invisible wall for the
     * just the rotating balls to collide with.
     *
     * @param s is the square.
     * @param c is the one coin in this level.
     */
    public LevelThree(Square s, Coin c) {
        collide = true;
        balls = new ArrayList<>();
        walls = new ArrayList<>();
        square = s;
        coin = c;
        speed = 2.25;
        Wall wall = new Wall(350, 200, 4, 165, Color.BLACK);
        Wall wall2 = new Wall(350, 200, 35, 4, Color.BLACK);
        Wall wall3 = new Wall(385, 200, 4, 30, Color.BLACK);
        Wall wall4 = new Wall(385, 230, 100, 4, Color.BLACK);
        Wall wall5 = new Wall(485, 230, 4, 135, Color.BLACK);
        Wall wall6 = new Wall(350, 365, 139, 4, Color.BLACK);
        invis = new Wall(350, 233, 35, 1, Color.BLACK);
        addWall(wall, wall2, wall3, wall4, wall5, wall6);
        Ball ball1 = new Ball(427, 235.5, 19, 19, Color.BLACK, speed, 0);
        Ball ball2 = new Ball(392, 344.5, 19, 19, Color.BLACK, -speed, 0);
        Ball ball3 = new Ball(427, 344.5, 19, 19, Color.BLACK, -speed, 0);
        for (double i = 235.5; i <= 344.5; i += 36.25) {
            Ball temp = new Ball(355.5, i, 19, 19, Color.BLACK, 0, -speed);
            Ball temp2 = new Ball(464.5, i, 19, 19, Color.BLACK, 0, speed);
            addBall(temp);
            addBall(temp2);
        }
        addBall(ball1);
        addBall(ball2);
        addBall(ball3);
    }

    /**
     * This method adds a ball to the array list of balls.
     *
     * @param a is the ball to be added to the array list.
     */
    public void addBall(Ball a) {
        balls.add(a);
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
     */
    public void addWall(Wall w1, Wall w2, Wall w3, Wall w4, Wall w5, Wall w6) {
        walls.add(w1);
        walls.add(w2);
        walls.add(w3);
        walls.add(w4);
        walls.add(w5);
        walls.add(w6);
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
        coin.draw(canvas, coin.getColor());
        for (Wall w : walls) {
            w.draw(canvas, w.getColor());
        }
        square.draw(canvas, square.getColor());
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
            square.onCollision(w);
            for (Ball b : balls) {
                if (collide) {
                    square.onCollision(b);
                }
                if (b.checkCollision(w) || b.checkCollision(invis)) {
                    /*code to rotate the balls in the correct direction based on their original speed.
                     It also sets them a little bit out of their original position so that they will not get stuck inside the wall.
                     */
                    if (b.getXSpeed() == speed) {
                        b.setX(464.5);
                        b.setXSpeed(0);
                        b.setYSpeed(speed);
                    } else if (b.getYSpeed() == speed) {
                        b.setY(344.5);
                        b.setXSpeed(-speed);
                        b.setYSpeed(0);
                    } else if (b.getXSpeed() == -speed) {
                        b.setX(355.5);
                        b.setXSpeed(0);
                        b.setYSpeed(-speed);
                    } else if (b.getYSpeed() == -speed) {
                        b.setY(235.5);
                        b.setXSpeed(speed);
                        b.setYSpeed(0);
                    }
                }
            }
        }
        square.onCollision(coin);
    }
}
