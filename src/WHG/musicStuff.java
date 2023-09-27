/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WHG;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * This class is used to play the music and the sound effects of the game.
 *
 * @author hill.david20
 */
public class musicStuff {

    /**
     * This method plays the music, and if it is the main song, it will play it
     * continuously.
     *
     * @param musicLocation is the song or sound effect that will be played.
     */
    void playMusic(String musicLocation) {
        try {
            File musicPath = new File(musicLocation);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                if (musicLocation.equals("World's Hardest Game Soundtrack.wav")) {
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                }
            } else {
                System.out.println("Can't find file");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
