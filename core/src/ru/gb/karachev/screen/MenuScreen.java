package ru.gb.karachev.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.gb.karachev.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Texture background;
    private Vector2 pos;
    private Vector2 diff;
    private Vector2 point;
    private final float speed = 14f;

    @Override
    public void show() {
        super.show();
        img = new Texture("x_wing_blue.png");
        background = new Texture("bg.png");
        pos = new Vector2(Gdx.graphics.getWidth() / 2f - img.getWidth() / 2f,
                Gdx.graphics.getHeight() / 2f - img.getHeight() / 2f);
        diff = new Vector2();
        point = pos.cpy();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(background, 0, 0);
        batch.draw(img, pos.x, pos.y);
        batch.end();
        update();
    }

    private void update() {
        if (pos.dst(point) > speed) {
            pos.add(diff);
        } else {
            pos.set(point);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        background.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        point.set(screenX, Gdx.graphics.getHeight() - screenY);
        diff.set(point.cpy().sub(pos));
        diff.nor().scl(speed);
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return super.touchDragged(screenX, screenY, pointer);
    }
}