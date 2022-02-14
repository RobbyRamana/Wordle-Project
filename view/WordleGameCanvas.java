package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class WordleGameCanvas extends JPanel {
    
    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    private WordleGamePanel panel;
    private Graphics g;

    public WordleGameCanvas(WordleGamePanel panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {
        this.g = g;
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        WordleGamePanel.GameState state = panel.getGameState();
        if (state == WordleGamePanel.GameState.READY) {
            g2.setColor(Color.gray);
            g2.setFont(new Font("Neue Helvetica", Font.BOLD, 75));
            g2.drawString("WORDLE!", 70, 150);
        }








    }
}
