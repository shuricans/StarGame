package ru.gb.karachev.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.gb.karachev.base.BaseButton;
import ru.gb.karachev.math.Rect;
import ru.gb.karachev.screen.GameScreen;

public class NewGameButton extends BaseButton {

    private final GameScreen gameScreen;

    public NewGameButton(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
    }

    @Override
    public void action() {
        gameScreen.reset();
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.06f);
        pos.set(worldBounds.pos.x, worldBounds.pos.y - getHeight());
    }
}
