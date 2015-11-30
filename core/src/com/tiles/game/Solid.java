package com.tiles.game;

import com.badlogic.gdx.graphics.Texture;

public abstract class Solid extends Tile{

	public Solid(int x, int y, Texture t) {
		super(x, y, t, true);
	}

}
