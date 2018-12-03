package uet.oop.bomberman.entities.tile.item;

import uet.oop.bomberman.Game;
import uet.oop.bomberman.Sound;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.graphics.Sprite;

public class SpeedItem extends Item {

	public SpeedItem(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}

	@Override
	public boolean collide(Entity e) {
	    //tăng tốc độ chạy bomber
		// TODO: xử lý Bomber ăn Item
		if (e instanceof Bomber) {
			Sound sound = new Sound("C:\\Users\\ADMIN\\IdeaProjects\\bomberman-starter\\res\\Sound\\18_SFX 1.wav");
			sound.start();
            Game.addBomberSpeed(0.3);
            remove();
        }
        return true;
	}
}
