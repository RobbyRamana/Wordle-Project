package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.WordleGame;

public class WordleGamePanel {
    public enum GameState {
        READY, PLAYING, GAMEOVER, VICTORY
    }

    private GameState gameState = GameState.READY;
    private WordleGameCanvas canvas;
    private JFrame window;
    private JTextField gameKeyField = new JTextField();
    private JButton[] letterButtons;
    private JButton enterButton = new JButton("Enter");
    private JButton newButton = new JButton("New");
    private WordleGame wordGuess;

    public WordleGamePanel(JFrame window) {
        this.window = window;
    }

    public void init() {
        Container cp = window.getContentPane();
        JPanel gamePanel = new JPanel();
        gamePanel.setPreferredSize(new Dimension(400, 200));
        gamePanel.setLayout(new GridLayout(2, 1));
        cp.add(BorderLayout.CENTER, gamePanel);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 2));
        Font font = new Font ("Neue Helvetica", Font.BOLD, 20);
        gameKeyField.setForeground(Color.white);
        gameKeyField.setBackground(Color.BLACK);
        gameKeyField.setFont(font);
        northPanel.add(gameKeyField);
        gameKeyField.setEditable(false);

        gameKeyField.setText("PROXY");

        cp.add(BorderLayout.NORTH, northPanel);

        canvas = new WordleGameCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4,3));

        //WordleGameKeyListener keyListener = new WordleGameKeyListener(this);


        letterButtons = new JButton[26];
        char label = 'a';
        for (int i = 0; i < 26; i++) {
            letterButtons[i] = new JButton("" + label);
            southPanel.add(letterButtons[i]);
            //letterButtons[i].addActionListener(keyListener);
            label++;
        }

        //newButton.addActionListener(keyListener);

        southPanel.add(newButton);

        cp.add(BorderLayout.SOUTH, southPanel);

        for (var b: letterButtons) {
            b.setEnabled(false);
        }

    }

    public GameState getGameState() {
        return gameState;
    }
}
