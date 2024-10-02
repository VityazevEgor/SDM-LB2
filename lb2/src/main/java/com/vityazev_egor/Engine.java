package com.vityazev_egor;

import com.vityazev_egor.Models.IGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {
    private final IGame game;

    private String playerName;
    private BufferedReader input;

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
            String playerAnswer = input.readLine();
            if (playerAnswer.equalsIgnoreCase(question.getCorrectAnswer())){
                System.out.println("Correct!");
            }
            else{
                System.out.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.", playerAnswer, question.getCorrectAnswer()));
            }
        }
    }

    private void dispose() throws IOException{
        input.close();
    }
    
}
