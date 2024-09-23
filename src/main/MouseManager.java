package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gamestates.Gamestate;

public class MouseManager implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		switch(Gamestate.state) {
		case MENU:
			GamePanel.getMenu().mouseClicked(e);;
			break;
		case GAME:
			GamePanel.getGame().mouseClicked(e);
			break;
		default: 
			break;
		}
		
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
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
