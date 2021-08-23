package ru.gb.karachev.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.gb.karachev.base.Sprite;
import ru.gb.karachev.math.Rect;

public class FlameMainShip extends Sprite {

    private static final float ANIMATE_INTERVAL = 0.1f;
    private static final float HEIGHT = 0.09f;
    private static final float LITTLE_FIX = 0.005f;

    private float animateTimer;

    public FlameMainShip(TextureAtlas atlas) {
        super(atlas.findRegion("flameMainShip"), 1, 3, 3);
        setHeightProportion(HEIGHT);
    }

    public void set(float x, float y) {
        this.pos.set(x, y + LITTLE_FIX);
    }

    @Override
    public void update(float delta) {
        animateTimer += delta;
        if (animateTimer >= ANIMATE_INTERVAL) {
            animateTimer = 0f;
            if (++frame == regions.length) {
                frame = 0;
            }
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(HEIGHT);
    }
}
