package uet.oop.bomberman;

import uet.oop.bomberman.gui.Frame;

public class BombermanGame {
	
	public static void main(String[] args) {
		Sound sound = new Sound("C:\\Users\\dell\\IdeaProjects\\bomberman-starter\\res\\Sound\\Sound.wav");
		sound.start();
		sound.suspend();
		sound.resume();
		new Frame();

	}
}
