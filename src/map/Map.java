package map;

import java.awt.image.BufferedImage;

public class Map {
	public static int[][] mapData;
	
	public BufferedImage image;
	public boolean collision = false;
	
	
	public Map(int[][] mapData) {
		Map.mapData = mapData;
	}
	
	public int getSpriteIndex(int x, int y) {
		return mapData[x][y];
	}
	
	public int[][] getMapData(){
		return mapData;
	}
}
