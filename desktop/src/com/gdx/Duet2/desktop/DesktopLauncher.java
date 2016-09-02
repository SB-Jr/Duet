package com.gdx.Duet2.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gdx.Duet2.GameMain;

public class DesktopLauncher 
{
	public static void main (String[] arg)
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height=700;
		config.width = 350;
		config.title = "Duet";
		config.resizable = false;
		new LwjglApplication(new GameMain(), config);
	}
}