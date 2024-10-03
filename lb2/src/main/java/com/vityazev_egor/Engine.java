package com.vityazev_egor;

import com.vityazev_egor.Models.IGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {
    private final IGame game;
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_GRAY = "\u001B[90m";

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

    private void runGameLoop() throws IOException{
        System.out.println(game.getName());
        for (int i=0; i<3; i++){
            var question = game.genQuestion();
            System.out.println(question.getQuestion());
            if (showAnswers){
                printGrayText(question.getCorrectAnswer());
            }
            String playerAnswer = input.readLine();
            if (question.checkAnswer(playerAnswer)){
                System.out.println("Correct!");
            }
            else{
                System.out.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.", playerAnswer, question.getCorrectAnswer()));
                hadWrongAnswer = true;
                break;
            }
        }
    }

    private void printGrayText(String text) {
        System.out.println(ANSI_GRAY + text + ANSI_RESET);
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
