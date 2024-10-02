package com.vityazev_egor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.vityazev_egor.Games.NOKGame;

public class Application {

    public static void main(String[] args) throws IOException {
        printMathBookArt();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int choice = Integer.parseInt(input.readLine());
        
        switch (choice) {
            case 1:
                new Engine(new NOKGame()).runGame();
                break;
            case 2:
                break;
            default:
                System.out.println("Invalid choice. Please restart and select 1 or 2.");
        }
        input.close();
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
