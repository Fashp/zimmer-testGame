package com.tiles.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class Tile {
	private int x, y;			// The x and y location of the tile in tile coords
	private int worldX, worldY;
	private int texX, texY;		// The width and height of the texture 
	public Texture tex;			// Texture of the sprite
	public boolean solid;
	public Rectangle col;
	
	public Tile(int x, int y, Texture t, boolean solid)
	{
		this.x = x;
		this.y = y;
		this.tex = t;
		this.solid = solid;
		texX = t.getWidth();
		texY = t.getHeight();
		worldX = x * texX;
		worldY = y * texY;
		col = new Rectangle(worldX, worldY, texX, texY);
	}
	
	public int getX()
	{
		return worldX;
	}
	
	public int getY()
	{
		return worldY;
	}
}
