package com.tiles.solid.game;

import com.badlogic.gdx.graphics.Texture;
import com.tiles.game.Solid;

public class WallTile extends Solid {

	public WallTile(int x, int y) {
		super(x, y, new Texture("grey.png"));
	}

}
