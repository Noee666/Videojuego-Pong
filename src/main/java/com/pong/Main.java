package com.pong;

import com.pong.view.GamePanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 * Inicia la aplicación del videojuego
 * <p>
 * Configura y crea las instancias necesarias
 * para iniciar la aplicación
 */
public final class Main {
    /**
     * Prohíbe crear una instancia de esta clase
     */
    private Main() { }
    /**
     * Ejecuta {@code javax.swing} en Event Dispatch Thread (hilo EDT)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createWindow);
    }
    /**
     * Crea y configura el {@code JFrame} principal
     */
    private static void createWindow() {
        var frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new GamePanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
