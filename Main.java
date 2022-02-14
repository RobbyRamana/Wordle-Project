import java.io.IOException;

import javax.swing.JFrame;

import view.WordleGamePanel;

public class Main {
    
    public static void main(String[] args) throws IOException {
        JFrame window = new JFrame();
        //window.setTitle("Wordle");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(400, 100);

        var game = new WordleGamePanel(window);
        game.init();

        window.pack();
        window.setVisible(true);
    }
}
