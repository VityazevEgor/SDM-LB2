package com.vityazev_egor;

import com.vityazev_egor.Games.NOKGame;
import com.vityazev_egor.Games.ProgressionGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

    public static void main(String[] args) throws IOException {
        parseArguments(args);
        printMathBookArt();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int choice = Integer.parseInt(input.readLine());
        
        switch (choice) {
            case 1:
                new Engine(new NOKGame()).runGame();
                break;
            case 2:
                new Engine(new ProgressionGame()).runGame();
                break;
            default:
                System.out.println("Invalid choice. Please restart and select 1 or 2.");
        }
        input.close();
    }

    private static void parseArguments(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (isShowAnswersArgument(args[i])) {
                i = handleShowAnswersArgument(args, i);
            }
        }
    }
    
    private static boolean isShowAnswersArgument(String arg) {
        return "--showAnswers".equals(arg);
    }
    
    private static int handleShowAnswersArgument(String[] args, int index) {
        if (index + 1 < args.length) {
            Engine.showAnswers = Boolean.parseBoolean(args[index + 1]);
            System.out.println("Enabled 'showAnswers' mode");
            return index + 1;
        } else {
            System.out.println("You didn't provide a value for '--showAnswers' argument");
            return index;
        }
    }
    

    private static void printMathBookArt() {
        System.out.println("====================");
        System.out.println("   GAME SELECTION   ");
        System.out.println("====================");
        System.out.println("      _______ ");
        System.out.println("     /      /,");
        System.out.println("    / MATH // ");
        System.out.println("   /______//  ");
        System.out.println("  (______(/   ");
        System.out.println();
        System.out.println("Please choose a game:");
        System.out.println("1. Least Common Multiple (LCM)");
        System.out.println("2. Geometric Progression");
        System.out.println("======================");
        System.out.print("Enter your choice (1 or 2): ");
    }
}
