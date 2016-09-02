package com.gdx.Duet2;

import com.badlogic.gdx.Game;

public class GameMain extends Game
{

	MyGame s;
	Score s1;
	int score;
	@Override
	public void create()
	{
		s1 = new Score(this);
		score=0;
		s = new MyGame(this);
		setScreen(s);
	}
	
	
}

