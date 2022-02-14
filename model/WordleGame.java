package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class WordleGame {
    static final int MAX_GUESSES = 6;
    ArrayList<String> possibleGuesses;
    ArrayList<String> possibleAnswers;
    String[] userGuesses = new String[MAX_GUESSES];
    String gameKey;

    public WordleGame() throws FileNotFoundException, IOException {
    
        Arrays.fill(userGuesses, "     ");

        String filePath = "C:\\Users\\Robby Ramana\\OneDrive\\Documents\\SE3103\\Wordle Project\\model\\wordle-answers-alphabetical.txt";
        possibleAnswers = readFileLines(filePath);
    
        filePath = "C:\\Users\\Robby Ramana\\OneDrive\\Documents\\SE3103\\Wordle Project\\model\\wordle-allowed-guesses.txt";
        possibleGuesses = readFileLines(filePath);
    
        gameKey = possibleGuesses.get(generateKey(possibleGuesses.size()));   
    }
    private int generateKey(int num) {
        Random r = new Random();
        return r.nextInt(num);
    }

    public String getGameKey() {
        return gameKey;
    }

    private ArrayList<String> readFileLines(String filepath) throws FileNotFoundException, IOException{
        File fp = new File(filepath);
        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);
      
        ArrayList<String> lines = new ArrayList<>();
        String line;
        while((line = br.readLine()) != null) { lines.add(line); }
      
        fr.close();
        return lines;
      }
}