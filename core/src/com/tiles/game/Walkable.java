package com.tiles.game;

import com.badlogic.gdx.graphics.Texture;

public abstract class Walkable extends Tile {

	public Walkable(int x, int y, Texture t) {
		super(x, y, t, false);
	}

}
