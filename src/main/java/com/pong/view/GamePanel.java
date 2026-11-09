package com.pong.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import static com.pong.model.Measures.*;
/// Representa un `JPanel` adaptado para las necesidades de la aplicación
public final class GamePanel extends JPanel {
    // --- Middle Line ---
    private static final int MIDDLE_LINE_WIDTH = 2;
    private static final int MIDDLE_LINE_HEIGHT = 10;
    private static final int MIDDLE_LINE_GAP = 25;
    // --- BallPos ---
    private double ballX = (COURT_WIDTH - BALL_SIZE) / 2.0;
    private double ballY = (COURT_HEIGHT - BALL_SIZE) / 2.0;
    // --- BallSpeed ---
    private double ballSpeedX = 300; // píxeles por segundo
    private double ballSpeedY = 100; // píxeles por segundo
    /// Crea y configura una instancia de `GamePanel`
    public GamePanel() {
        setPreferredSize(new Dimension(COURT_WIDTH, COURT_HEIGHT));
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        var g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);

        // Dibuja la línea divisora central
        for (int y = 0; y < COURT_HEIGHT; y+=MIDDLE_LINE_GAP) {
          g2.fillRect(COURT_WIDTH / 2 - (MIDDLE_LINE_WIDTH / 2), y,
                      MIDDLE_LINE_WIDTH, MIDDLE_LINE_HEIGHT);
        }
        // Dibuja la paleta izquierda
        g2.fillRect(PADDLE_MARGIN, COURT_HEIGHT / 2 - (PADDLE_HEIGHT / 2),
                    PADDLE_WIDTH, PADDLE_HEIGHT);
        // Dibuja la paleta derecha
        g2.fillRect(COURT_WIDTH - PADDLE_MARGIN - PADDLE_WIDTH, COURT_HEIGHT / 2 - (PADDLE_HEIGHT / 2),
                    PADDLE_WIDTH, PADDLE_HEIGHT);
        // Dibuja la bola
        g2.fillRect((int) Math.round(ballX), (int) Math.round(ballY),
                    BALL_SIZE, BALL_SIZE);
    }
    /// Realiza un cálculo para determinar la nueva posición de la bola
    ///
    /// @param deltaSeconds segundos transcurridos entre el frame anterior y el actual
    public void update(double deltaSeconds) {
        ballX += ballSpeedX * deltaSeconds;
        if (ballX < 0 || ballX + BALL_SIZE > COURT_WIDTH) {
            ballSpeedX = -ballSpeedX;
        }
        ballY += ballSpeedY * deltaSeconds;
        if (ballY < 0 || ballY + BALL_SIZE > COURT_HEIGHT) {
            ballSpeedY = -ballSpeedY;
        }
    }
}
