package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import gamestates.Game;
import gamestates.Gamestate;
import gamestates.Menu;
import map.MapManager;

public class GamePanel extends JPanel implements Runnable{
	public final static int ORIGINAL_TILE_SIZE = 16;
	public final static int SCALE = 3;
	public final static int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;
	public final static int maxScreenCol = 16;
	public final static int maxScreenRow = 12;
	public final static int screenWidth = TILE_SIZE * maxScreenCol;
	public final static int screenHeight = TILE_SIZE * maxScreenRow;
	//WORLD SETTINGS
	public final static int MAX_WORLD_COL = 50;
	public final static int MAX_WORLD_ROW = 50;
	public final static int WORLD_WIDTH = TILE_SIZE * MAX_WORLD_COL;
	public final static int WORLD_HEIGHT = TILE_SIZE * MAX_WORLD_ROW;
	//FPS
	final int FPS = 60;
	KeyManager keyH = new KeyManager();
	Thread gameThread;
	//Options
	public static Game game;
	public static Menu menu ;
	
	public GamePanel(){
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		//this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
		initObjects();
	}
	
	private void initObjects() {
		game = new Game(this);
		menu = new Menu(this);
	}
	public void startGameThread(){
		gameThread = new Thread(this);
		gameThread.start();
	}
	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;
		while (gameThread != null){
			
			long currentTime = System.nanoTime();
			//System.out.println("Current Time:" + currentTime);
			
			//System.out.println("The game loop is running");
			//back-end
			update();
			//front-end
			repaint();
			
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				
				if(remainingTime  <  0) {
					remainingTime  = 0;
				}
				
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static Game getGame() {
		return game;
	}
	public static Menu getMenu() {
		return menu;
	}
	public void update() {
		switch(Gamestate.state) {
		case MENU:
			menu.update();
			break;
		case GAME:
			game.update();
			break;
		default: 
			break;
		}
	}
	
	public void paintComponent(Graphics g) {
		switch(Gamestate.state) {
		case MENU:
			menu.draw(g);
			break;
		case GAME:
			game.draw(g);
			break;
		default: 
			break;
		}
		
	}
}
