package com.exercicis;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Locale;

public class Exercici0014 {

    public static String getMovePC() {
        String[] moves = {"PEDRA", "PAPER", "TISORES"};
        return moves[new Random().nextInt(moves.length)];
    }

    public static String getPlayerMove(Scanner scanner) {
        while (true) {
            System.out.print("Escriu PEDRA, PAPER, TISORES o SORTIR: ");
            String move = scanner.nextLine().toUpperCase();

            if (move.equals("SORTIR")) {
                return null;
            }
            if (move.equals("PEDRA") || move.equals("PAPER") || move.equals("TISORES")) {
                return move;
            }
        }
    }

    public static String getWinner(String playerMove, String pcMove) {
        if (playerMove.equals(pcMove)) {
            return "DRAW" ;
        }
        switch (playerMove) {
            case "PEDRA":
                return pcMove.equals("TISORES") ? "PLAYER" : "PC";
            case "PAPER":
                return pcMove.equals("PEDRA") ? "PLAYER" : "PC";
            case "TISORES":
                return pcMove.equals("PAPER") ? "PLAYER" : "PC";
            default:
                return "ERROR";
        }
    }

    public static String getScoreMessage(int playerScore, int pcScore) {
        return String.format("MARCADOR -> JUGADOR: %d - PC: %d", playerScore, pcScore);
    }

    public static String getWinnerMessage(boolean playerWon) {
        return playerWon ? "Felicitats! Has guanyat la partida!" : "Ho sento! Ha guanyat el PC!";
    }

    public static void updateStats(HashMap<String, Integer> stats, String move, boolean win) {
        String contador = move + "_COUNT";
        stats.put(contador, stats.get(contador) + 1);

        if (win) {
            String winKey = move + "_WINS";
            stats.put(winKey, stats.get(winKey) + 1);
        }
    }

    public static String getMessage(String winner, String playerMove, String pcMove) {
        /*
            TODO: Resol aquí la funció
        */
        return ""; 
    }

    public static void showStats(HashMap<String, Integer> stats) {
        /*
            TODO: Resol aquí la funció
        */
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Definim l'scanner al principi
        try {
            /*
                TODO: Resol aquí l'exercici
            */
        } finally {
            scanner.close();  // Tanquem l'scanner al final
        }
    }
}