package uet.oop.bomberman.entities.tile.item;

import uet.oop.bomberman.sounds.*;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.Game;

import java.io.File;

public class FlameItem extends Item {

	public FlameItem(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}

	@Override
	public boolean collide(Entity e) {
		//tăng độ dài flame
		// TODO: xử lý Bomber ăn Item
		if (e instanceof Bomber) {

			Game.addBombRadius(1);
			remove();
			Sound.anitem();
		}
		return false;
	}
}
