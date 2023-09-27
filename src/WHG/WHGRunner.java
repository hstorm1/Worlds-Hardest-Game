/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WHG;

import javafx.scene.canvas.Canvas;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This class is used to run The World's Hardest Game.
 *
 * @author hill.david20
 */
public class WHGRunner extends Application {

    /**
     * @param args the command line arguments
     */
    //declaring all instance variables for the square, levels, coins, animated blocks, and menus.
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private static Canvas canvas;
    private LevelOne levelone;
    private LevelTwo leveltwo;
    private LevelThree levelthree;
    private LevelThreePreMenu levelthreepremenu;
    private LevelFour levelfour;
    private LevelFive levelfive;
    private LevelFivePreMenu levelfivepremenu;
    private Square square;
    private Coin coin1;
    private Coin coin2;
    private AnimatedBlock ablock, ablock2, ablock3, ablock4, ablock5, ablock6, ablock7, ablock8, ablock9, ablock10;
    private MenuOne menuone;
    private MenuTwo menutwo;
    private MenuThree menuthree;
    private GameCompletedMenu gcMenu;
    private TopBar topbar;
    private int setX = 1;
    private boolean move, mone = true;
    private boolean mtwo, mthree, startsong, tbar, lone, lonePre, ltwo, ltwoPre, lthree, lthreePre,
            lthreePreM, lfour, lfourPre, lfive, lfivePre, lfivePreM = false;
    private int levelcount = 1;
    private double preLevelFC = 100;
    private int deathFC = 50;
    private long millis, millis2;
    /*the millis variables are used to get the time before and after the game is played
    so that the time it took to finish the game can be calculated.*/
    RedrawTimer timer = new RedrawTimer();

