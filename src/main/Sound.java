package main;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[30]; // se utiliza la url para almacenar la ruta de los archivos de sonido

    public Sound() {

        soundURL[0] = getClass().getResource("/sound/SonicAdventures.wav");
        soundURL[1] = getClass().getResource("/sound/Key.wav");
        soundURL[2] = getClass().getResource("/sound/Coin.wav");
        soundURL[3] = getClass().getResource("/sound/PowerUp.wav");
        soundURL[4] = getClass().getResource("/sound/Unlock.wav");
    }
    // crearemos 4 metodos

    public void setFile(int i) {

        try {

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais); // de esta manera se abre un archivo de audio en java

        } catch (Exception e) {
        }
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }
}
