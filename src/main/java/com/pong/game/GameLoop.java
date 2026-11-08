package com.pong.game;

import java.util.function.DoubleConsumer;
import javax.swing.Timer;

public final class GameLoop {

    private static final int FRAME_DELAY_MS = 1000 / 60;
    private static final double NANOS_PER_SECOND = 1_000_000_000.0;
    private static final double MAX_DELTA_SECONDS = 0.05;

    private final Timer timer;
    private long lastTick;

    public GameLoop(DoubleConsumer update, Runnable render) {
        timer = new Timer(FRAME_DELAY_MS, event ->{
            long now = System.nanoTime();
            double delta = (now - lastTick) / NANOS_PER_SECOND;
            lastTick = now;

            update.accept(Math.min(delta, MAX_DELTA_SECONDS));
            render.run();
        });
    }

    public void start() {
        lastTick = System.nanoTime();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
}
