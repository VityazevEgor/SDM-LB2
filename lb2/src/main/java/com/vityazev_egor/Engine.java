package com.vityazev_egor;

import com.vityazev_egor.Models.IGame;
import com.vityazev_egor.Models.Question;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {
    private final IGame game;
    private final String ansiReset = "\u001B[0m";
    private final String ansiGray = "\u001B[90m";

    private String playerName;
    private BufferedReader input;
    private Boolean hadWrongAnswer = false;

    public static Boolean showAnswers = false;

    public Engine(IGame game){
        this.game = game;
    }

    public void runGame() throws IOException{
        init();
        runGameLoop();
        dispose();
    }

    private void init() throws IOException{
        input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to the Brain Games!");
        System.err.println("May I have your name? ");
        playerName = input.readLine();
        System.out.println(String.format("Hello, %s!", playerName));
    }

    private void runGameLoop() throws IOException {
        System.out.println(game.getName());
        for (int i = 0; i < 3; i++) {
            if (!processQuestion()) {
                break;
            }
        }
    }

    private Boolean processQuestion() throws IOException {
        var question = game.genQuestion();
        askQuestion(question);
        if (showAnswers) {
            printGrayText(question.getCorrectAnswer());
        }
        return checkAnswer(question);
    }

    private void askQuestion(Question question) {
        System.out.println(question.getQuestion());
    }

    private Boolean checkAnswer(Question question) throws IOException {
        String playerAnswer = input.readLine();
        if (question.checkAnswer(playerAnswer)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.", playerAnswer, question.getCorrectAnswer()));
            hadWrongAnswer = true;
            return false;
        }
    }


    private void printGrayText(String text) {
        System.out.println(ansiGray + text + ansiReset);
    }

    private void printGrayText(Integer value) {
        printGrayText(value.toString());
    }

    private void dispose() throws IOException{
        if (hadWrongAnswer){
            System.out.println(String.format("Let's try again, %s!", playerName));
        }
        else{
            System.out.println(String.format("Congratulations, %s!", playerName));
        }
        input.close();
    }
    
}
