package com.pong.model;

/// Clase utilitaria que almacena constantes globales de la aplicación
///
/// Esta clase no puede ser instanciada
///
public final class Measures {
    /// Prohíbe crear una instancia de esta clase
    private Measures() { }
    // --- Panel ---
    public static final int COURT_WIDTH = 800;
    public static final int COURT_HEIGHT = 600;
    // --- Paddle ---
    public static final int PADDLE_WIDTH = 4;
    public static final int PADDLE_HEIGHT = 30;
    public static final int PADDLE_MARGIN = 15;
    // --- Ball ---
    public static final int BALL_SIZE = 15;
}
