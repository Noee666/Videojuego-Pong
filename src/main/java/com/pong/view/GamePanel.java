package com.pong.view;

import com.pong.model.Ball;
import com.pong.model.Game;
import com.pong.model.Paddle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Objects;
import javax.swing.JPanel;
import static com.pong.model.Measures.*;
/// Representa un `JPanel` adaptado para las necesidades de la aplicación
public final class GamePanel extends JPanel {
    // --- Middle Line ---
    private static final int MIDDLE_LINE_WIDTH = 2;
    private static final int MIDDLE_LINE_HEIGHT = 10;
    private static final int MIDDLE_LINE_GAP = 25;

    private final Game game;
    /// Crea y configura una instancia de `GamePanel`
    ///
    /// @param game reglas que el juego está obligado a cumplir
    public GamePanel(Game game) {
        this.game = Objects.requireNonNull(game, "game must not be null");
        setPreferredSize(new Dimension(COURT_WIDTH, COURT_HEIGHT));
        setBackground(Color.BLACK);
    }
    /// {@inheritDoc}
    ///
    /// @param graphics the <code>Graphics</code> object to protect
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        var graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.WHITE);

        drawMiddleLine(graphics2D);
        drawBall(graphics2D, game.ball());
        drawPaddle(graphics2D, game.leftPaddle());
        drawPaddle(graphics2D, game.rightPaddle());
    }

    private void drawBall(Graphics2D graphics2D, Ball ball) {
        var pos = ball.position();
        graphics2D.fillRect((int) Math.round(pos.x()), (int) Math.round(pos.y()),
                            BALL_SIZE, BALL_SIZE);
    }

    private void drawPaddle(Graphics2D graphics2D, Paddle paddle) {
        var pos = paddle.position();
        graphics2D.fillRect((int) Math.round(pos.x()), (int) Math.round(pos.y()),
                            PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    private void drawMiddleLine(Graphics2D graphics2D) {
        for (int y = 0; y < COURT_HEIGHT; y += 20) {
            graphics2D.fillRect((COURT_WIDTH - MIDDLE_LINE_WIDTH) / 2, y,
                                MIDDLE_LINE_WIDTH, MIDDLE_LINE_HEIGHT);
        }
    }
}
