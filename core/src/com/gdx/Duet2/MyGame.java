package com.gdx.Duet2;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;

public class MyGame implements Screen,InputProcessor
{
	SpriteBatch batch;
	Texture img,big,big1,bb;
	GameMain g1;
	Sprite bob,block1,bobback;
	int rotate;
	float currotate;
	ArrayList<Block> blocks;
	long timer,levelchange;
	Rectangle r1,r2;
	Score s1;
	
	//Constructor
	public MyGame(GameMain g)
	{
		g1 = g;
		init();
	}
	
	//Initialization
	public void init()
	{
		batch = new SpriteBatch();
		img = new Texture(Gdx.files.internal("assets/bob.png"));
		big = new Texture(Gdx.files.internal("assets/big.png"));
		big1 = new Texture(Gdx.files.internal("assets/big.png"));
		bb = new Texture(Gdx.files.internal("assets/bobback.png"));
		bob = new Sprite(img);
		bobback = new Sprite(bb);
		r1 = new Rectangle(2,62,30,30);
		r2 = new Rectangle(120,62,30,30);
		s1 = new Score(g1);
		//bg = new Texture(Gdx.files.internal("background1.png"));
		
		bobback.setPosition(0, 0);
		bob.setPosition(0, 0);
		
		rotate =0;
		currotate =0;
		timer = TimeUtils.nanoTime();
		levelchange = TimeUtils.nanoTime();
		
		blocks = new ArrayList<Block>();
		
		
		
		Gdx.input.setInputProcessor(this);
	}

	//This function is called again and again
	public void render(float delta)
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);                           //sets blackground black color 
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);				//clears the buffer containg textures
		batch.begin();
		//batch.draw(bg, 0, 0);
		bobback.draw(batch);
		bob.draw(batch);
		
		bob.setPosition(100, 0);
		if(bob.getRotation()==0)
			bobback.setPosition(95, 60);
		else if(bob.getRotation()==90)
			bobback.setPosition(85, 60);
		else if(bob.getRotation()==180)
			bobback.setPosition(92, 60);
		else if(bob.getRotation()==270)
			bobback.setPosition(95, 60);
		
		//create blocks after 2 seconds
		if(TimeUtils.timeSinceNanos(timer)> 1500000000l)
		{
			spawnBlocks();
			timer = TimeUtils.nanoTime();
		}
		
		//move the blocks downward by decreasing the y coordinate
		for(Block b:blocks)
		{
			block1 = new Sprite(b.t);
			block1.setPosition(b.x,b.y);
			block1.draw(batch);
			b.y-=1.5;
			b.r.y-=1.5;
		}
		
		
		//rotate the bob
		if(rotate == 1)
		{
			bob.setRotation(currotate);
			bobback.setRotation(currotate);
			currotate +=3.3;
		}
		else if(rotate == -1)
		{
			bob.setRotation(currotate-1);
			bobback.setRotation(currotate-1);
			currotate -=3.3;
		}
		
		//to see if the collisions takes place or not
		for(Block b:blocks)
		{
			if(b.r.overlaps(r1)||(b.r.overlaps(r2)))
			{
				s1 = new Score(g1);
				g1.setScreen(s1);
			}
		}
		
		//to remove blocks once they are out of the screen
		for(Block b:blocks)
		{
			if(b.y<0)
			{
				b.remove=true;
				g1.score++;
			}
		}
		for(int i =0;i<blocks.size();i++)
		{
			Block b = blocks.get(i);
			if(b.remove == true)
			{
				blocks.remove(i);
			}
		}
		
		
		r1.setPosition(bobback.getVertices()[SpriteBatch.X1],bobback.getVertices()[SpriteBatch.Y1]);
		r2.setPosition(bobback.getVertices()[SpriteBatch.X4],bobback.getVertices()[SpriteBatch.Y4]);
		//batch.draw(big,r1.x,r1.y);
		//batch.draw(big1,r2.x,r2.y);
		
		
		batch.end();
	}
	

	//called when blocks need to be created
	public void spawnBlocks()
	{
		int randpos = MathUtils.random(1, 2);
		int randblock = MathUtils.random(1, 3);
		Block b = new Block(randpos,randblock);
		blocks.add(b);
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

	//called when key press occurs
	@Override
	public boolean keyDown(int keycode) 
	{
		if(keycode == Input.Keys.RIGHT)
		{
			//bob.setRotation(10);
			rotate = -1;
		}
		else if(keycode == Input.Keys.LEFT)
		{
			//bob.setRotation(10);
			rotate = 1;
		}
		return false;
	}

	//called when key release occurs
	@Override
	public boolean keyUp(int keycode) 
	{
		if((keycode == Input.Keys.RIGHT)||(keycode == Input.Keys.LEFT))
			rotate =0;
		
		return false;
	}


	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
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
