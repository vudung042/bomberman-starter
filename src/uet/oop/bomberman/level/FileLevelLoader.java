package uet.oop.bomberman.level;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.LayeredEntity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Balloon;
import uet.oop.bomberman.entities.character.enemy.Oneal;
import uet.oop.bomberman.entities.tile.Grass;
import uet.oop.bomberman.entities.tile.Portal;
import uet.oop.bomberman.entities.tile.Wall;
import uet.oop.bomberman.entities.tile.destroyable.Brick;
import uet.oop.bomberman.entities.tile.item.BombItem;
import uet.oop.bomberman.entities.tile.item.FlameItem;
import uet.oop.bomberman.entities.tile.item.SpeedItem;
import uet.oop.bomberman.exceptions.LoadLevelException;
import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.graphics.Sprite;

import java.io.*;

public class FileLevelLoader extends LevelLoader {

	/**
	 * Ma trận chứa thông tin bản đồ, mỗi phần tử lưu giá trị kí tự đọc được
	 * từ ma trận bản đồ trong tệp cấu hình
	 */
	private static char[][] _map;
	
	public FileLevelLoader(Board board, int level) throws LoadLevelException {
		super(board, level);
	}
	
	@Override
	public void loadLevel(int level) {
		// TODO: đọc dữ liệu từ tệp cấu hình /levels/Level{level}.txt
		// TODO: cập nhật các giá trị đọc được vào _width, _height, _level, _map
		try {
		InputStream in = FileLevelLoader.class.getResourceAsStream("/levels/Level" + level + ".txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String data = br.readLine();
			String[] k = data.split(" ");
			_level = Integer.parseInt(k[0]);
			_height = Integer.parseInt(k[1]);
			_width = Integer.parseInt(k[2]);
			_map = new char[_height][_width];
			String line;
			for(int i = 0; i<_height;i++){
				line = br.readLine();
				for (int j=0;j<_width;j++){
					_map[i][j] = line.charAt(j);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createEntities() {
		// TODO: tạo các Entity của màn chơi
		// TODO: sau khi tạo xong, gọi _board.addEntity() để thêm Entity vào game

		// TODO: phần code mẫu ở dưới để hướng dẫn cách thêm các loại Entity vào game
		// TODO: hãy xóa nó khi hoàn thành chức năng load màn chơi từ tệp cấu hình
		// thêm Wall
		for(int x=0;x<_width;x++){
			for(int y=0; y<_height;y++){
				char a = _map[y][x];
				int pos = x + y * _width;
				//thêm Wall
				if(a=='#') _board.addEntity(pos, new Wall(x, y,  Sprite.wall));
				//thêm Bomber
				else if(a=='p') {
					_board.addCharacter(new Bomber(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
					Screen.setOffset(0, 0);
					_board.addEntity(pos, new Grass(x, y, Sprite.grass));
				}
				//thêm Balloon
				else if(a=='1') {
					_board.addCharacter(new Balloon(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
					_board.addEntity(pos, new Grass(x, y, Sprite.grass));
				}
				//thêm Oneal
				else if(a=='2') {
					_board.addCharacter(new Oneal(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
					_board.addEntity(pos, new Grass(x, y, Sprite.grass));
				}
				//thêm Brick
				else if(a=='*'){
					_board.addEntity(pos, new LayeredEntity(x, y, new Grass(x, y, Sprite.grass), new Brick(x, y, Sprite.brick)));
				}
				//thêm SpeedItem
				else if(a=='s'){
					_board.addEntity(pos, new LayeredEntity(x, y, new Grass(x ,y, Sprite.grass), new SpeedItem(x, y, Sprite.powerup_wallpass), new Brick(x, y, Sprite.brick)));
				}
				//thêm BombItem
				else if(a=='b'){
					_board.addEntity(pos, new LayeredEntity(x, y, new Grass(x ,y, Sprite.grass), new BombItem(x, y, Sprite.powerup_bombs), new Brick(x, y, Sprite.brick)));
				}
				//thêm FlameItem
				else if(a=='f'){
					_board.addEntity(pos, new LayeredEntity(x, y, new Grass(x ,y, Sprite.grass), new FlameItem(x, y, Sprite.powerup_flames), new Brick(x, y, Sprite.brick)));
				}
				//thêm Portal
				else if(a=='x'){
					_board.addEntity(pos, new LayeredEntity(x, y, new Grass(x ,y, Sprite.grass), new Portal(x, y, Sprite.portal,_board), new Brick(x, y, Sprite.brick)));
				}
				else
					_board.addEntity(pos, new Grass(x, y,  Sprite.grass));
			}
		}

	}

}
