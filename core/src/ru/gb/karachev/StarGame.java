package ru.gb.karachev;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import ru.gb.karachev.screen.MenuScreen;

public class StarGame extends Game {

	private Music music;

	@Override
	public void create () {
		setScreen(new MenuScreen(this));
		music = Gdx.audio.newMusic(Gdx.files.internal("sounds/music.mp3"));
		music.setLooping(true);
		music.play();
	}

	@Override
	public void dispose() {
		super.dispose();
		music.dispose();
	}
}