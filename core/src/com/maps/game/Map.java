package com.maps.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tiles.game.Tile;
import com.tiles.solid.game.WallTile;
import com.tiles.walkable.game.GrassTile;

public class Map {

	public ArrayList<Tile> tiles;	// List of tiles
	public int width, height;		// Width and Height of the map
	private SpriteBatch batch;		// Sprite batch for rendering
	private static final int xTileSize = 16;
	private static final int yTileSize = 16;
	
	/**
	 * Creates a new map with specified width and height
	 * @param width The width of the new map
	 * @param height The height of the new map
	 */
	public Map(int width, int height)
	{
		this.width = width;
		this.height = height;
		batch = new SpriteBatch();
		tiles = new ArrayList<Tile>();
	}
	
	/**
	 * Generates a map
	 */
	public void generate()
	{
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				if (i == 0 || j == 0 || i == (width - 1) || j == (height -1 ) || (i % 4 == 0 && j % 4 == 0))
				{
					tiles.add(new WallTile(i, j));
				}
				else
				{
					tiles.add(new GrassTile(i, j));
				}
			}
		}
	}
	
	/**
	 * Returns the tile at position (x, y)
	 * @param x The x position of the tile to get
	 * @param y The y position of the tile to get
	 * @return Tile located at position (x, y)
	 */
	public Tile getTileAt(int x, int y)
	{
		return tiles.get((x * width) + y);
	}
	
	public Tile getTileByPixel(int x, int y)
	{
		return tiles.get(((x / xTileSize) * width) + (y / yTileSize));
	}
	
	/**
	 * Renders the map using the given camera
	 * @param cam Orthographic camera to render the map with
	 */
	public void render(OrthographicCamera cam)
	{
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		for(Tile t : tiles)
		{
			batch.draw(t.tex, t.getX(), t.getY());
		}
		batch.end();
	}
	
}
