package com.pong.game;

import java.util.function.DoubleConsumer;
import javax.swing.Timer;
/// Representa el flujo de actualización de los eventos mostrados en pantalla.
///
/// Define un bucle pre-configurado y adaptado para juegos que una vez iniciado {@link GameLoop#start()} repite\
/// indefinidamente un `ActionEvent` cada {@value FRAME_DELAY_MS} ms hasta que lo llamen para detenerse {@link GameLoop#stop()}.\
/// Mide los intervalos de tiempo entre evento y evento y se los entrega a una función externa\
/// con la misma firma que {@link DoubleConsumer#accept(double)} finalmente ejecuta un\
/// `Runnable` que actualiza los elementos en pantalla.
///
/// Esta clase es totalmente independiente de la aplicación que la implementa.
public final class GameLoop {
    /// Frecuencia con la que se repite el evento del bucle en milisegundos: {@value} ms.
    private static final int FRAME_DELAY_MS = 1000 / 60;
    /// Cantidad de nanosegundos en un segundo: {@value} ns.
    private static final double NANOS_PER_SECOND = 1_000_000_000.0;
    /// Tolerancia maxima de espera entre evento y evento en segundos: {@value} s.
    private static final double MAX_DELTA_SECONDS = 0.05;

    private final Timer timer;
    private long lastTick;
    /// Crea una instancia de GameLoop
    ///
    /// @param update función que recibe el intervalo de tiempo entre eventos.
    /// @param render operación externa encargada de actualizar la pantalla.
    public GameLoop(DoubleConsumer update, Runnable render) {
        timer = new Timer(FRAME_DELAY_MS, event ->{
            long now = System.nanoTime();
            double delta = (now - lastTick) / NANOS_PER_SECOND;
            lastTick = now;

            update.accept(Math.min(delta, MAX_DELTA_SECONDS));
            render.run();
        });
    }
    /// Inicia el bucle
    public void start() {
        lastTick = System.nanoTime();
        timer.start();
    }
    /// Detiene el bucle
    public void stop() {
        timer.stop();
    }
}
