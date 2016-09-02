package com.gdx.Duet2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Score implements Screen
{

	GameMain g1;
	BitmapFont b,sc;
	SpriteBatch batch;
	
	public Score(GameMain g)
	{
		g1 = g;
		init();
	}
	
	public void init()
	{
		batch = new SpriteBatch();
		b = new BitmapFont();
		sc = new BitmapFont();
		b.setColor(Color.RED);
		b.setScale(3,3);
		sc.setColor(Color.GREEN);
		sc.setScale(2, 2);
	}
	
	@Override
	public void render(float delta)
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		
		b.draw(batch, "GAME OVER!!", 35, 350);
		sc.draw(batch,"SCORE:"+g1.score, 108, 380);
		
		batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
