package gamestates;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import entity.Player;
import main.GamePanel;
import map.MapManager;

public class Game extends State implements Statemethods{
	public Game(GamePanel gp) {
		super(gp);
		initObjects();
	}

	private MapManager mapManager;
	private Player player;


	private void initObjects() {
		player = new Player();
		mapManager = new MapManager(player);
		player.loadMapData(mapManager.getCurrentMap().getMapData());
	}
	
	@Override
	public void update() {
		player.update();
		
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.black);
		g2.fillRect(0, 0, GamePanel.screenWidth, GamePanel.screenHeight);
		mapManager.draw(g2);
		player.draw(g2);
		g2.dispose();
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			player.setAttacking(true);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		switch(e.getKeyCode()){
		case KeyEvent.VK_W: 
			player.setUp(true);
			break;
		case KeyEvent.VK_S: 
			player.setDown(true);
			break;
		case KeyEvent.VK_A: 
			player.setLeft(true);
			break;
		case KeyEvent.VK_D: 
			player.setRight(true);
			break;
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
		switch(e.getKeyCode()){
		case KeyEvent.VK_W: 
			player.setUp(false);
			break;
		case KeyEvent.VK_S: 
			player.setDown(false);
			break;
		case KeyEvent.VK_A: 
			player.setLeft(false);
			break;
		case KeyEvent.VK_D: 
			player.setRight(false);
			break;
		}
	}
}