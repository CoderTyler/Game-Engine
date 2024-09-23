package utilities;
import main.GamePanel;
public class CollisionManager {
	public static boolean isValidMove(float x, float y, int width, int height, int[][] mapData) {
		if(!isSolid(x, y, mapData)) 
			if(!isSolid(x+width, y+height, mapData)) 
				if(!isSolid(x+width, y, mapData)) 
					if(!isSolid(x+width, y+height, mapData)) 
						return true;
		return false;
		
	}
	
	public static boolean isSolid(float x, float y, int[][] mapData) {
		if(x <= 0 || x >= GamePanel.WORLD_WIDTH - 24) {
			return true;
		}
		if(y <= 0 || y >= GamePanel.WORLD_HEIGHT - 24) {
			return true;
		}
		float xIndex = x /GamePanel.TILE_SIZE;
		float yIndex = y /GamePanel.TILE_SIZE;
		
		int value = mapData[(int)yIndex][(int)xIndex];
		
		if (value >= 150 || value < 0){
			return true;
		}
		else 
			return false;
	}
}
