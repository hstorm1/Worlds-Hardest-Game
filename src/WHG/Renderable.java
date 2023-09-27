/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WHG;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

/**
 * This interface is used to draw the objects on the screen.
 *
 * @author hill.david20
 */
public interface Renderable {

    /**
     * This method is used to draw the objects on the screen.
     *
     * @param canvas is the screen in which to draw on.
     * @param color is the color that will be used for the object.
     */
    public void draw(Canvas canvas, Color color);
}
