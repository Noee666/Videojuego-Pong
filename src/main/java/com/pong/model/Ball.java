package com.pong.model;

import java.util.Objects;
/// Representa una bola que puede cambiar de posición constantemente.
///
/// La posición y velocidad de la bola se calcula de forma separada\
/// y es indiferente a los elementos gráficos mostrados en pantalla
public final class Ball {

    private Vec2 position;
    private Vec2 velocity;
    /// Crea una bola con una posición/velocidad inicial
    ///
    /// @param position posición de la bola en el plano
    /// @param velocity velocidad de la bola px/s (píxeles por segundo)
    public Ball(Vec2 position, Vec2 velocity) {
        this.position = Objects.requireNonNull(position, "position must not be null");
        this.velocity = Objects.requireNonNull(velocity, "velocity must not be null");
    }
    /// Calcula la posición de la bola en cada frame.
    ///
    /// La firma de esta función coincide con {@link java.util.function.DoubleConsumer#accept(double)}\
    /// lo que permite usar la referencia a esta función `ball::update`\
    /// como argumento en {@link com.pong.game.GameLoop#GameLoop}
    ///
    /// @param deltaSeconds segundos transcurridos entre el frame anterior y el actual
    public void update(double deltaSeconds) {
        position = position.plus(velocity.times(deltaSeconds));
    }
    /// Revierte la dirección en la que se mueve la bola en el eje x
    public void reverseX() {
        velocity = new Vec2(-velocity.x(), velocity.y());
    }
    /// Revierte la dirección en la que se mueve la bola en el eje y
    public void reverseY() {
        velocity = new Vec2(velocity.x(), -velocity.y());
    }
    // --- Getters ---
    public Vec2 position() { return position; }
    public Vec2 velocity() { return velocity; }
}
