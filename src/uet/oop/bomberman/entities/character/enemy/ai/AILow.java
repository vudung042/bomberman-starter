package uet.oop.bomberman.entities.character.enemy.ai;

import java.*;

public class AILow extends AI {

	@Override
	public int calculateDirection() {
		// TODO: cài đặt thuật toán tìm đường đi

			return random.nextInt(4);

	}

}
