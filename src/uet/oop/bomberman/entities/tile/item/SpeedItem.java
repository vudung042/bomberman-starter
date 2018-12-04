package uet.oop.bomberman.entities.tile.item;

import uet.oop.bomberman.Game;
import uet.oop.bomberman.sounds.*;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.graphics.Sprite;

import java.io.File;

public class SpeedItem extends Item {

	public SpeedItem(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}

	@Override
	public boolean collide(Entity e) {
	    //tăng tốc độ chạy bomber
		// TODO: xử lý Bomber ăn Item
		if (e instanceof Bomber) {
			Sound sound = new Sound(new File("C:\\Users\\ADMIN\\IdeaProjects\\bomberman-starter\\res\\Sound\\Items.wav"));
			sound.play();
			sound.stop();
            Game.addBomberSpeed(0.3);
            remove();
        }
        return true;
	}
}
