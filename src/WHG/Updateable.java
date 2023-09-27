/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WHG;

import javafx.scene.canvas.Canvas;

/**
 * This interface is used to update the objects on the screen mainly for the
 * movement of them.
 *
 * @author hill.david20
 *
 */
public interface Updateable {

    /**
     * This method will update the objects on the screen.
     *
     * @param canvas is the screen in which to draw on.
     */
    public void update(Canvas canvas);
}
