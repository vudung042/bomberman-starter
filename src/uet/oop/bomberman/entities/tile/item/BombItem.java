package uet.oop.bomberman.entities.tile.item;

import uet.oop.bomberman.Game;
import uet.oop.bomberman.sounds.*;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.graphics.Sprite;

import java.io.File;

public class BombItem extends Item {

	public BombItem(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}

	@Override
	public boolean collide(Entity e) {
		//tăng số lượng bomb
		// TODO: xử lý Bomber ăn Item
		if (e instanceof Bomber) {
			Game.addBombRate(1);
			remove();
			Sound sound = new Sound(new File("C:\\Users\\dell\\IdeaProjects\\bomberman-starter\\res\\Sound\\Items.wav"));
			sound.play();
			sound.stop();
		}
		return false;
	}
}
