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
 * This class is used to draw the walls on the screen.
 *
 * @author hill.david20
 */
public class Wall extends Block implements Renderable {

    /**
     * Initialization constructor to construct a wall. It is just a block in the
     * game so it only needs to make the super call.
     *
     * @param x is the x position.
     * @param y is the y position.
     * @param w is the width.
     * @param h is the height.
     * @param col is the color.
     */
    public Wall(double x, double y, double w, double h, Color col) {
        super(x, y, w, h, col);
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
     * This method is used to draw the objects on the screen.
     *
     * @param canvas is the screen in which to draw on.
     * @param color is the color that will be used for the object.
     */
    @Override
    public void draw(Canvas canvas, Color color) {
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        graphics.setFill(Color.BLACK);
        graphics.fillRect(getX(), getY(), getWidth(), getHeight());
    }

}
