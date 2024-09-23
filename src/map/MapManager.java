package map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import entity.Player;
import gamestates.Game;
import main.GamePanel;
import utilities.DataLoader;

import static utilities.DataLoader.*;

public class MapManager {
	public BufferedImage[] tile;
	BufferedImage tilesSprite;
	//private BufferedImage[] mapSprite;
	private Map mapOne;
	private Player player;
	public MapManager(Player player) {
		tile = new BufferedImage[150];
		tilesSprite = getImageAssets(SPRING_SPRITE);
		mapOne = new Map(DataLoader.getMapData());
		this.player = player;
		getTileSubImage();
		
	}
	
	//ALL TILES SAVED IN TILE ARRAY
	public void getTileSubImage() {
		int index = 0;
		for (int j = 0; j<10; j++)
			for (int i = 0; i<15; i++) {
				index = j*15 + i;
				tile[index]= tilesSprite.getSubimage(GamePanel.ORIGINAL_TILE_SIZE*j, GamePanel.ORIGINAL_TILE_SIZE*i, GamePanel.ORIGINAL_TILE_SIZE, GamePanel.ORIGINAL_TILE_SIZE);
			}
	}

//Tiles being drawn beyond map boundaries 
	public void draw(Graphics2D g2) {
		/**
		for (int j = 0; j < GamePanel.MAX_WORLD_ROW; j++)
			for (int i = 0; i < GamePanel.MAX_WORLD_COL; i++) {
				int index = mapOne.getSpriteIndex(i, j);
				int worldX = i * GamePanel.TILE_SIZE;
				int worldY = j * GamePanel.TILE_SIZE;
				int screenX = worldX - player.worldX ;
				int screenY = worldY - player.worldY ;
				
				g2.drawImage(tile[index], screenX, screenY, GamePanel.TILE_SIZE, GamePanel.TILE_SIZE, null);
				//g2.drawImage(tile[index], GamePanel.TILE_SIZE * i, GamePanel.TILE_SIZE * j, GamePanel.TILE_SIZE, GamePanel.TILE_SIZE, null);
			}
		*/
		int worldCol = 0;
		int worldRow = 0;
		
		//LOADS MAP DATA
		while(worldCol < GamePanel.MAX_WORLD_COL && worldRow < GamePanel.MAX_WORLD_ROW ) {
			int tileNumber = Map.mapData[worldRow][worldCol];
			int worldX = worldCol * GamePanel.TILE_SIZE;
			int worldY = worldRow * GamePanel.TILE_SIZE;
			
			int screenX = worldX - player.worldX + player.screenX;
			int screenY = worldY - player.worldY + player.screenY;
			
			
			g2.drawImage(tile[tileNumber], screenX, screenY, GamePanel.TILE_SIZE, GamePanel.TILE_SIZE, null);
			
			
			worldCol ++;
			
			if (worldCol == GamePanel.MAX_WORLD_COL) {
				worldCol = 0;
				worldRow ++;
	
			}
		}
		
		
	}
	public Map getCurrentMap() {
		return mapOne;
	}
}