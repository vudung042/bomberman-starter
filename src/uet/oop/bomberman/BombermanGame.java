package uet.oop.bomberman;

import uet.oop.bomberman.gui.Frame;
import uet.oop.bomberman.sounds.Sound;

import java.io.File;

public class BombermanGame {
	
	public static void main(String[] args) {
		File file = new File("C:\\Users\\ADMIN\\IdeaProjects\\bomberman-starter\\res\\Sound\\Sound.wav");
		Sound sound = new Sound(file);
		sound.play();
		new Frame();

	}
}
