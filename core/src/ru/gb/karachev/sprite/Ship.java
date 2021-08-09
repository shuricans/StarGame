package ru.gb.karachev.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.gb.karachev.base.Sprite;
import ru.gb.karachev.math.Rect;

public class Ship extends Sprite {

    private static final float PADDING = 0.03f;
    private static final int COUNT_FRAMES = 2;
    private static final float X_SPEED = 0.5f;

    private boolean lockRightMove;
    private boolean lockLeftMove;

    private final Vector2 v;
    private Rect worldBounds;

    public Ship(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship"));
        int tileWidth = regions[0].getRegionWidth() / COUNT_FRAMES;
        int tileHeight = regions[0].getRegionHeight();
        regions[0] = regions[0].split(tileWidth, tileHeight)[0][0];
        v = new Vector2();
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setHeightProportion(0.2f);
        setBottom(worldBounds.getBottom() + PADDING);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        checkAndHandleBounds();
    }

    private void checkAndHandleBounds() {
        if (getRight() >= worldBounds.getRight()) {
            lockRightMove = true;
            stop();
        }
        if (getLeft() <= worldBounds.getLeft()) {
            lockLeftMove = true;
            stop();
        }
    }

    public void moveLeft() {
        if (!lockLeftMove) {
            v.set(-X_SPEED, 0f);
            lockRightMove = false;
        }
    }

    public void moveRight() {
        if (!lockRightMove) {
            v.set(X_SPEED, 0f);
            lockLeftMove = false;
        }
    }


    public void stop() {
        v.set(0, 0);
    }
}
