package com.player.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Player {
	private Texture t;	
	private SpriteBatch batch;
	public int x, y, height, width;
	private static final int speed = 2;
	public Rectangle col;
	
	public Player(int x, int y)
	{
		t = new Texture("pink.jpg");
		batch = new SpriteBatch();
		this.x = x;
		this.y = y;
		height = t.getHeight();
		width = t.getWidth();
		col = new Rectangle(x, y, height, width);
	}
	
	/**
	 * Moves the player
	 * @param x Direction player should move along x
	 * @param y Direction player should move along y
	 */
	public void move(int x, int y)
	{
		this.x += x * speed;
		this.y += y * speed;
		col.setX(this.x);
		col.setY(this.y);
	}
	
	public void render(OrthographicCamera cam)
	{
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		batch.draw(t, x, y);
		batch.end();
	}
}
