package uet.oop.bomberman.sounds;
//import java.io.IOException;
//
//import javax.sound.sampled.AudioInputStream;
//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.Clip;
//import javax.sound.sampled.LineUnavailableException;
//import javax.sound.sampled.UnsupportedAudioFileException;
//
//public class Sound {
//        private Clip clip;
//
//        public Sound(Clip clip)
//        {
//            this.clip = clip;
//        }
//
//        public void play()
//        {
//            new Thread(new Runnable()
//            {
//                @Override
//                public void run()
//                {
//                    synchronized (clip)
//                    {
//                        clip.stop();
//                        clip.setFramePosition(0);
//                        clip.start();
//                    }
//                }
//            }).start();
//        }
//
//        public void stop()
//        {
//            clip.stop();
//        }
//
//        // Static implementation
//        public static Sound menu = Sound.loadSound("menu.wav");
//        public static Sound bomb = Sound.loadSound("bomb.wav");
//        public static Sound bip = Sound.loadSound("bip2.wav");
//
//        public static Sound loadSound(String name)
//        {
//            Sound sound = null;
//
//            try
//            {
//                AudioInputStream ais = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource("sounds/" + name));
//                Clip clip = AudioSystem.getClip();
//                clip.open(ais);
//
//                sound = new Sound(clip);
//            }
//            catch (UnsupportedAudioFileException e)
//            {
//                e.printStackTrace();
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//            catch (LineUnavailableException e)
//            {
//                e.printStackTrace();
//            }
//
//            return sound;
//        }
//    }
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound {

    private Clip clip;

    public Sound(File path) {
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
        } catch (Exception e) {
        }
    }

    public void play() {
        if (clip != null) {
            stop();
            clip.setFramePosition(0);
            clip.start();
        }
    }

    public void stop() {
        if (clip.isRunning()) clip.stop();
    }

    public void close() {
        clip.close();
    }

//    public static void main(String[] args) {
//        Audio audio = new Audio(new File("Asset/placeBombSound.war"));
//        audio.play();
//    }
}
