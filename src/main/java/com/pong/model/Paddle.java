package com.pong.model;

public final class Paddle {

    private Vec2 position;

    public Paddle(Vec2 position) {
        this.position = position;
    }

    public Vec2 position() { return position; }
}
