package uet.oop.bomberman.sounds;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class  Sound {

    public static Clip clip;

    public static void clip(File path) {
        try {
            AudioInputStream ais;
            ais = AudioSystem.getAudioInputStream(path);
            AudioFormat baseFormat = ais.getFormat();
            AudioFormat decodeFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(),
                    16,
                    baseFormat.getChannels(),
                    baseFormat.getChannels() * 2,
                    baseFormat.getSampleRate(),
                    false
            );
            AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
            clip = AudioSystem.getClip();
            clip.open(dais);
            clip.loop(5);
        } catch (Exception e) {
        }

    }

    public static void stop() {
        if (clip.isRunning()) clip.stop();
    }

    public static void audio(){
       clip(new File("C:\\Users\\dell\\IdeaProjects\\bomberman-starter\\res\\Sound\\Audio.wav"));

    }
}
