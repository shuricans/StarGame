package ru.gb.karachev.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.gb.karachev.base.Sprite;
import ru.gb.karachev.math.Rect;

public class GameOverLabel extends Sprite {

    public GameOverLabel(TextureAtlas atlas) {
        super(atlas.findRegion("message_game_over"));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.07f);
        pos.set(worldBounds.pos.x, worldBounds.pos.y + getHeight());
    }
}
