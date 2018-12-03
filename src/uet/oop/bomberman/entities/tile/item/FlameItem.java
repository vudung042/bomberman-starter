package uet.oop.bomberman.entities.tile.item;

import uet.oop.bomberman.Sound;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.Game;

public class FlameItem extends Item {

	public FlameItem(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}

	@Override
	public boolean collide(Entity e) {
		//tăng độ dài flame
		// TODO: xử lý Bomber ăn Item
		if (e instanceof Bomber) {
			Sound sound = new Sound("C:\\Users\\ADMIN\\IdeaProjects\\bomberman-starter\\res\\Sound\\18_SFX 1.wav");
			sound.start();
			Game.addBombRadius(1);
			remove();
		}
		return true;
	}
}
