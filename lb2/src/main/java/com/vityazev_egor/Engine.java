package com.vityazev_egor;

import com.vityazev_egor.Models.IGame;
import java.util.*;

public class Engine {
    private final IGame game;

    private String playerName;
    private Scanner sc;

    public Engine(IGame game){
        this.game = game;
    }

    public void runGame(){
        init();
        runGameLoop();
        dispose();
    }

    private void init(){
        sc = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.err.println("May I have your name? ");
        playerName = sc.nextLine();
        System.out.println(String.format("Hello, %s!", playerName));
    }

    private void runGameLoop(){
        System.out.println(game.getName());
        for (int i=0; i<3; i++){
            var question = game.genQuestion();
            System.out.println(question.getQuestion());
            String playerAnswer = sc.nextLine();
            if (playerAnswer.equalsIgnoreCase(question.getCorrectAnswer())){
                System.out.println("Correct!");
            }
            else{
                System.out.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.", playerAnswer, question.getCorrectAnswer()));
            }
        }
    }

    private void dispose(){
        sc.close();

    }
    
}
