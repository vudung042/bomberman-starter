package uet.oop.bomberman;

import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.bomb.Flame;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Enemy;
import uet.oop.bomberman.gui.Frame;
import uet.oop.bomberman.sounds.Sound;
import uet.oop.bomberman.sounds.Sounds;


import java.io.File;

public class BombermanGame {

	public static void main(String[] args) {
        Sounds.audio();
		new Frame();

	}
}
