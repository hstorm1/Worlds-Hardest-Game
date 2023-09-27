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
 * This class is used to draw level one on the screen to be played.
 *
 * @author hill.david20
 */
public class LevelOne {

    private ArrayList<Ball> balls;
    private ArrayList<Wall> walls;
    private ArrayList<Updateable> updateables;
    private Square square;
    private boolean collide;

    /**
     * Initialization constructor to initialize the array lists and the square.
     * It initializes all the walls and balls to be placed in the level as well.
     *
     * @param s is the square.
     */
    public LevelOne(Square s) {
        collide = true;
        balls = new ArrayList<>();
        walls = new ArrayList<>();
        updateables = new ArrayList<>();
        square = s;
        Wall wall = new Wall(150, 195, 100, 4, Color.BLACK);
        Wall wall2 = new Wall(150, 195, 4, 200, Color.BLACK);
        Wall wall3 = new Wall(250, 195, 4, 165, Color.BLACK);
        Wall wall4 = new Wall(250, 360, 35, 4, Color.BLACK);
        Wall wall5 = new Wall(150, 395, 170, 4, Color.BLACK);
        Wall wall6 = new Wall(320, 364, 4, 35, Color.BLACK);
        Wall wall7 = new Wall(285, 230, 4, 134, Color.BLACK);
        Wall wall8 = new Wall(285, 230, 280, 4, Color.BLACK);
        Wall wall9 = new Wall(320, 360, 280, 4, Color.BLACK);
        Wall wall10 = new Wall(565, 195, 4, 39, Color.BLACK);
        Wall wall11 = new Wall(565, 195, 170, 4, Color.BLACK);
        Wall wall12 = new Wall(600, 230, 4, 134, Color.BLACK);
        Wall wall13 = new Wall(600, 230, 35, 4, Color.BLACK);
        Wall wall14 = new Wall(635, 230, 4, 165, Color.BLACK);
        Wall wall15 = new Wall(735, 195, 4, 200, Color.BLACK);
        Wall wall16 = new Wall(635, 395, 104, 4, Color.BLACK);
        addWall(wall, wall2, wall3, wall4, wall5, wall6, wall7, wall8,
                wall9, wall10, wall11, wall12, wall13, wall14, wall15, wall16);
        Ball ball1 = new Ball(580, 243, 19, 19, Color.BLACK, -4.5, 0);
        Ball ball2 = new Ball(296, 276, 19, 19, Color.BLACK, 4.5, 0);
        Ball ball3 = new Ball(580, 309, 19, 19, Color.BLACK, -4.5, 0);
        Ball ball4 = new Ball(296, 340, 19, 19, Color.BLACK, 4.5, 0);
        addBall(ball1, ball2, ball3, ball4);
        addUpdateable(ball1, ball2, ball3, ball4, square);
    }

    /**
     * This method adds multiple balls in the array list in one call. It helps
     * from having to call one method many times.
     *
     * @param a is one of the balls to be added to the array list.
     * @param b is one of the balls to be added to the array list.
     * @param c is one of the balls to be added to the array list.
     * @param d is one of the balls to be added to the array list.
     */
    public void addBall(Ball a, Ball b, Ball c, Ball d) {
        balls.add(a);
        balls.add(b);
        balls.add(c);
        balls.add(d);
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
     * @param w13 is one of the walls to be added to the array list.
     * @param w14 is one of the walls to be added to the array list.
     * @param w15 is one of the walls to be added to the array list.
     * @param w16 is one of the walls to be added to the array list.
     */
    public void addWall(Wall w1, Wall w2, Wall w3, Wall w4, Wall w5, Wall w6, Wall w7, Wall w8,
            Wall w9, Wall w10, Wall w11, Wall w12, Wall w13, Wall w14, Wall w15, Wall w16) {
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
        walls.add(w13);
        walls.add(w14);
        walls.add(w15);
        walls.add(w16);
    }

    /**
     * This method adds multiple walls in the array list in one call. It helps
     * from having to call one method many times.
     *
     * @param u1 is one of the updateables to be added to the array list.
     * @param u2 is one of the updateables to be added to the array list.
     * @param u3 is one of the updateables to be added to the array list.
     * @param u4 is one of the updateables to be added to the array list.
     * @param u5 is one of the updateables to be added to the array list.
     */
    public void addUpdateable(Updateable u1, Updateable u2, Updateable u3, Updateable u4, Updateable u5) {
        updateables.add(u1);
        updateables.add(u2);
        updateables.add(u3);
        updateables.add(u4);
        updateables.add(u5);
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
        square.draw(canvas, square.getColor());
    }

    /**
     * This method updates the objects that need to be updated on the screen.
     *
     * @param canvas is the canvas in which to draw on.
     */
    public void updateAll(Canvas canvas) {
        for (Updateable u : updateables) {
            u.update(canvas);
        }
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
        if (collide) {
            for (Ball b : balls) {
                square.onCollision(b);
            }
        }
    }
}
