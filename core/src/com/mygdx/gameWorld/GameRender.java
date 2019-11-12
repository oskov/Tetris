package com.mygdx.gameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.game.TetrisGame;

public class GameRender {
    private final TetrisGame game;
    private GameWorld world;
    private OrthographicCamera cam;
    private Texture[] tex;
    private SpriteBatch batch;
    private BitmapFont font;
    private TextureRegion reg;
    private ShapeRenderer shapeRenderer;
    private Forms currentForm;
    private Forms nextForm;

    public GameRender(GameWorld world, TetrisGame game) {
        this.world = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(false, 800, 800);
        tex = new Texture[6];
        tex[0] = new Texture(Gdx.files.internal("texture/tetris-blue.png"));
        tex[1] = new Texture(Gdx.files.internal("texture/tetris-green.png"));
        tex[2] = new Texture(Gdx.files.internal("texture/tetris-purple.png"));
        tex[3] = new Texture(Gdx.files.internal("texture/tetris-red.png"));
        tex[4] = new Texture(Gdx.files.internal("texture/tetris-yellow.png"));
        tex[5] = new Texture(Gdx.files.internal("texture/tetris-white.png"));
        this.game = game;
        batch = game.batch;
        font = game.font;
        batch.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }

    public void render() {
        if (currentForm == null) {
            currentForm = world.getForm(0);
            nextForm = world.getForm(1);

        } else {

            currentForm = world.getForm(0);
            nextForm = world.getForm(1);

        }
        Gdx.gl.glClearColor(200, 200, 200, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        int[][] p = world.getGameField();
        Coord[] points = world.getPoints();
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.begin(ShapeType.Line);
        shapeRenderer.rect(280, 0, 300, 800);
        shapeRenderer.rect(600, 500, 150, 150);
        shapeRenderer.rect(600, 250, 150, 150);
        shapeRenderer.end();
        batch.disableBlending();
        int[][] curForm = currentForm.generateForm();
        int[][] nexForm = nextForm.generateForm();

        batch.begin();

        for (int x = 0; x < curForm.length; x++) {
            for (int y = 0; y < curForm.length; y++) {
                if (curForm[x][y] > 0) {
                    if (currentForm != Forms.L_FORM) {
                        batch.draw(tex[5], 600 + x * 30, +500 + y * 30);
                    } else {
                        batch.draw(tex[5], 600 + x * 30, +500 + y * 30 - 30);
                    }
                }
            }
        }

        for (int x = 0; x < nexForm.length; x++) {
            for (int y = 0; y < nexForm.length; y++) {
                if (nexForm[x][y] > 0) {
                    if (nextForm != Forms.L_FORM) {
                        batch.draw(tex[5], 600 + x * 30, +250 + y * 30);
                    } else {
                        batch.draw(tex[5], 600 + x * 30, +250 + y * 30 - 30);
                    }
                }
            }
        }

        font.draw(batch, "Score: " + world.getScore(), 70, 700);
        if (points != null) for (Coord c : points) {
            batch.draw(tex[world.getColor() - 1], 280 + c.x * 30, c.y * 30);
        }
        for (int i = 0; i < p.length; i++) {
            for (int a = 0; a < p[i].length; a++) {
                if (p[i][a] > 0) {
                    batch.draw(tex[p[i][a] - 1], 280 + i * 30, a * 30);
                }

            }

        }

        batch.end();
    }
}
