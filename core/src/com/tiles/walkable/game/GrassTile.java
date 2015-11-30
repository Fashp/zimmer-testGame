package com.tiles.walkable.game;

import com.badlogic.gdx.graphics.Texture;
import com.tiles.game.Walkable;

public class GrassTile extends Walkable{
	
	public GrassTile(int x, int y) {
		super(x, y, new Texture("green.jpg"));
	}

}
