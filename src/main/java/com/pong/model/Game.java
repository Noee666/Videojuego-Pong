package com.pong.model;

import static com.pong.model.Measures.*;

public final class Game {

    private static final Vec2 INITIAL_BALL_VELOCITY = new Vec2(300, 100);

    private final Ball ball;
    private final Paddle leftPaddle;
    private final Paddle rightPaddle;

    public Game() {
        leftPaddle = new Paddle(new Vec2(PADDLE_MARGIN_X, PADDLE_MARGIN_Y));
        rightPaddle = new Paddle(new Vec2(COURT_WIDTH - PADDLE_MARGIN_X - PADDLE_WIDTH,
                                                  PADDLE_MARGIN_Y));

        var center = new Vec2((COURT_WIDTH - BALL_SIZE) / 2.0,
                              (COURT_HEIGHT - BALL_SIZE) / 2.0);
        ball = new Ball(center, INITIAL_BALL_VELOCITY);
    }

    public void update(double deltaSeconds) {
        ball.update(deltaSeconds);
        bounceOffWalls();
    }

    private void bounceOffWalls() {
        var pos = ball.position();
        if (pos.x() < 0 || pos.x() + BALL_SIZE > COURT_WIDTH) {
            ball.reverseX();
        }
        if (pos.y() < 0 || pos.y() + BALL_SIZE > COURT_HEIGHT) {
            ball.reverseY();
        }
    }

    public Ball ball() { return ball; }
    public Paddle leftPaddle() { return leftPaddle; }
    public Paddle rightPaddle() { return rightPaddle; }
}
