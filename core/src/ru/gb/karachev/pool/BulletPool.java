package ru.gb.karachev.pool;

import ru.gb.karachev.base.SpritesPool;
import ru.gb.karachev.sprite.Bullet;

public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newSprite() {
        return new Bullet();
    }
}
