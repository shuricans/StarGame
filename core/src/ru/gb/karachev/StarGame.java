package ru.gb.karachev;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import ru.gb.karachev.screen.MenuScreen;

public class StarGame extends Game {

	@Override
	public void create () {
		setScreen(new MenuScreen(this));
	}

}