package com.pong;

import com.pong.game.GameLoop;
import com.pong.view.GamePanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/// Inicia la aplicación del videojuego
///
/// Configura y crea las instancias necesarias
/// para iniciar la aplicación
public final class Main {
    /// Prohíbe crear una instancia de esta clase
    private Main() { }
    /// Ejecuta `javax.swing` en Event Dispatch Thread (hilo EDT)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createWindow);
    }
    /// Crea y configura el `JFrame` principal
    private static void createWindow() {
        var frame = new JFrame("Pong");
        var panel = new GamePanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        new GameLoop(panel::update, panel::repaint).start();
    }
}
