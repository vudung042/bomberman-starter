package uet.oop.bomberman.sounds;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class  Sound {

    public static Clip clip;


    public static void clips(File path) {
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
            clip.start();
        } catch (Exception e) {
        }

    }

    public static void bomno(){
        clips(new File("C:\\Users\\ADMIN\\IdeaProjects\\bomberman-starter1\\res\\Sound\\Explosion.wav"));
    }
    public static void bomberchet(){
        clips(new File("C:\\Users\\ADMIN\\IdeaProjects\\bomberman-starter1\\res\\Sound\\Die.wav"));
    }
    public static void enemychet(){
        clips(new File("C:\\Users\\ADMIN\\IdeaProjects\\bomberman-starter1\\res\\Sound\\Enemy.wav"));
    }
    public static void gameover(){
        clips(new File("C:\\Users\\ADMIN\\IdeaProjects\\bomberman-starter1\\res\\Sound\\GameOver.wav"));
    }
    public static void anitem(){
        clips(new File("C:\\Users\\ADMIN\\IdeaProjects\\bomberman-starter1\\res\\Sound\\Items.wav"));
    }
    public static void win(){
        clips(new File("C:\\Users\\ADMIN\\IdeaProjects\\bomberman-starter1\\res\\Sound\\Win.wav"));
    }
    public static void datbom(){
        clips(new File("C:\\Users\\ADMIN\\IdeaProjects\\bomberman-starter1\\res\\Sound\\placeBomb.wav"));
    }
    public static void quacua(){
        clips(new File("C:\\Users\\dell\\IdeaProjects\\bomberman-starter\\res\\Sound\\Portal.wav"));
    }
}
