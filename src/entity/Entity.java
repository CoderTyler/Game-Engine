package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.ImageGraphicAttribute;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import static utilities.Constants.PlayerConstants.*;

public class Entity {
	public int worldX, worldY;
	public int x, y;
	public int speed;
	public BufferedImage sprite;
	public BufferedImage animation;
	public BufferedImage[][] animations;
	public int tick, subSpriteIndex, animationSpeed = 10, entityAction;
	public String direction, facing;
	
	//Collision
	public Rectangle hitbox;
	public boolean entityC = false;
	protected void drawHitbox(Graphics2D g2) {
		g2.setColor(Color.pink);
		g2.drawRect(hitbox.x,  hitbox.y, hitbox.width, hitbox.height);
	}
	protected void updateHitbox() {
		hitbox.x = (int)x;
		hitbox.y = (int)y;
	}
	public void loadAnimations(int width, int height) {
		animations = new BufferedImage[8][8];
		for (int j = 0; j < 8; j++) {
			for(int i = 0; i < 8; i++) {
				//System.out.println(i);
				animations[j][i] = sprite.getSubimage(width*i, height*j, width, height);
			}
		}
	}
	
	public void updateAnimationTick() {
		tick++;
		if(tick >= animationSpeed) {
			tick= 0;
			subSpriteIndex++;
			if (subSpriteIndex >= getSpriteCells(entityAction)){
				subSpriteIndex = 0;
			}
		}
	}

}


