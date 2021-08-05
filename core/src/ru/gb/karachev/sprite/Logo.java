package ru.gb.karachev.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.gb.karachev.base.Sprite;
import ru.gb.karachev.math.Rect;

public class Logo extends Sprite {

    private static final float V_LEN = 0.005f;
    private static final float HEIGHT_PERCENT_OF_WB = 0.15f;

    private final Vector2 touch;
    private final Vector2 v;

    public Logo(Texture texture) {
        super(new TextureRegion(texture));
        touch = new Vector2();
        v = new Vector2();
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        if (touch.dst(pos) > V_LEN) {
            pos.add(v);
        } else {
            pos.set(touch);
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight() * HEIGHT_PERCENT_OF_WB);
        pos.set(worldBounds.pos);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch.set(touch);
        v.set(touch.sub(pos)).setLength(V_LEN);
        return false;
    }
}
