package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gamestates.Gamestate;

public class KeyManager implements KeyListener{
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(Gamestate.state) {
		case MENU:
			GamePanel.getMenu().keyPressed(e);
			break;
		case GAME:
			GamePanel.getGame().keyPressed(e);
			break;
		default:
			break;
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(Gamestate.state) {
		case MENU:
			GamePanel.getMenu().keyReleased(e);
			break;
		case GAME:
			GamePanel.getGame().keyReleased(e);
			break;
		default:
			break;
		}

	}
	
}
