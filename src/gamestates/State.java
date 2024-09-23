package gamestates;

import main.GamePanel;

public class State {
	protected GamePanel gp;
	
	public State(GamePanel gp) {
		this.gp = gp;
	}
	
	public GamePanel getGamePanel() {
		return gp;
	}
}
