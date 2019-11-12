package com.mygdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.mygdx.game.TetrisGame;
import com.mygdx.gameWorld.GameRender;
import com.mygdx.gameWorld.GameWorld;
import com.mygdx.helper.InputHandler;

public class GameScreen implements Screen {
    private final TetrisGame game;
    private GameWorld world;
    private GameRender render;
    private Music music;

    public GameScreen(TetrisGame game) {
        world = new GameWorld();
        render = new GameRender(world, game);
        Gdx.input.setInputProcessor(new InputHandler(this, world));
        music = Gdx.audio.newMusic(Gdx.files.internal("sounds/music.wav"));
        music.setVolume(0.3f);
        music.play();
        music.setLooping(true);
        this.game = game;
    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
    }

    @Override
    public void render(float delta) {
        world.update(delta); //
        render.render();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "Resize");
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
        Gdx.app.log("GameScreen", "pause");
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
        Gdx.app.log("GameScreen", "resume");
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
        Gdx.app.log("GameScreen", "hide");
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        Gdx.app.log("GameScreen", "dispose");
    }

    public void turnMusic() {
        if (music.isPlaying()) {
            music.pause();
        } else {
            music.play();
        }
    }
}
