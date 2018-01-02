package com.mygdx.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.gameWorld.GameWorld;
import com.mygdx.screens.GameScreen;

public class InputHandler implements InputProcessor {
	private GameScreen screen;
	private GameWorld world;
	public InputHandler(GameScreen sc, GameWorld world){
		this.screen=sc;
		this.world=world;
	}
	
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		switch(character) {
		case 'D':
		case 'd':world.move(1); break;
		case 'A':
		case 'a': world.move(-1); break;
		case 'S':
		case 's': world.down();	break;
		case 'W':
		case 'w':  world.rotate(); break;
		case 'N':
		case 'n':screen.turnMusic(); break;
		case 'C':
		case 'c':world.clean(); break;
		}
	
		
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		Gdx.app.log("Handler",String.valueOf(screenX)+"   "+String.valueOf(screenY)+"   "+String.valueOf(pointer)+"   "+String.valueOf(button));
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
