package com.gdx.Duet2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Block
{
	TextureRegion tr[];
	float x,y;
	int type,l,b;
	boolean rotate,disapear,remove;
	Texture t;
	Rectangle r;
	
	public Block(float pos,int ty)
	{
		tr = new TextureRegion[5];
		type =ty;
		if(type == 1)
		{
			if(pos == 1)
			{
				x =70;
			}
			else
			{
				x = 180;
			}
			y = 710;
			t = new Texture(Gdx.files.internal("assets/block1.png"));
			tr[0] = new TextureRegion(t);
			for(int i=1;i<5;i++)
			{
				tr[i] = new TextureRegion(new Texture(Gdx.files.internal("assets/block1d"+i+".png")));
			}
			l = 100;
			b = 30;
		}
		else if(type == 2)
		{
			if(pos == 1)
			{
				x =140;
			}
			else
			{
				x = 150;
			}
			y = 710;
			t = new Texture(Gdx.files.internal("assets/block2.png"));
			tr[0] = new TextureRegion(t);
			for(int i=1;i<5;i++)
			{
				tr[i] = new TextureRegion(new Texture(Gdx.files.internal("assets/block1d"+i+".png")));
			}
			l = 60;
			b = 30;
		}
		else if(type == 3)
		{
			if(pos == 1)
			{
				x =20;
			}
			else
			{
				x = 170;
			}
			y = 710;
			rotate = true;
			t = new Texture(Gdx.files.internal("assets/block3.png"));
			tr[0] = new TextureRegion(t);
			for(int i=1;i<5;i++)
			{
				tr[i] = new TextureRegion(new Texture(Gdx.files.internal("assets/block1d"+i+".png")));
			}
			l = 150;
			b = 30;
		}
		r = new Rectangle(x,y,l,b);
	}
}
