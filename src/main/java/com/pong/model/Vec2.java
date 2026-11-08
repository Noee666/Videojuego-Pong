package com.pong.model;
/// Representa un vector 2D inmutable
///
/// Se usa tanto para posiciones como para velocidades
///
/// @param x
/// @param y
public record Vec2(double x, double y) {
    /// Suma los atributos de `this` con los de otro vector \
    /// del mismo tipo para crear otra instancia de `Vec2`
    ///
    /// @param other vector recibido
    /// @return nueva instancia de `Vec2` representando la suma
    public Vec2 plus(Vec2 other) {
        return new Vec2(x + other.x, y + other.y);
    }
    /// Multiplica los atributos de `this` por un factor para crear otra instancia
    ///
    /// @param factor número decimal
    /// @return nueva instancia de `Vec2` representando el resultado
    public Vec2 times(double factor) {
        return new Vec2(x * factor, y * factor);
    }
}
