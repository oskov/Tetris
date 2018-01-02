package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.screens.GameScreen;

public class MyGdxGame extends Game {
	public SpriteBatch batch;
	public BitmapFont font;
	@Override
	public void create() {
		font = new BitmapFont();
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
	}

	
}