    /**
     * This method starts the game up and initializes all the instance
     * variables.
     *
     * @param primaryStage is the main Stage to start the game.
     * @throws Exception is the game cannot be loaded.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();
        canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);
        square = new Square(115, 260, 16, 16, Color.RED, 0, 0);
        coin1 = new Coin(434, 282, 17, 17, Color.BLACK);
        coin2 = new Coin(629, 409, 17, 17, Color.BLACK);
        levelone = new LevelOne(square);
        leveltwo = new LevelTwo(square, coin1);
        levelthree = new LevelThree(square, coin1);
        levelfour = new LevelFour(square, coin1, coin2);
        levelfive = new LevelFive(square, coin1);
        ablock = new AnimatedBlock(250, 364, 70, 31, Color.WHITE);
        ablock2 = new AnimatedBlock(285, 230, 315, 134, Color.WHITE);
        ablock3 = new AnimatedBlock(565, 195, 74, 35, Color.WHITE);
        ablock4 = new AnimatedBlock(202, 180, 480, 214, Color.WHITE);
        ablock5 = new AnimatedBlock(353, 234, 134, 26, Color.WHITE);
        ablock6 = new AnimatedBlock(460, 260, 26, 108, Color.WHITE);
        ablock7 = new AnimatedBlock(353, 340, 108, 26, Color.WHITE);
        ablock8 = new AnimatedBlock(353, 260, 27, 82, Color.WHITE);
        ablock9 = new AnimatedBlock(210, 142, 440, 290, Color.WHITE);
        ablock10 = new AnimatedBlock(140, 150, 600, 300, Color.WHITE);
        millis = millis2 = 0;
        menuone = new MenuOne();
        menutwo = new MenuTwo();
        menuthree = new MenuThree();
        levelthreepremenu = new LevelThreePreMenu();
        levelfivepremenu = new LevelFivePreMenu();
        gcMenu = new GameCompletedMenu();
        topbar = new TopBar();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setTitle("The World's Hardest Game");
        primaryStage.setScene(scene);
        primaryStage.show();
        timer.start();

        scene.setOnKeyPressed((KeyEvent event) -> {
            if ((event.getCode() == KeyCode.RIGHT && move) || (event.getCode() == KeyCode.D && move)) {
                square.setXVel(2.25);
                //set the square to move to the right
            }
            if ((event.getCode() == KeyCode.LEFT && move) || (event.getCode() == KeyCode.A && move)) {
                square.setXVel(-2.25);
                //set the square to move to the left
            }
            if ((event.getCode() == KeyCode.UP && move) || (event.getCode() == KeyCode.W && move)) {
                square.setYVel(-2.25);
                //set the square to move up
            }
            if ((event.getCode() == KeyCode.DOWN && move) || (event.getCode() == KeyCode.S && move)) {
                square.setYVel(2.25);
                //set the square to move down
            }
            if (event.getCode() == KeyCode.ENTER && lthreePreM) {
                lthreePreM = false;
                lthreePre = true;
            }
            if (event.getCode() == KeyCode.ENTER && lfivePreM) {
                lfivePreM = false;
                lfivePre = true;
            }
            /if you would like to beat the game easily without dying,
            just press Control Alt Shift E, and it will shut off collisions between the square and the ball.
            However, this comes with a cost. Your death count will be set to 1000. It's up to you if it's worth it.*/
            if (event.getCode() == KeyCode.E && event.isControlDown() && event.isShiftDown() && event.isAltDown()) {
                if (square.getDeathCount() < 1000) {
                    square.setDeathCount(1000);
                }
                if (levelone.getCollide()) {
                    levelone.setCollide(false);
                    leveltwo.setCollide(false);
                    levelthree.setCollide(false);
                    levelfour.setCollide(false);
                    levelfive.setCollide(false);
                } else {
                    levelone.setCollide(true);
                    leveltwo.setCollide(true);
                    levelthree.setCollide(true);
                    levelfour.setCollide(true);
                    levelfive.setCollide(true);
                }
            }
        });
        scene.setOnKeyReleased((KeyEvent event) -> {
            if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D) {
                square.setXVel(0);
                //set the square to not move
            }
            if (event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A) {
                square.setXVel(0);
                //set the square to not move
            }
            if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W) {
                square.setYVel(0);
                //set the square to not move
            }
            if (event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.S) {
                square.setYVel(0);
                //set the square to not move
            }
        });
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                double mouseX = t.getX();
                double mouseY = t.getY();
                if (t.getButton().equals(MouseButton.PRIMARY)) //left mouse button pressed
                {
                    //these if statements represent if the mouse is pressed on a menu button.
                    if (mouseX > 280 && mouseX < 620 && mouseY > 240 && mouseY < 280 && mone) {
                        startsong = true;
                        mtwo = true;
                    }
                    if (mouseX > 330 && mouseX < 550 && mouseY > 420 && mouseY < 550 && mtwo) {
                        mthree = true;
                    }
                    if (mouseX > 580 && mouseX < 800 && mouseY > 420 && mouseY < 550 && mthree) {
                        lonePre = true;
                        tbar = true;
                    }
                    if (mouseX > 80 && mouseX < 300 && mouseY > 420 && mouseY < 550 && mthree) {
                        mthree = false;
                        mtwo = true;
                    }
                    if (mouseX > 10 && mouseX < 100 && mouseY > 0 && mouseY < 50 && tbar) {
                        levelcount = 1;
                        lone = false;
                        lonePre = false;
                        ltwo = false;
                        ltwoPre = false;
                        lthree = false;
                        lthreePre = false;
                        lthreePreM = false;
                        lfour = false;
                        lfourPre = false;
                        lfivePre = false;
                        lfive = false;
                        lfivePreM = false;
                        tbar = false;
                        mtwo = true;
                        square.reset();
                    }
                    if (lthreePreM && mouseX > 355 && mouseY > 450 && mouseX < 505 && mouseY < 550) {
                        lthreePreM = false;
                        lthreePre = true;
                    }
                    if (lfivePreM && mouseX > 355 && mouseY > 450 && mouseX < 505 && mouseY < 550) {
                        lfivePreM = false;
                        lfivePre = true;
                    }
                    if (mouseX > 305 && mouseX < 525 && mouseY > 420 && mouseY < 550 && levelcount == 6) {
                        mtwo = true;
                    }
                }
            }
        });
    }

    /**
     * This launches the program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This class is used to draw and update objects on the screen with a Timer.
     */
    public class RedrawTimer extends AnimationTimer {

        /**
         * This method is what is used to draw and update the objects in the
         * game.
         *
         * @param now does nothing.
         */
        @Override
        public void handle(long now) {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            ablock.change(canvas);
            ablock2.change(canvas);
            ablock3.change(canvas);
            ablock4.change(canvas);
            ablock5.change(canvas);
            ablock6.change(canvas);
            ablock7.change(canvas);
            ablock8.change(canvas);
            ablock9.change(canvas);
            ablock10.change(canvas);
            if (mone) {
                ltwo = false;
                menuone.draw(canvas);
            }
            if (startsong) {
                String filepath = "World's Hardest Game Soundtrack.wav";
                musicStuff musicObject = new musicStuff();
                musicObject.playMusic(filepath);
            }
            if (mtwo) {
                preLevelFC = 100;
                levelfive.resetAllBalls();
                setX = 1;
                levelcount = 1;
                coin1.setOriginalX(434);
                coin1.setOriginalY(282);
                coin1.reset();
                coin2.reset();
                mone = false;
                startsong = false;
                menutwo.draw(canvas);
            }
            if (mthree) {
                mtwo = false;
                menuthree.draw(canvas);
            }
            if (lonePre) {
                millis = System.currentTimeMillis();
                mthree = false;
                square.setDeathCount(0);
                levelone.setCollide(true);
                leveltwo.setCollide(true);
                levelthree.setCollide(true);
                levelfour.setCollide(true);
                levelfive.setCollide(true);
                gc.setFill(Color.WHITESMOKE);
                gc.fillRect(0, 0, 900, 600);
                gc.setFill(Color.BLACK);
                gc.setFont(new Font("BOLD", 60));
                gc.fillText("YOU DON'T KNOW WHAT", 110, 290);
                gc.fillText("YOU'RE GETTING INTO.", 110, 370);
                preLevelFC -= 0.9;
            }
            if (preLevelFC <= 0) {
                lone = true;
                preLevelFC = 100;
            }
            if (lone) {
                lonePre = false;
                if (setX == 1) {
                    square.setX(190);
                    square.setY(285);
                    square.setOriginalX(190);
                    square.setOriginalY(285);
                    setX = 2;
                }
                gc.setFill(Color.rgb(180, 181, 254));
                gc.fillRect(0, 0, 900, 600);
                gc.setFill(Color.rgb(181, 254, 180));
                gc.fillRect(150, 195, 100, 200);
                gc.fillRect(639, 195, 100, 200);
                ablock.draw(canvas, ablock.getColor());
                ablock2.draw(canvas, ablock2.getColor());
                ablock3.draw(canvas, ablock3.getColor());
                levelone.drawAll(canvas);
                levelone.updateAll(canvas);
                levelone.checkCollide();
            }
            if (square.getX() > 639 && lone) {
                ltwoPre = true;
                levelcount = 2;
            }
            if (ltwoPre) {
                lone = false;
                gc.setFill(Color.WHITESMOKE);
                gc.fillRect(0, 0, 900, 600);
                gc.setFill(Color.BLACK);
                gc.setFont(new Font("BOLD", 70));
                gc.fillText("DON'T EVEN BOTHER", 110, 290);
                gc.fillText("TRYING.", 310, 370);
                preLevelFC--;
            }
            if (preLevelFC == 0) {
                ltwo = true;
                preLevelFC = 100;
            }
            if (ltwo) {
                ltwoPre = false;
                if (setX == 2) {
                    square.setX(115);
                    square.setY(280);
                    square.setOriginalX(115);
                    square.setOriginalY(280);
                    setX = 3;
                }
                gc.setFill(Color.rgb(180, 181, 254));
                gc.fillRect(0, 0, 900, 600);
                ablock4.draw(canvas, ablock4.getColor());
                gc.setFill(Color.rgb(181, 254, 180));
                gc.fillRect(90, 250, 112, 70);
                gc.fillRect(682, 255, 110, 69);
                leveltwo.drawAll(canvas);
                leveltwo.updateAll(canvas);
                leveltwo.checkCollide();
            }
            if (square.getX() > 680 && square.getY() > 255 && square.getY() + square.getHeight() < 324 && coin1.getX() == -50 && ltwo) {
                ltwo = false;
                lthreePreM = true;
                levelcount = 3;
            }
            if (lthreePreM) {
                levelthreepremenu.draw(canvas);
            }
            if (lthreePre) {
                ltwo = false;
                lthreePreM = false;
                gc.setFill(Color.WHITESMOKE);
                gc.fillRect(0, 0, 900, 600);
                gc.setFill(Color.BLACK);
                gc.setFont(new Font("BOLD", 50));
                gc.fillText("I CAN ALMOST GUARANTEE", 130, 290);
                gc.setFont(new Font("BOLD", 70));
                gc.fillText("YOU WILL FAIL.", 210, 370);
                preLevelFC -= 0.9;
            }
            if (preLevelFC <= 0) {
                lthree = true;
                preLevelFC = 100;
            }
            if (lthree) {
                lthreePre = false;
                if (setX == 3) {
                    square.setX(410);
                    square.setY(290);
                    square.setOriginalX(410);
                    square.setOriginalY(290);
                    coin1.setX(360);
                    coin1.setY(210);
                    coin1.setOriginalX(360);
                    coin1.setOriginalY(210);
                    setX = 4;
                }
                gc.setFill(Color.rgb(180, 181, 254));
                gc.fillRect(0, 0, 900, 600);
                ablock5.draw(canvas, ablock5.getColor());
                ablock6.draw(canvas, ablock6.getColor());
                ablock7.draw(canvas, ablock7.getColor());
                ablock8.draw(canvas, ablock8.getColor());
                gc.setFill(Color.rgb(181, 254, 180));
                gc.fillRect(380, 260, 80, 80);
                levelthree.drawAll(canvas);
                levelthree.updateAll(canvas);
                levelthree.checkCollide();
            }
            if (square.getX() >= 380 && square.getY() >= 260 && coin1.getX() == -50 && lthree) {
                lthree = false;
                lfourPre = true;
                levelcount = 4;
            }
            if (lfourPre) {
                lthree = false;
                gc.setFill(Color.WHITESMOKE);
                gc.fillRect(0, 0, 900, 600);
                gc.setFill(Color.BLACK);
                gc.setFont(new Font("BOLD", 70));
                gc.fillText("THAT ONE WAS EASY.", 100, 330);
                preLevelFC--;
            }
            if (preLevelFC == 0) {
                lfour = true;
                preLevelFC = 100;
            }
            if (lfour) {
                lfourPre = false;
                if (setX == 4) {
                    square.setX(424);
                    square.setY(115);
                    square.setOriginalX(424);
                    square.setOriginalY(115);
                    coin1.setX(217);
                    coin1.setY(147);
                    coin1.setOriginalX(217);
                    coin1.setOriginalY(147);
                    setX = 5;
                }
                gc.setFill(Color.rgb(180, 181, 254));
                gc.fillRect(0, 0, 900, 600);
                ablock9.draw(canvas, ablock9.getColor());
                gc.setFill(Color.rgb(181, 254, 180));
                gc.fillRect(410, 100, 44, 42);
                gc.fillRect(410, 432, 44, 42);
                levelfour.drawAll(canvas);
                levelfour.updateAll(canvas);
                levelfour.checkCollide();
            }
            if (square.getY() >= 437 && coin1.getX() == -50 && coin2.getX() == -50 && lfour) {
                lfour = false;
                lfivePreM = true;
                levelcount = 5;
            }
            if (lfivePreM) {
                levelfivepremenu.draw(canvas);
            }
            if (lfivePre) {
                lfour = false;
                lfivePreM = false;
                gc.setFill(Color.WHITESMOKE);
                gc.fillRect(0, 0, 900, 600);
                gc.setFill(Color.BLACK);
                gc.setFont(new Font("BOLD", 80));
                gc.fillText("IMPOSSIBLE.", 210, 330);
                preLevelFC--;
            }
            if (preLevelFC == 0) {
                lfivePre = false;
                lfive = true;
                preLevelFC = 100;
            }
            if (lfive) {
                lfivePre = false;
                if (setX == 5) {
                    square.setX(197);
                    square.setY(210);
                    square.setOriginalX(197);
                    square.setOriginalY(210);
                    coin1.setX(600);
                    coin1.setY(185);
                    coin1.setOriginalX(600);
                    coin1.setOriginalY(185);
                    setX = 6;
                }
                gc.setFill(Color.rgb(180, 181, 254));
                gc.fillRect(0, 0, 900, 600);
                ablock10.draw(canvas, ablock10.getColor());
                gc.setFill(Color.rgb(181, 254, 180));
                gc.fillRect(670, 355, 70, 96);
                gc.fillRect(140, 150, 90, 106);
                levelfive.drawAll(canvas);
                levelfive.updateAll(canvas);
                levelfive.checkCollide();
            }
            if (square.getX() >= 675 && square.getY() > 365 && coin1.getX() == -50 && lfive) {
                millis2 = System.currentTimeMillis();
                System.out.println("You finished the game in " + ((millis2 - millis) / 1000.0) + " seconds.");
                lfive = false;
                levelcount = 6;
                tbar = false;
            }
            if (levelcount == 6) {
                gcMenu.draw(canvas);
                gc.setFill(Color.RED);
                gc.setFont(new Font("BOLD", 35));
                gc.fillText(Integer.toString(square.getDeathCount()), 530, 300);
            }
            if (tbar) {
                topbar.draw(canvas);
                gc.setFill(Color.WHITE);
                gc.fillText(Integer.toString(levelcount), 408, 35);
                gc.fillText(Integer.toString(square.getDeathCount()), 820, 35);
            }
            if (square.getHit()) {
                move = false;
            }
            if (!move) {
                square.setXVel(0);
                square.setYVel(0);
                square.setColor(Color.rgb(deathFC * 5, 0, 0));
                for (Ball b : levelfive.getBalls()) {
                    b.setColor(Color.rgb(deathFC * 5, 0, 0));
                }
                deathFC--;
            }
            if (deathFC == 50) {
                String filepath = "Punch Sound Effect.wav";
                musicStuff musicObject = new musicStuff();
                musicObject.playMusic(filepath);
            }
            if (deathFC == 1) {
                move = true;
                square.reset();
                square.setColor(Color.RED);
                coin1.reset();
                coin2.reset();
                levelfive.resetAllBalls();
                deathFC = 51;
            }
            if (preLevelFC == 99 || preLevelFC == 99.1) {
                String filepath = "Swoosh Sound Effect.wav";
                musicStuff musicObject = new musicStuff();
                musicObject.playMusic(filepath);
            }
            //update, draw and collide all of the Blocks in each of the levels.
        }
    }
}
