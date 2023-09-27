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
 * This class is used to draw level two on the screen to be played.
 *
 * @author hill.david20
 */
public class LevelTwo {

    private ArrayList<Ball> balls;
    private Coin coin;
    private ArrayList<Wall> walls;
    private Square square;
    private boolean collide;
    private int alternate = 1;
    //the alternate variable is used to alternate the balls to be drawn to save code.

    /**
     * Initialization constructor to initialize the array lists, square, and
     * coin. It initializes all the walls and balls to be placed in the level as
     * well.
     *
     * @param s is the square.
     * @param c is the one coin in this level.
     */
    public LevelTwo(Square s, Coin c) {
        balls = new ArrayList<>();
        coin = c;
        walls = new ArrayList<>();
        square = s;
        coin = c;
        collide = true;
        Wall wall = new Wall(90, 250, 110, 4, Color.BLACK);
        Wall wall2 = new Wall(90, 250, 4, 70, Color.BLACK);
        Wall wall3 = new Wall(90, 320, 110, 4, Color.BLACK);
        Wall wall4 = new Wall(200, 180, 4, 74, Color.BLACK);
        Wall wall5 = new Wall(200, 320, 4, 74, Color.BLACK);
        Wall wall6 = new Wall(200, 180, 480, 4, Color.BLACK);
        Wall wall7 = new Wall(200, 394, 480, 4, Color.BLACK);
        Wall wall8 = new Wall(680, 180, 4, 74, Color.BLACK);
        Wall wall9 = new Wall(680, 324, 4, 74, Color.BLACK);
        Wall wall10 = new Wall(680, 254, 110, 4, Color.BLACK);
        Wall wall11 = new Wall(680, 320, 110, 4, Color.BLACK);
        Wall wall12 = new Wall(790, 254, 4, 70, Color.BLACK);
        addWall(wall, wall2, wall3, wall4, wall5, wall6, wall7, wall8, wall9, wall10, wall11, wall12);
        int index = 213;
        while (index < 685) {
            if (alternate % 2 == 1) {
                Ball temp = new Ball(index, 186, 19, 19, Color.BLACK, 0, 3);
                addBall(temp);
                alternate++;
                index += 40;
            } else {
                Ball temp = new Ball(index, 374, 19, 19, Color.BLACK, 0, -3);
                addBall(temp);
                alternate++;
                index += 40;
            }
        }
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
            for (Ball b : balls) {
                b.onCollision(w);
            }
            square.onCollision(w);
        }
        square.onCollision(coin);
        if (collide) {
            for (Ball b : balls) {
                square.onCollision(b);
            }
        }
    }
}
