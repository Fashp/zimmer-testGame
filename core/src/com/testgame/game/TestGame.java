package com.testgame.game;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Intersector;
import com.maps.game.Map;
import com.player.game.Player;
import com.tiles.game.Tile;

public class TestGame extends ApplicationAdapter {
	Map m;
	Player p;
	OrthographicCamera cam;
	
	public void gameLoop()
	{
		while (true) 
		{
			
		}
	}
	
	@Override
	public void create () {
		m = new Map(10, 10);
		m.generate();
		p = new Player(16, 16);
		
		cam = new OrthographicCamera(320, 320);
		
		//gameLoop();
	}

	@Override
	public void render () 
	{
		handleMovement();
		
		cam.position.set(p.x, p.y, 1);
		cam.update();
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		m.render(cam);
		p.render(cam);
	}
	
	/**
	 * Reads controller input and moves the player
	 * accordingly.
	 */
	void handleMovement()
	{
		int xDir = 0;
		int yDir = 0;
		
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
		{
			xDir = 1;
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
		{
			xDir = -1;
		}
		
		if (Gdx.input.isKeyPressed(Input.Keys.UP))
		{
			yDir = 1;
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
		{
			yDir = -1;
		}
		
		movePlayer(xDir, yDir);
	}
	
	/**
	 * moves the player in a direction / directions, then handles collision correction
	 * @param xDir	moving in x direction (+ for right, - for left)
	 * @param yDir	moving in y direction (+ for up, - for down)
	 */
	void movePlayer(int xDir, int yDir)
	{
		// Handle x movement
		p.move(xDir, 0);	
		if (playerCollides() == true)
		{
			p.move(-1 * xDir, 0);
		}
		
		// Handle y movement
		p.move(0, yDir);
		if (playerCollides() == true)
		{
			p.move(0, -1 * yDir);
		}
	}
	
	/**
	 * Checks to see if any of the player's corners intersect with any solid tiles
	 * @return true on collision
	 */
	boolean playerCollides()
	{
		ArrayList<Tile> adjacent_tiles = new ArrayList<Tile>();
		adjacent_tiles.add(m.getTileByPixel(p.x + p.width, p.y + p.height));	// Top right corner
		adjacent_tiles.add(m.getTileByPixel(p.x + p.width, p.y));				// Bottom right corner
		adjacent_tiles.add(m.getTileByPixel(p.x, p.y + p.height));				// Top left corner
		adjacent_tiles.add(m.getTileByPixel(p.x, p.y));							// Bottom left corner
		
		for(Tile t : adjacent_tiles)
		{
			if (Intersector.overlaps(p.col, t.col) && t.solid == true)
			{
				return true;
			}
		}
		return false;
	}
}
