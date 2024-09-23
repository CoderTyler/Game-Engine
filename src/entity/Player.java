package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.GamePanel;
import main.KeyManager;

import static utilities.Constants.PlayerConstants.*;
import static utilities.DataLoader.*;
import static utilities.CollisionManager.isValidMove;
public class Player extends Entity{
	
	boolean moving = true;
	int ORGINAL_PLAYER_SIZE = 24;
	int PLAYER_SIZE;
	public final int screenX;
	public final int screenY;
	private int[][] mapData;
	boolean up, down, left, right, attacking;
	
	public Player() {
		PLAYER_SIZE = ORGINAL_PLAYER_SIZE*GamePanel.SCALE;	
		direction = "down";
		facing = "right";
		screenX = GamePanel.screenWidth/2 - (PLAYER_SIZE/2);
		screenY = GamePanel.screenHeight/2 - (PLAYER_SIZE/2);
		hitbox = new Rectangle(0, 0, 32, 37);
		sprite = getImageAssets(PLAYER_SPRITE);
		setDefaultValues();
		
		
	}
	public void setDefaultValues() {
		worldX = screenX;
		worldY = screenY;
		x = worldX;
		y= worldY;
		speed = 4;
	}
	//Inputs
	public void setUp(boolean value) {
		up = value;
	}
	public void setDown(boolean value) {
		down = value;
	}
	public void setLeft(boolean value) {
		left = value;
	}
	public void setRight(boolean value) {
		right = value;
	}
	public void setAttacking(boolean value) {
		attacking = value;
	}
	
	public void update() {
		if (up == true) {
			moving = true;
			direction = "up";
		}
		else if (down == true) {
			moving = true;
			direction = "down";	

		}
		else if (left == true) {
			direction = "left";
			moving = true;
			facing= "left";
		}
		else if (right == true) {
			direction = "right";
			moving = true;
			facing= "right";
		}
		else {
			moving = false;
		}
		//Set EntityAction
		if(facing == "right") {
			entityAction = RUNNING_1;
		}else {
			entityAction = RUNNING_2;
		}
		//find way remove moving
		if(moving == true) {
			int xSpeed = 0, ySpeed = 0;

			switch(direction) {
				case "up":
					ySpeed -= speed;
				break;	
				case "down":
					ySpeed += speed;
					break;	
				case "left":
					xSpeed -= speed;
					break;	
				case "right":
					xSpeed += speed;
					break;	
			}
			System.out.println("Player " + worldX + "," + worldY + "\t Speed" + xSpeed + "," + ySpeed);
			if(isValidMove(worldX+xSpeed, worldY+ySpeed, 32, 36, mapData)) {
				this.worldY += ySpeed;
				this.worldX += xSpeed;
			}
		}
	}
	public void loadMapData(int[][] mapData) {
		this.mapData = mapData;
	}
	public void draw(Graphics2D g2) {
		updateHitbox();
		drawHitbox(g2);
		loadAnimations(24, 24);
		if (up == true || down == true ||left == true || right == true) {
			entityAction = (facing == "right") ?  RUNNING_1 : RUNNING_2;
		}else {
			entityAction = (facing == "right") ? IDLE_1 : IDLE_2;
		}
		updateAnimationTick();
		animation = animations[entityAction][subSpriteIndex];
		g2.drawImage(animation, screenX, screenY, PLAYER_SIZE, PLAYER_SIZE, null);
	}
}
