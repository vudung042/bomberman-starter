package uet.oop.bomberman.sounds;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;


public class Sounds
{
    public static AudioClip play(String path)
    {
        AudioClip clip=null;
        URL url = Sounds.class.getResource(path);
        clip = Applet.newAudioClip(url);

        return clip;
    }

    public static AudioClip bomno(){
        return play("/Sound/Explosion.wav");
    }
    public static AudioClip bomberchet(){
        return play("/Sound/Die.wav");
    }
    public static AudioClip enemychet(){
        return play("/Sound/Enemy.wav");
    }
    public static AudioClip gameover(){
        return play("/Sound/GameOver.wav");
    }
    public static AudioClip anitem(){
        return play("/Sound/Items.wav");
    }
    public static AudioClip win(){
    return play("/Sound/Win.wav");
    }
    public static AudioClip datbom(){
        return play("/Sound/placeBomb.wav");
    }
    public static AudioClip quacua(){
        return play("/Sound/Portal.wav");
    }

}

