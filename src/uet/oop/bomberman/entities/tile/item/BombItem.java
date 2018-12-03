package uet.oop.bomberman.entities.tile.item;

import uet.oop.bomberman.Game;
import uet.oop.bomberman.Sound;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.graphics.Sprite;

public class BombItem extends Item {

	public BombItem(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}

	@Override
	public boolean collide(Entity e) {
		//tăng số lượng bomb
		// TODO: xử lý Bomber ăn Item
		if (e instanceof Bomber) {
			Sound sound = new Sound("C:\\Users\\ADMIN\\IdeaProjects\\bomberman-starter\\res\\Sound\\18_SFX 1.wav");
			sound.start();
			Game.addBombRate(1);
			remove();
		}
		return true;
	}
}
