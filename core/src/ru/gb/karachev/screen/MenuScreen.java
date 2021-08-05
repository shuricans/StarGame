package ru.gb.karachev.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.gb.karachev.base.BaseScreen;
import ru.gb.karachev.math.Rect;
import ru.gb.karachev.sprite.Background;
import ru.gb.karachev.sprite.Logo;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Texture ship;
    private Background background;
    private Logo logoShip;

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(bg);
        ship = new Texture("textures/x_wing_blue.png");
        logoShip = new Logo(ship);
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        logoShip.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        logoShip.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        ship.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        logoShip.touchDown(touch, pointer, button);
        return false;
    }
}