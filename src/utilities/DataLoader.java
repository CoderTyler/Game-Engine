package utilities;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import main.GamePanel;
import map.Map;

public class DataLoader {
	//ENTITIES
	public static final String PLAYER_SPRITE = "/MiniPlayer.png";
	public static final String BLACKSMITH_SPRITE = "/MiniBlacksmith.png";
	
	//MAP
	public static final String SUMMER_SPRITE = "/SummerTiles.png";
	public static final String SPRING_SPRITE = "/SpringTiles.png";
	public static final String AUTUMN_SPRITE = "/AutumnTiles.png";
	public static final String WINTER_SPRITE = "/WinterTiles.png";
	public static final String LEVEL_ONE_DATA = "/1.png";
	public static BufferedImage getImageAssets(String file) {
			BufferedImage img;
			InputStream is  = DataLoader.class.getResourceAsStream(file);
			
			try {
				img = ImageIO.read(is);
				return img;
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return null;
		}
	public static int[][] getMapData(){
		int[][] mapData = new int[GamePanel.MAX_WORLD_COL][GamePanel.MAX_WORLD_ROW];
		BufferedImage img = getImageAssets(LEVEL_ONE_DATA);
		
		for(int j = 0; j < img.getHeight(); j++) {
			for(int i = 0 ; i <img.getWidth(); i++) {
				Color color = new Color(img.getRGB(i,  j));
				int tileIndex = color.getRed();
				int objectIndex = color.getGreen();
				int enemyIndex = color.getBlue();
				
				if(tileIndex >=100)
					tileIndex = 0;
				mapData[j][i] = tileIndex;
				System.out.println(tileIndex);
			}
		}
		return mapData;
	}
}
